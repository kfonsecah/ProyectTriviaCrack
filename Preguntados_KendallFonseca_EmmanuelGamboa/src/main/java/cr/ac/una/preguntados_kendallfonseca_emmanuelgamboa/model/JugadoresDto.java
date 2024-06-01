package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public class JugadoresDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private BigDecimal idJugador;
    private String nombre;
    private String correo;
    private BigInteger preguntasRespondidas;
    private BigInteger preguntasAcertadas;
    private BigInteger partidasGanadas;
    private BigInteger version;

    public JugadoresDto() {
    }

    public JugadoresDto(BigDecimal idJugador, String nombre, String correo, BigInteger preguntasRespondidas, BigInteger preguntasAcertadas, BigInteger partidasGanadas, BigInteger version) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.correo = correo;
        this.preguntasRespondidas = preguntasRespondidas;
        this.preguntasAcertadas = preguntasAcertadas;
        this.partidasGanadas = partidasGanadas;
        this.version = version;
    }

    public BigDecimal getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(BigDecimal idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public BigInteger getPreguntasRespondidas() {
        return preguntasRespondidas;
    }

    public void setPreguntasRespondidas(BigInteger preguntasRespondidas) {
        this.preguntasRespondidas = preguntasRespondidas;
    }

    public BigInteger getPreguntasAcertadas() {
        return preguntasAcertadas;
    }

    public void setPreguntasAcertadas(BigInteger preguntasAcertadas) {
        this.preguntasAcertadas = preguntasAcertadas;
    }

    public BigInteger getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(BigInteger partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }
}

