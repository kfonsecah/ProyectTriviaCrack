/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.controller;

import java.net.URL;
import java.util.ResourceBundle;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.App;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.AnimationManager;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.AppContext;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.FlowController;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Kendall Fonseca
 */
public class AboutCreatorsController extends Controller implements Initializable {

    String Sound_Click = "/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/sounds/Play.wav";

    @FXML
    private ImageView imgRoullette;

    @FXML
    private StackPane root;

    AnimationManager animationManager = AnimationManager.getInstance();

    @FXML
    private MFXButton btnGoback;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        AppContext.getInstance().set("StartAnimation", false);
        animationManager.applyRotationAnimation(imgRoullette);

    }

    @Override
    public void initialize() {


    }

    @FXML
    void onActionBtnGoback(ActionEvent event) {

        animationManager.playSound(Sound_Click);
        FlowController.getInstance().goView("StartMenuView");

    }
    
}
