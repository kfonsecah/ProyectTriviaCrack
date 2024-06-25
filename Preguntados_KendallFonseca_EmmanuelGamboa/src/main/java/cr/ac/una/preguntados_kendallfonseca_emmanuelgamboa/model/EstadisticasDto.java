package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model;

import javafx.beans.property.SimpleStringProperty;
import java.io.Serializable;

public class EstadisticasDto implements Serializable {

    private static final long serialVersionUID = 1L;

    public SimpleStringProperty idEstadistica;
    public SimpleStringProperty categoria;
    public Number preguntasRespondidasCategoria;
    public Number preguntasAcertadasCategoria;
    public Number respuestasTotalesRespondidas;
    public Number respuestasTotalesAcertadas;
    public SimpleStringProperty version;
    public SimpleStringProperty idJugador;

    public EstadisticasDto() {
        this.idEstadistica = new SimpleStringProperty("");
        this.categoria = new SimpleStringProperty("");
        this.preguntasRespondidasCategoria = 0;
        this.preguntasAcertadasCategoria = 0;
        this.respuestasTotalesRespondidas = 0;
        this.respuestasTotalesAcertadas = 0;
        this.version = new SimpleStringProperty("");
        this.idJugador = new SimpleStringProperty("");
    }

    public EstadisticasDto(Estadisticas estadisticas) {
        this();
        this.idEstadistica.set(estadisticas.getIdEstadistica().toString());
        this.categoria.set(estadisticas.getCategoria());
        this.preguntasRespondidasCategoria = estadisticas.getPreguntasRespondidasCategoria();
        this.preguntasAcertadasCategoria = estadisticas.getPreguntasAcertadasCategoria();
        this.respuestasTotalesRespondidas = estadisticas.getRespuestasTotalesRespondidas();
        this.respuestasTotalesAcertadas = estadisticas.getRespuestasTotalesAcertadas();
        this.version.set(estadisticas.getVersion().toString());
        this.idJugador.set(estadisticas.getIdJugador().getIdJugador().toString());
    }

    public Long getIdEstadistica() {
        return Long.valueOf(idEstadistica.get());
    }

    public void setIdEstadistica(Long idEstadistica) {
        this.idEstadistica.set(idEstadistica.toString());
    }

    public String getCategoria() {
        return categoria.get();
    }

    public void setCategoria(String categoria) {
        this.categoria.set(categoria);
    }

    public Number getPreguntasRespondidasCategoria() {
        return preguntasRespondidasCategoria;
    }

    public void setPreguntasRespondidasCategoria(Number preguntasRespondidasCategoria) {
        this.preguntasRespondidasCategoria = preguntasRespondidasCategoria;
    }

    public Number getPreguntasAcertadasCategoria() {
        return preguntasAcertadasCategoria;
    }

    public void setPreguntasAcertadasCategoria(Number preguntasAcertadasCategoria) {
        this.preguntasAcertadasCategoria = preguntasAcertadasCategoria;
    }

    public Number getRespuestasTotalesRespondidas() {
        return respuestasTotalesRespondidas;
    }

    public void setRespuestasTotalesRespondidas(Number respuestasTotalesRespondidas) {
        this.respuestasTotalesRespondidas = respuestasTotalesRespondidas;
    }

    public Number getRespuestasTotalesAcertadas() {
        return respuestasTotalesAcertadas;
    }

    public void setRespuestasTotalesAcertadas(Number respuestasTotalesAcertadas) {
        this.respuestasTotalesAcertadas = respuestasTotalesAcertadas;
    }

    public Long getVersion() {
        return Long.valueOf(version.get());
    }

    public void setVersion(Long version) {
        this.version.set(version.toString());
    }

    public Long getIdJugador() {
        return Long.valueOf(idJugador.get());
    }

    public void setIdJugador(Long idJugador) {
        this.idJugador.set(idJugador.toString());
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadistica != null ? idEstadistica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EstadisticasDto)) {
            return false;
        }
        EstadisticasDto other = (EstadisticasDto) object;
        return !((this.idEstadistica == null && other.idEstadistica != null) || (this.idEstadistica != null && !this.idEstadistica.equals(other.idEstadistica)));
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.EstadisticasDto[ idEstadistica=" + idEstadistica + " ]";
    }
}