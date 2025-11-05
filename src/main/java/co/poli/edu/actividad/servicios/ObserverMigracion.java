package co.poli.edu.actividad.servicios;

public class ObserverMigracion implements ObserverSuscriber{
    @Override
    public String enviarNotificacion() {
        return "Notificación enviada a Migración.";
    }
    @Override
    public String getNombre() {
        return "Migración";
    }
}
