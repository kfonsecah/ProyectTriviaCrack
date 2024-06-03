package cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.Formato;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.Mensaje;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service.JugadoresService;
import cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util.Respuesta;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class RegisterController extends Controller implements Initializable {

    @FXML
    private MFXTextField txtNombre;
    @FXML
    private MFXButton btnGuardar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtNombre.delegateSetTextFormatter(Formato.getInstance().letrasFormat(15));
    }

    public void initialize() {

    }

    @FXML
    private void onActionBtnAdd(ActionEvent event) {
        try {
            String nombre = txtNombre.getText();
            if (nombre == null || nombre.isBlank()) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar Jugador", getStage(), "El nombre no puede estar vacío.");
                return;
            }
            JugadoresService jugadoresService = new JugadoresService();
            Respuesta respuesta = jugadoresService.crearJugadorConNombre(nombre);
            if (respuesta.getEstado()) {
                txtNombre.clear();
                new Mensaje().showModal(Alert.AlertType.INFORMATION, "Guardar Jugador", getStage(), "Jugador guardado correctamente.");
            } else {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar Jugador", getStage(), respuesta.getMensaje());
            }
        } catch (Exception ex) {
            Logger.getLogger(JugadoresService.class.getName()).log(Level.SEVERE, "Error guardando el jugador.", ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar Jugador", getStage(), "Ocurrió un error guardando el jugador.");
        }
    }

    @FXML
    private void onActionBtnClean(ActionEvent event) {
        txtNombre.clear();
    }


}
