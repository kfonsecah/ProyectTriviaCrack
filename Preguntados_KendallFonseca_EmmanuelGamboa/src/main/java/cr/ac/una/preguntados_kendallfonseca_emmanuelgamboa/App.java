package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.FlowController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FlowController.getInstance().InitializeFlow(stage, null);
        FlowController.getInstance().goMain();
    }

    public static void main(String[] args) {
        launch();
    }
}
