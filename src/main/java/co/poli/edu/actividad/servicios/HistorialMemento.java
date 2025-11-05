package co.poli.edu.actividad.servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Caretaker (Conserje): Gestiona el historial de los Mementos de los pasaportes.
 */
public class HistorialMemento {

    private final Map<String, List<MementoPasaporte>> historial;

    public HistorialMemento() {
        this.historial = new HashMap<>();
    }

    /**
     * Agrega un nuevo Memento al historial de un pasaporte específico.
     * @param idPasaporte El ID del pasaporte.
     * @param memento El estado del pasaporte a guardar.
     */
    public void agregarMemento(String idPasaporte, MementoPasaporte memento) {
        historial.computeIfAbsent(idPasaporte, k -> new ArrayList<>()).add(memento);
    }

    /**
     * Devuelve el historial completo de todos los pasaportes.
     * @return Un mapa con todo el historial.
     */
    public Map<String, List<MementoPasaporte>> getHistorialCompleto() {
        return historial;
    }
}
