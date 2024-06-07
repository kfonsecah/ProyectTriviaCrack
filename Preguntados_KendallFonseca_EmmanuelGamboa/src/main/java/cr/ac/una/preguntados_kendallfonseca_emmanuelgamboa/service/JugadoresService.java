package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Jugadores;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.JugadoresDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.EntityManagerHelper;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.Respuesta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JugadoresService {

    EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;

    public Respuesta findByNombre(String nombre) {
        try {
            Jugadores jugador = (Jugadores) em.createNamedQuery("Jugadores.findByNombre")
                    .setParameter("nombre", nombre)
                    .getSingleResult();
            return new Respuesta(true, "", "", "Jugador", new JugadoresDto(jugador));
        } catch (NoResultException ex) {
            return null;
        } catch (Exception ex) {
            Logger.getLogger(JugadoresService.class.getName()).log(Level.SEVERE, "Error al buscar el jugador.", ex);
            return new Respuesta(false, "Error al buscar el jugador.", "findByNombre " + ex.getMessage());
        }
    }

    public Respuesta crearJugadorConNombre(String nombre) {
        try {

            if (findByNombre(nombre) != null) {
                return new Respuesta(false, "El nombre ya está en uso. Por favor, elige otro nombre."+ nombre, "", "Jugador", null);
            }

            et = em.getTransaction();
            et.begin();
            Jugadores jugador = new Jugadores();
            jugador.setNombre(nombre);
            jugador.setCorreo(nombre+ "@preguntados.com");
            jugador.setPreguntasRespondidas(Long.valueOf(0));
            jugador.setPreguntasAcertadas(Long.valueOf(0));
            jugador.setPartidasGanadas(Long.valueOf(0));

            em.persist(jugador);
            et.commit();
            return new Respuesta(true, "", "", "Jugador", new JugadoresDto(jugador));
        } catch (Exception ex) {
            if (et.isActive()) {
                et.rollback();
            }
            Logger.getLogger(JugadoresService.class.getName()).log(Level.SEVERE, "Error al guardar el jugador.", ex);
            return new Respuesta(false, "Error al guardar el jugador.", "crearJugadorConNombre " + ex.getMessage());
        }
    }

    public Respuesta getJugadores() {
        try {
            List<Jugadores> jugadoresList = em.createNamedQuery("Jugadores.findAll", Jugadores.class).getResultList();
            List<JugadoresDto> jugadoresDtoList = new ArrayList<>();
            for (Jugadores jugador : jugadoresList) {
                jugadoresDtoList.add(new JugadoresDto(jugador));
            }
            return new Respuesta(true, "", "", "JugadoresList", jugadoresDtoList);
        } catch (Exception ex) {
            Logger.getLogger(JugadoresService.class.getName()).log(Level.SEVERE, "Error al obtener los jugadores.", ex);
            return new Respuesta(false, "Error al obtener los jugadores.", "getJugadores " + ex.getMessage());
        }
    }
}
