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

    AnimationManager animationManager = AnimationManager.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AppContext.getInstance().set("StartAnimation", false);
        animationManager.applyBreathingAnimation(btnInformation);
        //animationManager.fadeOut(txtDialog);
    }

    @Override
    public void initialize() {
        // TODO
    }

    @FXML
    void onActionHover(ActionEvent event) {
    }

    @FXML
    void onActionBtnAlbert(ActionEvent event) {

    }

    @FXML
    void onActionBtnArthur(ActionEvent event) {

    }

    @FXML
    void onActionBtnBonzo(ActionEvent event) {

    }

    @FXML
    void onActionBtnGoBack(ActionEvent event) {
        FlowController.getInstance().goView("StartMenuView");
    }

    @FXML
    void onActionBtnLeonardo(ActionEvent event) {

    }

    @FXML
    void onActionBtnPalomitas(ActionEvent event) {

    }

    @FXML
    void onActionBtnTito(ActionEvent event) {

    }

    @FXML
    void onActionBtnInformation(ActionEvent event) {
        animationManager.fadeIn(txtDialog);






//        // Crear el contenido del diálogo
//        MFXGenericDialog dialogContent = new MFXGenericDialog("Información", "" +
//                "Este es el cuadro de diálogo de información.");
//        dialogContent.setShowClose(true);
//
//        dialogContent.setShowMinimize(false);
//        dialogContent.setShowAlwaysOnTop(false);
//
//
//        // Crear el MFXStageDialog y configurarlo
//        MFXStageDialog dialog = new MFXStageDialog(dialogContent);
//        dialog.setOwnerNode(root); // Establecer el propietario del diálogo
//        dialog.setDraggable(true); // Hacer el dialogo arrastrable
//        dialog.setScrimOwner(true); // Aplicar un scrim (fondo oscuro) al propietario
//        dialog.setScrimStrength(0.7); // Configurar la opacidad del scrim
//        dialog.setCenterInOwnerNode(true); // Centrar el diálogo en el nodo propietario
//
//        // Mostrar el diálogo
//        dialog.show();
    }


}

