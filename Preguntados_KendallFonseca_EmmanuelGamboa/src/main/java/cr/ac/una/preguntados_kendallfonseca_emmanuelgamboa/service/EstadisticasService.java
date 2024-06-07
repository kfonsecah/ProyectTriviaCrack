package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.Estadisticas;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.EstadisticasDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.EntityManagerHelper;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.Respuesta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.stream.Collectors;

public class EstadisticasService {

    private final EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;


}
