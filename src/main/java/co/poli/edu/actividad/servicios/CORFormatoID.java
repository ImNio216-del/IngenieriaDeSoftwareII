package co.poli.edu.actividad.servicios;

import co.poli.edu.actividad.modelo.Pasaporte;


public class CORFormatoID extends CORBaseHandler {


    private static final String FormatoID = "[A-Z]{2}\\d{6}";

    @Override
    public String validar(Pasaporte pasaporte) {
        final String id = pasaporte.getId();
        if (id == null || id.trim().isEmpty() || !id.matches(FormatoID)) {
            return "Error de Formato: El ID del pasaporte debe tener 2 letras mayúsculas seguidas de 6 números (ej. AB123456).";
        }
        return validarSiguiente(pasaporte);
    }
}
