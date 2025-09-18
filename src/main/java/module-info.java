module pasaporte {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.sql;


    opens co.poli.edu.actividad.controlador to javafx.fxml;
    exports co.poli.edu.actividad.controlador;

    opens co.poli.edu.actividad.vista to javafx.fxml;
    exports co.poli.edu.actividad.vista;

    exports co.poli.edu.actividad.repositorio;

}