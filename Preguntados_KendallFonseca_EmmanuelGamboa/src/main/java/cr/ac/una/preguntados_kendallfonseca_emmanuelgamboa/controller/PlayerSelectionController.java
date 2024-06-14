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

    String modo_juego;
    Integer tiempo_juego;

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
        modo_juego = (String) appContext.get("modo_juego");
        tiempo_juego = (Integer) appContext.get("tiempo_juego");

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
    void onActionBtnFicha(ActionEvent event) {
        if (Objects.equals(playerNumber, playerCounter)) {
            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Información", getStage(), "Todos los jugadores han sido seleccionados");
        } else {
            if (comboboxPlayers.getValue() != null) {

                String nombre = comboboxPlayers.getValue();

                partidasJugadoresDto.setPosicionTablero(0L);

                partidasJugadoresDto.setPersonajesObtenidos("Ninguno");


                if (event.getSource() == btnFicha1) {
                    partidasJugadoresDto.setFichaSeleccionada(1L);
                    btnFicha1.setDisable(true);
                } else if (event.getSource() == btnFicha2) {
                    partidasJugadoresDto.setFichaSeleccionada(2L);
                    btnFicha2.setDisable(true);
                } else if (event.getSource() == btnFicha3) {
                    partidasJugadoresDto.setFichaSeleccionada(3L);
                    btnFicha3.setDisable(true);
                } else if (event.getSource() == btnFicha4) {
                    partidasJugadoresDto.setFichaSeleccionada(4L);
                    btnFicha4.setDisable(true);
                } else if (event.getSource() == btnFicha5) {
                    partidasJugadoresDto.setFichaSeleccionada(5L);
                    btnFicha5.setDisable(true);
                } else if (event.getSource() == btnFicha6) {
                    partidasJugadoresDto.setFichaSeleccionada(6L);
                    btnFicha6.setDisable(true);
                }

                if (modo_juego.equals("facil"))
                    partidasJugadoresDto.setAyudas("D, P, B, TE");
                else if (modo_juego.equals("medio"))
                    partidasJugadoresDto.setAyudas(" ");
                else if (modo_juego.equals("dificil"))
                    partidasJugadoresDto.setAyudas(" ");

                Respuesta respuesta = jugadoresService.findByNombre(nombre);
                if (respuesta.getEstado()) {
                   jugadoresDto = (JugadoresDto) respuesta.getResultado("Jugador");
                    partidasJugadoresDto.setIdJugador(jugadoresDto);

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
    void onActionBtnGoBack(ActionEvent event) {
        clearPartida();
        FlowController.getInstance().goView("GameMenuView");
    }

    @FXML
    void onActionBtnNewPlayer(ActionEvent event) {

        FlowController.getInstance().goViewInWindowModal("RegisterView", getStage(), false);
        loadJugadores();

    }

    @FXML
    void onActionBtnPlay(ActionEvent event) {

        PartidasDto partidasDto = new PartidasDto();
        partidasDto.setInformacionJson((String) appContext.get("configPartida"));
        partidasDto.setPartidasJugadoresList(partidasJugadoresList);

        Respuesta respuesta = partidasService.guardarPartida(partidasDto);

        if (!respuesta.getEstado()) {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), respuesta.getMensaje());
        } else {
            PartidasDto partidasDto1 = (PartidasDto) respuesta.getResultado("Partida");
            appContext.set("idPartida", partidasDto1.getIdPartida());
        }





        FlowController.getInstance().goView("BoardGameView");
    }

    private void clearPartida() {
        partidasJugadoresList.clear();
        playerNumber = 0;
        btnPlay.setDisable(true);

        btnFicha1.setDisable(false);
        btnFicha2.setDisable(false);
        btnFicha3.setDisable(false);
        btnFicha4.setDisable(false);
        btnFicha5.setDisable(false);
        btnFicha6.setDisable(false);

        AppContext.getInstance().delete("playerCounter");
        AppContext.getInstance().delete("configPartida");
        AppContext.getInstance().delete("gameTime");
        AppContext.getInstance().delete("modo_juego");
    }


}
