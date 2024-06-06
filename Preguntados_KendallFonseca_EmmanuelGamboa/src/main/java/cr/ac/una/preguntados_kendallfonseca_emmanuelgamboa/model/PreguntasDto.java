package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.StringProperty;

public class PreguntasDto implements Serializable {

    private static final long serialVersionUID = 1L;

    public SimpleStringProperty idPregunta;
    public SimpleStringProperty categoria;
    public SimpleStringProperty preguntaTexto;
    public SimpleStringProperty vecesRespondida;
    public SimpleStringProperty vecesAcertada;
    public SimpleStringProperty version;
    public SimpleStringProperty estado;
    public List<RespuestasDto> respuestasList;

    public PreguntasDto() {
        this.idPregunta = new SimpleStringProperty("");
        this.categoria = new SimpleStringProperty("");
        this.preguntaTexto = new SimpleStringProperty("");
        this.vecesRespondida = new SimpleStringProperty("0");
        this.vecesAcertada = new SimpleStringProperty("0");
        this.estado = new SimpleStringProperty("A");
        this.version = new SimpleStringProperty("0");
        this.respuestasList = new ArrayList<>();
    }

    public PreguntasDto(Preguntas pregunta) {
        this();
        this.idPregunta.set(pregunta.getIdPregunta().toString());
        this.categoria.set(pregunta.getCategoria());
        this.preguntaTexto.set(pregunta.getPreguntaTexto());
        this.vecesRespondida.set(pregunta.getVecesRespondida()
                != null ? pregunta.getVecesRespondida().toString() : "0");//si es null se pone 0, si no se pone el valor
        this.vecesAcertada.set(pregunta.getVecesAcertada()
                != null ? pregunta.getVecesAcertada().toString() : "0");
        this.estado.set(pregunta.getEstado());


        ArrayList<Respuestas> respuestas= new ArrayList<>(pregunta.getRespuestasList());
        for (Respuestas respuesta : respuestas) {
            this.respuestasList.add(new RespuestasDto(respuesta));
        }
    }

    public Long getIdPregunta() {
        return Long.valueOf(idPregunta.get());
    }

    public void setIdPregunta(Long idPregunta) {
        this.idPregunta.set(idPregunta.toString());
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
        return Long.valueOf(vecesRespondida.get());
    }

    public void setVecesRespondida(Long vecesRespondida) {
        this.vecesRespondida.set(vecesRespondida.toString());
    }

    public Long getVecesAcertada() {
        return Long.valueOf(vecesAcertada.get());
    }

    public void setVecesAcertada(Long vecesAcertada) {
        this.vecesAcertada.set(vecesAcertada.toString());
    }

    public Long getVersion() {
        return Long.valueOf(version.get());
    }

    public void setVersion(Long version) {
        this.version.set(version.toString());
    }

    public String getEstado() {
        return estado.get();
    }

    public List<RespuestasDto> getRespuestasList() {
        return respuestasList;
    }

    public void setRespuestasList(List<RespuestasDto> respuestasList) {
        this.respuestasList = respuestasList;
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
}


