package co.poli.edu.actividad.servicios;

import co.poli.edu.actividad.modelo.Pais;


public class ESTAdaptadorPais {

    private Pais pais;

    public ESTAdaptadorPais(Pais pais) {
        this.pais = pais;
    }


    public String getNombre() {

        return pais.getNombre();
    }


    public String getId() {
        return pais.getId();
    }

}
