/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.controller;

import java.net.URL;
import java.util.*;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.JugadoresDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.PartidasDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.PartidasJugadores;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.PartidasJugadoresDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service.JugadoresService;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service.PartidasService;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.*;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Kendall Fonseca
 */
public class BoardGameController extends Controller implements Initializable {

    /**
     * Initializes the controller class.
     */

    String Sound_Pregunta = "/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/sounds/TurnRule.wav";

    @FXML
    private ImageView Ficha1Player1;

    @FXML
    private ImageView Ficha1Player2;

    @FXML
    private ImageView Ficha1Player3;

    @FXML
    private ImageView Ficha1Player4;

    @FXML
    private ImageView Ficha1Player5;

    @FXML
    private ImageView Ficha1Player6;

    @FXML
    private ImageView Ficha2Player1;

    @FXML
    private ImageView Ficha2Player2;

    @FXML
    private ImageView Ficha2Player3;

    @FXML
    private ImageView Ficha2Player4;

    @FXML
    private ImageView Ficha2Player5;

    @FXML
    private ImageView Ficha3Player1;

    @FXML
    private ImageView Ficha3Player2;

    @FXML
    private ImageView Ficha3Player3;

    @FXML
    private ImageView Ficha3Player4;

    @FXML
    private ImageView Ficha3Player5;

    @FXML
    private ImageView Ficha3Player6;

    @FXML
    private ImageView Ficha4Player1;

    @FXML
    private ImageView Ficha4Player2;

    @FXML
    private ImageView Ficha4Player3;

    @FXML
    private ImageView Ficha4Player4;

    @FXML
    private ImageView Ficha4Player5;

    @FXML
    private ImageView Ficha4Player6;

    @FXML
    private ImageView Ficha5Player1;

    @FXML
    private ImageView Ficha5Player2;

    @FXML
    private ImageView Ficha5Player3;

    @FXML
    private ImageView Ficha5Player4;

    @FXML
    private ImageView Ficha5Player5;

    @FXML
    private ImageView Ficha5Player6;

    @FXML
    private ImageView Ficha6Player1;

    @FXML
    private ImageView Ficha6Player2;

    @FXML
    private ImageView Ficha6Player3;

    @FXML
    private ImageView Ficha6Player4;

    @FXML
    private ImageView Ficha6Player5;

    @FXML
    private ImageView Ficha6Player6;

    @FXML
    private MFXButton btnRotate;

    @FXML
    private ImageView fichaPlayer1;

    @FXML
    private ImageView fichaPlayer2;

    @FXML
    private ImageView fichaPlayer3;

    @FXML
    private ImageView fichaPlayer4;

    @FXML
    private ImageView fichaPlayer5;

    @FXML
    private ImageView fichaPlayer6;

    @FXML
    private StackPane hubPlayer1;

    @FXML
    private StackPane hubPlayer2;

    @FXML
    private StackPane hubPlayer3;

    @FXML
    private StackPane hubPlayer4;

    @FXML
    private StackPane hubPlayer5;

    @FXML
    private StackPane hubPlayer6;

    @FXML
    private StackPane invisibleStackPane;

    @FXML
    private Label player1Name;

    @FXML
    private Label player2Name;

    @FXML
    private Label player3Name;

    @FXML
    private Label player4Name;

    @FXML
    private Label player5Name;

    @FXML
    private Label player6Name;


    @FXML
    private MFXButton btnSalirYGuardar;

    @FXML
    private StackPane root;

    @FXML
    private ImageView ruletaBoard;

    @FXML
    private ImageView imageTablero;

    @FXML
    private ImageView geografiaPregunta;

    @FXML
    private ImageView historiaPregunta;

    @FXML
    private ImageView artePregunta;

    @FXML
    private ImageView cienciaPregunta;

    @FXML
    private ImageView popPregunta;

    @FXML
    private ImageView deportesPregunta;

    @FXML
    private MFXButton btnJugarPregunta;



    private Long partidaid;
    private PartidasDto partidasDto = new PartidasDto();


    AppContext appContext = AppContext.getInstance();
    PartidasService partidasService = new PartidasService();
    JugadoresService jugadoresService = new JugadoresService();

    AnimationManager animationManager = AnimationManager.getInstance();

    private ArrayList<ImageView> imageViewFichas = new ArrayList<>();


