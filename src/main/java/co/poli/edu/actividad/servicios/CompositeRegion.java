package co.poli.edu.actividad.servicios;

import java.util.ArrayList;
import java.util.List;

public class CompositeRegion extends CompositeEspacioGeografico {
    private List<CompositeEspacioGeografico> hijos = new ArrayList<>();

    public CompositeRegion(String id, String nombre) {
        super(id, nombre);
    }

    @Override
    public void add(CompositeEspacioGeografico comp) {
        hijos.add(comp);
    }

    @Override
    public void remove(CompositeEspacioGeografico comp) {
        hijos.remove(comp);
    }

    @Override
    public List<CompositeEspacioGeografico> getChildren() {
        return hijos;
    }

    @Override
    public void mostrar() {
        System.out.println("Región [" + id + "]: " + nombre);
        for (CompositeEspacioGeografico hijo : hijos) {
            hijo.mostrar();
        }
    }
}
