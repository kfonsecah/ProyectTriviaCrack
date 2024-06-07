package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import java.io.Serializable;

public class EstadisticasDto implements Serializable {

    private static final long serialVersionUID = 1L;

    public SimpleStringProperty idEstadistica;
    public SimpleStringProperty categoria;
    public SimpleStringProperty preguntasRespondidasCategoria;
    public SimpleStringProperty preguntasAcertadasCategoria;
    public SimpleStringProperty respuestasTotalesRespondidas;
    public SimpleStringProperty respuestasTotalesAcertadas;
    public SimpleStringProperty version;
    public SimpleStringProperty idJugador;

    public EstadisticasDto() {
        this.idEstadistica = new SimpleStringProperty("");
        this.categoria = new SimpleStringProperty("");
        this.preguntasRespondidasCategoria = new SimpleStringProperty("0");
        this.preguntasAcertadasCategoria = new SimpleStringProperty("0");
        this.respuestasTotalesRespondidas = new SimpleStringProperty("0");
        this.respuestasTotalesAcertadas = new SimpleStringProperty("0");
        this.version = new SimpleStringProperty("0");
        this.idJugador = new SimpleStringProperty("");
    }

    public EstadisticasDto(Estadisticas estadisticas) {
        this();
        this.idEstadistica.set(estadisticas.getIdEstadistica().toString());
        this.categoria.set(estadisticas.getCategoria());
        this.preguntasRespondidasCategoria.set(estadisticas.getPreguntasRespondidasCategoria().toString());
        this.preguntasAcertadasCategoria.set(estadisticas.getPreguntasAcertadasCategoria().toString());
        this.respuestasTotalesRespondidas.set(estadisticas.getRespuestasTotalesRespondidas().toString());
        this.respuestasTotalesAcertadas.set(estadisticas.getRespuestasTotalesAcertadas().toString());
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

    public Long getPreguntasRespondidasCategoria() {
        return Long.valueOf(preguntasRespondidasCategoria.get());
    }

    public void setPreguntasRespondidasCategoria(Long preguntasRespondidasCategoria) {
        this.preguntasRespondidasCategoria.set(preguntasRespondidasCategoria.toString());
    }

    public Long getPreguntasAcertadasCategoria() {
        return Long.valueOf(preguntasAcertadasCategoria.get());
    }

    public void setPreguntasAcertadasCategoria(Long preguntasAcertadasCategoria) {
        this.preguntasAcertadasCategoria.set(preguntasAcertadasCategoria.toString());
    }

    public Long getRespuestasTotalesRespondidas() {
        return Long.valueOf(respuestasTotalesRespondidas.get());
    }

    public void setRespuestasTotalesRespondidas(Long respuestasTotalesRespondidas) {
        this.respuestasTotalesRespondidas.set(respuestasTotalesRespondidas.toString());
    }

    public Long getRespuestasTotalesAcertadas() {
        return Long.valueOf(respuestasTotalesAcertadas.get());
    }

    public void setRespuestasTotalesAcertadas(Long respuestasTotalesAcertadas) {
        this.respuestasTotalesAcertadas.set(respuestasTotalesAcertadas.toString());
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
        if ((this.idEstadistica == null && other.idEstadistica != null) || (this.idEstadistica != null && !this.idEstadistica.equals(other.idEstadistica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.EstadisticasDto[ idEstadistica=" + idEstadistica + " ]";
    }
}
