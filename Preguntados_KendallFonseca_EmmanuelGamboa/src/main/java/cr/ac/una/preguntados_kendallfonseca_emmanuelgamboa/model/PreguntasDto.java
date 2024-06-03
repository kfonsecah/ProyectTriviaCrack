package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.StringProperty;

public class PreguntasDto implements Serializable {

    private static final long serialVersionUID = 1L;

    public SimpleLongProperty idPregunta;
    public SimpleStringProperty categoria;
    public SimpleStringProperty preguntaTexto;
    public SimpleLongProperty vecesRespondida;
    public SimpleLongProperty vecesAcertada;
    public SimpleLongProperty version;
    public SimpleStringProperty estado;
    public List<RespuestasDto> respuestasList;

    public PreguntasDto() {
        this.idPregunta = new SimpleLongProperty();
        this.categoria = new SimpleStringProperty("");
        this.preguntaTexto = new SimpleStringProperty("");
        this.vecesRespondida = new SimpleLongProperty();
        this.vecesAcertada = new SimpleLongProperty();
        this.estado = new SimpleStringProperty("A");
        this.version = new SimpleLongProperty();
        this.respuestasList = null;
    }

    public PreguntasDto(Preguntas pregunta) {
        this();
        this.idPregunta.set(pregunta.getIdPregunta());
        this.categoria.set(pregunta.getCategoria());
        this.preguntaTexto.set(pregunta.getPreguntaTexto());
        this.vecesRespondida.set(pregunta.getVecesRespondida());
        this.vecesAcertada.set(pregunta.getVecesAcertada());
        this.estado.set(pregunta.getEstado());
        this.version.set(pregunta.getVersion());
        this.respuestasList = new ArrayList<>();
    }

    public Long getIdPregunta() {
        return idPregunta.get();
    }

    public void setIdPregunta(Long idPregunta) {
        this.idPregunta.set(idPregunta);
    }

    public String getCategoria() {
        return categoria.get();
    }

    public void setCategoria(String categoria) {
        this.categoria.set(categoria);
    }

    public String getPreguntaTexto() {
        return preguntaTexto.get();
    }

    public void setPreguntaTexto(String preguntaTexto) {
        this.preguntaTexto.set(preguntaTexto);
    }

    public Long getVecesRespondida() {
        return vecesRespondida.get();
    }

    public void setVecesRespondida(Long vecesRespondida) {
        this.vecesRespondida.set(vecesRespondida);
    }

    public Long getVecesAcertada() {
        return vecesAcertada.get();
    }

    public void setVecesAcertada(Long vecesAcertada) {
        this.vecesAcertada.set(vecesAcertada);
    }

    public Long getVersion() {
        return version.get();
    }

    public void setVersion(Long version) {
        this.version.set(version);
    }
    public String getEstado() {
        return estado.get();
    }
    public void setEstado(String estado) {
        this.estado.set(estado);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPregunta != null ? idPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PreguntasDto)) {
            return false;
        }
        PreguntasDto other = (PreguntasDto) object;
        if ((this.idPregunta == null && other.idPregunta != null) || (this.idPregunta != null && !this.idPregunta.equals(other.idPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.PreguntasDto[ idPregunta=" + idPregunta + " ]";
    }

    public List<RespuestasDto> getRespuestasList() {
        return respuestasList;
    }
}
