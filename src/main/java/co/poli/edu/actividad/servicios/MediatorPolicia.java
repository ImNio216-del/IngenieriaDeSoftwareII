package co.poli.edu.actividad.servicios;

public class MediatorPolicia extends MediatorColega {

    public MediatorPolicia(Mediator mediator) {
        super(mediator);
    }

    @Override
    public String recibirMensaje(String mensaje) {
        return "Policía recibió: " + mensaje + "\n";
    }
}
