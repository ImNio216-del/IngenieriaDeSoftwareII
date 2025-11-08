package co.poli.edu.actividad.servicios;

import co.poli.edu.actividad.modelo.Pasaporte;


public interface CORHandler {
    void setSiguiente(CORHandler NManejador);
    String validar(Pasaporte pasaporte);
}
