package co.poli.edu.actividad.vista;

import co.poli.edu.actividad.modelo.*;
import co.poli.edu.actividad.servicios.AdaptadorCiudad;
import co.poli.edu.actividad.servicios.CompositeRegion;
import co.poli.edu.actividad.servicios.PasaporteOrdinarioBuilder;
import co.poli.edu.actividad.servicios.TitularPrototype;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // --- Crear un titular base ---
    	
        Titular titular1 = new Titular("T001", "Juan Pérez", "1990-05-15");
        Titular titular2 = new Titular("T002", "Mariana Pinilla", "2004-08-11");

        // --- Crear un Prototype para clonar ---
        TitularPrototype prototype1 = new TitularPrototype(titular1);
        TitularPrototype prototype2 = new TitularPrototype(titular2);

        // --- Clonar el titular ---
        Titular titularClonado1 = prototype1.clonar();
        Titular titularClonado2 = prototype2.clonar();

        // --- Crear un país sin ciudades por simplicidad ---
        Pais paisColombia = new Pais("CO", "Colombia", new ArrayList<>());

        // --- Crear pasaportes ordinarios usando el Builder ---
        PasaporteOrdinario pasaporte1 = new PasaporteOrdinarioBuilder()
                .id("P001")
                .titular(titularClonado1)
                .fechaExpedicion("2025-09-21")
                .pais(paisColombia)
                .motivoPasaporte("Viaje Internacional")
                .motivoUso("Turismo")
                .build();

        PasaporteOrdinario pasaporte2 = new PasaporteOrdinarioBuilder()
                .id("P002")
                .titular(titularClonado2)
                .fechaExpedicion("2025-09-22")
                .pais(paisColombia)
                .motivoPasaporte("Trabajo")
                .motivoUso("Economia")
                .build();

        // --- Imprimir los pasaportes ---
        System.out.println(pasaporte1);
        System.out.println(pasaporte2);

        // --- Imprimir los titulares base y clonados ---
        System.out.println("Titular Base: " + titular1);
        System.out.println("Titular Base: " + titular2);
        System.out.println("Titular Clonado 1: " + titularClonado1);
        System.out.println("Titular Clonado 2: " + titularClonado2);

        // --- Imprimir país ---
        System.out.println("País de los pasaportes: " + paisColombia);
        
        
        
        System.out.println("___________________________________________________________");
        
 
    }
}
