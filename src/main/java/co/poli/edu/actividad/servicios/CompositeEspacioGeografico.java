package co.poli.edu.actividad.servicios;

import java.util.List;

public abstract class CompositeEspacioGeografico {
    protected String id;
    protected String nombre;

    public CompositeEspacioGeografico(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    // Métodos para manejar hijos (por defecto no soportados)
    public void add(CompositeEspacioGeografico comp) {
        throw new UnsupportedOperationException();
    }

    public void remove(CompositeEspacioGeografico comp) {
        throw new UnsupportedOperationException();
    }

    public List<CompositeEspacioGeografico> getChildren() {
        throw new UnsupportedOperationException();
    }

    public abstract void mostrar();
}
