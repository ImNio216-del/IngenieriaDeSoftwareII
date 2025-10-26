package co.poli.edu.actividad.vista;

import java.util.Scanner;

import co.poli.edu.actividad.modelo.*;
import co.poli.edu.actividad.servicios.*;

public class Main {
    public static void main(String[] args) {
    	
    	Scanner scan = new Scanner(System.in);
    	
      /*  System.out.println("=== PATRÓN BRIDGE ===");

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
        
        */
        System.out.println("✿ -------------------- ✿ ----------------------- ✿/");
        
        System.out.println("Main Flyweight");
        
        PasaporteTipo tipoP1 = FactoriaFlyWeight.getPasaporteTipo("Ordinario", "Azul Oscuro", "Español", "República de Colombia");
        tipoP1.mostrarPasaporteCompleto(101, "OA123456", "2023-01-15", "2033-01-14");


        PasaporteTipo tipoP2 = FactoriaFlyWeight.getPasaporteTipo("Ordinario", "Azul Oscuro", "Español", "República de Colombia");
        tipoP2.mostrarPasaporteCompleto(102, "OA789012", "2024-03-20", "2034-03-19");


        PasaporteTipo tipoP3 = FactoriaFlyWeight.getPasaporteTipo("Diplomático", "Negro", "Español e Inglés", "República de Colombia");
        tipoP3.mostrarPasaporteCompleto(201, "PD987654", "2022-11-01", "2032-10-31");
        

        PasaporteTipo tipoP4 = FactoriaFlyWeight.getPasaporteTipo("Ordinario", "Verde", "Español", "Estados Unidos Mexicanos");
        tipoP4.mostrarPasaporteCompleto(301, "MX456789", "2024-05-10", "2034-05-09");
        

        
        System.out.println("✿ -------------------- ✿ ----------------------- ✿");
        System.out.println("---------Main Facade----------");
        FacadePasaporte fachada = new FacadePasaporte();
        fachada.procesar("1001", "Ana Pérez", "Colombia");
        fachada.procesar("2003", "Luis Gómez", "Chile");
        fachada.procesar("1349", "Juan Pérez", "Colombia");
        fachada.procesar("12345", "Ana Pérez", "Colombia");
        fachada.procesar("12349", "Ana Pérez", "Colombia");

        
        System.out.println("✿ -------------------- ✿ ----------------------- ✿");
        System.out.println("=== DEMO PROXY PASAPORTE ===");
        ProxyPasaporte proxy = new ProxyAdaptadorPasaporte();
      
        System.out.println("=== DEMO PROXY PASAPORTE ===");
        System.out.print("Ingrese su rol (Administrador, Funcionario o Visitante): ");
        String rol = scan.nextLine();

        proxy.visualizarInformacion(rol);

        scan.close();
    }
}
