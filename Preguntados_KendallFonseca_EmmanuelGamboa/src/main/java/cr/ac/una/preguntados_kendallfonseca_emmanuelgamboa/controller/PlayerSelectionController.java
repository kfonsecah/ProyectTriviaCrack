/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.JugadoresDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.PartidasDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.PartidasJugadoresDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service.JugadoresService;
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

    AnimationManager animationManager = AnimationManager.getInstance();
    JugadoresService jugadoresService = new JugadoresService();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        animationManager.applyRotationAnimation(roulete);


        playersNumber.setText("Jugador 1");


    }
    @Override
    public void initialize() {
        loadJugadores();
    }

    private void loadJugadores() {
        comboboxPlayers.getItems().clear();
        Respuesta respuesta = jugadoresService.getJugadores();
        if (respuesta.getEstado()) {
            List<JugadoresDto> jugadoresList = (List<JugadoresDto>) respuesta.getResultado("JugadoresList");
            ObservableList<JugadoresDto> jugadores = FXCollections.observableArrayList(jugadoresList);
            for (JugadoresDto jugador : jugadores) {
                comboboxPlayers.getItems().add(jugador.getNombre());
            }
        } else {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), respuesta.getMensaje());
        }
    }

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

    PartidasJugadoresDto partidasJugadoresDto = new PartidasJugadoresDto();
    PartidasDto partidasDto = new PartidasDto();


    Integer playerCounter = (Integer) AppContext.getInstance().get("playerCounter");

    public void nuevaPartidasDto() {
        partidasDto = new PartidasDto();
    }




    @FXML
    void onActionBtnFicha1(ActionEvent event) {
        if (comboboxPlayers.getValue() != null) {
            String nombre = comboboxPlayers.getValue();
            partidasJugadoresDto.setPosicionTablero(0L);
            partidasJugadoresDto.setPersonajesObtenidos("Ninguno");
            partidasJugadoresDto.setFichaSeleccionada(1L);
            partidasJugadoresDto.setAyudas("Ninguna");

            Respuesta respuesta = jugadoresService.findByNombre(nombre);
            if (respuesta != null && respuesta.getEstado()) {
                JugadoresDto jugadoresDto = (JugadoresDto) respuesta.getResultado("Jugador");
                if (jugadoresDto.getPartidasJugadoresList() == null) {
                    jugadoresDto.setPartidasJugadoresList(new ArrayList<>());
                }


                partidasJugadoresDto.setIdPartida(partidasDto.getIdPartida());

                jugadoresDto.getPartidasJugadoresList().add(partidasJugadoresDto);
                Respuesta respuesta1 = jugadoresService.uptade(jugadoresDto);
                if (!respuesta1.getEstado()) {
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), respuesta1.getMensaje());
                }
            } else {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "Jugador no encontrado.");
            }

            playersNumber.setText("Jugador 2");
        } else {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "Por favor seleccione un jugador");
        }
    }



    @FXML
    void onActionBtnFicha2(ActionEvent event) {

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
        FlowController.getInstance().goView("GameMenuView");

    }

    @FXML
    void onActionBtnNewPlayer(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("RegisterView");
    }

    @FXML
    void onActionBtnPlay(ActionEvent event) {
        FlowController.getInstance().goView("BoardGameView");
    }
    
}
