package co.poli.edu.actividad.servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Caretaker (Conserje): Gestiona el historial de los Mementos de los pasaportes.
 */
public class MementoCaretaker {

    private final Map<String, List<MementoPasaporte>> historial;

    public MementoCaretaker() {
        this.historial = new HashMap<>();
    }

    /**
     * Agrega un nuevo Memento al historial de un pasaporte específico.
     */
    public void agregarMemento(String idPasaporte, MementoPasaporte memento) {
        historial.computeIfAbsent(idPasaporte, k -> new ArrayList<>()).add(memento);
    }

    /**
     * Deshace el último cambio para un pasaporte específico.
     * Elimina el estado más reciente y devuelve el estado anterior.
     * @param idPasaporte El ID del pasaporte a revertir.
     * @return El Memento del estado anterior, o null si no hay a dónde revertir.
     */
    public MementoPasaporte deshacer(String idPasaporte) {
        List<MementoPasaporte> mementos = historial.get(idPasaporte);
        if (mementos == null || mementos.size() <= 1) {
            return null;
        }
        
        mementos.remove(mementos.size() - 1);
        return mementos.get(mementos.size() - 1);
    }

    /**
     * Devuelve el historial completo de todos los pasaportes.
     * @return Un mapa con todo el historial.
     */
    public Map<String, List<MementoPasaporte>> getHistorialCompleto() {
        return historial;
    }
}
