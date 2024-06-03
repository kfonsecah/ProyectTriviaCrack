package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model;

import jakarta.persistence.Id;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class JugadoresDto {


    public SimpleStringProperty id;
    public StringProperty nombre;
    public StringProperty correo;
    public StringProperty preguntasRespondidas;
    public StringProperty preguntasAcertadas;
    public StringProperty partidasGanadas;
    public StringProperty version;

    public JugadoresDto() {
        this.id = new SimpleStringProperty("");
        this.nombre = new SimpleStringProperty("");
        this.correo = new SimpleStringProperty("");
        this.preguntasRespondidas = new SimpleStringProperty("");
        this.preguntasAcertadas = new SimpleStringProperty("");
        this.partidasGanadas = new SimpleStringProperty("");
        this.version = new SimpleStringProperty("");
    }

    public JugadoresDto(Jugadores jugador) {
        this();
        this.id.set(jugador.getIdJugador().toString());
        this.nombre.set(jugador.getNombre());
    }

    public Long getId() {
        if (this.id.get() != null && !this.id.get().isBlank())
        {
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
    public String getPreguntasRespondidas() {
        return preguntasRespondidas.get();
    }
    public void setPreguntasRespondidas(String preguntasRespondidas) {
        this.preguntasRespondidas.set(preguntasRespondidas);
    }
    public String getPreguntasAcertadas() {
        return preguntasAcertadas.get();
    }
    public void setPreguntasAcertadas(String preguntasAcertadas) {
        this.preguntasAcertadas.set(preguntasAcertadas);
    }
    public String getPartidasGanadas() {
        return partidasGanadas.get();
    }
    public void setPartidasGanadas(String partidasGanadas) {
        this.partidasGanadas.set(partidasGanadas);
    }
    public String getVersion() {
        return version.get();
    }
    public void setVersion(String version) {
        this.version.set(version);
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JugadoresDto))
        {
            return false;
        }
        JugadoresDto other = (JugadoresDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.JugadoresDto[ idJugador=" + id + " ]";
    }


}
