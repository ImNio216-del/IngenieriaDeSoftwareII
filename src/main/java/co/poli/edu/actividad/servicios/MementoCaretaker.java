package co.poli.edu.actividad.servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MementoCaretaker {

    private final Map<String, List<MementoPasaporte>> historial;

    public MementoCaretaker() {
        this.historial = new HashMap<>();
    }

    public void agregarMemento(String idPasaporte, MementoPasaporte memento) {
        historial.computeIfAbsent(idPasaporte, k -> new ArrayList<>()).add(memento);
    }

    public MementoPasaporte deshacer(String idPasaporte) {
        List<MementoPasaporte> mementos = historial.get(idPasaporte);
        if (mementos == null || mementos.size() <= 1) {
            return null;
        }
        
        mementos.remove(mementos.size() - 1);
        return mementos.get(mementos.size() - 1);
    }
    public Map<String, List<MementoPasaporte>> getHistorialCompleto() {
        return historial;
    }
}
