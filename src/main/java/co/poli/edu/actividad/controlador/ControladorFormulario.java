package co.poli.edu.actividad.controlador;

import co.poli.edu.actividad.modelo.Pasaporte;
import co.poli.edu.actividad.modelo.PasaporteOrdinario;
import co.poli.edu.actividad.servicios.MementoCaretaker;
import co.poli.edu.actividad.servicios.MementoPasaporte;
import co.poli.edu.actividad.servicios.ObserverPublisher;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControladorFormulario {

    @FXML private Button btt1, bttModificar, bttGenerarHistorial, bttDeshacer;
    @FXML private CheckBox opc1, opc2;
    @FXML private TextField txt1, txt2, txt3, txt6, txt9;
    @FXML private TableView<MementoPasaporte> table;
    @FXML private TableColumn<MementoPasaporte, String> column1, column2, column3, column4, column5, column6;

    private MementoCaretaker caretaker;
    private Map<String, Pasaporte> pasaportesActivos;
    private ObserverPublisher publisher;

    @FXML
    public void initialize() {
        caretaker = new MementoCaretaker();
        pasaportesActivos = new HashMap<>();
        publisher = new ObserverPublisher();

        column1.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdPasaporte()));
        column2.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumeroPasaporte()));
        column3.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaEmision()));
        column4.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombrePasajero()));
        column5.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPaisDeViaje()));
        column6.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoDePasaporte()));
    }

    @FXML
    void click(ActionEvent event) {
        String idPasaporte = txt1.getText();
        if (idPasaporte.isEmpty()) { showAlert("Error", "El ID del pasaporte no puede estar vacío."); return; }
        if (pasaportesActivos.containsKey(idPasaporte)) { showAlert("Error", "Ya existe un pasaporte con el ID " + idPasaporte); return; }

        Pasaporte nuevoPasaporte = new PasaporteOrdinario();
        actualizarDatosPasaporte(nuevoPasaporte);
        pasaportesActivos.put(idPasaporte, nuevoPasaporte);
        caretaker.agregarMemento(idPasaporte, nuevoPasaporte.guardarEstado());

        String resultadoNotificacion = publisher.notificarSuscribers();
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Notificaciones Enviadas");
        alerta.setHeaderText("Resultado de la notificación:");
        alerta.setContentText(resultadoNotificacion);
        alerta.showAndWait();
    }

    @FXML
    void modificarPasaporte(ActionEvent event) {
        String idPasaporte = txt1.getText();
        Pasaporte pasaporteAModificar = pasaportesActivos.get(idPasaporte);
        if (pasaporteAModificar == null) { showAlert("Error", "No se encontró ningún pasaporte con el ID " + idPasaporte); return; }

        actualizarDatosPasaporte(pasaporteAModificar);
        caretaker.agregarMemento(idPasaporte, pasaporteAModificar.guardarEstado());
        showAlert("Éxito", "Pasaporte modificado. Nuevo estado guardado.");
    }

    @FXML
    void deshacerCambio(ActionEvent event) {
        String idPasaporte = txt1.getText();
        Pasaporte pasaporteARevertir = pasaportesActivos.get(idPasaporte);
        if (pasaporteARevertir == null) { showAlert("Error", "No se encontró ningún pasaporte con el ID " + idPasaporte); return; }

        MementoPasaporte mementoAnterior = caretaker.deshacerMementoPasaporte(idPasaporte);

        if (mementoAnterior == null) {
            showAlert("Información", "No hay más cambios que deshacer para este pasaporte.");
            return;
        }

        pasaporteARevertir.restaurarEstado(mementoAnterior);
        actualizarFormularioConDatos(pasaporteARevertir);
        showAlert("Éxito", "Último cambio deshecho. El pasaporte ha sido revertido a su estado anterior.");
    }

    @FXML
    void generarHistorial(ActionEvent event) {
        Map<String, List<MementoPasaporte>> historialCompleto = caretaker.getMementoCompleto();
        if (historialCompleto.isEmpty()) { showAlert("Información", "El historial está vacío."); table.getItems().clear(); return; }

        List<MementoPasaporte> todosLosMementos = new ArrayList<>();
        for (List<MementoPasaporte> mementos : historialCompleto.values()) {
            todosLosMementos.addAll(mementos);
        }
        table.setItems(FXCollections.observableArrayList(todosLosMementos));
    }

    private void actualizarDatosPasaporte(Pasaporte pasaporte) {
        String tipoPasaporte = opc1.isSelected() ? "Ordinario" : opc2.isSelected() ? "Diplomático" : "No seleccionado";
        pasaporte.setId(txt1.getText());
        pasaporte.setNumeroPasaporte(txt2.getText());
        pasaporte.setFechaEmision(txt3.getText());
        pasaporte.setNombrePasajero(txt9.getText());
        pasaporte.setPaisDeViaje(txt6.getText());
        pasaporte.setTipoDePasaporte(tipoPasaporte);
    }
    
    private void actualizarFormularioConDatos(Pasaporte pasaporte) {
        txt1.setText(pasaporte.getId());
        txt2.setText(pasaporte.getNumeroPasaporte());
        txt3.setText(pasaporte.getFechaEmision());
        txt9.setText(pasaporte.getNombrePasajero());
        txt6.setText(pasaporte.getPaisDeViaje());
        if (pasaporte.getTipoDePasaporte().equals("Ordinario")) {
            opc1.setSelected(true); opc2.setSelected(false);
        } else if (pasaporte.getTipoDePasaporte().equals("Diplomático")) {
            opc1.setSelected(false); opc2.setSelected(true);
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
