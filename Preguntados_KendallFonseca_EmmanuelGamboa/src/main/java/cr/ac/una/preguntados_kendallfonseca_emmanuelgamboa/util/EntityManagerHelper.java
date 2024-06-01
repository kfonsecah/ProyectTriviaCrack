package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Clase que se encarga de manejar la conexión con la base de datos
 */

public class EntityManagerHelper {

    private static final EntityManagerHelper SINGLENTON = new EntityManagerHelper();
    private static EntityManagerFactory emf;
    private static EntityManager em;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("PreguntadosPU");
            em = emf.createEntityManager();
        } catch (ExceptionInInitializerError e) {
            throw e;
        }
    }

    public static EntityManagerHelper getInstance() {
        return SINGLENTON;
    }

    public static EntityManager getManager() {
        if (em == null) {
            emf = Persistence.createEntityManagerFactory("PreguntadosPU");
            em = emf.createEntityManager();
        }
        return em;
    }
}
