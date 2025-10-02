package co.poli.edu.actividad.vista;

import co.poli.edu.actividad.modelo.*;
import co.poli.edu.actividad.servicios.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PATRÓN BRIDGE ===");

        // Pais (puedes pasar null para la lista de ciudades)
        Pais paisUSA = new Pais("US", "Estados Unidos", null);

        // Pasaporte ordinario con un Chip (Bridge)
        Chip chip = new Chip("CH1", "Chip NFC", "ALTO", "v1.0", 256);
        Pasaporte pasaporteOrd = new PasaporteOrdinario();
        pasaporteOrd.addElementoSeguridad(chip);
        pasaporteOrd.imprimirDetalles(); // imprime detalles + validaciones de elementos

        System.out.println();

        // Pasaporte diplomático con Biometrico (Bridge)
        Biometrico biom = new Biometrico("B1", "Sensor huella", "ALTO", "huella");
        Pasaporte pasaporteDipl = new PasaporteDiplomatico();
        pasaporteDipl.addElementoSeguridad(biom);
        pasaporteDipl.imprimirDetalles();

        System.out.println("\n=== PATRÓN DECORATOR ===");

        // Titular base
        Titular titular = new Titular("Juan Pérez", "123456789");

        // Decorator: agregar Visa (necesita un objeto Pais para la Visa)
        Visa visaUSA = new Visa("V-001", paisUSA);
        DecoratorVisa titularConVisa = new DecoratorVisa(titular, visaUSA);
        System.out.println("Titular con visa -> " + titularConVisa.mostrarInfo());

        // Luego decorar con Seguro
        DecoratorSeguro titularConVisaYSeguro = new DecoratorSeguro(titularConVisa, "Seguro Internacional");
        System.out.println("Titular con visa y seguro -> " + titularConVisaYSeguro.mostrarInfo());
    }
}
