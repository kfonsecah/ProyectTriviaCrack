package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model;

import jakarta.persistence.Id;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class JugadoresDto {


    public SimpleStringProperty id;
    public StringProperty nombre;

    public JugadoresDto() {
        this.id = new SimpleStringProperty("");
        this.nombre = new SimpleStringProperty("");
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
