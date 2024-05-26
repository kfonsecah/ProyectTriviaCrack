/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.controller;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.AnimationManager;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MantQuestionsController extends Controller implements Initializable {


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
    private TableView<?> tblAnswers;

    @FXML
    private TableView<?> tblQuestions;

    AnimationManager animationManager = AnimationManager.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle rb){


    }

    @Override
    public void initialize() {
        // TODO
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

}

