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
import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Kendall Fonseca
 */
public class PlayerSelectionController extends Controller implements Initializable {

    AnimationManager animationManager = AnimationManager.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        animationManager.applyRotationAnimation(roulete);

    }
    @Override
    public void initialize() {

    }

    @FXML
    private ImageView roulete;


    @FXML
    private MFXButton btnFicha1;

    @FXML
    private MFXButton btnFicha2;

    @FXML
    private MFXButton btnFicha3;

    @FXML
    private MFXButton btnFicha4;

    @FXML
    private MFXButton btnFicha5;

    @FXML
    private MFXButton btnFicha6;

    @FXML
    private MFXButton btnGoBack;

    @FXML
    private MFXButton btnNewPlayer;

    @FXML
    private MFXComboBox<?> comboboxPlayers;

    @FXML
    private StackPane root;

    @FXML
    private Label playersNumber;

    @FXML
    private MFXButton btnPlay;




    @FXML
    void onActionBtnFicha1(ActionEvent event) {

    }

    @FXML
    void onActionBtnFicha2(ActionEvent event) {

    }

    @FXML
    void onActionBtnFicha3(ActionEvent event) {

    }

    @FXML
    void onActionBtnFicha4(ActionEvent event) {

    }

    @FXML
    void onActionBtnFicha5(ActionEvent event) {

    }

    @FXML
    void onActionBtnFicha6(ActionEvent event) {

    }

    @FXML
    void onActionBtnGoBack(ActionEvent event) {
        FlowController.getInstance().goView("GameMenuView");

    }

    @FXML
    void onActionBtnNewPlayer(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("RegisterView");
    }

    @FXML
    void onActionBtnPlay(ActionEvent event) {
        FlowController.getInstance().goView("BoardGameView");
    }
    
}
