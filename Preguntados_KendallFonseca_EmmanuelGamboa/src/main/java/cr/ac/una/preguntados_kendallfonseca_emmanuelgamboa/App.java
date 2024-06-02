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

        // Probar entity creando nuevo jugador
        EntityManager em = EntityManagerHelper.getManager();
        em.getTransaction().begin();
        em.createNativeQuery("INSERT INTO jugadores (nombre, correo, preguntas_respondidas, preguntas_acertadas, partidas_ganadas) VALUES ('Kendall Fonseca', 'lksdklda@', 2, 2, 2)").executeUpdate();
        em.getTransaction().commit();
    }
}
