package co.poli.edu.actividad.servicios;

import co.poli.edu.actividad.modelo.Pasaporte;
import co.poli.edu.actividad.modelo.PasaporteOrdinario;

public class FactoryOrdinario implements FactoriaInterface {

    @Override
    public Pasaporte crearPasaporte() {
        return new PasaporteOrdinario();
    }
}
