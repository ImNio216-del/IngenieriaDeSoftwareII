package co.poli.edu.actividad.servicios;

import co.poli.edu.actividad.modelo.Titular;

public class TitularPrototype {
    private Titular titularBase;

    public TitularPrototype(Titular titularBase) {
        this.titularBase = titularBase;
    }

    // Clonación básica (Prototype)
    public Titular clonar() {
        if (titularBase == null) return null;
        return new Titular(
            titularBase.getNombre(),
            titularBase.getIdentificacion()
        );
    }

    public void setTitularBase(Titular nuevoTitular) {
        this.titularBase = nuevoTitular;
    }

    public Titular getTitularBase() {
        return titularBase;
    }
}
