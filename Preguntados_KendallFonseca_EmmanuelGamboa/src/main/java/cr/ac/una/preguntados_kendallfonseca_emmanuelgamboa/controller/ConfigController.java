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
import io.github.palexdev.materialfx.dialogs.MFXGenericDialog;
import io.github.palexdev.materialfx.dialogs.MFXStageDialog;
import javafx.fxml.Initializable;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ConfigController extends Controller implements Initializable {

    String Sound_Click = "/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/sounds/Play.wav";
    String Sound_Open = "/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/sounds/Report.wav";
    @FXML
    private MFXButton btnAlbert;

    @FXML
    private MFXButton btnArthur;

    @FXML
    private MFXButton btnBonzo;

    @FXML
    private MFXButton btnGoBack;

    @FXML
    private MFXButton btnLeonardo;

    @FXML
    private MFXButton btnPalomitas;

    @FXML
    private MFXButton btnTito;

    @FXML
    private MFXButton btnInformation;

    @FXML
    private StackPane root;

    @FXML
    private StackPane txtDialog;


    @FXML
    private StackPane titleStackPane;

    AnimationManager animationManager = AnimationManager.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AppContext.getInstance().set("StartAnimation", false);
        animationManager.applyBreathingAnimation(btnInformation);
        animationManager.applyFloatingAnimation(titleStackPane);
        //animationManager.fadeOut(txtDialog);
    }

    @Override
    public void initialize() {
        // TODO
    }


    @FXML
    void onActionBtnAlbert(ActionEvent event) {
        AppContext.getInstance().set("Criteriodebusqueda", "Ciencia");
        animationManager.playSound(Sound_Open);
        FlowController.getInstance().goView("MantQuestionsView");
    }

    @FXML
    void onActionBtnArthur(ActionEvent event) {
        AppContext.getInstance().set("Criteriodebusqueda", "Historia");
        animationManager.playSound(Sound_Open);
        FlowController.getInstance().goView("MantQuestionsView");


    }

    @FXML
    void onActionBtnBonzo(ActionEvent event) {
        AppContext.getInstance().set("Criteriodebusqueda", "Deportes");
        animationManager.playSound(Sound_Open);
        FlowController.getInstance().goView("MantQuestionsView");
    }

    @FXML
    void onActionBtnGoBack(ActionEvent event) {
        AppContext.getInstance().set("Criteriodebusqueda", "");
        FlowController.getInstance().goView("StartMenuView");
        animationManager.playSound(Sound_Click);
    }

    @FXML
    void onActionBtnLeonardo(ActionEvent event) {
        AppContext.getInstance().set("Criteriodebusqueda", "Arte");
        animationManager.playSound(Sound_Open);
        FlowController.getInstance().goView("MantQuestionsView");

    }

    @FXML
    void onActionBtnPalomitas(ActionEvent event) {
        AppContext.getInstance().set("Criteriodebusqueda", "Pop");
        animationManager.playSound(Sound_Open);
        FlowController.getInstance().goView("MantQuestionsView");

    }

    @FXML
    void onActionBtnTito(ActionEvent event) {
        AppContext.getInstance().set("Criteriodebusqueda", "Geografia");
        animationManager.playSound(Sound_Open);
        FlowController.getInstance().goView("MantQuestionsView");
    }

    @FXML
    void onActionBtnInformation(ActionEvent event) {
        animationManager.fadeIn(txtDialog);
    }


}

