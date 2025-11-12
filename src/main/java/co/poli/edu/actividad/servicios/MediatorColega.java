package co.poli.edu.actividad.servicios;

public abstract class MediatorColega {
    protected Mediator mediator;

    public MediatorColega(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract String recibirMensaje(String mensaje);

    public void enviarMensaje(String mensaje) {
        mediator.enviarMensaje(mensaje, this);
    }
}