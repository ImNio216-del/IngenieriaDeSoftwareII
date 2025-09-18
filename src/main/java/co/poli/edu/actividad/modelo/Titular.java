package co.poli.edu.actividad.modelo;

public class Titular {
    private String idTitular;
    private String nombre;
    private String fechaNacimiento;

    public Titular(String id, String nombre, String fechaNacimiento) {
        this.idTitular = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getId() {
        return idTitular;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public String toString() {
        return nombre + " (ID: " + idTitular + ", Nacimiento: " + fechaNacimiento + ")";
    }
}
