package co.poli.edu.actividad.modelo;

public class Titular {
    private String nombre;
    private String identificacion;

    public Titular(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String mostrarInfo() {
        return "Titular [nombre=" + nombre + ", identificación=" + identificacion + "]";
    }

    @Override
    public String toString() {
        return mostrarInfo();
    }
}