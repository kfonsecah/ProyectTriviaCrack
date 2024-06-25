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
import javafx.scene.chart.BarChart;
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
    private BarChart<String, Number> chartTotalArte;

    @FXML
    private BarChart<String, Number> chartTotalCiencia;

    @FXML
    private BarChart<String, Number> chartTotalDeportes;

    @FXML
    private BarChart<String, Number> chartTotalGeografia;

    @FXML
    private BarChart<String, Number> chartTotalHistoria;

    @FXML
    private BarChart<String, Number> chartTotalPop;

    @FXML
    private BarChart<String, Number> chartTotalPreguntas;

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



        tblJugadores.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                loadEstadisticas(newSelection);
            }
        });

        tbcName.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tbcMail.setCellValueFactory(new PropertyValueFactory<>("correo"));
        }



    @Override
    public void initialize() {
        loadJugadores();
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

        List<EstadisticasDto> estadisticasList = jugador.getEstadisticasList();
        for (EstadisticasDto estadistica : estadisticasList) {
            switch (estadistica.getCategoria()) {
                case "Deportes":
                    updateChart(chartTotalDeportes, estadistica);
                    break;
                case "Geografia":
                    updateChart(chartTotalGeografia, estadistica);
                    break;
                case "Historia":
                    updateChart(chartTotalHistoria, estadistica);
                    break;
                case "Arte":
                    updateChart(chartTotalArte, estadistica);
                    break;
                case "Ciencia":
                    updateChart(chartTotalCiencia, estadistica);
                    break;
                case "Pop":
                    updateChart(chartTotalPop, estadistica);
                    break;
            }
        }
        updateTotalPreguntasChart(chartTotalPreguntas, jugador);
    }

    private void updateChart(BarChart<String, Number> grafico, EstadisticasDto estadistica) {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Respondidas");

        series.getData().add(new XYChart.Data<>("Preguntas Respondidas", estadistica.getPreguntasRespondidasCategoria()));
        series.getData().add(new XYChart.Data<>("Preguntas Acertadas", estadistica.getPreguntasAcertadasCategoria()));

        grafico.getData().add(series);
    }

    private void updateTotalPreguntasChart(BarChart<String, Number> grafico, JugadoresDto jugador) {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Total");

        series.getData().add(new XYChart.Data<>("Preguntas Respondidas", jugador.getPreguntasRespondidas()));
        series.getData().add(new XYChart.Data<>("Preguntas Acertadas", jugador.getPreguntasAcertadas()));

        grafico.getData().add(series);
    }

    private void clearCharts() {
        chartTotalArte.getData().clear();
        chartTotalCiencia.getData().clear();
        chartTotalDeportes.getData().clear();
        chartTotalGeografia.getData().clear();
        chartTotalHistoria.getData().clear();
        chartTotalPop.getData().clear();
        chartTotalPreguntas.getData().clear();
    }

    @FXML
    void onActionBtnGoBack(ActionEvent event) {
        animationManager.playSound(Sound_Click);
        FlowController.getInstance().goView("StartView");
    }
}
