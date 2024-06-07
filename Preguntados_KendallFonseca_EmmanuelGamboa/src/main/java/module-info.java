module cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires jakarta.persistence;
    requires MaterialFX;
    requires java.base;
    requires javafx.media;
    requires java.instrument;
   // requires java.persistence;
    //requires jakarta.xml.bind;
    //requires com.oracle.database.jdbc;
    requires eclipselink;
    requires java.sql;


    opens cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa to javafx.fxml, jakarta.persistence, javafx.graphics;
    opens cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.controller to javafx.fxml, javafx.graphics, MaterialFX;
    opens cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model to jakarta.persistence, com.oracle.database.jdbc, javafx.base, eclipselink;

    exports cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa;
    exports cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.controller;
    exports cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.model;
    exports cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.util;
    exports cr.ac.una.preguntados_kendallfonseca_emmanuelgamboa.service;
}
