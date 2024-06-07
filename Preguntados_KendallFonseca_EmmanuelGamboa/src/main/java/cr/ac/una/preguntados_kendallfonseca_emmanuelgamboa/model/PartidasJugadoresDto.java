package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model;

/**
 * DTO for PartidasJugadores entity.
 */
public class PartidasJugadoresDto {
    private Long idPartidaJugador;
    private Long fichaSeleccionada;
    private String personajesObtenidos;
    private Long posicionTablero;
    private Long version;
    private Long idJugador;
    private Long idPartida;

    public PartidasJugadoresDto() {
    }

    public PartidasJugadoresDto(PartidasJugadores partidasJugadores) {
        this.idPartidaJugador = partidasJugadores.getIdPartidaJugador();
        this.fichaSeleccionada = partidasJugadores.getFichaSeleccionada();
        this.personajesObtenidos = partidasJugadores.getPersonajesObtenidos();
        this.posicionTablero = partidasJugadores.getPosicionTablero();
        this.version = partidasJugadores.getVersion();
        this.idJugador = partidasJugadores.getIdJugador().getIdJugador();
        this.idPartida = partidasJugadores.getIdPartida().getIdPartida();
    }

    public Long getIdPartidaJugador() {
        return idPartidaJugador;
    }

    public void setIdPartidaJugador(Long idPartidaJugador) {
        this.idPartidaJugador = idPartidaJugador;
    }

    public Long getFichaSeleccionada() {
        return fichaSeleccionada;
    }

    public void setFichaSeleccionada(Long fichaSeleccionada) {
        this.fichaSeleccionada = fichaSeleccionada;
    }

    public String getPersonajesObtenidos() {
        return personajesObtenidos;
    }

    public void setPersonajesObtenidos(String personajesObtenidos) {
        this.personajesObtenidos = personajesObtenidos;
    }

    public Long getPosicionTablero() {
        return posicionTablero;
    }

    public void setPosicionTablero(Long posicionTablero) {
        this.posicionTablero = posicionTablero;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Long idJugador) {
        this.idJugador = idJugador;
    }

    public Long getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Long idPartida) {
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
