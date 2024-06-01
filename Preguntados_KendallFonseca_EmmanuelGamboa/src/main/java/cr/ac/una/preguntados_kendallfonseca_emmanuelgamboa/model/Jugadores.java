/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;

/**
 *
 * @author Kendall Fonseca
 */
@Entity
@Table(name = "JUGADORES")
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
    @SequenceGenerator(
            name = "JUGADORES_SEQ",
            sequenceName = "JUGADORES_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JUGADORES_SEQ")
    @Basic(optional = false)
    @Column(name = "ID_JUGADOR")
    private BigDecimal idJugador;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "CORREO")
    private String correo;
    @Column(name = "PREGUNTAS_RESPONDIDAS")
    private BigInteger preguntasRespondidas;
    @Column(name = "PREGUNTAS_ACERTADAS")
    private BigInteger preguntasAcertadas;
    @Column(name = "PARTIDAS_GANADAS")
    private BigInteger partidasGanadas;
    @Basic(optional = false)
    @Column(name = "VERSION")
    private BigInteger version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJugador", fetch = FetchType.LAZY)
    private Collection<PartidasJugadores> partidasJugadoresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJugador", fetch = FetchType.LAZY)
    private Collection<Estadisticas> estadisticasCollection;

    public Jugadores() {
    }

    public Jugadores(BigDecimal idJugador) {
        this.idJugador = idJugador;
    }

    public Jugadores(BigDecimal idJugador, BigInteger version) {
        this.idJugador = idJugador;
        this.version = version;
    }

    public BigDecimal getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(BigDecimal idJugador) {
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

    public BigInteger getPreguntasRespondidas() {
        return preguntasRespondidas;
    }

    public void setPreguntasRespondidas(BigInteger preguntasRespondidas) {
        this.preguntasRespondidas = preguntasRespondidas;
    }

    public BigInteger getPreguntasAcertadas() {
        return preguntasAcertadas;
    }

    public void setPreguntasAcertadas(BigInteger preguntasAcertadas) {
        this.preguntasAcertadas = preguntasAcertadas;
    }

    public BigInteger getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(BigInteger partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public Collection<PartidasJugadores> getPartidasJugadoresCollection() {
        return partidasJugadoresCollection;
    }

    public void setPartidasJugadoresCollection(Collection<PartidasJugadores> partidasJugadoresCollection) {
        this.partidasJugadoresCollection = partidasJugadoresCollection;
    }

    public Collection<Estadisticas> getEstadisticasCollection() {
        return estadisticasCollection;
    }

    public void setEstadisticasCollection(Collection<Estadisticas> estadisticasCollection) {
        this.estadisticasCollection = estadisticasCollection;
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
