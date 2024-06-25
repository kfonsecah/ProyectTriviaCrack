package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Partidas;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.PartidasDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.PartidasJugadores;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.PartidasJugadoresDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.EntityManagerHelper;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.Respuesta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

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
            Partidas partidas = new Partidas(partida);

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

    public Respuesta findById(Long id) {
        try {
            Partidas partida = em.createNamedQuery("Partidas.findByIdPartida", Partidas.class)
                    .setParameter("idPartida", id)
                    .getSingleResult();

            return new Respuesta(true, "", "", "PartidaCreada", new PartidasDto(partida));

        } catch (NoResultException ex) {
            return null;
        } catch (Exception ex) {
            Logger.getLogger(PartidasService.class.getName()).log(Level.SEVERE, "Error al buscar partida", ex);
            return new Respuesta(false, "Error al buscar la partida", "findByIdPartida" + ex.getMessage());

        }
    }

    public Respuesta listarPartidas() {
        try {
            List<Partidas> partidas = em.createNamedQuery("Partidas.findAll", Partidas.class)
                    .getResultList();
            List<PartidasDto> dtos = new ArrayList<>();
            for (Partidas partida : partidas) {
                dtos.add(new PartidasDto(partida));
            }
            if(dtos.isEmpty() || dtos == null){
                return new Respuesta(false, "No se encontraron partidas.", "listarPartidas");
            }
            return new Respuesta(true, "", "", "listaPartidas", dtos);
        } catch (Exception ex) {
            Logger.getLogger(PartidasService.class.getName()).log(Level.SEVERE, "Error al listar partidas", ex);
            return new Respuesta(false, "Error al listar partidas.", "listarPartidas " + ex.getMessage());
        }
    }


}
