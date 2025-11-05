package co.poli.edu.actividad.servicios;

import co.poli.edu.actividad.modelo.Titular;
import co.poli.edu.actividad.modelo.Visa;

public class DecoratorVisa extends DecoratorAbstractTitular {

    private Visa visa;

    public DecoratorVisa(Titular titular, Visa visa) {
        super(titular);
        this.visa = visa;
    }

    public Visa getVisa() {
        return visa;
    }

    public void setVisa(Visa visa) {
        this.visa = visa;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | " + visa.toString();
    }

    @Override
    public String toString() {
        return mostrarInfo();
    }
}
