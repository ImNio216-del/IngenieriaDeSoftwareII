package co.poli.edu.actividad.controlador;

import co.poli.edu.actividad.modelo.Ciudad;
import co.poli.edu.actividad.servicios.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ControladorGeografico {

    @FXML private Button btt1; // Crear País
    @FXML private Button btt2; // Crear Región
    @FXML private Button btt3; // Crear Ciudad

    @FXML private TreeView<CompositeEspacioGeografico> info1;
    @FXML private TextField txtId;    // Campo ID
    @FXML private TextField txtNombre; // Campo Nombre

    private TreeItem<CompositeEspacioGeografico> rootItem;

    @FXML
    public void initialize() {
        // Raíz "Mundo"
        CompositeRegion mundo = new CompositeRegion("0", "Mundo");
        rootItem = new TreeItem<>(mundo);
        rootItem.setExpanded(true);

        // Configurar TreeView
        info1.setCellFactory(tv -> new TreeCell<>() {
            @Override
            protected void updateItem(CompositeEspacioGeografico item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else if (item instanceof CompositePais) {
                    setText("País [" + item.getId() + "]: " + item.getNombre());
                } else if (item instanceof CompositeRegion) {
                    setText("Región [" + item.getId() + "]: " + item.getNombre());
                } else if (item instanceof AdaptadorCiudad) {
                    setText("Ciudad: " + item.getNombre());
                } else {
                    setText(item.getId() + ": " + item.getNombre());
                }
            }
        });

        info1.setRoot(rootItem);

        // <-- Eliminé el ejemplo inicial de país y región -->
    }

    @FXML
    void click(ActionEvent event) {
        Object source = event.getSource();
        if (source == btt1) crearPais();
        else if (source == btt2) crearRegion();
        else if (source == btt3) crearCiudadAdapter();
    }

    private void crearPais() {
        String id = txtId.getText().trim();
        String nombre = txtNombre.getText().trim();
        if (id.isEmpty() || nombre.isEmpty()) {
            mostrarAlerta("Debe ingresar un ID y un nombre para el país.");
            return;
        }

        CompositePais pais = new CompositePais(id, nombre);
        TreeItem<CompositeEspacioGeografico> paisItem = new TreeItem<>(pais);
        rootItem.getChildren().add(paisItem);
        rootItem.setExpanded(true);
        limpiarCampos();
    }

    private void crearRegion() {
        TreeItem<CompositeEspacioGeografico> seleccionado = info1.getSelectionModel().getSelectedItem();
        if (seleccionado == null || !(seleccionado.getValue() instanceof CompositePais)) {
            mostrarAlerta("Debe seleccionar un país para agregar una región.");
            return;
        }

        String id = txtId.getText().trim();
        String nombre = txtNombre.getText().trim();
        if (id.isEmpty() || nombre.isEmpty()) {
            mostrarAlerta("Debe ingresar un ID y un nombre para la región.");
            return;
        }

        CompositeRegion region = new CompositeRegion(id, nombre);
        TreeItem<CompositeEspacioGeografico> regionItem = new TreeItem<>(region);

        CompositePais pais = (CompositePais) seleccionado.getValue();
        pais.add(region);

        seleccionado.getChildren().add(regionItem);
        seleccionado.setExpanded(true);
        limpiarCampos();
    }

    private void crearCiudadAdapter() {
        TreeItem<CompositeEspacioGeografico> seleccionado = info1.getSelectionModel().getSelectedItem();
        if (seleccionado == null || !(seleccionado.getValue() instanceof CompositeRegion)) {
            mostrarAlerta("Debe seleccionar una región para agregar una ciudad.");
            return;
        }

        String id = txtId.getText().trim();
        String nombre = txtNombre.getText().trim();
        if (id.isEmpty() || nombre.isEmpty()) {
            mostrarAlerta("Debe ingresar un ID y un nombre para la ciudad.");
            return;
        }

        Ciudad ciudad = new Ciudad(id, nombre);
        AdaptadorCiudad ciudadAdapter = new AdaptadorCiudad(ciudad);
        TreeItem<CompositeEspacioGeografico> ciudadItem = new TreeItem<>(ciudadAdapter);

        CompositeRegion region = (CompositeRegion) seleccionado.getValue();
        region.add(ciudadAdapter);

        seleccionado.getChildren().add(ciudadItem);
        seleccionado.setExpanded(true);
        limpiarCampos();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Advertencia");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
    }
}
