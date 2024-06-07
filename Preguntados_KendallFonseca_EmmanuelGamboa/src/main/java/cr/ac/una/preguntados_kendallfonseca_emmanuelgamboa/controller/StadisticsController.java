package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.EstadisticasDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model.JugadoresDto;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service.JugadoresService;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.AnimationManager;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.FlowController;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.Mensaje;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.Respuesta;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Kendall Fonseca
 */
public class StadisticsController extends Controller implements Initializable {

    String Sound_Click = "/cr/ac/una/preguntados_kendallfonseca_emmanuelgamboa/resources/sounds/Play.wav";

    AnimationManager animationManager = AnimationManager.getInstance();

    @FXML
    private MFXButton btnGoBack;

    @FXML
    private StackedAreaChart<String, Number> grafDeportes;

    @FXML
    private StackedAreaChart<String, Number> grafGeografia;

    @FXML
    private StackedAreaChart<String, Number> grafHistoria;

    @FXML
    private StackedAreaChart<String, Number> grafTotalArte;

    @FXML
    private StackedAreaChart<String, Number> grafTotalCiencia;

    @FXML
    private StackedAreaChart<String, Number> grafTotalPop;

    @FXML
    private StackedAreaChart<String, Number> grafTotaldePreguntas;

    @FXML
    private TableView<JugadoresDto> tblJugadores;

    @FXML
    private TableColumn<JugadoresDto, String> tbcMail;

    @FXML
    private TableColumn<JugadoresDto, String> tbcName;

    private JugadoresService jugadoresService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jugadoresService = new JugadoresService();

        tbcMail.setCellValueFactory(new PropertyValueFactory<>("correo"));
        tbcName.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        loadJugadores();

        tblJugadores.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 2) {
                JugadoresDto selectedJugador = tblJugadores.getSelectionModel().getSelectedItem();
                if (selectedJugador != null) {
                    loadEstadisticas(selectedJugador);
                }
            }
        });
    }

    @Override
    public void initialize() {

    }

    private void loadJugadores() {
        Respuesta respuesta = jugadoresService.getJugadores();
        if (respuesta.getEstado()) {
            List<JugadoresDto> jugadoresList = (List<JugadoresDto>) respuesta.getResultado("JugadoresList");
            ObservableList<JugadoresDto> jugadores = FXCollections.observableArrayList(jugadoresList);
            tblJugadores.setItems(jugadores);
        } else {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Error", getStage(), respuesta.getMensaje());
        }
    }

    private void loadEstadisticas(JugadoresDto jugador) {
        clearCharts();

        for (EstadisticasDto estadistica : jugador.estadisticasList) {
            switch (estadistica.getCategoria()) {
                case "Deportes":
                    updateChart(grafDeportes, estadistica);
                    break;
                case "Geografia":
                    updateChart(grafGeografia, estadistica);
                    break;
                case "Historia":
                    updateChart(grafHistoria, estadistica);
                    break;
                case "Arte":
                    updateChart(grafTotalArte, estadistica);
                    break;
                case "Ciencia":
                    updateChart(grafTotalCiencia, estadistica);
                    break;
                case "Pop":
                    updateChart(grafTotalPop, estadistica);
                    break;
                default:
                    break;
            }
        }

        // Actualiza el gráfico de total de preguntas
        updateTotalPreguntasChart(grafTotaldePreguntas, jugador);
    }

    private void updateChart(StackedAreaChart<String, Number> chart, EstadisticasDto estadistica) {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName(estadistica.getCategoria());

        series.getData().add(new XYChart.Data<>("Preguntas Respondidas", Long.valueOf(estadistica.getPreguntasRespondidasCategoria())));
        series.getData().add(new XYChart.Data<>("Preguntas Acertadas", Long.valueOf(estadistica.getPreguntasAcertadasCategoria())));

        chart.getData().add(series);
    }

    private void updateTotalPreguntasChart(StackedAreaChart<String, Number> chart, JugadoresDto jugador) {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName(jugador.getNombre());

        series.getData().add(new XYChart.Data<>("Total Preguntas Respondidas", Long.valueOf(jugador.getPreguntasRespondidas())));
        series.getData().add(new XYChart.Data<>("Total Preguntas Acertadas", Long.valueOf(jugador.getPreguntasAcertadas())));

        chart.getData().add(series);
    }

    private void clearCharts() {
        grafDeportes.getData().clear();
        grafGeografia.getData().clear();
        grafHistoria.getData().clear();
        grafTotalArte.getData().clear();
        grafTotalCiencia.getData().clear();
        grafTotalPop.getData().clear();
        grafTotaldePreguntas.getData().clear();
    }

    @FXML
    void onActionBtnGoBack(ActionEvent event) {
        animationManager.playSound(Sound_Click);
        FlowController.getInstance().goView("StartView");
    }
}
