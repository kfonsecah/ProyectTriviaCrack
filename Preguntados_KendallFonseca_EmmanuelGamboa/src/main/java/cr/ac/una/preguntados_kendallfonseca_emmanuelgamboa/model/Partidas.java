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
@Table(name = "PARTIDAS")
@NamedQueries({
    @NamedQuery(name = "Partidas.findAll", query = "SELECT p FROM Partidas p"),
    @NamedQuery(name = "Partidas.findByIdPartida", query = "SELECT p FROM Partidas p WHERE p.idPartida = :idPartida"),
    @NamedQuery(name = "Partidas.findByVersion", query = "SELECT p FROM Partidas p WHERE p.version = :version")})
public class Partidas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(
            name = "PARTIDAS_SEQ",
            sequenceName = "PARTIDAS_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARTIDAS_SEQ")
    @Basic(optional = false)
    @Column(name = "ID_PARTIDA")
    private BigDecimal idPartida;
    @Lob
    @Column(name = "INFORMACION_JSON")
    private String informacionJson;
    @Basic(optional = false)
    @Column(name = "VERSION")
    private BigInteger version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPartida", fetch = FetchType.LAZY)
    private Collection<PartidasJugadores> partidasJugadoresCollection;

    public Partidas() {
    }

    public Partidas(BigDecimal idPartida) {
        this.idPartida = idPartida;
    }

    public Partidas(BigDecimal idPartida, BigInteger version) {
        this.idPartida = idPartida;
        this.version = version;
    }

    public BigDecimal getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(BigDecimal idPartida) {
        this.idPartida = idPartida;
    }

    public String getInformacionJson() {
        return informacionJson;
    }

    public void setInformacionJson(String informacionJson) {
        this.informacionJson = informacionJson;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPartida != null ? idPartida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partidas)) {
            return false;
        }
        Partidas other = (Partidas) object;
        if ((this.idPartida == null && other.idPartida != null) || (this.idPartida != null && !this.idPartida.equals(other.idPartida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Partidas[ idPartida=" + idPartida + " ]";
    }
    
}
