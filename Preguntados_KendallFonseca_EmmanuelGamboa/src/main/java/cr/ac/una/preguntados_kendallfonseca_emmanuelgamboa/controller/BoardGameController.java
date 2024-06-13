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
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.PartidasJugadores;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.PartidasJugadoresDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service.JugadoresService;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service.PartidasService;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.AppContext;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.Mensaje;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.Respuesta;
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
    private StackPane root;

    @FXML
    private ImageView ruletaBoard;

    @FXML
    private ImageView imageTablero;


    private Long partidaid;
    private PartidasDto partidasDto = new PartidasDto();


    AppContext appContext = AppContext.getInstance();
    PartidasService partidasService = new PartidasService();
    JugadoresService jugadoresService = new JugadoresService();

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

        partidaid = (Long) appContext.get("idPartida");
        setPartida();


    }


    void setPartida() {

        Respuesta respuesta = partidasService.findById(partidaid);
        if (!respuesta.getEstado()) {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), respuesta.getMensaje());
        } else {

            partidasDto = (PartidasDto) respuesta.getResultado("PartidaCreada");
        }


        for (PartidasJugadoresDto partidasJugadoresDto : partidasDto.getPartidasJugadoresList()) {
            System.out.println(partidasJugadoresDto.getAyudas());
            System.out.println(partidasJugadoresDto.getFichaSeleccionada());
        }

        int cantidadJugadores = partidasDto.getPartidasJugadoresList().size();

        if (cantidadJugadores == 2) {
            hubPlayer1.setVisible(true);
            hubPlayer2.setVisible(true);
            hubPlayer3.setVisible(false);
            hubPlayer4.setVisible(false);
            hubPlayer5.setVisible(false);
            hubPlayer6.setVisible(false);
            imageTablero.setImage(new Image(getClass().getResource("/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/tablero2.png").toExternalForm()));
        }
        if (cantidadJugadores == 3) {
            hubPlayer1.setVisible(true);
            hubPlayer2.setVisible(true);
            hubPlayer3.setVisible(true);
            hubPlayer4.setVisible(false);
            hubPlayer5.setVisible(false);
            hubPlayer6.setVisible(false);
            imageTablero.setImage(new Image(getClass().getResource("/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/tablero3.png").toExternalForm()));
        }
        if (cantidadJugadores == 4) {
            hubPlayer1.setVisible(true);
            hubPlayer2.setVisible(true);
            hubPlayer3.setVisible(true);
            hubPlayer4.setVisible(true);
            hubPlayer5.setVisible(false);
            hubPlayer6.setVisible(false);
            imageTablero.setImage(new Image(getClass().getResource("/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/tablero4.png").toExternalForm()));
        }
        if (cantidadJugadores == 5) {
            hubPlayer1.setVisible(true);
            hubPlayer2.setVisible(true);
            hubPlayer3.setVisible(true);
            hubPlayer4.setVisible(true);
            hubPlayer5.setVisible(true);
            hubPlayer6.setVisible(false);
            imageTablero.setImage(new Image(getClass().getResource("/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/tablero5.png").toExternalForm()));
        }
        if (cantidadJugadores == 6) {
            hubPlayer1.setVisible(true);
            hubPlayer2.setVisible(true);
            hubPlayer3.setVisible(true);
            hubPlayer4.setVisible(true);
            hubPlayer5.setVisible(true);
            hubPlayer6.setVisible(true);
            imageTablero.setImage(new Image(getClass().getResource("/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/tablero6.png").toExternalForm()));
            ;
        }



        agregarImageViewFichas();
        deshabilitarFichas();
        setJugadores();


    }

    @FXML
    void onActionBtnRotate(ActionEvent event) {
        for (PartidasJugadoresDto partidasJugadoresDto : partidasDto.getPartidasJugadoresList()) {
            System.out.println(partidasJugadoresDto.getAyudas());
        }
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

            if (jugadorId == null) {
                System.out.println("El ID del jugador está vacío para la ficha: " + partidasJugadoresDto.getFichaSeleccionada());
                continue;
            }

            System.out.println("Buscando jugador con ID: " + jugadorId);

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
                        break;
                    case 2:
                        fichaPlayer2.setImage(new Image(getClass().getResource("/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/fichasPlayer2.png").toExternalForm()));
                        player2Name.setText(jugador.getNombre());
                        break;
                    case 3:
                        fichaPlayer3.setImage(new Image(getClass().getResource("/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/fichasPlayer3.png").toExternalForm()));
                        player3Name.setText(jugador.getNombre());
                        break;
                    case 4:
                        fichaPlayer4.setImage(new Image(getClass().getResource("/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/fichasPlayer4.png").toExternalForm()));
                        player4Name.setText(jugador.getNombre());
                        break;
                    case 5:
                        fichaPlayer5.setImage(new Image(getClass().getResource("/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/fichasPlayer5.png").toExternalForm()));
                        player5Name.setText(jugador.getNombre());
                        break;
                    case 6:
                        fichaPlayer6.setImage(new Image(getClass().getResource("/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/fichasPlayer6.png").toExternalForm()));
                        player6Name.setText(jugador.getNombre());
                        break;
                    default:
                        break;
                }
            }
        }
    }





}





