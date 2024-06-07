/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.controller;

import java.net.URL;
import java.util.ResourceBundle;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.AnimationManager;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.FlowController;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.Mensaje;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXSpinner;
import io.github.palexdev.materialfx.controls.models.spinner.IntegerSpinnerModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.StackPane;

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
    private StackPane root;

    @FXML
    private MFXButton btnEasyMode;

    @FXML
    private MFXButton btnHardMode;

    @FXML
    private MFXButton btnMidMode;

    @FXML
    private MFXButton btnJugar;

    @FXML
    private MFXSpinner<Integer> spinnerGameTime;
    @FXML
    private MFXSpinner<Integer> spinnerPlayersQuantity;


    String Sound_Click = "/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/sounds/Play.wav";

    AnimationManager animationManager = AnimationManager.getInstance();

    String modo_juego = "";
    String jsonInfo = "";

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        IntegerSpinnerModel gameTime = new IntegerSpinnerModel();
        gameTime.setMax(60);
        gameTime.setMin(7);

        IntegerSpinnerModel playersQuantity = new IntegerSpinnerModel();
        playersQuantity.setMax(6);
        playersQuantity.setMin(2);


        spinnerGameTime.setSpinnerModel(gameTime);
        spinnerPlayersQuantity.setSpinnerModel(playersQuantity);
    }

    @Override
    public void initialize() {

    }




    @FXML
    void onActionBtnGoBack(ActionEvent event) {
        animationManager.playSound(Sound_Click);
        FlowController.getInstance().goView("StartView");
        jsonInfo = "";

    }

    @FXML
    void onActionBtnHelp(ActionEvent event) {

        FlowController.getInstance().goViewInWindow("InstructionsView");

    }

    @FXML
    void onActionBtnEasyMode(ActionEvent event) {

        modo_juego = "facil";

    }

    @FXML
    void onActionBtnHardMode(ActionEvent event) {

       modo_juego = "dificil";
    }

    @FXML
    void onActionBtnMidMode(ActionEvent event) {

       modo_juego = "medio";
    }


    @FXML
    void onActionBtnJugar(ActionEvent event) {
        if (modo_juego.equals("")||spinnerGameTime.getValue()<7||spinnerPlayersQuantity.getValue()<2){

            new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), "Por favor seleccione un modo de juego, tiempo de partida y mas de un jugadores");
            return;
        }
        animationManager.playSound(Sound_Click);
        FlowController.getInstance().goView("PlayerSelectionView");


        jsonInfo= "{"+
                "\"modo_juego\":\""+modo_juego+"\","+
                "\"tiempo_juego\":"+spinnerGameTime.getValue()+","+
                "\"cantidad_jugadores\":"+spinnerPlayersQuantity.getValue()+
                "}";

        System.out.println(jsonInfo);
    }



}
