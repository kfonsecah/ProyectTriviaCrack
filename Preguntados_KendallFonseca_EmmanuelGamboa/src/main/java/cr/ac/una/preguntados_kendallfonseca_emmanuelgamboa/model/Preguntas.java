/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kendall Fonseca
 */
@Entity
@Table(name = "PREGUNTAS")
@NamedQueries({
    @NamedQuery(name = "Preguntas.findAll", query = "SELECT p FROM Preguntas p"),
    @NamedQuery(name = "Preguntas.findByIdPregunta", query = "SELECT p FROM Preguntas p WHERE p.idPregunta = :idPregunta"),
    @NamedQuery(name = "Preguntas.findByCategoria", query = "SELECT p FROM Preguntas p WHERE p.categoria = :categoria"),
    @NamedQuery(name = "Preguntas.findByPreguntaTexto", query = "SELECT p FROM Preguntas p WHERE p.preguntaTexto = :preguntaTexto"),
    @NamedQuery(name = "Preguntas.findByVecesRespondida", query = "SELECT p FROM Preguntas p WHERE p.vecesRespondida = :vecesRespondida"),
    @NamedQuery(name = "Preguntas.findByVecesAcertada", query = "SELECT p FROM Preguntas p WHERE p.vecesAcertada = :vecesAcertada"),
    @NamedQuery(name = "Preguntas.findByVersion", query = "SELECT p FROM Preguntas p WHERE p.version = :version")})
public class Preguntas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "PREGUNTAS_SEQ", sequenceName = "PREGUNTAS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PREGUNTAS_SEQ")
    @Basic(optional = false)
    @Column(name = "ID_PREGUNTA")
    private Long idPregunta;
    @Column(name = "CATEGORIA")
    private String categoria;
    @Column(name = "PREGUNTA_TEXTO")
    private String preguntaTexto;
    @Column(name = "VECES_RESPONDIDA")
    private Long vecesRespondida;
    @Column(name = "VECES_ACERTADA")
    private Long vecesAcertada;

    @Column(name = "ESTADO")
    private String estado;

    @Version
    @Column(name = "VERSION")
    private Long version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPregunta", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Respuestas> respuestasList;

    public Preguntas() {
    }

    public Preguntas(Long idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Preguntas(Long idPregunta, Long version) {
        this.idPregunta = idPregunta;
        this.version = version;
    }

    public Preguntas(PreguntasDto dto){
        this.idPregunta = dto.getIdPregunta();
        actualizar(dto);
    }

    public void actualizar(PreguntasDto dto){
        this.categoria = dto.getCategoria();
        this.preguntaTexto = dto.getPreguntaTexto();
        this.vecesRespondida = dto.getVecesRespondida();
        this.vecesAcertada = dto.getVecesAcertada();
        this.estado = dto.getEstado();
        this.version = dto.getVersion();
    }

    public Long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPreguntaTexto() {
        return preguntaTexto;
    }

    public void setPreguntaTexto(String preguntaTexto) {
        this.preguntaTexto = preguntaTexto;
    }

    public Long getVecesRespondida() {
        return vecesRespondida;
    }

    public void setVecesRespondida(Long vecesRespondida) {
        this.vecesRespondida = vecesRespondida;
    }

    public Long getVecesAcertada() {
        return vecesAcertada;
    }

    public void setVecesAcertada(Long vecesAcertada) {
        this.vecesAcertada = vecesAcertada;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Respuestas> getRespuestasList() {

       return respuestasList;
    }

    public void setRespuestasList(List<Respuestas> respuestasList) {
        this.respuestasList = respuestasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPregunta != null ? idPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preguntas)) {
            return false;
        }
        Preguntas other = (Preguntas) object;
        if ((this.idPregunta == null && other.idPregunta != null) || (this.idPregunta != null && !this.idPregunta.equals(other.idPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Preguntas[ idPregunta=" + idPregunta + " ]";
    }
    
}
