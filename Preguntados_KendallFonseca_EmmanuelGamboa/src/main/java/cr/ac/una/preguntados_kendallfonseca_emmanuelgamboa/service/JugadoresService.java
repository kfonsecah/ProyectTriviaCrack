package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.*;
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
        EntityTransaction et = null;
        try {
            // Verificar si el nombre ya existe
            if (findByNombre(nombre) != null) {
                return new Respuesta(false, "El nombre ya está en uso. Por favor, elige otro nombre.", nombre, "Jugador", null);
            }

            et = em.getTransaction();
            et.begin();
            Jugadores jugador = new Jugadores();
            jugador.setNombre(nombre);
            jugador.setCorreo(nombre + "@preguntados.com");
            jugador.setPreguntasRespondidas(Long.valueOf(0));
            jugador.setPreguntasAcertadas(Long.valueOf(0));
            jugador.setPartidasGanadas(Long.valueOf(0));


            // Categorias predefinidas
            String[] categorias = {"Arte", "Pop", "Ciencia", "Geografia", "Deporte", "Historia"};

            // Crear estadisticas iniciales para cada categoría
            List<Estadisticas> estadisticasList = new ArrayList<>();
            for (String categoria : categorias) {
                Estadisticas estadistica = new Estadisticas();
                estadistica.setCategoria(categoria);
                estadistica.setPreguntasRespondidasCategoria(Long.valueOf(0));
                estadistica.setPreguntasAcertadasCategoria(Long.valueOf(0));
                estadistica.setRespuestasTotalesRespondidas(Long.valueOf(0));
                estadistica.setRespuestasTotalesAcertadas(Long.valueOf(0));
                estadistica.setIdJugador(jugador);
                estadisticasList.add(estadistica);
            }
            jugador.setEstadisticasList(estadisticasList);

            jugador.setPartidasJugadoresList(new ArrayList<>());

            em.persist(jugador);
            for (Estadisticas estadistica : estadisticasList) {
                em.persist(estadistica);
            }
            et.commit();

            return new Respuesta(true, "Jugador creado con éxito.", "", "Jugador", new JugadoresDto(jugador));
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
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

    public Respuesta uptade(JugadoresDto jugadoresDto) {
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            Jugadores jugador = em.find(Jugadores.class, Long.valueOf(jugadoresDto.getId()));

            jugador.setNombre(jugadoresDto.getNombre());
            jugador.setCorreo(jugadoresDto.getCorreo());
            jugador.setPreguntasRespondidas(jugadoresDto.getPreguntasRespondidas().longValue());
            jugador.setPreguntasAcertadas(jugadoresDto.getPreguntasAcertadas().longValue());
            jugador.setPartidasGanadas(jugadoresDto.getPartidasGanadas().longValue());

            List<PartidasJugadoresDto> partidasJugadoresDtoList = jugadoresDto.getPartidasJugadoresList();
            List<PartidasJugadores> partidasJugadoresList = new ArrayList<>();

            for (PartidasJugadoresDto partidasJugadoresDto : partidasJugadoresDtoList) {
                PartidasJugadores partidasJugadores = new PartidasJugadores();
                partidasJugadores.setIdJugador(jugador);
                partidasJugadores.setFichaSeleccionada(partidasJugadoresDto.getFichaSeleccionada());
                partidasJugadores.setPersonajesObtenidos(partidasJugadoresDto.getPersonajesObtenidos());
                partidasJugadores.setPosicionTablero(partidasJugadoresDto.getPosicionTablero().longValue());


                Partidas partida = em.find(Partidas.class, partidasJugadoresDto.getIdPartida());
                partidasJugadores.setIdPartida(partida);

                partidasJugadoresList.add(partidasJugadores);
            }
            jugador.setPartidasJugadoresList(partidasJugadoresList);

            em.merge(jugador);
            et.commit();
            return new Respuesta(true, "Jugador ficha añadida con éxito.", "", "Jugador", new JugadoresDto(jugador));
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            Logger.getLogger(JugadoresService.class.getName()).log(Level.SEVERE, "Error al actualizar el jugador.", ex);
            return new Respuesta(false, "Error al actualizar el jugador.", "uptade " + ex.getMessage());
        }
    }



}
