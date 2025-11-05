package co.poli.edu.actividad.modelo;

public class Chip extends ElementoDeSeguridad {

    private String version;
    private int capacidad; // en KB

    public Chip(String id, String descripcion, String nivelSeguridad, String version, int capacidad) {
        super(id, descripcion, nivelSeguridad);
        this.version = version;
        this.capacidad = capacidad;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String validar() {
        return "Chip versión " + version + " validado con capacidad " + capacidad + "KB";
    }

    @Override
    public String toString() {
        return super.toString() + " Chip [version=" + version + ", capacidad=" + capacidad + "]";
    }
}
