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
@Table(name = "ESTADISTICAS")
@NamedQueries({
    @NamedQuery(name = "Estadisticas.findAll", query = "SELECT e FROM Estadisticas e"),
    @NamedQuery(name = "Estadisticas.findByIdEstadistica", query = "SELECT e FROM Estadisticas e WHERE e.idEstadistica = :idEstadistica"),
    @NamedQuery(name = "Estadisticas.findByCategoria", query = "SELECT e FROM Estadisticas e WHERE e.categoria = :categoria"),
    @NamedQuery(name = "Estadisticas.findByPreguntasRespondidasCategoria", query = "SELECT e FROM Estadisticas e WHERE e.preguntasRespondidasCategoria = :preguntasRespondidasCategoria"),
    @NamedQuery(name = "Estadisticas.findByPreguntasAcertadasCategoria", query = "SELECT e FROM Estadisticas e WHERE e.preguntasAcertadasCategoria = :preguntasAcertadasCategoria"),
    @NamedQuery(name = "Estadisticas.findByRespuestasTotalesRespondidas", query = "SELECT e FROM Estadisticas e WHERE e.respuestasTotalesRespondidas = :respuestasTotalesRespondidas"),
    @NamedQuery(name = "Estadisticas.findByRespuestasTotalesAcertadas", query = "SELECT e FROM Estadisticas e WHERE e.respuestasTotalesAcertadas = :respuestasTotalesAcertadas"),
    @NamedQuery(name = "Estadisticas.findByVersion", query = "SELECT e FROM Estadisticas e WHERE e.version = :version")})
public class Estadisticas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESTADISTICAS_SEQ")
    @SequenceGenerator(name = "ESTADISTICAS_SEQ", sequenceName = "ESTADISTICAS_SEQ", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_ESTADISTICA")
    private Long idEstadistica;
    @Column(name = "CATEGORIA")
    private String categoria;
    @Column(name = "PREGUNTAS_RESPONDIDAS_CATEGORIA")
    private Long preguntasRespondidasCategoria;
    @Column(name = "PREGUNTAS_ACERTADAS_CATEGORIA")
    private Long preguntasAcertadasCategoria;
    @Column(name = "RESPUESTAS_TOTALES_RESPONDIDAS")
    private Long respuestasTotalesRespondidas;
    @Column(name = "RESPUESTAS_TOTALES_ACERTADAS")
    private Long respuestasTotalesAcertadas;
    @Version
    @Basic(optional = false)
    @Column(name = "VERSION")
    private Long version;
    @JoinColumn(name = "ID_JUGADOR", referencedColumnName = "ID_JUGADOR")
    @ManyToOne(cascade = CascadeType.REMOVE,optional = false, fetch = FetchType.EAGER)
    private Jugadores idJugador;

    public Estadisticas() {
    }

    public Estadisticas(Long idEstadistica) {
        this.idEstadistica = idEstadistica;
    }

    public Estadisticas(Long idEstadistica, Long version) {
        this.idEstadistica = idEstadistica;
        this.version = version;
    }

    public Estadisticas(EstadisticasDto dto){
        this.idEstadistica = dto.getIdEstadistica();
        actualizar(dto);
    }

    public void actualizar(EstadisticasDto dto){
        this.idEstadistica = dto.getIdEstadistica();
        this.categoria = dto.getCategoria();
        this.preguntasRespondidasCategoria = dto.getPreguntasRespondidasCategoria().longValue();
        this.preguntasAcertadasCategoria = dto.getPreguntasAcertadasCategoria().longValue();
        this.respuestasTotalesRespondidas = dto.getRespuestasTotalesRespondidas().longValue();
        this.respuestasTotalesAcertadas = dto.getRespuestasTotalesAcertadas().longValue();
        this.version = dto.getVersion();
    }

    public Long getIdEstadistica() {
        return idEstadistica;
    }

    public void setIdEstadistica(Long idEstadistica) {
        this.idEstadistica = idEstadistica;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getPreguntasRespondidasCategoria() {
        return preguntasRespondidasCategoria;
    }

    public void setPreguntasRespondidasCategoria(Long preguntasRespondidasCategoria) {
        this.preguntasRespondidasCategoria = preguntasRespondidasCategoria;
    }

    public Long getPreguntasAcertadasCategoria() {
        return preguntasAcertadasCategoria;
    }

    public void setPreguntasAcertadasCategoria(Long preguntasAcertadasCategoria) {
        this.preguntasAcertadasCategoria = preguntasAcertadasCategoria;
    }

    public Long getRespuestasTotalesRespondidas() {
        return respuestasTotalesRespondidas;
    }

    public void setRespuestasTotalesRespondidas(Long respuestasTotalesRespondidas) {
        this.respuestasTotalesRespondidas = respuestasTotalesRespondidas;
    }

    public Long getRespuestasTotalesAcertadas() {
        return respuestasTotalesAcertadas;
    }

    public void setRespuestasTotalesAcertadas(Long respuestasTotalesAcertadas) {
        this.respuestasTotalesAcertadas = respuestasTotalesAcertadas;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadistica != null ? idEstadistica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadisticas)) {
            return false;
        }
        Estadisticas other = (Estadisticas) object;
        if ((this.idEstadistica == null && other.idEstadistica != null) || (this.idEstadistica != null && !this.idEstadistica.equals(other.idEstadistica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Estadisticas[ idEstadistica=" + idEstadistica + " ]";
    }
    
}
