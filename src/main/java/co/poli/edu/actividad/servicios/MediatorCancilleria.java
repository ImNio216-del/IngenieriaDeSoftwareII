package co.poli.edu.actividad.servicios;

public class MediatorCancilleria extends MediatorColega {

    public MediatorCancilleria(Mediator mediator) {
        super(mediator);
    }

    @Override
    public String recibirMensaje(String mensaje) {
        return "Cancillería recibió: " + mensaje + "\n";
    }
}
