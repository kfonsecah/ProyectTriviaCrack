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


}
