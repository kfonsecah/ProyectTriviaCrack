/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.controller;

import java.net.URL;
import java.util.ResourceBundle;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.AnimationManager;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.FlowController;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXSpinner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Kendall Fonseca
 */
public class GameMenuController extends Controller implements Initializable{

    @FXML
    private MFXButton btnGoBack;

    @FXML
    private MFXButton btnInfo;

    @FXML
    private MFXButton btnEasyMode;

    @FXML
    private MFXButton btnHardMode;

    @FXML
    private MFXButton btnMidMode;

    @FXML
    private MFXButton player1ficha1;

    @FXML
    private MFXButton player1ficha2;

    @FXML
    private MFXButton player1ficha3;

    @FXML
    private MFXButton player1ficha4;

    @FXML
    private MFXButton player1ficha5;

    @FXML
    private MFXButton player1ficha6;

    @FXML
    private MFXButton player2ficha1;

    @FXML
    private MFXButton player2ficha2;

    @FXML
    private MFXButton player2ficha3;

    @FXML
    private MFXButton player2ficha4;

    @FXML
    private MFXButton player2ficha5;

    @FXML
    private MFXButton player2ficha6;

    @FXML
    private MFXButton player3ficha1;

    @FXML
    private MFXButton player3ficha2;

    @FXML
    private MFXButton player3ficha3;

    @FXML
    private MFXButton player3ficha4;

    @FXML
    private MFXButton player3ficha5;

    @FXML
    private MFXButton player3ficha6;

    @FXML
    private MFXButton player4ficha1;

    @FXML
    private MFXButton player4ficha2;

    @FXML
    private MFXButton player4ficha3;

    @FXML
    private MFXButton player4ficha4;

    @FXML
    private MFXButton player4ficha5;

    @FXML
    private MFXButton player4ficha6;

    @FXML
    private MFXButton player5ficha1;

    @FXML
    private MFXButton player5ficha2;

    @FXML
    private MFXButton player5ficha3;

    @FXML
    private MFXButton player5ficha4;

    @FXML
    private MFXButton player5ficha5;

    @FXML
    private MFXButton player5ficha6;

    @FXML
    private MFXButton player6ficha1;

    @FXML
    private MFXButton player6ficha2;

    @FXML
    private MFXButton player6ficha3;

    @FXML
    private MFXButton player6ficha4;

    @FXML
    private MFXButton player6ficha5;

    @FXML
    private MFXButton player6ficha6;

    @FXML
    private MFXSpinner<?> spinnerGameTime;

    @FXML
    private MFXSpinner<?> spinnerPlayersQuantity;


    String Sound_Click = "/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/sounds/Play.wav";

    AnimationManager animationManager = AnimationManager.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void initialize() {

    }

    @FXML
    void onActionBtnGoBack(ActionEvent event) {
        animationManager.playSound(Sound_Click);
        FlowController.getInstance().goView("StartView");

    }

    @FXML
    void onActionBtnHelp(ActionEvent event) {

        FlowController.getInstance().goViewInWindow("InstructionsView");

    }

    @FXML
    void onActionBtnEasyMode(ActionEvent event) {

    }

    @FXML
    void onActionBtnHardMode(ActionEvent event) {

    }

    @FXML
    void onActionBtnMidMode(ActionEvent event) {

    }

    @FXML
    void onActionPlayer1ficha1(ActionEvent event) {

    }

    @FXML
    void onActionPlayer1ficha2(ActionEvent event) {

    }

    @FXML
    void onActionPlayer1ficha3(ActionEvent event) {

    }

    @FXML
    void onActionPlayer1ficha4(ActionEvent event) {

    }

    @FXML
    void onActionPlayer1ficha5(ActionEvent event) {

    }

    @FXML
    void onActionPlayer1ficha6(ActionEvent event) {

    }

    @FXML
    void onActionPlayer2ficha1(ActionEvent event) {

    }

    @FXML
    void onActionPlayer2ficha2(ActionEvent event) {

    }

    @FXML
    void onActionPlayer2ficha3(ActionEvent event) {

    }

    @FXML
    void onActionPlayer2ficha4(ActionEvent event) {

    }

    @FXML
    void onActionPlayer2ficha5(ActionEvent event) {

    }

    @FXML
    void onActionPlayer2ficha6(ActionEvent event) {

    }

    @FXML
    void onActionPlayer3ficha1(ActionEvent event) {

    }

    @FXML
    void onActionPlayer3ficha2(ActionEvent event) {

    }

    @FXML
    void onActionPlayer3ficha3(ActionEvent event) {

    }

    @FXML
    void onActionPlayer3ficha4(ActionEvent event) {

    }

    @FXML
    void onActionPlayer3ficha5(ActionEvent event) {

    }

    @FXML
    void onActionPlayer3ficha6(ActionEvent event) {

    }

    @FXML
    void onActionPlayer4ficha1(ActionEvent event) {

    }

    @FXML
    void onActionPlayer4ficha2(ActionEvent event) {

    }

    @FXML
    void onActionPlayer4ficha3(ActionEvent event) {

    }

    @FXML
    void onActionPlayer4ficha4(ActionEvent event) {

    }

    @FXML
    void onActionPlayer4ficha5(ActionEvent event) {

    }

    @FXML
    void onActionPlayer4ficha6(ActionEvent event) {

    }

    @FXML
    void onActionPlayer5ficha1(ActionEvent event) {

    }

    @FXML
    void onActionPlayer5ficha2(ActionEvent event) {

    }

    @FXML
    void onActionPlayer5ficha3(ActionEvent event) {

    }

    @FXML
    void onActionPlayer5ficha4(ActionEvent event) {

    }

    @FXML
    void onActionPlayer5ficha5(ActionEvent event) {

    }

    @FXML
    void onActionPlayer5ficha6(ActionEvent event) {

    }

    @FXML
    void onActionPlayer6ficha1(ActionEvent event) {

    }

    @FXML
    void onActionPlayer6ficha2(ActionEvent event) {

    }

    @FXML
    void onActionPlayer6ficha3(ActionEvent event) {

    }

    @FXML
    void onActionPlayer6ficha4(ActionEvent event) {

    }

    @FXML
    void onActionPlayer6ficha5(ActionEvent event) {

    }

    @FXML
    void onActionPlayer6ficha6(ActionEvent event) {

    }



}
