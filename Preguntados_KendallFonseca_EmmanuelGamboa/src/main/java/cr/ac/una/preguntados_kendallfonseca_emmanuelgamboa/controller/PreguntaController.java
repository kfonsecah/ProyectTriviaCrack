/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.controller;

import java.net.URL;
import java.util.ResourceBundle;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Kendall Fonseca
 */
public class PreguntaController extends Controller implements Initializable {


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

        @FXML
        void onActionBtnRespuesta1(ActionEvent event) {

        }

        @FXML
        void onActionBtnRespuesta2(ActionEvent event) {

        }

        @FXML
        void onActionBtnRespuesta3(ActionEvent event) {

        }

        @FXML
        void onActionBtnRespuesta4(ActionEvent event) {

        }

        @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void initialize() {
        // TODO
    }
}
