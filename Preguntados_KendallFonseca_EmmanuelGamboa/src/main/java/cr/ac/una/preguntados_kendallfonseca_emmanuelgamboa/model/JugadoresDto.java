package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.util.ArrayList;
import java.util.List;

public class JugadoresDto {

    public SimpleStringProperty id;
    public StringProperty nombre;
    public StringProperty correo;
    public Number preguntasRespondidas;
    public Number preguntasAcertadas;
    public Number partidasGanadas;
    public Long version;
    public List<EstadisticasDto> estadisticasList;
    public List<PartidasJugadoresDto> partidasJugadoresList;

    public JugadoresDto() {
        this.id = new SimpleStringProperty("");
        this.nombre = new SimpleStringProperty("");
        this.correo = new SimpleStringProperty("");
        this.preguntasRespondidas = 0;
        this.preguntasAcertadas = 0;
        this.partidasGanadas = 0;
        this.estadisticasList = new ArrayList<>();
        this.partidasJugadoresList = new ArrayList<>();
        this.version = 0L;
    }

    public JugadoresDto(Jugadores jugador) {
        this();
        this.id.set(jugador.getIdJugador().toString());
        this.nombre.set(jugador.getNombre());
        this.correo.set(jugador.getCorreo());
        this.preguntasRespondidas = jugador.getPreguntasRespondidas();
        this.preguntasAcertadas = jugador.getPreguntasAcertadas();
        this.partidasGanadas = jugador.getPartidasGanadas();
        this.version = jugador.getVersion();

        if (jugador.getEstadisticasList() != null) {
            for (Estadisticas estadistica : jugador.getEstadisticasList()) {
                this.estadisticasList.add(new EstadisticasDto(estadistica));
            }
        }

        if (jugador.getPartidasJugadoresList() != null) {
            for (PartidasJugadores partidasJugadores : jugador.getPartidasJugadoresList()) {
                this.partidasJugadoresList.add(new PartidasJugadoresDto(partidasJugadores));
            }
        }
    }


    public Long getId() {
        if (this.id.get() != null && !this.id.get().isBlank()) {
            return Long.valueOf(this.id.get());
        }
        return null;
    }

    public void setId(Long id) {
        this.id.set(id.toString());
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public String getCorreo() {
        return correo.get();
    }

    public void setCorreo(String correo) {
        this.correo.set(correo);
    }

    public Number getPreguntasRespondidas() {
        return preguntasRespondidas;
    }

    public void setPreguntasRespondidas(Number preguntasRespondidas) {
        this.preguntasRespondidas = preguntasRespondidas;
    }

    public Number getPreguntasAcertadas() {
        return preguntasAcertadas;
    }

    public void setPreguntasAcertadas(Number preguntasAcertadas) {
        this.preguntasAcertadas = preguntasAcertadas;
    }

    public Number getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(Number partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public void setEstadisticasList(List<EstadisticasDto> estadisticasList) {
        this.estadisticasList = estadisticasList;
    }

    public List<EstadisticasDto> getEstadisticasList() {
        return estadisticasList;
    }
    public List<PartidasJugadoresDto> getPartidasJugadoresList() {
        return partidasJugadoresList;
    }

    public void setPartidasJugadoresList(List<PartidasJugadoresDto> partidasJugadoresList) {
        this.partidasJugadoresList = partidasJugadoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof JugadoresDto)) {
            return false;
        }
        JugadoresDto other = (JugadoresDto) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.JugadoresDto[ idJugador=" + id + " ]";
    }
}