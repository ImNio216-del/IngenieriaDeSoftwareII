package co.poli.edu.actividad.vista;

import java.util.ArrayList;

import co.poli.edu.actividad.modelo.ElementoSeguridad;
import co.poli.edu.actividad.modelo.PasaporteOrdinario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import co.poli.edu.actividad.modelo.Titular;
import co.poli.edu.actividad.modelo.Pais;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Carga de la vista con FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/poli/edu/actividad/vista/menu.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Gestión de Pasaportes");
            primaryStage.show();

            // Ejecutar ejemplo en modo visual
            ejecutarEjemplo("Visual (JavaFX)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ------------------ BUILDER + PROTOTYPE ------------------
    private void ejecutarEjemplo(String modo) {
        System.out.println("\n=== EJEMPLO (" + modo + ") ===");

        // PASAPORTE 1 (Builder completo)
        PasaporteOrdinario po = new PasaporteOrdinario();
        po.setId("ABC123");
        po.setTitular(new Titular("101", "Juan Pérez", "CC"));
        po.setPais(new Pais("57", "Colombia", new ArrayList<>()));
        po.setFechaExpedicion("17/09/2025");
        po.setMotivoViaje("Turismo");

        // Usar BUILDER con todos los atributos
        ElementoSeguridad seguridadCompleta = new ElementoSeguridad.Builder()
                .setHol("Holograma 3D")
                .setSAgua("Sello oficial")
                .setTEspecial("Tinta UV")
                .setChipElec("Chip NFC biométrico")
                .build();

        po.setElementoSeguridad(seguridadCompleta);

        // Clonar (Prototype)
        PasaporteOrdinario copia = po.clone();
        copia.setId("XYZ999");
        copia.setMotivoViaje("Negocios");

        // Mostrar en consola
        System.out.println("Pasaporte original (seguridad completa):");
        System.out.println(po);

        System.out.println("Pasaporte clonado:");
        System.out.println(copia);

        // PASAPORTE 2 (Builder parcial)
        PasaporteOrdinario po2 = new PasaporteOrdinario();
        po2.setId("LMN456");
        po2.setTitular(new Titular("202", "Ana Gómez", "CE"));
        po2.setPais(new Pais("34", "España", new ArrayList<>()));
        po2.setFechaExpedicion("01/01/2026");
        po2.setMotivoViaje("Estudios");

        // Builder solo con algunos atributos
        ElementoSeguridad seguridadParcial = new ElementoSeguridad.Builder()
                .setHol("Holograma básico")
                .setChipElec("Chip simple")
                .build();

        po2.setElementoSeguridad(seguridadParcial);

        // Clonar (Prototype)
        PasaporteOrdinario copia2 = po2.clone();
        copia2.setId("ZZZ111");
        copia2.setMotivoViaje("Investigación");

        System.out.println("\nPasaporte original (seguridad parcial):");
        System.out.println(po2);

        System.out.println("Pasaporte clonado (desde seguridad parcial):");
        System.out.println(copia2);
    }

    // ------------------ MODO CONSOLA ------------------
    public static void main(String[] args) {
        System.out.println("Iniciando aplicación de Gestión de Pasaportes...");

        // Ejecutar ejemplo en modo consola
        Main ejemplo = new Main();
        ejemplo.ejecutarEjemplo("Consola pura");

        // Lanzar JavaFX
        launch(args);
    }
}