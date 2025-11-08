package co.poli.edu.actividad.servicios;

import co.poli.edu.actividad.modelo.Pasaporte;


public abstract class CORBaseHandler implements CORHandler {

    private CORHandler siguiente;

    @Override
    public void setSiguiente(CORHandler siguiente) {
        this.siguiente = siguiente;
    }

    protected String validarSiguiente(Pasaporte pasaporte) {
        if (siguiente == null) {
            return null; // Fin de la cadena, validación exitosa.
        }
        return siguiente.validar(pasaporte);
    }
}
