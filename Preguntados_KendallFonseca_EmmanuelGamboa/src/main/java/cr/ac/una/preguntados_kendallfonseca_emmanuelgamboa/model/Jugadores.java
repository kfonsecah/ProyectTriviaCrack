/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author Kendall Fonseca
 */
@Entity
@Table(name = "JUGADORES", schema = "KEN")
@NamedQueries({
    @NamedQuery(name = "Jugadores.findAll", query = "SELECT j FROM Jugadores j"),
    @NamedQuery(name = "Jugadores.findByIdJugador", query = "SELECT j FROM Jugadores j WHERE j.idJugador = :idJugador"),
    @NamedQuery(name = "Jugadores.findByNombre", query = "SELECT j FROM Jugadores j WHERE j.nombre = :nombre"),
    @NamedQuery(name = "Jugadores.findByCorreo", query = "SELECT j FROM Jugadores j WHERE j.correo = :correo"),
    @NamedQuery(name = "Jugadores.findByPreguntasRespondidas", query = "SELECT j FROM Jugadores j WHERE j.preguntasRespondidas = :preguntasRespondidas"),
    @NamedQuery(name = "Jugadores.findByPreguntasAcertadas", query = "SELECT j FROM Jugadores j WHERE j.preguntasAcertadas = :preguntasAcertadas"),
    @NamedQuery(name = "Jugadores.findByPartidasGanadas", query = "SELECT j FROM Jugadores j WHERE j.partidasGanadas = :partidasGanadas"),
    @NamedQuery(name = "Jugadores.findByVersion", query = "SELECT j FROM Jugadores j WHERE j.version = :version")})
public class Jugadores implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "JUGADORES_SEQ", sequenceName = "JUGADORES_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JUGADORES_SEQ")
    @Basic(optional = false)
    @Column(name = "ID_JUGADOR")
    private Long idJugador;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "CORREO")
    private String correo;
    @Column(name = "PREGUNTAS_RESPONDIDAS")
    private Long preguntasRespondidas;
    @Column(name = "PREGUNTAS_ACERTADAS")
    private Long preguntasAcertadas;
    @Column(name = "PARTIDAS_GANADAS")
    private Long partidasGanadas;
    @Version
    @Column(name = "VERSION")
    private Long version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJugador", fetch = FetchType.EAGER)
    private List<PartidasJugadores> partidasJugadoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJugador", fetch = FetchType.EAGER)
    private List<Estadisticas> estadisticasList;

    public Jugadores() {
    }

    public Jugadores(Long idJugador) {
        this.idJugador = idJugador;
    }

    public Jugadores(Long idJugador, Long version) {
        this.idJugador = idJugador;
        this.version = version;
    }

    public Jugadores(JugadoresDto jugador) {
      this.idJugador = jugador.getId();
      actualizar(jugador);
    }

    public void actualizar(JugadoresDto jugador) {
        this.idJugador = jugador.getId();
        this.nombre = jugador.getNombre();
        this.correo = jugador.getCorreo();
        this.preguntasRespondidas = jugador.getPreguntasRespondidas().longValue();
        this.preguntasAcertadas = jugador.getPreguntasAcertadas().longValue();
        this.partidasGanadas = jugador.getPartidasGanadas().longValue();
        this.version = jugador.getVersion();

//        if (jugador.getPartidasJugadoresList() != null) {
//            for (PartidasJugadoresDto partidasJugadores : jugador.getPartidasJugadoresList()) {
//                PartidasJugadores partidasJugadores1 = new PartidasJugadores();
//                partidasJugadores1.actualizar(partidasJugadores);
//                this.partidasJugadoresList.add(partidasJugadores1);
//            }
//        }
//
//        if (jugador.getEstadisticasList() != null) {
//            for (EstadisticasDto estadisticas : jugador.getEstadisticasList()) {
//                Estadisticas estadisticas1 = new Estadisticas();
//                estadisticas1.actualizar(estadisticas);
//                this.estadisticasList.add(estadisticas1);
//            }
//        }

    }

    public Long getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Long idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getPreguntasRespondidas() {
        return preguntasRespondidas;
    }

    public void setPreguntasRespondidas(Long preguntasRespondidas) {
        this.preguntasRespondidas = preguntasRespondidas;
    }

    public Long getPreguntasAcertadas() {
        return preguntasAcertadas;
    }

    public void setPreguntasAcertadas(Long preguntasAcertadas) {
        this.preguntasAcertadas = preguntasAcertadas;
    }

    public Long getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(Long partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public List<PartidasJugadores> getPartidasJugadoresList() {
        return partidasJugadoresList;
    }

    public void setPartidasJugadoresList(List<PartidasJugadores> partidasJugadoresList) {
        this.partidasJugadoresList = partidasJugadoresList;
    }

    public List<Estadisticas> getEstadisticasList() {
        return estadisticasList;
    }

    public void setEstadisticasList(List<Estadisticas> estadisticasList) {
        this.estadisticasList = estadisticasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJugador != null ? idJugador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugadores)) {
            return false;
        }
        Jugadores other = (Jugadores) object;
        if ((this.idJugador == null && other.idJugador != null) || (this.idJugador != null && !this.idJugador.equals(other.idJugador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Jugadores[ idJugador=" + idJugador + " ]";
    }
    
}
