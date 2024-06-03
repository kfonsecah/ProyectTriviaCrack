package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Preguntas;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class PreguntasService {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PreguntadosPU");
    private final EntityManager em = emf.createEntityManager();

    public List<Preguntas> getAllPreguntas() {
        return em.createNamedQuery("Preguntas.findAll", Preguntas.class).getResultList();
    }

    //obtener preguntas segun el parametro de busqueda
    public List<Preguntas> getPreguntasBySearch(String categoria) {
        return em.createNamedQuery("Preguntas.findByCategoria", Preguntas.class)
                .setParameter("categoria", categoria)
                .getResultList();
    }

    public void close() {
        em.close();
        emf.close();
    }
}

