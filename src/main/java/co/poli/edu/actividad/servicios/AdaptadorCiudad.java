package co.poli.edu.actividad.servicios;

import co.poli.edu.actividad.modelo.Ciudad;

public class AdaptadorCiudad extends CompositeEspacioGeografico {

    private Ciudad ciudad;

    public AdaptadorCiudad(Ciudad ciudad) {
        super(ciudad.getCodigo(), ciudad.getNombre());
        this.ciudad = ciudad;
    }

    @Override
    public void mostrar() {
        System.out.println("Ciudad: " + ciudad.getNombre());
    }

    @Override
    public String toString() {
        return ciudad.getNombre();
    }
}
