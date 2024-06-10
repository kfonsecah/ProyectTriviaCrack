package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PartidasDto {
    private SimpleStringProperty idPartida;
    private String informacionJson;
        private Long version;
    private List<PartidasJugadoresDto> partidasJugadoresList;


    public PartidasDto() {
        this.idPartida = new SimpleStringProperty("0");
        this.informacionJson = new String("");
        this.partidasJugadoresList = new ArrayList<>();
        this.version = 0L;
    }


    public PartidasDto(Partidas partidas) {
        this();
        this.idPartida.set(partidas.getIdPartida().toString());
        this.informacionJson = partidas.getInformacionJson();
        this.version = partidas.getVersion();

        for (PartidasJugadores partidasJugadores : partidas.getPartidasJugadoresList()) {
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
