package co.poli.edu.actividad.modelo;

public abstract class ElementoDeSeguridad {
    private String id;
    private String descripcion;
    private String nivelSeguridad;

    public ElementoDeSeguridad(String id, String descripcion, String nivelSeguridad) {
        this.id = id;
        this.descripcion = descripcion;
        this.nivelSeguridad = nivelSeguridad;
    }

    public String getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNivelSeguridad() {
        return nivelSeguridad;
    }

    // Método abstracto para validación
    public abstract String validar();

    @Override
    public String toString() {
        return "ElementoDeSeguridad [id=" + id 
                + ", descripcion=" + descripcion 
                + ", nivelSeguridad=" + nivelSeguridad + "]";
    }
}
