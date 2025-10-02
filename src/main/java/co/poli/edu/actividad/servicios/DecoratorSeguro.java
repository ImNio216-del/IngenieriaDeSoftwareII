package co.poli.edu.actividad.servicios;

import co.poli.edu.actividad.modelo.Titular;

public class DecoratorSeguro extends DecoratorAbstractTitular {

    private String seguro;

    public DecoratorSeguro(Titular titular, String seguro) {
        super(titular);
        this.seguro = seguro;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | Seguro: " + seguro;
    }

    @Override
    public String toString() {
        return mostrarInfo();
    }
}
