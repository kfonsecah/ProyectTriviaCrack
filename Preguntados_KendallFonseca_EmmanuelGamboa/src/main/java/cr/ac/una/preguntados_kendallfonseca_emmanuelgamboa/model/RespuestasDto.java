package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model;

import java.io.Serializable;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RespuestasDto implements Serializable {

    private static final long serialVersionUID = 1L;

    public SimpleStringProperty idRespuesta;
    public SimpleStringProperty respuestaTexto;
    public SimpleStringProperty esCorrecta;
    public SimpleStringProperty  vecesSeleccionada;
    public SimpleStringProperty version;
    private PreguntasDto idPregunta;

    public RespuestasDto() {
        this.idRespuesta = new SimpleStringProperty("");
        this.respuestaTexto = new SimpleStringProperty("");
        this.esCorrecta = new SimpleStringProperty("");
        this.vecesSeleccionada = new SimpleStringProperty("0");
        this.idPregunta = new PreguntasDto();
    }

    public RespuestasDto(Respuestas respuesta) {
        this();
        this.idRespuesta.set(respuesta.getIdRespuesta().toString());
        this.respuestaTexto.set(respuesta.getRespuestaTexto());
        this.esCorrecta.set(respuesta.getEsCorrecta());
        this.vecesSeleccionada.set(respuesta.getVecesSeleccionada().toString());

    }

    public Long getIdRespuesta() {
        return Long.valueOf(idRespuesta.get());
    }

    public void setIdRespuesta(Long idRespuesta) {
        this.idRespuesta.set(idRespuesta.toString());
    }

    public String getRespuestaTexto() {
        return respuestaTexto.get();
    }

    public void setRespuestaTexto(String respuestaTexto) {
        this.respuestaTexto.set(respuestaTexto);
    }

    public String getEsCorrecta() {
        return esCorrecta.get();
    }

    public void setEsCorrecta(String esCorrecta) {
        this.esCorrecta.set(esCorrecta);
    }

    public Long getVecesSeleccionada() {
        return Long.valueOf(vecesSeleccionada.get());
    }

    public void setVecesSeleccionada(Long vecesSeleccionada) {
        this.vecesSeleccionada.set(vecesSeleccionada.toString());
    }

    public Long getVersion() {
        return Long.valueOf(version.get());
    }

    public void setVersion(Long version) {
        this.version.set(version.toString());
    }

    public PreguntasDto getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(PreguntasDto idPregunta) {
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
        if (!(object instanceof RespuestasDto)) {
            return false;
        }
        RespuestasDto other = (RespuestasDto) object;
        if ((this.idRespuesta == null && other.idRespuesta != null) || (this.idRespuesta != null && !this.idRespuesta.equals(other.idRespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.RespuestasDto[ idRespuesta=" + idRespuesta + " ]";
    }
}