    JugadoresDto jugador1 = new JugadoresDto();
    JugadoresDto jugador2 = new JugadoresDto();
    JugadoresDto jugador3 = new JugadoresDto();
    JugadoresDto jugador4 = new JugadoresDto();
    JugadoresDto jugador5 = new JugadoresDto();
    JugadoresDto jugador6 = new JugadoresDto();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @Override
    public void initialize() {
        appContext.set("turno", jugador1.getId());
        partidaid = (Long) appContext.get("idPartida");
        setPartida();

    }


    void setPartida() {

        hubPlayer1.setVisible(false);
        hubPlayer2.setVisible(false);
        hubPlayer3.setVisible(false);
        hubPlayer4.setVisible(false);
        hubPlayer5.setVisible(false);
        hubPlayer6.setVisible(false);

        Respuesta respuesta = partidasService.findById(partidaid);
        if (!respuesta.getEstado()) {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), respuesta.getMensaje());
        } else {

            partidasDto = (PartidasDto) respuesta.getResultado("PartidaCreada");
        }


        int cantidadJugadores = partidasDto.getPartidasJugadoresList().size();

        if (cantidadJugadores == 2) {
            imageTablero.setImage(new Image(getClass().getResource("/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/tablero2.png").toExternalForm()));
        }
        if (cantidadJugadores == 3) {

            imageTablero.setImage(new Image(getClass().getResource("/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/tablero3.png").toExternalForm()));
        }
        if (cantidadJugadores == 4) {
            imageTablero.setImage(new Image(getClass().getResource("/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/tablero4.png").toExternalForm()));
        }
        if (cantidadJugadores == 5) {
            imageTablero.setImage(new Image(getClass().getResource("/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/tablero5.png").toExternalForm()));
        }
        if (cantidadJugadores == 6) {
            imageTablero.setImage(new Image(getClass().getResource("/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/tablero6.png").toExternalForm()));

        }
        agregarImageViewFichas();
        deshabilitarFichas();
        setJugadores();

    }

    @FXML
    void onActionBtnRotate(ActionEvent event) {
        AnimationManager animationManager = AnimationManager.getInstance();
        animationManager.applyRandomRotation(ruletaBoard);
        animationManager.moveToCoordinates(invisibleStackPane, 0, 0, 1);
        animacionPregunta();
        animationManager.playSound(Sound_Pregunta);
    }


    private void agregarImageViewFichas() {
        imageViewFichas.add(Ficha1Player1);
        imageViewFichas.add(Ficha1Player2);
        imageViewFichas.add(Ficha1Player3);
        imageViewFichas.add(Ficha1Player4);
        imageViewFichas.add(Ficha1Player5);
        imageViewFichas.add(Ficha1Player6);

        imageViewFichas.add(Ficha2Player1);
        imageViewFichas.add(Ficha2Player2);
        imageViewFichas.add(Ficha2Player3);
        imageViewFichas.add(Ficha2Player4);
        imageViewFichas.add(Ficha2Player5);

        imageViewFichas.add(Ficha3Player1);
        imageViewFichas.add(Ficha3Player2);
        imageViewFichas.add(Ficha3Player3);
        imageViewFichas.add(Ficha3Player4);
        imageViewFichas.add(Ficha3Player5);
        imageViewFichas.add(Ficha3Player6);

        imageViewFichas.add(Ficha4Player1);
        imageViewFichas.add(Ficha4Player2);
        imageViewFichas.add(Ficha4Player3);
        imageViewFichas.add(Ficha4Player4);
        imageViewFichas.add(Ficha4Player5);
        imageViewFichas.add(Ficha4Player6);

        imageViewFichas.add(Ficha5Player1);
        imageViewFichas.add(Ficha5Player2);
        imageViewFichas.add(Ficha5Player3);
        imageViewFichas.add(Ficha5Player4);
        imageViewFichas.add(Ficha5Player5);
        imageViewFichas.add(Ficha5Player6);

        imageViewFichas.add(Ficha6Player1);
        imageViewFichas.add(Ficha6Player2);
        imageViewFichas.add(Ficha6Player3);
        imageViewFichas.add(Ficha6Player4);
        imageViewFichas.add(Ficha6Player5);
        imageViewFichas.add(Ficha6Player6);
    }


    private void deshabilitarFichas() {
        for (ImageView imageView : imageViewFichas) {
            imageView.setOpacity(0.3);
        }
    }

    void setJugadores() {
        for (PartidasJugadoresDto partidasJugadoresDto : partidasDto.getPartidasJugadoresList()) {
            JugadoresDto jugadorDto = partidasJugadoresDto.getIdJugador(); // Obtener JugadoresDto

            Long jugadorId = jugadorDto.getId(); // Obtener ID del JugadoresDto


            Respuesta respuesta = jugadoresService.findById(jugadorId);
            if (!respuesta.getEstado()) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), respuesta.getMensaje());
            } else {
                JugadoresDto jugador = (JugadoresDto) respuesta.getResultado("Jugador");
                Long fichaSeleccionada = partidasJugadoresDto.getFichaSeleccionada();

                switch (fichaSeleccionada.intValue()) {
                    case 1:
                        fichaPlayer1.setImage(new Image(getClass().getResource("/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/fichasPlayer1.png").toExternalForm()));
                        player1Name.setText(jugador.getNombre());
                        jugador1 = jugador;
                        hubPlayer1.setVisible(true);
                        appContext.set("turno", jugador1.getId());
                        break;
                    case 2:
                        fichaPlayer2.setImage(new Image(getClass().getResource("/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/fichasPlayer2.png").toExternalForm()));
                        player2Name.setText(jugador.getNombre());
                        jugador2 = jugador;
                        hubPlayer2.setVisible(true);
                        break;
                    case 3:
                        fichaPlayer3.setImage(new Image(getClass().getResource("/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/fichasPlayer3.png").toExternalForm()));
                        player3Name.setText(jugador.getNombre());
                        jugador3 = jugador;
                        hubPlayer3.setVisible(true);
                        break;
                    case 4:
                        fichaPlayer4.setImage(new Image(getClass().getResource("/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/fichasPlayer4.png").toExternalForm()));
                        player4Name.setText(jugador.getNombre());
                        jugador4 = jugador;
                        hubPlayer4.setVisible(true);
                        break;
                    case 5:
                        fichaPlayer5.setImage(new Image(getClass().getResource("/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/fichasPlayer5.png").toExternalForm()));
                        player5Name.setText(jugador.getNombre());
                        jugador5 = jugador;
                        hubPlayer5.setVisible(true);
                        break;
                    case 6:
                        fichaPlayer6.setImage(new Image(getClass().getResource("/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/fichasPlayer6.png").toExternalForm()));
                        player6Name.setText(jugador.getNombre());
                        jugador6 = jugador;
                        hubPlayer6.setVisible(true);

                        break;
                    default:
                        break;
                }
            }
        }
    }


    void animacionPregunta(){
        if (appContext.get("Criterio").equals("Geografia")) {
            animationManager.moveToCoordinates(geografiaPregunta, 0, 0, 1);
            animationManager.moveToCoordinates(btnJugarPregunta, 0, 100, 1);
        }
        if (appContext.get("Criterio").equals("Historia")) {
            animationManager.moveToCoordinates(historiaPregunta, 0, 0, 1);
            animationManager.moveToCoordinates(btnJugarPregunta, 0, 100, 1);
        }
        if (appContext.get("Criterio").equals("Arte")) {
            animationManager.moveToCoordinates(artePregunta, 0, 0, 1);
            animationManager.moveToCoordinates(btnJugarPregunta, 0, 100, 1);
        }
        if (appContext.get("Criterio").equals("Ciencia")) {
            animationManager.moveToCoordinates(cienciaPregunta, 0, 0, 1);
            animationManager.moveToCoordinates(btnJugarPregunta, 0, 100, 1);
        }
        if (appContext.get("Criterio").equals("Pop")) {
            animationManager.moveToCoordinates(popPregunta, 0, 0, 1);
            animationManager.moveToCoordinates(btnJugarPregunta, 0, 100, 1);
        }
        if (appContext.get("Criterio").equals("Deportes")) {
            animationManager.moveToCoordinates(deportesPregunta, 0, 0, 1);
            animationManager.moveToCoordinates(btnJugarPregunta, 0, 100, 1);
        }

    }

    @FXML
    void btnSalirYGuardar(ActionEvent event) {
        FlowController.getInstance().goView("StartView");
        AppContext.getInstance().delete("playerCounter");

    }

    @FXML
    void onActionBtnJugarPregunta(ActionEvent event) {
        FlowController.getInstance().goViewInWindowModal("PreguntaView", getStage(), false);
        limpiarElementos();

    }


    private void limpiarElementos() {
        geografiaPregunta.setTranslateY(-1100);
        historiaPregunta.setTranslateY(-1100);
        artePregunta.setTranslateY(-1100);
        cienciaPregunta.setTranslateY(-1100);
        popPregunta.setTranslateY(-1100);
        deportesPregunta.setTranslateY(-1100);
        btnJugarPregunta.setTranslateY(1100);
        invisibleStackPane.setTranslateX(-1700);

    }

}





