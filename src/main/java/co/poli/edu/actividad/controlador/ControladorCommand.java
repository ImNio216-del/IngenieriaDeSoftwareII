package co.poli.edu.actividad.controlador;

import co.poli.edu.actividad.servicios.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleStringProperty;

public class ControladorCommand {

    @FXML
    private Button BttEditar;

    @FXML
    private Button BttEliminar;

    @FXML
    private Button BttGuardar;

    @FXML
    private Button BttLimpiar;

    @FXML
    private TableColumn<PasaporteFicticio, String> ColumnaColor;

    @FXML
    private TableColumn<PasaporteFicticio, String> ColumnaEmisor;

    @FXML
    private TableColumn<PasaporteFicticio, String> ColumnaIdioma;

    @FXML
    private TableColumn<PasaporteFicticio, String> ColumnaTipo;

    @FXML
    private TableView<PasaporteFicticio> TablaVista;

    @FXML
    private TextField txtColor;

    @FXML
    private TextField txtEmisor;

    @FXML
    private TextField txtIdioma;

    @FXML
    private TextField txtTipo;
    
    
    
    
    //----PATRON STRATEGY
    
    @FXML
    private Button BttValidar;   //BOTÓN
   
    //----PATRON STRATEGY
    
    
    
    //---------------------------------------------------------COMMAND----------------------------------------------------------------------------------//

    // Lista de datos simulada (repositorio temporal)
    private final ObservableList<PasaporteFicticio> listaPasaportes = FXCollections.observableArrayList();

    // Objetos del patrón Command
    private final CommandInvocador invocador = new CommandInvocador();
    private final CommandPasaporte servicioPasaporte = new CommandPasaporte();

    @FXML
    public void initialize() {
        // Configurar columnas de la tabla
        ColumnaTipo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTipo()));
        ColumnaColor.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getColorCubierta()));
        ColumnaIdioma.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getIdioma()));
        ColumnaEmisor.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEmisor()));

        // Enlazar la tabla con la lista de pasaportes
        TablaVista.setItems(listaPasaportes);

        // Asociar acciones a los botones
        BttGuardar.setOnAction(e -> guardarPasaporte());
        BttEditar.setOnAction(e -> editarPasaporte());
        BttEliminar.setOnAction(e -> eliminarPasaporte());
        BttLimpiar.setOnAction(e -> limpiarCampos());
        
        
        
        //----PATRON STRATEGY
        BttValidar.setOnAction(e -> validarPasaporte());   // ASIGNACIÓN
        //----PATRON STRATEGY

        
        
        // Cargar datos seleccionados en los campos al hacer clic en una fila
        TablaVista.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                txtTipo.setText(newSel.getTipo());
                txtColor.setText(newSel.getColorCubierta());
                txtIdioma.setText(newSel.getIdioma());
                txtEmisor.setText(newSel.getEmisor());
            }
        });
        
        
    }

    private void guardarPasaporte() {
        PasaporteFicticio nuevo = new PasaporteFicticio(
                txtTipo.getText(),
                txtColor.getText(),
                txtIdioma.getText(),
                txtEmisor.getText()
        );

        // Ejecutar comando de guardar
        Command comando = new CommandGuardarPasaporte(servicioPasaporte, nuevo);
        invocador.asignarComando(comando);
        invocador.ejecutarComando();

        listaPasaportes.add(nuevo);
        TablaVista.refresh();
        limpiarTextFields();
    }

    private void editarPasaporte() {
        PasaporteFicticio seleccionado = TablaVista.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Debe seleccionar un pasaporte para editar.");
            return;
        }

        // Actualizar los valores del objeto seleccionado
        seleccionado = new PasaporteFicticio(
                txtTipo.getText(),
                txtColor.getText(),
                txtIdioma.getText(),
                txtEmisor.getText()
        );

        Command comando = new CommandEditarPasaporte(servicioPasaporte, seleccionado);
        invocador.asignarComando(comando);
        invocador.ejecutarComando();

        int index = TablaVista.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            listaPasaportes.set(index, seleccionado);
        }

        TablaVista.refresh();
    }

    private void eliminarPasaporte() {
        PasaporteFicticio seleccionado = TablaVista.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Debe seleccionar un pasaporte para eliminar.");
            return;
        }

        Command comando = new CommandEliminarPasaporte(servicioPasaporte, seleccionado);
        invocador.asignarComando(comando);
        invocador.ejecutarComando();

        listaPasaportes.remove(seleccionado);
        TablaVista.refresh();
    }

    private void limpiarCampos() {
        // Creamos el comando de limpiar, usando el mismo servicioPasaporte
        Command comando = new CommandLimpiar(servicioPasaporte);
        invocador.asignarComando(comando);
        invocador.ejecutarComando();

        // Además limpiamos los campos visualmente
        limpiarTextFields();
    }


    private void limpiarTextFields() {
        txtTipo.clear();
        txtColor.clear();
        txtIdioma.clear();
        txtEmisor.clear();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
   
    
    
    
    //----PATRON STRATEGY
    @FXML
    private void validarPasaporte(){
        PasaporteFicticio seleccionado=TablaVista.getSelectionModel().getSelectedItem();
        if(seleccionado==null){
            mostrarAlerta("Debe seleccionar un pasaporte para validar.");
            return;
        }
        
        // Creacion StrategyContext
        StrategyContext context=new StrategyContext();
        
        // Ejecucion 3 validaciones y sus resultados
        String resultado=context.validarTodo(seleccionado);
        
        // Mostrar resultados
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Resultado de la validación");
        alert.setContentText(resultado);
        alert.showAndWait();
    }
    
    
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------//
}