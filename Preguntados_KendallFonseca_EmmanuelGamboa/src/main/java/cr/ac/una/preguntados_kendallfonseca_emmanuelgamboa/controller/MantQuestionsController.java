/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.controller;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Preguntas;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.PreguntasDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Respuestas;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.RespuestasDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service.PreguntasService;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service.RespuestasService;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.*;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MantQuestionsController extends Controller implements Initializable {

    String Sound_Click = "/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/sounds/Play.wav";


    @FXML
    private MFXButton btnGoBack;

    AnimationManager animationManager = AnimationManager.getInstance();


    @FXML
    private MFXButton btnAdd;

    @FXML
    private MFXButton btnDeactivate;

    @FXML
    private MFXButton btnDelete;

    @FXML
    private MFXButton btnEdit;

    @FXML
    private MFXButton btnSearch;

    @FXML
    private MFXTextField fieldSearch;

    @FXML
    private StackPane rainBackground;

    @FXML
    private MFXComboBox<?> searchCriterion;

    @FXML
    private TableView<Respuestas> tblAnswers;

    @FXML
    private TableView<PreguntasDto> tblQuestions;

    @FXML
    private TableColumn<PreguntasDto, Long> colIdPregunta;

    @FXML
    private TableColumn<PreguntasDto, String> colCategoria;

    @FXML
    private TableColumn<PreguntasDto, String> colPreguntaTexto;

    @FXML
    private TableColumn<PreguntasDto, Long> colVecesRespondida;

    @FXML
    private TableColumn<PreguntasDto, Long> colVecesAcertada;

    @FXML
    private TableColumn<PreguntasDto, String> colEstado;

    @FXML
    private MFXTextField contentPregunta;

    @FXML
    private MFXTextField contentRespuesta1;

    @FXML
    private MFXTextField contentRespuesta2;

    @FXML
    private MFXTextField contentRespuesta3;

    @FXML
    private MFXTextField contentRespuesta4;

    @FXML
    private MFXButton btnNuevaPregunta;

    private PreguntasService preguntasService;

    private RespuestasService respuestasService;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        preguntasService = new PreguntasService();
        respuestasService = new RespuestasService();
        btnAdd.setDisable(true);
        initializeTableView();
    }
    private void loadPreguntas() {
        Respuesta respuesta = preguntasService.getPreguntasBySearch(AppContext.getInstance().get("Criteriodebusqueda").toString());
        if (!respuesta.getEstado()) {
            animationManager.playSound(Sound_Click);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), respuesta.getMensaje());
            tblQuestions.getItems().clear();
        } else {
           tblQuestions.getItems().clear();
           List<PreguntasDto> preguntasList = (List<PreguntasDto>) respuesta.getResultado("Preguntas");
           ObservableList<PreguntasDto> preguntasObservableList = FXCollections.observableArrayList(preguntasList);
           tblQuestions.setItems(preguntasObservableList);
        }
    }

    private void loadRespuestas() {
        tblQuestions.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                PreguntasDto pregunta = tblQuestions.getSelectionModel().getSelectedItem();
                contentPregunta.setText(pregunta.getPreguntaTexto());
                List<RespuestasDto> respuestasList = preguntasService.getRespuestasByPregunta(pregunta);

                // Verificacion para asegurarse de que la lista de respuestas no sea nula
                if (respuestasList != null) {
                    ObservableList<RespuestasDto> respuestasObservableList = FXCollections.observableArrayList(respuestasList);

                    contentRespuesta1.clear();
                    contentRespuesta2.clear();
                    contentRespuesta3.clear();
                    contentRespuesta4.clear();

                    int correctAnswerCount = 0;
                    int incorrectAnswerCount = 0;

                    for (RespuestasDto respuesta : respuestasObservableList) {
                        if (respuesta.getEsCorrecta().equals("Y")) {
                            if (correctAnswerCount == 0) {
                                contentRespuesta1.setText(respuesta.getRespuestaTexto());
                                correctAnswerCount++;
                            }
                        } else {
                            switch (incorrectAnswerCount) {
                                case 0:
                                    contentRespuesta2.setText(respuesta.getRespuestaTexto());
                                    break;
                                case 1:
                                    contentRespuesta3.setText(respuesta.getRespuestaTexto());
                                    break;
                                case 2:
                                    contentRespuesta4.setText(respuesta.getRespuestaTexto());
                                    break;
                            }
                            incorrectAnswerCount++;
                        }
                    }
                } else {
                    // Manejar caso en el que la lista de respuestas es nula
                    contentRespuesta1.clear();
                    contentRespuesta2.clear();
                    contentRespuesta3.clear();
                    contentRespuesta4.clear();
                }
            }
        });
    }

    @Override
    public void initialize() {
        loadPreguntas();
    }

    private void initializeTableView() {
        colIdPregunta.setCellValueFactory(new PropertyValueFactory<>("idPregunta"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colPreguntaTexto.setCellValueFactory(new PropertyValueFactory<>("preguntaTexto"));
        colVecesRespondida.setCellValueFactory(new PropertyValueFactory<>("vecesRespondida"));
        colVecesAcertada.setCellValueFactory(new PropertyValueFactory<>("vecesAcertada"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
    }
    @FXML
    void onActionBtnNueva(ActionEvent event) {
        btnAdd.setDisable(false);

        contentPregunta.clear();
        contentRespuesta1.clear();
        contentRespuesta2.clear();
        contentRespuesta3.clear();
        contentRespuesta4.clear();

        contentPregunta.requestFocus();

        nuevaPregunta();

    }

    private void nuevaPregunta(){
        PreguntasDto pregunta = new PreguntasDto();
    }

    @FXML
    void onActionBtnAdd(ActionEvent event) {
        String pregunta = contentPregunta.getText();
        String respuesta1 = contentRespuesta1.getText();
        String respuesta2 = contentRespuesta2.getText();
        String respuesta3 = contentRespuesta3.getText();
        String respuesta4 = contentRespuesta4.getText();

        if (pregunta.isEmpty() || respuesta1.isEmpty() || respuesta2.isEmpty() || respuesta3.isEmpty() || respuesta4.isEmpty()) {
            animationManager.playSound(Sound_Click);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "Todos los campos son requeridos.");
        } else {
            PreguntasDto preguntaDto = new PreguntasDto();
            preguntaDto.setPreguntaTexto(pregunta);
            preguntaDto.setCategoria(AppContext.getInstance().get("Criteriodebusqueda").toString());
            preguntaDto.setVecesRespondida(Long.valueOf(0));
            preguntaDto.setVecesAcertada(Long.valueOf(0));

            RespuestasDto respuesta1Dto = new RespuestasDto();
            respuesta1Dto.setRespuestaTexto(respuesta1);
            respuesta1Dto.setEsCorrecta("Y");

            RespuestasDto respuesta2Dto = new RespuestasDto();
            respuesta2Dto.setRespuestaTexto(respuesta2);
            respuesta2Dto.setEsCorrecta("N");

            RespuestasDto respuesta3Dto = new RespuestasDto();
            respuesta3Dto.setRespuestaTexto(respuesta3);
            respuesta3Dto.setEsCorrecta("N");

            RespuestasDto respuesta4Dto = new RespuestasDto();
            respuesta4Dto.setRespuestaTexto(respuesta4);
            respuesta4Dto.setEsCorrecta("N");

            List<RespuestasDto> respuestas = List.of(respuesta1Dto, respuesta2Dto, respuesta3Dto, respuesta4Dto);

            Respuesta respuesta = preguntasService.addPregunta(preguntaDto, respuestas);

            if (!respuesta.getEstado()) {
                animationManager.playSound(Sound_Click);
                new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), respuesta.getMensaje());
            } else {
                animationManager.playSound(Sound_Click);
                new Mensaje().showModal(Alert.AlertType.INFORMATION, "Éxito", getStage(), "Pregunta guardada correctamente.");
                loadPreguntas();
                loadRespuestas();


            }

        }






    }

    @FXML
    void onActionBtnDeactivate(ActionEvent event) {
        PreguntasDto pregunta= tblQuestions.getSelectionModel().getSelectedItem();
        Respuesta respuesta = preguntasService.deactivatePregunta(pregunta);
        if (!respuesta.getEstado()) {
            animationManager.playSound(Sound_Click);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "Error al desactivar la pregunta.");
        }else{
            animationManager.playSound(Sound_Click);
            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Éxito", getStage(), "Pregunta desactivada correctamente.");
            //cambiar color de la pregunta desactivada
            loadPreguntas();

            loadRespuestas();
        }

    }

    @FXML
    void onActionBtnDelete(ActionEvent event) {

     PreguntasDto pregunta= tblQuestions.getSelectionModel().getSelectedItem();
     Respuesta respuesta = preguntasService.deletePregunta(pregunta);
     if (!respuesta.getEstado()) {
         animationManager.playSound(Sound_Click);
         new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "Error al eliminar la pregunta.");
     }else{
            animationManager.playSound(Sound_Click);
            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Éxito", getStage(), "Pregunta eliminada correctamente.");
            loadPreguntas();
            loadRespuestas();
     }

    }

    @FXML
    void onActionBtnEdit(ActionEvent event) {

    }

    @FXML
    void onActionBtnSearch(ActionEvent event) {

    }

    @FXML
    void onActionBtnGoBack(ActionEvent event) {
        AppContext.getInstance().delete("Criteriodebusqueda");
        FlowController.getInstance().goView("ConfigView");
        animationManager.playSound(Sound_Click);

    }

}

