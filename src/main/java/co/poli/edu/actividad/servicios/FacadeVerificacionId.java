package co.poli.edu.actividad.servicios;

public class FacadeVerificacionId {
    public boolean verificar(String id) {
        System.out.println("Verificando identidad para ID: " + id);
        return id != null && id.length() >= 5; // Ejemplo de validación simple
    }
}
