package co.poli.edu.actividad.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class ControladorFormulario {

    @FXML
    private Button btt1; //Crear

    @FXML
    private CheckBox opc1; //Pasaporte ordinario

    @FXML
    private CheckBox opc2; //Pasaporte diplomático

    @FXML
    private TextField txt1; // Id Pasaporte

    @FXML
    private TextField txt13; // Fecha de nacimiento

    @FXML
    private TextField txt2; // Motivo de pasaporte

    @FXML
    private TextField txt4; // Fecha de expedición

    @FXML
    private TextField txt5; // Id País

    @FXML
    private TextField txt8; // Id Pasajero

    @FXML
    private TextField txt9; // Nombre Pasajero

    @FXML
    void click(ActionEvent event) {
        // Obtener valores de los campos
        String idPasaporte = txt1.getText();
        String motivo = txt2.getText();
        String fechaExpedicion = txt4.getText();
        String idPais = txt5.getText();
        String idPasajero = txt8.getText();
        String nombrePasajero = txt9.getText();
        String fechaNacimiento = txt13.getText();

        // Determinar tipo de pasaporte
        String tipoPasaporte = "";
        if (opc1.isSelected()) {
            tipoPasaporte = "Ordinario";
        } else if (opc2.isSelected()) {
            tipoPasaporte = "Diplomático";
        } else {
            tipoPasaporte = "No seleccionado";
        }

        // Imprimir en consola
        System.out.println("=== PASAPORTE CREADO ===");
        System.out.println("ID Pasaporte: " + idPasaporte);
        System.out.println("Motivo: " + motivo);
        System.out.println("Fecha Expedición: " + fechaExpedicion);
        System.out.println("ID País: " + idPais);
        System.out.println("ID Pasajero: " + idPasajero);
        System.out.println("Nombre Pasajero: " + nombrePasajero);
        System.out.println("Fecha Nacimiento: " + fechaNacimiento);
        System.out.println("Tipo de Pasaporte: " + tipoPasaporte);
        System.out.println("=========================");
    }
}
