/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.controller;

import java.net.URL;
import java.util.ResourceBundle;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.AnimationManager;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.AppContext;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.FlowController;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Kendall Fonseca
 */
public class StartController extends Controller implements Initializable {

    String Sound_Click = "/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/sounds/Play.wav";


    @FXML
    private MFXButton btnGoBack;

    @FXML
    private MFXButton btnSavedMatches;

    @FXML
    private MFXButton btnStadistics;

    @FXML
    private MFXButton btnStarMatch;





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

        AppContext.getInstance().set("StartAnimation", false);

        FlowController.getInstance().goView("StartMenuView");
        animationManager.playSound(Sound_Click);

    }

    @FXML
    void onActionBtnSavedMatches(ActionEvent event) {
        FlowController.getInstance().goView("SavedGamesView");

    }

    @FXML
    void onActionBtnStadistics(ActionEvent event) {
        FlowController.getInstance().goView("StadisticsView");

    }

    @FXML
    void onActionBtnStartMatches(ActionEvent event) {

    }
    
}
