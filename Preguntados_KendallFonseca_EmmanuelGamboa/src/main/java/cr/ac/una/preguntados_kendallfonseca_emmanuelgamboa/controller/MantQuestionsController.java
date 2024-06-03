/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.controller;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Preguntas;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.PreguntasDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Respuestas;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service.PreguntasService;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service.RespuestasService;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.AnimationManager;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.AppContext;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.FlowController;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TableColumn;

import java.net.URL;
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
    private TableView<Preguntas> tblQuestions;

    @FXML
    private TableColumn<Preguntas, Long> colIdPregunta;

    @FXML
    private TableColumn<Preguntas, String> colCategoria;

    @FXML
    private TableColumn<Preguntas, String> colPreguntaTexto;

    @FXML
    private TableColumn<Preguntas, Long> colVecesRespondida;

    @FXML
    private TableColumn<Preguntas, Long> colVecesAcertada;

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
        List<Preguntas> preguntasList = preguntasService.getPreguntasBySearch(AppContext.getInstance().get("Criteriodebusqueda").toString());
        ObservableList<Preguntas> preguntasObservableList = FXCollections.observableArrayList(preguntasList);
        tblQuestions.setItems(preguntasObservableList);

    }

    private void loadRespuestas() {

        tblQuestions.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                Preguntas pregunta = tblQuestions.getSelectionModel().getSelectedItem();
                contentPregunta.setText(pregunta.getPreguntaTexto());
                List<Respuestas> respuestasList = respuestasService.getRespuestasByPregunta(pregunta);
                ObservableList<Respuestas> respuestasObservableList = FXCollections.observableArrayList(respuestasList);

                contentRespuesta1.clear();
                contentRespuesta2.clear();
                contentRespuesta3.clear();
                contentRespuesta4.clear();


                int correctAnswerCount = 0;
                int incorrectAnswerCount = 0;

                for (Respuestas respuesta : respuestasObservableList) {
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
            }
        });
    }


    @Override
    public void initialize() {
        loadPreguntas();
        loadRespuestas();
    }

    private void initializeTableView() {
        colIdPregunta.setCellValueFactory(new PropertyValueFactory<>("idPregunta"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colPreguntaTexto.setCellValueFactory(new PropertyValueFactory<>("preguntaTexto"));
        colVecesRespondida.setCellValueFactory(new PropertyValueFactory<>("vecesRespondida"));
        colVecesAcertada.setCellValueFactory(new PropertyValueFactory<>("vecesAcertada"));
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




    }

    @FXML
    void onActionBtnDeactivate(ActionEvent event) {

    }

    @FXML
    void onActionBtnDelete(ActionEvent event) {

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

