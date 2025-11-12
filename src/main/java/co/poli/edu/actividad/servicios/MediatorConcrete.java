package co.poli.edu.actividad.servicios;

import java.util.ArrayList;
import java.util.List;

public class MediatorConcrete implements Mediator {

    private List<MediatorColega> instituciones;

    public MediatorConcrete() {
        instituciones = new ArrayList<>();
    }

    public void registrarInstitucion(MediatorColega institucion) {
        if (!instituciones.contains(institucion)) {
            instituciones.add(institucion);
        }
    }

    @Override
    public String enviarMensaje(String mensaje, MediatorColega emisor) {
        String nombreEmisor = emisor.getClass().getSimpleName();
        StringBuilder respuesta = new StringBuilder();

        for (MediatorColega institucion : instituciones) {
            if (institucion == emisor) continue; // No se envía a sí mismo

            // Reglas de comunicación
            if (nombreEmisor.contains("Policia")) {
                // Policía notifica a Cancillería y Migración
                if (institucion instanceof MediatorCancilleria || institucion instanceof MediatorMigracion) {
                    respuesta.append(institucion.recibirMensaje("De Policía: " + mensaje + "\n"));
                }
            } 
            else if (nombreEmisor.contains("Cancilleria")) {
                // Cancillería notifica solo a Policía
                if (institucion instanceof MediatorPolicia) {
                    respuesta.append(institucion.recibirMensaje("De Cancillería: " + mensaje + "\n"));
                }
            } 
            else if (nombreEmisor.contains("Migracion")) {
                // Migración notifica solo a Cancillería
                if (institucion instanceof MediatorCancilleria) {
                    respuesta.append(institucion.recibirMensaje("De Migración: " + mensaje + "\n"));
                }
            }
        }

        if (respuesta.length() == 0) {
            return "No hay destinatarios para el mensaje de " + nombreEmisor + ".";
        }

        return "Mensaje enviado desde " + nombreEmisor + ":\n\n" + respuesta.toString();
    }
}
