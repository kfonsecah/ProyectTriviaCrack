package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Partidas;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.EntityManagerHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartidasService {

    private EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;

    public Partidas crearNuevaPartida() {
        et = em.getTransaction();
        et.begin();
        Partidas partida = new Partidas();
        em.persist(partida);
        et.commit();
        return partida;
    }

    public void guardarPartida(Partidas partida) {
        et = em.getTransaction();
        et.begin();
        em.merge(partida);
        et.commit();
    }
}
