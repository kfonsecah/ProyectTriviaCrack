package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PartidasDto {
    private SimpleStringProperty idPartida;
    private String informacionJson;
    private SimpleStringProperty version;
    private List<PartidasJugadoresDto> partidasJugadoresList;

    public PartidasDto() {
        this.idPartida = new SimpleStringProperty("");
        this.informacionJson = new String("");
        this.partidasJugadoresList = new ArrayList<>();
        this.version = new SimpleStringProperty("");
    }


    public PartidasDto(Partidas partidas) {
        this();
        this.idPartida.set(partidas.getIdPartida().toString());
        this.informacionJson = partidas.getInformacionJson();
        this.version.set(partidas.getVersion().toString());

       ArrayList<PartidasJugadores> partidas_jugadores= new ArrayList<>(partidas.getPartidasJugadoresList());
        for (PartidasJugadores partidasJugadores : partidas_jugadores) {
            this.partidasJugadoresList.add(new PartidasJugadoresDto(partidasJugadores));
        }

    }

    public Long getIdPartida() {
        return Long.valueOf(idPartida.get());
    }

    public void setIdPartida(Long idPartida) {
        this.idPartida.set(idPartida.toString());
    }

    public String getInformacionJson() {
        return informacionJson;
    }

    public void setInformacionJson(String informacionJson) {
        this.informacionJson = informacionJson;
    }

    public Long getVersion() {
        return Long.valueOf(version.get());
    }

    public void setVersion(Long version) {
        this.version.set(version.toString());
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
