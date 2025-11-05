package co.poli.edu.actividad.servicios;

import co.poli.edu.actividad.modelo.Titular;

public abstract class DecoratorAbstractTitular extends Titular {

    protected Titular titular; // referencia al objeto base

    public DecoratorAbstractTitular(Titular titular) {
        super(titular.getNombre(), titular.getIdentificacion());
        this.titular = titular;
    }

    @Override
    public String mostrarInfo() {
        return titular.mostrarInfo();
    }

    @Override
    public String toString() {
        return titular.toString();
    }
}
