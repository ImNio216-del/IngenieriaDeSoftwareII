package co.poli.edu.actividad.servicios;

import co.poli.edu.actividad.modelo.Pasaporte;


public class CORTipoPasaporte extends CORBaseHandler {

    @Override
    public String validar(Pasaporte pasaporte) {
        String tipo = pasaporte.getTipoDePasaporte();

        if (tipo == null || (!tipo.equalsIgnoreCase("Ordinario") && !tipo.equalsIgnoreCase("Diplomatico"))) {
            return "Error de Datos: El 'Tipo de Pasaporte' debe ser 'Ordinario' o 'Diplomatico'.";
        }
        return validarSiguiente(pasaporte);
    }
}