package co.poli.edu.actividad.servicios;

public class ObserverCancilleria implements ObserverSuscriber{
    @Override
    public String enviarNotificacion() {
        return "Notificación enviada a Cancillería.";
    }
    @Override
    public String getNombre() {
        return "Cancillería";
    }
}
