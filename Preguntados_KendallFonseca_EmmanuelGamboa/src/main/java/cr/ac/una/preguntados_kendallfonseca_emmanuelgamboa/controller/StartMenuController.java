package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.controller;

import java.net.URL;
import java.util.ResourceBundle;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.AnimationManager;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Kendall Fonseca
 */
public class StartMenuController extends Controller implements Initializable {


    @FXML
    private MFXButton btnAboutOf;

    @FXML
    private MFXButton btnConfig;

    @FXML
    private MFXButton btnPlay;

    @FXML
    private ImageView imgLogo;

    @FXML
    private AnchorPane root;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AnimationManager animationManager = AnimationManager.getInstance();
        animationManager.applyFloatingAnimation(imgLogo);
        animationManager.applyFadeAnimation(imgLogo);
        animationManager.setCustomCursor(root, "/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/cursor_pointer3D.png");
        animationManager.applySlideInFromBottom(btnPlay);
        animationManager.applySlideInFromBottomSlow(btnConfig);
        animationManager.applySlideInFromBottomSlow(btnAboutOf);
        animationManager.playSound("/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/sounds/Startup-App.wav");
    }


    @Override
    public void initialize() {
    }

    @FXML
    void onActionbtnAboutOff(ActionEvent event) {

    }

    @FXML
    void onActionbtnConfig(ActionEvent event) {

    }

    @FXML
    void onActionbtnPlay(ActionEvent event) {

    }


}



