package co.poli.edu.actividad.servicios;

import co.poli.edu.actividad.modelo.Pasaporte;


public class CORDatosRequeridos extends CORBaseHandler {


    @Override
    public String validar(Pasaporte pasaporte) {
        if (pasaporte.getNombrePasajero() == null || pasaporte.getNombrePasajero().trim().isEmpty()) {
            return "Error de Datos: El campo 'Nombre del Pasajero' es obligatorio y no puede estar vacío.";
        }
        if (pasaporte.getTipoDePasaporte() == null || pasaporte.getTipoDePasaporte().trim().isEmpty()) {
            return "Error de Datos: El campo 'Tipo de Pasaporte' es obligatorio y no puede estar vacío.";
        }

        return validarSiguiente(pasaporte);
    }
}
