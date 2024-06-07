/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Kendall Fonseca
 */
@Entity
@Table(name = "PARTIDAS_JUGADORES")
@NamedQueries({
    @NamedQuery(name = "PartidasJugadores.findAll", query = "SELECT p FROM PartidasJugadores p"),
    @NamedQuery(name = "PartidasJugadores.findByIdPartidaJugador", query = "SELECT p FROM PartidasJugadores p WHERE p.idPartidaJugador = :idPartidaJugador"),
    @NamedQuery(name = "PartidasJugadores.findByFichaSeleccionada", query = "SELECT p FROM PartidasJugadores p WHERE p.fichaSeleccionada = :fichaSeleccionada"),
    @NamedQuery(name = "PartidasJugadores.findByPersonajesObtenidos", query = "SELECT p FROM PartidasJugadores p WHERE p.personajesObtenidos = :personajesObtenidos"),
    @NamedQuery(name = "PartidasJugadores.findByPosicionTablero", query = "SELECT p FROM PartidasJugadores p WHERE p.posicionTablero = :posicionTablero"),
    @NamedQuery(name = "PartidasJugadores.findByVersion", query = "SELECT p FROM PartidasJugadores p WHERE p.version = :version")})
public class PartidasJugadores implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARTIDAS_JUGADORES_SEQ")
    @SequenceGenerator(name = "PARTIDAS_JUGADORES_SEQ", sequenceName = "PARTIDAS_JUGADORES_SEQ", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_PARTIDA_JUGADOR")
    private Long idPartidaJugador;
    @Basic(optional = false)
    @Column(name = "FICHA_SELECCIONADA")
    private Long fichaSeleccionada;
    @Column(name = "PERSONAJES_OBTENIDOS")
    private String personajesObtenidos;
    @Column(name = "AYUDAS")
    private String ayudas;
    @Basic(optional = false)
    @Column(name = "POSICION_TABLERO")
    private Long posicionTablero;
    @Version
    @Basic(optional = false)
    @Column(name = "VERSION")
    private Long version;
    @JoinColumn(name = "ID_JUGADOR", referencedColumnName = "ID_JUGADOR")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Jugadores idJugador;
    @JoinColumn(name = "ID_PARTIDA", referencedColumnName = "ID_PARTIDA")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Partidas idPartida;

    public PartidasJugadores() {
    }

    public PartidasJugadores(Long idPartidaJugador) {
        this.idPartidaJugador = idPartidaJugador;
    }

    public PartidasJugadores(Long idPartidaJugador, Long fichaSeleccionada, Long posicionTablero, Long version) {
        this.idPartidaJugador = idPartidaJugador;
        this.fichaSeleccionada = fichaSeleccionada;
        this.posicionTablero = posicionTablero;
        this.version = version;
    }

    public Long getIdPartidaJugador() {
        return idPartidaJugador;
    }

    public void setIdPartidaJugador(Long idPartidaJugador) {
        this.idPartidaJugador = idPartidaJugador;
    }

    public Long getFichaSeleccionada() {
        return fichaSeleccionada;
    }

    public void setFichaSeleccionada(Long fichaSeleccionada) {
        this.fichaSeleccionada = fichaSeleccionada;
    }

    public String getPersonajesObtenidos() {
        return personajesObtenidos;
    }

    public void setPersonajesObtenidos(String personajesObtenidos) {
        this.personajesObtenidos = personajesObtenidos;
    }

    public Long getPosicionTablero() {
        return posicionTablero;
    }

    public void setPosicionTablero(Long posicionTablero) {
        this.posicionTablero = posicionTablero;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Jugadores getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Jugadores idJugador) {
        this.idJugador = idJugador;
    }

    public Partidas getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Partidas idPartida) {
        this.idPartida = idPartida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPartidaJugador != null ? idPartidaJugador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PartidasJugadores)) {
            return false;
        }
        PartidasJugadores other = (PartidasJugadores) object;
        if ((this.idPartidaJugador == null && other.idPartidaJugador != null) || (this.idPartidaJugador != null && !this.idPartidaJugador.equals(other.idPartidaJugador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.PartidasJugadores[ idPartidaJugador=" + idPartidaJugador + " ]";
    }
    
}
