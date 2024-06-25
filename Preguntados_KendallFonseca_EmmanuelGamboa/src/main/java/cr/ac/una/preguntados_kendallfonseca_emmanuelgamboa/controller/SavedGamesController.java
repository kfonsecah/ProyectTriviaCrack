package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.controller;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.PartidasDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service.PartidasService;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.*;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SavedGamesController extends Controller implements Initializable {

    String Sound_Click = "/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/sounds/Play.wav";


    @FXML
    private MFXButton btnDelete;

    @FXML
    private MFXButton btnGoBack;

    @FXML
    private MFXButton btnPlay;


    @FXML
    private ImageView meteorito;

    @FXML
    private StackPane root;

    @FXML
    private TableView<PartidasDto> tbvSavedGames;

    @FXML
    private TableColumn<PartidasDto, Long> tbcPartidas;


    AnimationManager animationManager = AnimationManager.getInstance();

    PartidasService partidasService = new PartidasService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarPartidas();

        tbcPartidas.setCellValueFactory(new PropertyValueFactory<>("idPartida"));

    }

    private void cargarPartidas() {
        Respuesta respuesta = partidasService.listarPartidas();
        if (respuesta.getEstado()) {
            ObservableList<PartidasDto> partidas = FXCollections.observableArrayList((List<PartidasDto>) respuesta.getResultado("listaPartidas"));
            tbvSavedGames.setItems(partidas);
        } else {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Error al cargar partidas", null, respuesta.getMensaje());
        }
    }

    @Override
    public void initialize() {
        cargarPartidas();



    }

    @FXML
    void onACtionBtnDelete(ActionEvent event) {

    }

    @FXML
    void onActionBtnGoBack(ActionEvent event) {
        animationManager.playSound(Sound_Click);
        FlowController.getInstance().goView("StartView");
    }

    @FXML
    void onActionBtnPlay(ActionEvent event) {
        PartidasDto seleccionada = tbvSavedGames.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            cargarJuego(seleccionada);
        } else {
            new Mensaje().showModal(Alert.AlertType.WARNING, "Selección de partida", null, "Seleccione una partida para jugar.");
        }
    }

    @FXML
    void onAnimationAction(MouseEvent event) {
        animationManager.applyFloatingAnimation(meteorito);
    }

    private void cargarJuego(PartidasDto partida) {
        AppContext.getInstance().set("idPartida", partida.getIdPartida());

        String modoJuego = extraerModoDeJuego(partida.getInformacionJson());

        System.out.println("Modo de Juego: " + modoJuego);
        AppContext.getInstance().set("modo_juego", partida.getInformacionJson());
        AppContext.getInstance().set("configPartida", partida.getInformacionJson());

        FlowController.getInstance().goView("BoardGameView");
    }


    public String extraerModoDeJuego(String configJson) {

        int inicio = configJson.indexOf('{') + 1;
        int fin = configJson.indexOf(',');

        String modoJuego = configJson.substring(inicio, fin).trim();
        return modoJuego;
    }





}