package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.controller;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.AnimationManager;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.FlowController;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class SavedGamesController extends Controller implements Initializable {

    String Sound_Click = "/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/sounds/Play.wav";


    @FXML
    private MFXButton btnDelete;

    @FXML
    private MFXButton btnGoBack;

    @FXML
    private MFXButton btnPlay;


    @FXML
    private ImageView meteorito;

    @FXML
    private StackPane root;

    @FXML
    private TableView<?> tbvSavedGames;


    AnimationManager animationManager = AnimationManager.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @Override
    public void initialize() {
    }

    @FXML
    void onACtionBtnDelete(ActionEvent event) {

    }

    @FXML
    void onActionBtnGoBack(ActionEvent event) {
        animationManager.playSound(Sound_Click);
        FlowController.getInstance().goView("StartView");
    }

    @FXML
    void onActionBtnPlay(ActionEvent event) {

    }

    @FXML
    void onAnimationAction(MouseEvent event) {
        animationManager.applyFloatingAnimation(meteorito);

    }


}