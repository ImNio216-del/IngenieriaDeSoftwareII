package co.poli.edu.actividad.controlador;

import co.poli.edu.actividad.modelo.Pasaporte;
import co.poli.edu.actividad.modelo.PasaporteOrdinario;
import co.poli.edu.actividad.servicios.CORCliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorCOR {

    @FXML private TextField txtIdPasaporte;
    @FXML private TextField txtNombrePasajero;
    @FXML private TextField txtTipoPasaporte;
    @FXML private Button btnValidar;
    @FXML private TextArea areaResultado;

    private CORCliente clienteValidacion;

    @FXML
    public void initialize() {
        this.clienteValidacion = new CORCliente();
    }

    @FXML
    void validarPasaporte(ActionEvent event) {
        Pasaporte pasaporte = new PasaporteOrdinario();
        pasaporte.setId(txtIdPasaporte.getText());
        pasaporte.setNombrePasajero(txtNombrePasajero.getText());
        pasaporte.setTipoDePasaporte(txtTipoPasaporte.getText());

        String resultado = clienteValidacion.ejecutarValidacion(pasaporte);

        if (resultado == null) {
            areaResultado.setStyle("-fx-text-fill: green;");
            areaResultado.setText("¡ÉXITO! El pasaporte pasó todas las validaciones.");
        } else {
            areaResultado.setStyle("-fx-text-fill: red;");
            areaResultado.setText(resultado);
        }
    }
}