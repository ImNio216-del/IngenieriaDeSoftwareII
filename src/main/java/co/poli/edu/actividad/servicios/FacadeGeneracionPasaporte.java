package co.poli.edu.actividad.servicios;


public class FacadeGeneracionPasaporte {
    public void generar(String id, String nombre, String pais) {
        System.out.println("Generando pasaporte para: " + nombre);
        System.out.println("País: " + pais);
        System.out.println("ID: " + id);
        System.out.println("Pasaporte generado con éxito ✅");
    }
}
