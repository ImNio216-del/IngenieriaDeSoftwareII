package co.poli.edu.actividad.modelo;

import java.util.List;

public class Pais {
    private String idPais;
    private String nombre;
    private List<Ciudad> ciudades;

    public Pais(String idPais, String nombre, List<Ciudad> ciudades) {
        this.idPais = idPais;
        this.nombre = nombre;
        this.ciudades = ciudades;
    }

    public String getId() {
        return idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    @Override
    public String toString() {
        return nombre + " [" + idPais + "]";
    }
}
