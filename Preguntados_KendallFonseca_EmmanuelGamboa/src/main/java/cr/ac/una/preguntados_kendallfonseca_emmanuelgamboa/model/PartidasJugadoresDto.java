package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * DTO for PartidasJugadores entity.
 */
public class PartidasJugadoresDto {
    private SimpleStringProperty idPartidaJugador;
    private SimpleStringProperty fichaSeleccionada;
    private SimpleStringProperty personajesObtenidos;
    private SimpleStringProperty  ayudas;
    private SimpleStringProperty posicionTablero;
    private SimpleStringProperty  version;
    private JugadoresDto  idJugador;
    private PartidasDto idPartida;

    public PartidasJugadoresDto() {
        this.idPartidaJugador = new SimpleStringProperty("");
        this.personajesObtenidos = new SimpleStringProperty("0");
        this.fichaSeleccionada = new SimpleStringProperty("0");
        this.ayudas = new SimpleStringProperty("Ninguna");
        this.posicionTablero = new SimpleStringProperty("0");
        this.version = new SimpleStringProperty("0");
        this.idJugador = new JugadoresDto();
        this.idPartida = new PartidasDto();
    }

    public PartidasJugadoresDto(PartidasJugadores partidasJugadores) {
        this();
        this.idPartidaJugador.set(partidasJugadores.getIdPartidaJugador().toString());
        this.fichaSeleccionada.set(partidasJugadores.getFichaSeleccionada().toString());
        this.ayudas.set(partidasJugadores.getAyudas());
        this.personajesObtenidos.set(partidasJugadores.getPersonajesObtenidos());
        this.idJugador.setId(partidasJugadores.getIdJugador().getIdJugador());
        this.posicionTablero.set(partidasJugadores.getPosicionTablero().toString());
        this.version.set(partidasJugadores.getVersion().toString());
    }

    public Long getIdPartidaJugador() {
        if (this.idPartidaJugador.get() != null && !this.idPartidaJugador.get().isBlank())
        {
            return Long.valueOf(this.idPartidaJugador.get());
        }
        return null;
    }

    public void setIdPartidaJugador(SimpleStringProperty idPartidaJugador) {
        this.idPartidaJugador = idPartidaJugador;
    }

    public Long getFichaSeleccionada() {
        return Long.valueOf(fichaSeleccionada.get());
    }

    public void setFichaSeleccionada(Long fichaSeleccionada) {
        this.fichaSeleccionada.set(fichaSeleccionada.toString());
    }

    public String getPersonajesObtenidos() {
        return personajesObtenidos.get();
    }

    public void setPersonajesObtenidos(String personajesObtenidos) {
        this.personajesObtenidos.set(personajesObtenidos);
    }

    public String getAyudas() {
        return ayudas.get();
    }

     public void setAyudas(String ayudas) {
         this.ayudas.set(ayudas);
     }

    public Long getPosicionTablero() {
        return Long.valueOf(posicionTablero.get());
    }
    public void setPosicionTablero(Long posicionTablero) {
        this.posicionTablero.set(posicionTablero.toString());
    }

    public Long getVersion() {
        return Long.valueOf(version.get());
    }

    public void setVersion(Long version) {
        this.version.set(version.toString());
    }

    public JugadoresDto getIdJugador() {
        return idJugador;
    }
    public void setIdJugador(JugadoresDto idJugador) {
        this.idJugador = idJugador;
    }

    public PartidasDto getIdPartida() {
        return idPartida;

    }
    public void setIdPartida(PartidasDto idPartida) {
        this.idPartida = idPartida;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PartidasJugadoresDto)) {
            return false;
        }
        PartidasJugadoresDto other = (PartidasJugadoresDto) object;
        return !((this.idPartidaJugador == null && other.idPartidaJugador != null) || (this.idPartidaJugador != null && !this.idPartidaJugador.equals(other.idPartidaJugador)));
    }

    @Override
    public String toString() {
        return "PartidasJugadoresDto[idPartidaJugador=" + idPartidaJugador + "]";
    }
}
