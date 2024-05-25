package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.controller;

import java.net.URL;
import java.util.ResourceBundle;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.AnimationManager;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.FlowController;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kendall Fonseca
 */
public class StartMenuController extends Controller implements Initializable {

    String Sound_Startup = "/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/sounds/Startup-App.wav";
    String Sound_Click = "/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/sounds/Play.wav";

    @FXML
    private MFXButton btnAboutOf;

    @FXML
    private MFXButton btnConfig;

    @FXML
    private MFXButton btnPlay;

    @FXML
    private ImageView imgLogo;

    @FXML
    private BorderPane root;

    AnimationManager animationManager = AnimationManager.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        animationManager.applyFloatingAnimation(imgLogo);
        animationManager.applyFadeAnimation(imgLogo);
        animationManager.setCustomCursor(root, "/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/cursor_pointer3D.png");
        animationManager.applySlideInFromBottom(btnPlay);
        animationManager.applySlideInFromBottomSlow(btnConfig);
        animationManager.applySlideInFromBottomSlow(btnAboutOf);
        animationManager.playSound(Sound_Startup);
    }


    @Override
    public void initialize() {
    }

    @FXML
    void onActionbtnAboutOff(ActionEvent event) {

        animationManager.playSound(Sound_Click);
        FlowController.getInstance().goView("AboutCreatorsView");

    }

    @FXML
    void onActionbtnConfig(ActionEvent event) {

    }

    @FXML
    void onActionbtnPlay(ActionEvent event) {
        animationManager.playSound(Sound_Click);

    }


}



