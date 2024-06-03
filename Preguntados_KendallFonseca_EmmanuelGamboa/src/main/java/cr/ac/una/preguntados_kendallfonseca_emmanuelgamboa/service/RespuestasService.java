package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Preguntas;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Respuestas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class RespuestasService {

        private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PreguntadosPU");
        private final EntityManager em = emf.createEntityManager();

       public List<Respuestas> getAllRespuestas() {
            return em.createNamedQuery("Respuestas.findAll", Respuestas.class).getResultList();
        }

        //obtener respuestas asociadas a la pregunta
        public List<Respuestas> getRespuestasByPregunta(Preguntas idPregunta) {
            return em.createNamedQuery("Respuestas.findByPregunta", Respuestas.class)
                    .setParameter("idPregunta", idPregunta)
                    .getResultList();
        }

        public void addRespuesta(Respuestas respuesta) {
            em.getTransaction().begin();
            em.persist(respuesta);
            em.getTransaction().commit();
        }
}
