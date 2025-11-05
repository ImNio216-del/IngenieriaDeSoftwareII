package co.poli.edu.actividad.servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MementoCaretaker {

    private final Map<String, List<MementoPasaporte>> memento;

    public MementoCaretaker() {
        this.memento = new HashMap<>();
    }

    public void agregarMemento(String idPasaporte, MementoPasaporte memento) {
        this.memento.computeIfAbsent(idPasaporte, k -> new ArrayList<>()).add(memento);
    }

    public MementoPasaporte deshacerMementoPasaporte(String idPasaporte) {
        List<MementoPasaporte> memento = this.memento.get(idPasaporte);
        if (memento == null || memento.size() <= 1) {

            return null;
        }
        

        memento.remove(memento.size() - 1);

        return memento.get(memento.size() - 1);
    }

    public Map<String, List<MementoPasaporte>> getMementoCompleto() {
        return memento;
    }
}
