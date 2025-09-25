<<<<<<< HEAD
module co.edu.poli.IngenieriaDeSoftware {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;

    opens co.edu.poli.vista to javafx.fxml;
    exports co.edu.poli.vista;
    opens co.edu.poli.controlador to javafx.fxml;
    exports co.edu.poli.controlador;
}
=======
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
>>>>>>> 0141011 (Composite y adapter)
