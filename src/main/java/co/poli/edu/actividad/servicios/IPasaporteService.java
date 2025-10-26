package co.poli.edu.actividad.servicios;

import co.poli.edu.actividad.modelo.Pasaporte;

public interface IPasaporteService {
    Pasaporte obtenerPorId(String id) throws IllegalAccessException;
}
