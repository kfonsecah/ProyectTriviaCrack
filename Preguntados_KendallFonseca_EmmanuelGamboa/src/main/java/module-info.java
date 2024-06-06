module cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires jakarta.persistence;
    requires MaterialFX;
    requires java.base;
    requires javafx.media;
    requires java.instrument;
    requires java.persistence;
    requires com.oracle.database.jdbc;

    opens cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa to javafx.fxml, jakarta.persistence;
    opens cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.controller to javafx.fxml;
    opens cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model to jakarta.persistence;

    exports cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa;
    exports cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.controller;
    exports cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model;
    exports cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util;
}
