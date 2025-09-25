package co.poli.edu.actividad.servicios;

import co.poli.edu.actividad.modelo.Titular;

public class TitularPrototype {
    private Titular titularBase;

    public TitularPrototype(Titular titularBase) {
        this.titularBase = titularBase;
    }

    public Titular clonar() {
        if (titularBase == null) return null;
        return new Titular(
            titularBase.getId(),
            titularBase.getNombre(),
            titularBase.getFechaNacimiento()
        );
    }

    public void setTitularBase(Titular nuevoTitular) {
        this.titularBase = nuevoTitular;
    }

    public Titular getTitularBase() {
        return titularBase;
    }
}
