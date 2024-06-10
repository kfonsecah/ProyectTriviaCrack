package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.AppContext;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.EntityManagerHelper;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.FlowController;
import jakarta.persistence.EntityManager;
import javafx.application.Application;


import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Estado para manejar animaciones guardando en app context
        AppContext.getInstance().set("StartAnimation", true);
        FlowController.getInstance().InitializeFlow(stage, null);
        FlowController.getInstance().goMain();
    }

    public static void main(String[] args) {
        launch();

    }
}
