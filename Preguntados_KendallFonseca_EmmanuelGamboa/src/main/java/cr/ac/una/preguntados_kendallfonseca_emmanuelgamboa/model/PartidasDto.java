package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PartidasDto {
    private Long idPartida;
    private String informacionJson;
    private Long version;
    private List<PartidasJugadoresDto> partidasJugadoresList;

    public PartidasDto() {
        this.informacionJson = new String("");
        this.partidasJugadoresList = new ArrayList<>();
    }


    public PartidasDto(Partidas partidas) {
        this.idPartida = partidas.getIdPartida();
        this.informacionJson = partidas.getInformacionJson();
        this.version = partidas.getVersion();


       ArrayList<PartidasJugadores> partidas_jugadores= new ArrayList<>(partidas.getPartidasJugadoresList());
        for (PartidasJugadores partidasJugadores : partidas_jugadores) {
            this.partidasJugadoresList.add(new PartidasJugadoresDto(partidasJugadores));
        }

    }

    public Long getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Long idPartida) {
        this.idPartida = idPartida;
    }

    public String getInformacionJson() {
        return informacionJson;
    }

    public void setInformacionJson(String informacionJson) {
        this.informacionJson = informacionJson;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public List<PartidasJugadoresDto> getPartidasJugadoresList() {
        return partidasJugadoresList;
    }

    public void setPartidasJugadoresList(List<PartidasJugadoresDto> partidasJugadoresList) {
        this.partidasJugadoresList = partidasJugadoresList;
    }

    @Override
    public String toString() {
        return "PartidasDto[idPartida=" + idPartida + "]";
    }
}
