package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Partidas;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.PartidasDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.PartidasJugadores;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.PartidasJugadoresDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.EntityManagerHelper;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.Respuesta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PartidasService {

    private EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;

    public Respuesta guardarPartida(PartidasDto partida) {
        try {
            et = em.getTransaction();
            et.begin();
            Partidas partidas = new Partidas();
            partidas.setInformacionJson(partida.getInformacionJson());
            em.persist(partidas);
            et.commit();
            return new Respuesta(true, "", "", "Partida", new PartidasDto(partidas));
        } catch (Exception ex) {
            if (et.isActive()) {
                et.rollback();
            }
            Logger.getLogger(JugadoresService.class.getName()).log(Level.SEVERE, "Error al guardar la partida", ex);
            return new Respuesta(false, "Error al guardar la partida.", "guardarPartida " + ex.getMessage());


        }
    }

    public Respuesta guardarPartidaJugadores(PartidasJugadoresDto partidaJugadores) {
        try {
            et = em.getTransaction();
            et.begin();
            PartidasJugadores partidasJugadores = new PartidasJugadores(partidaJugadores);
            em.persist(partidasJugadores);
            et.commit();
            return new Respuesta(true, "", "", "PartidaJugadores", new PartidasJugadoresDto(partidasJugadores));
        } catch (Exception ex) {
            if (et.isActive()) {
                et.rollback();
            }
            Logger.getLogger(JugadoresService.class.getName()).log(Level.SEVERE, "Error al guardar la partida", ex);
            return new Respuesta(false, "Error al guardar la partida.", "guardarPartida " + ex.getMessage());
        }
    }

}
