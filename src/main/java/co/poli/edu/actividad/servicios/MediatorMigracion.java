package co.poli.edu.actividad.servicios;

public class MediatorMigracion extends MediatorColega {

    public MediatorMigracion(Mediator mediator) {
        super(mediator);
    }

    @Override
    public String recibirMensaje(String mensaje) {
        return "Migración recibió: " + mensaje + "\n";
    }
}
