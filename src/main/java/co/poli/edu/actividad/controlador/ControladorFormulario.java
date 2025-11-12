package co.poli.edu.actividad.controlador;

import co.poli.edu.actividad.modelo.Pais;
import co.poli.edu.actividad.modelo.Pasaporte;
import co.poli.edu.actividad.modelo.PasaporteOrdinario;
import co.poli.edu.actividad.servicios.*;


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

    // --- Componentes FXML (Memento y Observer) ---
    @FXML private Button btt1, bttModificar, bttGenerarHistorial, bttDeshacer;
    @FXML private CheckBox opc1, opc2;
    @FXML private TextField txt1, txt2, txt3, txt6, txt9;
    @FXML private TableView<MementoPasaporte> table;
    @FXML private TableColumn<MementoPasaporte, String> column1, column2, column3, column4, column5, column6;

    // --- Componentes FXML (State) ---
    @FXML private TextField txtIdPaisState;
    @FXML private ComboBox<String> comboTransiciones;
    @FXML private Button bttCambiarEstado;

    // --- Lógica de patrones ---
    private MementoCaretaker caretaker;
    private Map<String, Pasaporte> pasaportesActivos;
    private ObserverPublisher publisher;
    private Map<String, ESTPaisContext> paisesContext;

    // --- Componentes Mediator ---
    @FXML private Button BotonEnviarDesdeCancilleria;
    @FXML private Button BotonEnviarDesdeMigracion;
    @FXML private Button BotonEnviarDesdePolicia;
    @FXML private TextField txtDesdeCancilleria;
    @FXML private TextField txtDesdeMigracion;
    @FXML private TextField txtDesdePolicia;

    // --- Instancias del patrón Mediator ---
    private MediatorConcrete mediatorCentral;
    private MediatorCancilleria cancilleria;
    private MediatorMigracion migracion;
    private MediatorPolicia policia;

    //___________________________________________________________________________________________________________________________
    @FXML
    public void initialize() {
        caretaker = new MementoCaretaker();
        pasaportesActivos = new HashMap<>();
        publisher = new ObserverPublisher();
        paisesContext = new HashMap<>();

        // --- Configurar columnas ---
        column1.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdPasaporte()));
        column2.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumeroPasaporte()));
        column3.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaEmision()));
        column4.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombrePasajero()));
        column5.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPaisDeViaje()));
        column6.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoDePasaporte()));

        // --- Inicializar Mediator ---
        mediatorCentral = new MediatorConcrete();
        cancilleria = new MediatorCancilleria(mediatorCentral);
        migracion = new MediatorMigracion(mediatorCentral);
        policia = new MediatorPolicia(mediatorCentral);

        mediatorCentral.registrarInstitucion(cancilleria);
        mediatorCentral.registrarInstitucion(migracion);
        mediatorCentral.registrarInstitucion(policia);
    }

    // --- MÉTODOS PATRÓN STATE ---
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

    // --- MÉTODOS MEMENTO Y OBSERVER ---
    @FXML
    void click(ActionEvent event) {
        String idPasaporte = txt1.getText();
        if (idPasaporte.isEmpty()) {
            showAlert("Error", "El ID del pasaporte no puede estar vacío.");
            return;
        }
        if (pasaportesActivos.containsKey(idPasaporte)) {
            showAlert("Error", "Ya existe un pasaporte con el ID " + idPasaporte);
            return;
        }

        Pasaporte nuevoPasaporte = new PasaporteOrdinario();
        actualizarDatosPasaporte(nuevoPasaporte);
        pasaportesActivos.put(idPasaporte, nuevoPasaporte);
        caretaker.agregarMemento(idPasaporte, nuevoPasaporte.guardarEstado());

        String resultadoNotificacion = publisher.notificarSuscribers();
        showAlert("Notificaciones Enviadas", resultadoNotificacion);
    }

    @FXML
    void modificarPasaporte(ActionEvent event) {
        String idPasaporte = txt1.getText();
        Pasaporte pasaporteAModificar = pasaportesActivos.get(idPasaporte);
        if (pasaporteAModificar == null) {
            showAlert("Error", "No se encontró ningún pasaporte con el ID " + idPasaporte);
            return;
        }

        actualizarDatosPasaporte(pasaporteAModificar);
        caretaker.agregarMemento(idPasaporte, pasaporteAModificar.guardarEstado());
        showAlert("Éxito", "Pasaporte modificado. Nuevo estado guardado.");
    }

    @FXML
    void deshacerCambio(ActionEvent event) {
        String idPasaporte = txt1.getText();
        Pasaporte pasaporteARevertir = pasaportesActivos.get(idPasaporte);
        if (pasaporteARevertir == null) {
            showAlert("Error", "No se encontró ningún pasaporte con el ID " + idPasaporte);
            return;
        }

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
        if (historialCompleto.isEmpty()) {
            showAlert("Información", "El historial está vacío.");
            table.getItems().clear();
            return;
        }

        List<MementoPasaporte> todosLosMementos = new ArrayList<>();
        for (List<MementoPasaporte> mementos : historialCompleto.values()) {
            todosLosMementos.addAll(mementos);
        }
        table.setItems(FXCollections.observableArrayList(todosLosMementos));
    }

    // --- MÉTODOS MEDIATOR (totalmente independientes) ---
    @FXML
    void enviarDesdeCancilleria(ActionEvent event) {
        String mensaje = txtDesdeCancilleria.getText();
        if (mensaje.isEmpty()) {
            showAlert("Error", "El mensaje desde Cancillería no puede estar vacío.");
            return;
        }

        String respuesta = mediatorCentral.enviarMensaje(mensaje, cancilleria);
        showAlert("Mensaje desde Cancillería", respuesta);
    }

    @FXML
    void enviarDesdeMigracion(ActionEvent event) {
        String mensaje = txtDesdeMigracion.getText();
        if (mensaje.isEmpty()) {
            showAlert("Error", "El mensaje desde Migración no puede estar vacío.");
            return;
        }

        String respuesta = mediatorCentral.enviarMensaje(mensaje, migracion);
        showAlert("Mensaje desde Migración", respuesta);
    }

    @FXML
    void enviarDesdePolicia(ActionEvent event) {
        String mensaje = txtDesdePolicia.getText();
        if (mensaje.isEmpty()) {
            showAlert("Error", "El mensaje desde Policía no puede estar vacío.");
            return;
        }

        String respuesta = mediatorCentral.enviarMensaje(mensaje, policia);
        showAlert("Mensaje desde Policía", respuesta);
    }

    // --- MÉTODOS AUXILIARES ---
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
        opc1.setSelected("Ordinario".equals(pasaporte.getTipoDePasaporte()));
        opc2.setSelected("Diplomático".equals(pasaporte.getTipoDePasaporte()));
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
