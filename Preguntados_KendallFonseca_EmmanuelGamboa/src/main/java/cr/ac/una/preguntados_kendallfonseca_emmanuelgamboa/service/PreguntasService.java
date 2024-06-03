package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Preguntas;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.PreguntasDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Respuestas;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.RespuestasDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.Respuesta;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

public class PreguntasService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PreguntadosPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction et;

    public List<Preguntas> getAllPreguntas() {
        return em.createNamedQuery("Preguntas.findAll", Preguntas.class).getResultList();
    }

    //obtener preguntas segun el parametro de busqueda
    public List<PreguntasDto> getPreguntasBySearch(String categoria) {
        List<Preguntas> preguntasList = em.createNamedQuery("Preguntas.findByCategoria", Preguntas.class)
                .setParameter("categoria", categoria)
                .getResultList();
        return preguntasList.stream().map(PreguntasDto::new).collect(Collectors.toList());
    }

    public Respuesta addPregunta(PreguntasDto preguntaDto, List<RespuestasDto> respuestasDtos) {
        try {
            et= em.getTransaction();
            et.begin();

            // Convertir PreguntasDto a Preguntas, con metodo actualizar hubiese sido mas facil
            Preguntas pregunta = new Preguntas();
            pregunta.setCategoria(preguntaDto.getCategoria());
            pregunta.setPreguntaTexto(preguntaDto.getPreguntaTexto());
            pregunta.setVecesRespondida(preguntaDto.getVecesRespondida());
            pregunta.setVecesAcertada(preguntaDto.getVecesAcertada());
            pregunta.setEstado(preguntaDto.getEstado());

            // Persistir la pregunta
            em.persist(pregunta);
            em.flush();

            // Convertir RespuestasDto a Respuestas y persistir
            for (RespuestasDto respuestasDto : respuestasDtos) {
                Respuestas respuesta = new Respuestas();
                respuesta.setRespuestaTexto(respuestasDto.getRespuestaTexto());
                respuesta.setEsCorrecta(respuestasDto.getEsCorrecta());
                respuesta.setVecesSeleccionada(respuestasDto.getVecesSeleccionada());
                respuesta.setIdPregunta(pregunta); // Establecer relacion con la pregunta

                em.persist(respuesta);
            }
            em.flush();
            et.commit();

            em.refresh(pregunta);
            return new Respuesta(true, "", "", "Pregunta", new PreguntasDto(pregunta));
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                et.rollback();
            }
            return new Respuesta(false, "Error al guardar la pregunta.", "addPregunta " + ex.getMessage());
        }
    }

    public List<RespuestasDto> getRespuestasByPregunta(PreguntasDto preguntaDto) {
        Preguntas pregunta = em.find(Preguntas.class, preguntaDto.getIdPregunta());
        if (pregunta != null) {
            List<Respuestas> respuestasList = pregunta.getRespuestasList();
            return respuestasList.stream().map(RespuestasDto::new).collect(Collectors.toList());
        }
        return null;
    }

    public Respuesta deletePregunta(PreguntasDto preguntaDto) {
        try {
            et = em.getTransaction();
            et.begin();
            Preguntas pregunta = em.find(Preguntas.class, preguntaDto.getIdPregunta());
            if (pregunta != null) {
                for (Respuestas respuesta : pregunta.getRespuestasList()) {
                    em.remove(respuesta);
                }
                em.remove(pregunta);
                et.commit();
                return new Respuesta(true, "", "", "Pregunta eliminada correctamente", null);
            } else {
                et.rollback();
                return new Respuesta(false, "Pregunta no encontrada.", "deletePregunta");
            }
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                et.rollback();
            }
            return new Respuesta(false, "Error al eliminar la pregunta.", "deletePregunta " + ex.getMessage());
        }
    }

    public Respuesta deactivatePregunta(PreguntasDto preguntaDto) {
        try {
            et = em.getTransaction();
            et.begin();
            Preguntas pregunta = em.find(Preguntas.class, preguntaDto.getIdPregunta());
            if (pregunta != null) {
                pregunta.setEstado("I");
                em.merge(pregunta);
                et.commit();
                return new Respuesta(true, "", "", "Pregunta desactivada correctamente", null);
            } else {
                et.rollback();
                return new Respuesta(false, "Pregunta no encontrada.", "deactivatePregunta");
            }
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                et.rollback();
            }
            return new Respuesta(false, "Error al desactivar la pregunta.", "deactivatePregunta " + ex.getMessage());
        }
    }

}

