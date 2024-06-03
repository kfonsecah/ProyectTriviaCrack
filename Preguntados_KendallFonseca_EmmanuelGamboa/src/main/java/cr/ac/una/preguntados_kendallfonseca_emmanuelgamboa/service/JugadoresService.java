package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Jugadores;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.JugadoresDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.EntityManagerHelper;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.Respuesta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JugadoresService {

    EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;

    public Respuesta crearJugadorConNombre(String nombre) {
        try {
            et = em.getTransaction();
            et.begin();
            Jugadores jugador = new Jugadores();
            jugador.setNombre(nombre);
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
}
