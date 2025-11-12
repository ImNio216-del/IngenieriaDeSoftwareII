package co.poli.edu.actividad.controlador;

import co.poli.edu.actividad.modelo.Pais;
import co.poli.edu.actividad.modelo.Pasaporte;
import co.poli.edu.actividad.modelo.PasaporteOrdinario;
import co.poli.edu.actividad.servicios.MementoCaretaker;
import co.poli.edu.actividad.servicios.MementoPasaporte;
import co.poli.edu.actividad.servicios.ObserverPublisher;
// ¡IMPORTS AÑADIDOS!
import co.poli.edu.actividad.servicios.ESTPaisContext;
import co.poli.edu.actividad.servicios.ESTEstadoPais;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControladorFormulario {

    // --- Componentes FXML (Sección Memento y Observer) ---
    @FXML private Button btt1, bttModificar, bttGenerarHistorial, bttDeshacer;
    @FXML private CheckBox opc1, opc2;
    @FXML private TextField txt1, txt2, txt3, txt6, txt9;
    @FXML private TableView<MementoPasaporte> table;
    @FXML private TableColumn<MementoPasaporte, String> column1, column2, column3, column4, column5, column6;

    // --- Componentes FXML (Sección State) ---
    @FXML private TextField txtIdPaisState;
    @FXML private ComboBox<String> comboTransiciones;
    @FXML private Button bttCambiarEstado;

    // --- Lógica de Patrones ---
    private MementoCaretaker caretaker;
    private Map<String, Pasaporte> pasaportesActivos;
    private ObserverPublisher publisher;
    private Map<String, ESTPaisContext> paisesContext;

    @FXML
    public void initialize() {
        caretaker = new MementoCaretaker();
        pasaportesActivos = new HashMap<>();
        publisher = new ObserverPublisher();
        paisesContext = new HashMap<>();

        column1.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdPasaporte()));
        column2.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumeroPasaporte()));
        column3.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaEmision()));
        column4.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombrePasajero()));
        column5.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPaisDeViaje()));
        column6.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoDePasaporte()));
    }

    // --- Métodos para Patrón State ---

    @FXML
    void cargarPais(ActionEvent event) {
        String id = txtIdPaisState.getText();
        if (id.isEmpty()) {
            showAlert("Error", "Por favor, introduce el ID de un país.");
            return;
        }

        if (!paisesContext.containsKey(id)) {
            Pais nuevoPais = new Pais(id, "País " + id, null);
            paisesContext.put(id, new ESTPaisContext(nuevoPais));
        }

        ESTPaisContext context = paisesContext.get(id);
        String estadoActual = context.getEstado().getClass().getSimpleName().replace("ESTEstado", "");
        showAlert("País Cargado", "País '" + id + "' cargado con éxito.\nEstado actual: " + estadoActual);
        actualizarComboBox(id);
    }

    @FXML
    void cambiarEstado(ActionEvent event) {
        String id = txtIdPaisState.getText();
        String transicionSeleccionada = comboTransiciones.getValue();

        if (id.isEmpty() || transicionSeleccionada == null) {
            showAlert("Error", "Asegúrate de cargar un país y seleccionar una transición.");
            return;
        }

        ESTPaisContext context = paisesContext.get(id);
        if (context == null) {
            showAlert("Error", "El país '" + id + "' no se ha cargado. Presiona Enter en el campo de texto primero.");
            return;
        }

        String resultado;
        switch (transicionSeleccionada) {
            case "Poner en Revisión":
                resultado = context.ponerEnRevision();
                break;
            case "Aprobar y volver a Normal":
                resultado = context.exigirVisa();
                break;
            case "Exigir Visa":
                resultado = context.exigirVisa();
                break;
            case "Cerrar Fronteras":
                resultado = context.cerrarFronteras();
                break;
            case "Reabrir Fronteras":
                resultado = context.ponerEnRevision();
                break;
            default:
                resultado = "Transición no reconocida.";
                break;
        }

        showAlert("Cambio de Estado", resultado);
        actualizarComboBox(id);
    }

    private void actualizarComboBox(String idPais) {
        ESTPaisContext context = paisesContext.get(idPais);
        if (context != null) {
            List<String> transiciones = context.getEstado().getTransicionesPosibles();
            comboTransiciones.setItems(FXCollections.observableArrayList(transiciones));
            comboTransiciones.getSelectionModel().selectFirst();
        }
    }

    // --- Métodos para Memento y Observer (LÓGICA RESTAURADA) ---
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

        MementoPasaporte mementoAnterior = caretaker.deshacer(idPasaporte);
        if (mementoAnterior == null) {
            showAlert("Información", "No hay más cambios que deshacer para este pasaporte.");
            return;
        }

        pasaporteARevertir.restaurarEstado(mementoAnterior);
        actualizarFormularioConDatos(pasaporteARevertir);
        showAlert("Éxito", "Último cambio deshecho.");
    }

    @FXML
    void generarHistorial(ActionEvent event) {
        Map<String, List<MementoPasaporte>> historialCompleto = caretaker.getHistorialCompleto();
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
