/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.JugadoresDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Partidas;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.PartidasDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.PartidasJugadoresDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service.JugadoresService;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service.PartidasService;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.*;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Kendall Fonseca
 */
public class PlayerSelectionController extends Controller implements Initializable {

    @FXML
    private ImageView roulete;


    @FXML
    private MFXButton btnFicha1;

    @FXML
    private MFXButton btnFicha2;

    @FXML
    private MFXButton btnFicha3;

    @FXML
    private MFXButton btnFicha4;

    @FXML
    private MFXButton btnFicha5;

    @FXML
    private MFXButton btnFicha6;

    @FXML
    private MFXButton btnGoBack;

    @FXML
    private MFXButton btnNewPlayer;

    @FXML
    private MFXComboBox<String> comboboxPlayers;

    @FXML
    private StackPane root;

    @FXML
    private Label playersNumber;

    @FXML
    private MFXButton btnPlay;

    AnimationManager animationManager = AnimationManager.getInstance();
    JugadoresService jugadoresService = new JugadoresService();
    PartidasService partidasService = new PartidasService();
    AppContext appContext = AppContext.getInstance();

    PartidasJugadoresDto partidasJugadoresDto = new PartidasJugadoresDto();
    JugadoresDto jugadoresDto = new JugadoresDto();
    List<PartidasJugadoresDto> partidasJugadoresList = new ArrayList<>();

    Integer playerCounter = 0;
    Integer playerNumber = 0;

    public void nuevoPartidasJugadoresDto() {
        partidasJugadoresDto = new PartidasJugadoresDto();
    }

    public void nuevoJugadorDto() {
        jugadoresDto = new JugadoresDto();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        animationManager.applyRotationAnimation(roulete);
        btnPlay.setDisable(true);
    }

    @Override
    public void initialize() {
        playersNumber.setText("Jugador " + (playerNumber + 1));
        playerCounter = (Integer) appContext.get("cantidad_jugadores");

        loadJugadores();
    }

    private void loadJugadores() {
        comboboxPlayers.getItems().clear();
        Respuesta respuesta = jugadoresService.getJugadores();
        if (respuesta.getEstado()) {
            List<JugadoresDto> jugadoresList = (List<JugadoresDto>) respuesta.getResultado("JugadoresList");
            ObservableList<JugadoresDto> jugadoresDtoObservableList = FXCollections.observableArrayList(jugadoresList);
            for (JugadoresDto jugador : jugadoresDtoObservableList) {
                comboboxPlayers.getItems().add(jugador.getNombre());
            }
        } else {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), respuesta.getMensaje());
        }
    }


    @FXML
    void onActionBtnFicha1(ActionEvent event) {
        if (Objects.equals(playerNumber, playerCounter)) {
            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Información", getStage(), "Todos los jugadores han sido seleccionados");
        } else {
            if (comboboxPlayers.getValue() != null) {

                String nombre = comboboxPlayers.getValue();

                partidasJugadoresDto.setPosicionTablero(0L);

                partidasJugadoresDto.setPersonajesObtenidos("Ninguno");

                partidasJugadoresDto.setFichaSeleccionada(1L);

                if (appContext.get("modo_juego").equals("facil"))
                    partidasJugadoresDto.setAyudas("D, P, B, TE");
                else if (appContext.get("modo_juego").equals("medio"))
                    partidasJugadoresDto.setAyudas(" ");
                else if (appContext.get("modo_juego").equals("dificil"))
                    partidasJugadoresDto.setAyudas(" ");

                Respuesta respuesta = jugadoresService.findByNombre(nombre);
                if (respuesta.getEstado()) {
                   jugadoresDto = (JugadoresDto) respuesta.getResultado("Jugador");
                    partidasJugadoresDto.setIdJugador(jugadoresDto);
                    partidasJugadoresDto.setIdPartida(null);
                    partidasJugadoresList.add(partidasJugadoresDto);
                    nuevoPartidasJugadoresDto();
                    nuevoJugadorDto();
                    comboboxPlayers.getItems().remove(comboboxPlayers.getValue());
                } else {
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), respuesta.getMensaje());
                }
                comboboxPlayers.setValue(null);
                comboboxPlayers.clearSelection();
                playerNumber++;
                playersNumber.setText("Jugador " + (playerNumber + 1));
            } else {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "Por favor seleccione un jugador");
            }
        }
        if (Objects.equals(playerNumber, playerCounter)) {
            btnPlay.setDisable(false);
        }
    }

    @FXML
    void onActionBtnFicha2(ActionEvent event) {
        System.out.println(playerCounter);
    }

    @FXML
    void onActionBtnFicha3(ActionEvent event) {

    }

    @FXML
    void onActionBtnFicha4(ActionEvent event) {

    }

    @FXML
    void onActionBtnFicha5(ActionEvent event) {

    }

    @FXML
    void onActionBtnFicha6(ActionEvent event) {

    }

    @FXML
    void onActionBtnGoBack(ActionEvent event) {
        clearPartida();
        FlowController.getInstance().goView("GameMenuView");
    }

    @FXML
    void onActionBtnNewPlayer(ActionEvent event) {

        FlowController.getInstance().goViewInWindow("RegisterView");

    }

    @FXML
    void onActionBtnPlay(ActionEvent event) {

        PartidasDto partidasDto = new PartidasDto();
        partidasDto.setInformacionJson((String) appContext.get("configPartida"));
        Respuesta respuesta = partidasService.guardarPartida(partidasDto);
        if (!respuesta.getEstado()) {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), respuesta.getMensaje());
        }else {
            PartidasDto partidasDto1= (PartidasDto) respuesta.getResultado("Partida");
            for (PartidasJugadoresDto partidasJugadoresDto1: partidasJugadoresList) {
                partidasJugadoresDto1.setIdPartida(partidasDto1);
                Respuesta respuestaPartida = partidasService.guardarPartidaJugadores(partidasJugadoresDto1);
                if (!respuestaPartida.getEstado()) {
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), respuestaPartida.getMensaje());
                }
            }
        }
        FlowController.getInstance().goView("BoardGameView");
    }

    private void clearPartida() {
        partidasJugadoresList.clear();
        playerNumber = 0;
        btnPlay.setDisable(true);

        AppContext.getInstance().delete("playerCounter");
        AppContext.getInstance().delete("configPartida");
        AppContext.getInstance().delete("gameTime");
        AppContext.getInstance().delete("modo_juego");
    }


}
