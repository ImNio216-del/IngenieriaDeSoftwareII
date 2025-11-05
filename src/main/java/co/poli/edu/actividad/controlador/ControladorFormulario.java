package co.poli.edu.actividad.controlador;

import co.poli.edu.actividad.servicios.ObserverCancilleria;
import co.poli.edu.actividad.servicios.ObserverMigracion;
import co.poli.edu.actividad.servicios.ObserverPolicia;
import co.poli.edu.actividad.servicios.ObserverPublisher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControladorFormulario {

    @FXML
    private Button btt1;

    @FXML
    private Button btt2;

    @FXML
    private TableColumn<?, ?> colum5;

    @FXML
    private TableColumn<?, ?> column1;

    @FXML
    private TableColumn<?, ?> column2;

    @FXML
    private TableColumn<?, ?> column3;

    @FXML
    private TableColumn<?, ?> column4;

    @FXML
    private TableColumn<?, ?> column6;

    @FXML
    private CheckBox opc1;

    @FXML
    private CheckBox opc2;

    @FXML
    private TableView<?> table;

    @FXML
    private TextField txt1;

    @FXML
    private TextField txt10;

    @FXML
    private TextField txt11;

    @FXML
    private TextField txt12;

    @FXML
    private TextField txt13;

    @FXML
    private TextField txt14;

    @FXML
    private TextField txt2;

    @FXML
    private TextField txt3;

    @FXML
    private TextField txt4;

    @FXML
    private TextField txt5;

    @FXML
    private TextField txt6;

    @FXML
    private TextField txt7;

    @FXML
    private TextField txt8;

    @FXML
    private TextField txt9;
    
    
	private ObserverPublisher publisher;

    @FXML
    public void initialize() {
      
         //fondo2.setImage(new Image(getClass().getResource("/img/FB.jpeg").toExternalForm()));
         // Fondo1.setImage(new Image(getClass().getResource("/img/FP.jpg").toExternalForm()));
        //fondo3.setImage(new Image(getClass().getResource("/img/MARCO.png").toExternalForm()));

        publisher = new ObserverPublisher();

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
		String tipoPasaporte = opc1.isSelected() ? "Ordinario" : opc2.isSelected() ? "Diplomático" : "No seleccionado";

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

		String resultado = publisher.notificarSuscribers();

		// Mostrar en ventana de alerta
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setTitle("Notificaciones Enviadas");
		alerta.setHeaderText("Resultado de la notificación:");
		alerta.setContentText(resultado);
		alerta.showAndWait();
	}
}
