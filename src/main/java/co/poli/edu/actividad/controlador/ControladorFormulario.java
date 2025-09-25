package co.poli.edu.actividad.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControladorFormulario {

    @FXML
    private ImageView Fondo1;

    @FXML
    private ImageView fondo2;

    @FXML
    private ImageView fondo3;

    @FXML
    private Button btt1;

    @FXML
    private CheckBox opc1;

    @FXML
    private CheckBox opc2;

    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;

    @FXML
    private TextField txt4;

    @FXML
    private TextField txt5;

    @FXML
    private TextField txt8;

    @FXML
    private TextField txt9;

    @FXML
    private TextField txt13;

    @FXML
    public void initialize() {
        // Cargar imágenes
        fondo2.setImage(new Image(getClass().getResource("/img/fondo_blanco.jpeg").toExternalForm()));
        Fondo1.setImage(new Image(getClass().getResource("/img/FONDO_PASAPORTE.jpg").toExternalForm()));
        fondo3.setImage(new Image(getClass().getResource("/img/marco.png").toExternalForm()));
    }

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
        String tipoPasaporte = opc1.isSelected() ? "Ordinario" :
                               opc2.isSelected() ? "Diplomático" : "No seleccionado";

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
