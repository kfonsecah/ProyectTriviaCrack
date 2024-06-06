package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Preguntas;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.PreguntasDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Respuestas;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.RespuestasDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.Respuesta;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PreguntasService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PreguntadosPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction et;

    public Respuesta getAllPreguntas() {
        List<Preguntas> preguntasList = em.createNamedQuery("Preguntas.findAll", Preguntas.class).getResultList();
        List<PreguntasDto> preguntasDtoList = preguntasList.stream().map(PreguntasDto::new).collect(Collectors.toList());
        if (preguntasDtoList.isEmpty() || preguntasDtoList == null) {
            return new Respuesta(false, "No se encontraron preguntas.", "getAllPreguntas");
        }
        else {
            return new Respuesta(true, "", "", "Preguntas" , preguntasDtoList);
        }
    }

    //obtener preguntas segun el parametro de busqueda
    public Respuesta getPreguntasBySearch(String categoria) {
        List<Preguntas> preguntasList = em.createNamedQuery("Preguntas.findByCategoria", Preguntas.class)
                .setParameter("categoria", categoria)
                .getResultList();
        List<PreguntasDto> preguntasDtoList = new ArrayList<>();
        for (Preguntas pregunta : preguntasList) {
            preguntasDtoList.add(new PreguntasDto(pregunta));
        }
        if (preguntasDtoList.isEmpty() || preguntasDtoList == null) {
            return new Respuesta(false, "No se encontraron preguntas asociadas a esta categoria.", "getPreguntasBySearch");
        }
        else {
            return new Respuesta(true, "", "", "Preguntas" , preguntasDtoList);
        }
    }

    public Respuesta addPregunta(PreguntasDto preguntaDto) {
        try {
            et = em.getTransaction();
            et.begin();

            // Convertir PreguntasDto a Preguntas
            Preguntas pregunta = new Preguntas();
            pregunta.setCategoria(preguntaDto.getCategoria());
            pregunta.setPreguntaTexto(preguntaDto.getPreguntaTexto());
            pregunta.setVecesRespondida(preguntaDto.getVecesRespondida());
            pregunta.setVecesAcertada(preguntaDto.getVecesAcertada());
            pregunta.setEstado(preguntaDto.getEstado());

            List<Respuestas> respuestasList = new ArrayList<>();
            for (RespuestasDto respuestasDto : preguntaDto.getRespuestasList()) {
                Respuestas respuesta = new Respuestas();
                respuesta.setRespuestaTexto(respuestasDto.getRespuestaTexto());
                respuesta.setEsCorrecta(respuestasDto.getEsCorrecta());
                respuesta.setVecesSeleccionada(respuestasDto.getVecesSeleccionada());
                respuesta.setIdPregunta(pregunta);
                respuestasList.add(respuesta);
            }

            pregunta.setRespuestasList(respuestasList);


            em.persist(pregunta);


            et.commit();

            return new Respuesta(true, "", "", "Pregunta", new PreguntasDto(pregunta));
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
            return new Respuesta(false, "Error al guardar la pregunta.", "addPregunta " + ex.getMessage());
        }
    }



    public Respuesta deletePregunta(PreguntasDto preguntaDto) {
        try {
            et = em.getTransaction();
            et.begin();
            Preguntas pregunta = em.find(Preguntas.class, preguntaDto.getIdPregunta());
            if (pregunta != null) {
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

    public Respuesta updatePregunta(PreguntasDto preguntaDto) {
        try {
            et = em.getTransaction();
            et.begin();
            Preguntas pregunta = em.find(Preguntas.class, preguntaDto.getIdPregunta());
            if (pregunta != null) {
                pregunta.setCategoria(preguntaDto.getCategoria());
                pregunta.setPreguntaTexto(preguntaDto.getPreguntaTexto());
                pregunta.setVecesRespondida(preguntaDto.getVecesRespondida());
                pregunta.setVecesAcertada(preguntaDto.getVecesAcertada());
                pregunta.setEstado(preguntaDto.getEstado());

                // Actualizar las respuestas
                List<Respuestas> respuestasList = pregunta.getRespuestasList();
                respuestasList.clear();

                for (RespuestasDto respuestasDto : preguntaDto.getRespuestasList()) {
                    Respuestas respuesta = new Respuestas();
                    respuesta.setRespuestaTexto(respuestasDto.getRespuestaTexto());
                    respuesta.setEsCorrecta(respuestasDto.getEsCorrecta());
                    respuesta.setVecesSeleccionada(respuestasDto.getVecesSeleccionada());
                    respuesta.setIdPregunta(pregunta);
                    respuestasList.add(respuesta);
                }

                pregunta.setRespuestasList(respuestasList);
                em.merge(pregunta);
                et.commit();
                return new Respuesta(true, "", "", "Pregunta actualizada correctamente", new PreguntasDto(pregunta));
            } else {
                et.rollback();
                return new Respuesta(false, "Pregunta no encontrada.", "updatePregunta");
            }
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                et.rollback();
            }
            return new Respuesta(false, "Error al actualizar la pregunta.", "updatePregunta " + ex.getMessage());
        }
    }




}

