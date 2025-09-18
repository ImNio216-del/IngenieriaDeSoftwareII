package co.poli.edu.actividad.servicios;

import co.poli.edu.actividad.modelo.Pasaporte;
import co.poli.edu.actividad.modelo.PasaporteDiplomatico;

public class FactoryDiplomatico implements FactoriaInterface{

    public Pasaporte crearPasaporte() {
        return new PasaporteDiplomatico();
    }
}
