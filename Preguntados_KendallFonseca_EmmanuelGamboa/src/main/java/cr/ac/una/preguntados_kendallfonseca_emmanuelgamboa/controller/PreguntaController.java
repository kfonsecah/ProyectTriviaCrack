/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.controller;

import java.net.URL;
import java.util.*;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.PreguntasDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Respuestas;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.RespuestasDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service.PreguntasService;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.AppContext;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.Mensaje;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.Respuesta;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author Kendall Fonseca
 */
public class PreguntaController extends Controller implements Initializable {


        PreguntasService preguntasService = new PreguntasService();

        @FXML
        private MFXButton btnBomba;

        @FXML
        private MFXButton btnDobleRespuesta;

        @FXML
        private MFXButton btnPaso;

        @FXML
        private MFXButton btnRespuesta1;

        @FXML
        private MFXButton btnRespuesta2;

        @FXML
        private MFXButton btnRespuesta3;

        @FXML
        private MFXButton btnRespuesta4;

        @FXML
        private MFXTextField txtPregunta;


        ArrayList<MFXButton> botones = new ArrayList<>();


        @FXML
        void onActionBtnRespuesta(ActionEvent event) {
                MFXButton botonSeleccionado = (MFXButton) event.getSource();
                SimpleStringProperty esCorrecta = (SimpleStringProperty) botonSeleccionado.getUserData();

                if (esCorrecta.get().equals("Y") ){
                        new Mensaje().showModal(Alert.AlertType.INFORMATION, "Correcto", getStage(), "¡Respuesta correcta!");
                        getStage().close();
                } else {
                        if(AppContext.getInstance().get("doble_respuesta") != null && (boolean) AppContext.getInstance().get("doble_respuesta")){
                                new Mensaje().showModal(Alert.AlertType.INFORMATION, "Incorrecto", getStage(), "Respuesta incorrecta, tienes otro intento.");
                                AppContext.getInstance().set("doble_respuesta", false);
                        }
                        else {
                                new Mensaje().showModal(Alert.AlertType.ERROR, "Incorrecto", getStage(), "Respuesta incorrecta.");
                                getStage().close();
                        }

                }
        }


        @Override
        public void initialize(URL url, ResourceBundle rb) {

        }

        @Override
        public void initialize() {
                cargarPreguntaAleatoria();

                btnBomba.setDisable(false);
                btnDobleRespuesta.setDisable(false);
                btnPaso.setDisable(false);



                AppContext.getInstance().set("doble_respuesta", false);

                if(AppContext.getInstance().get("modo_juego").equals("medio")){
                        btnBomba.setDisable(true);
                        btnDobleRespuesta.setDisable(true);
                        btnPaso.setDisable(true);
                }
                else if(AppContext.getInstance().get("modo_juego").equals("dificil")){
                        btnBomba.setDisable(true);
                        btnDobleRespuesta.setDisable(true);
                        btnPaso.setDisable(true);
                }
        }

        private void cargarPreguntaAleatoria() {

                botones.add(btnRespuesta1);
                botones.add(btnRespuesta2);
                botones.add(btnRespuesta3);
                botones.add(btnRespuesta4);

                String categoria = AppContext.getInstance().get("Criterio").toString();
                PreguntasService preguntasService = new PreguntasService();
                Respuesta respuesta = preguntasService.getPreguntasBySearch(categoria);

                if (respuesta.getEstado()) {
                        List<PreguntasDto> preguntasList = (List<PreguntasDto>) respuesta.getResultado("Preguntas");
                        if (!preguntasList.isEmpty()) {
                                // Seleccionar una pregunta aleatoria
                                PreguntasDto preguntaAleatoria = preguntasList.get(new Random().nextInt(preguntasList.size()));

                                // Asignar la pregunta al campo de texto
                                txtPregunta.setText(preguntaAleatoria.getPreguntaTexto());

                                // Obtener y mezclar las respuestas
                                List<RespuestasDto> respuestasList = new ArrayList<>(preguntaAleatoria.getRespuestasList());
                                Collections.shuffle(respuestasList);

                                for (int i = 0; i < respuestasList.size(); i++) {
                                        botones.get(i).setText(respuestasList.get(i).getRespuestaTexto());
                                        botones.get(i).setUserData(respuestasList.get(i).esCorrecta);
                                        botones.get(i).setDisable(false);
                                }
                        } else {
                                new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), respuesta.getMensaje());
                        }
                }
        }



        @FXML
        void onActionBtnBomba(ActionEvent event) {
                btnBomba.setDisable(true);
                int deshabilitadas = 0;
                for (MFXButton boton : botones) {
                        SimpleStringProperty esCorrecta = (SimpleStringProperty) boton.getUserData();
                        if (deshabilitadas < 2 && esCorrecta != null && esCorrecta.get().equals("N")) {
                                boton.setDisable(true);
                                deshabilitadas++;
                        }
                }
        }




        @FXML
        void onActionBtnDobleRespuesta(ActionEvent event) {
                btnDobleRespuesta.setDisable(true);
                AppContext.getInstance().set("doble_respuesta", true);

        }

        @FXML
        void onActionBtnPaso(ActionEvent event) {
                btnPaso.setDisable(true);
                cargarPreguntaAleatoria();
        }

}
