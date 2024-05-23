module cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires jakarta.persistence;
    requires MaterialFX;
    requires java.base;

    opens cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa to javafx.fxml;
    exports cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa;
}
