package co.poli.edu.actividad.servicios;

public class FacadeVerificacionAntecedentes {
    public boolean verificarAntecedentes(String id) {
        System.out.println("Consultando antecedentes para ID: " + id);
        // Simula que todos los ID terminados en '9' tienen antecedentes
        return !id.endsWith("9");
    }
}
