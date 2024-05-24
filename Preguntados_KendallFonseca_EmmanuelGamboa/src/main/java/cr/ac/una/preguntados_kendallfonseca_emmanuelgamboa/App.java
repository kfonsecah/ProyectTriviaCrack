package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.controller.StartMenuController;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.FlowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FlowController.getInstance().InitializeFlow(stage, null);
        FlowController.getInstance().goMain();
    }


    public static void main(String[] args) {
        launch();
    }

}