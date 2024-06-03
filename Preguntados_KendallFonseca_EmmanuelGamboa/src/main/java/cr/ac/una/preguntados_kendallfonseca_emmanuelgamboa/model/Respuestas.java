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
@Table(name = "RESPUESTAS")
@NamedQueries({
    @NamedQuery(name = "Respuestas.findAll", query = "SELECT r FROM Respuestas r"),
    @NamedQuery(name = "Respuestas.findByIdRespuesta", query = "SELECT r FROM Respuestas r WHERE r.idRespuesta = :idRespuesta"),
    @NamedQuery(name = "Respuestas.findByRespuestaTexto", query = "SELECT r FROM Respuestas r WHERE r.respuestaTexto = :respuestaTexto"),
    @NamedQuery(name = "Respuestas.findByEsCorrecta", query = "SELECT r FROM Respuestas r WHERE r.esCorrecta = :esCorrecta"),
    @NamedQuery(name = "Respuestas.findByVecesSeleccionada", query = "SELECT r FROM Respuestas r WHERE r.vecesSeleccionada = :vecesSeleccionada"),
    @NamedQuery(name = "Respuestas.findByVersion", query = "SELECT r FROM Respuestas r WHERE r.version = :version")})
    @NamedQuery(name = "Respuestas.findByPregunta", query = "SELECT r FROM Respuestas r WHERE r.idPregunta = :idPregunta")
public class Respuestas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "RESPUESTAS_SEQ", sequenceName = "RESPUESTAS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESPUESTAS_SEQ")
    @Basic(optional = false)
    @Column(name = "ID_RESPUESTA")
    public Long idRespuesta;
    @Column(name = "RESPUESTA_TEXTO")
    public String respuestaTexto;
    @Basic(optional = false)
    @Column(name = "ES_CORRECTA")
    public String esCorrecta;
    @Column(name = "VECES_SELECCIONADA")
    public Long vecesSeleccionada;
    @Version
    @Column(name = "VERSION")
    public Long version;
    @JoinColumn(name = "ID_PREGUNTA", referencedColumnName = "ID_PREGUNTA")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    public Preguntas idPregunta;

    public Respuestas() {
    }

    public Respuestas(Long idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public Respuestas(Long idRespuesta, String esCorrecta, Long version) {
        this.idRespuesta = idRespuesta;
        this.esCorrecta = esCorrecta;
        this.version = version;
    }

    public Long getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Long idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getRespuestaTexto() {
        return respuestaTexto;
    }

    public void setRespuestaTexto(String respuestaTexto) {
        this.respuestaTexto = respuestaTexto;
    }

    public String getEsCorrecta() {
        return esCorrecta;
    }

    public void setEsCorrecta(String esCorrecta) {
        this.esCorrecta = esCorrecta;
    }

    public Long getVecesSeleccionada() {
        return vecesSeleccionada;
    }

    public void setVecesSeleccionada(Long vecesSeleccionada) {
        this.vecesSeleccionada = vecesSeleccionada;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Preguntas getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Preguntas idPregunta) {
        this.idPregunta = idPregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRespuesta != null ? idRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuestas)) {
            return false;
        }
        Respuestas other = (Respuestas) object;
        if ((this.idRespuesta == null && other.idRespuesta != null) || (this.idRespuesta != null && !this.idRespuesta.equals(other.idRespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Respuestas[ idRespuesta=" + idRespuesta + " ]";
    }
    
}
