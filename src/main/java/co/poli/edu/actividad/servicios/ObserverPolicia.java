package co.poli.edu.actividad.servicios;

public class ObserverPolicia implements ObserverSuscriber{
    @Override
    public String enviarNotificacion() {
        return "Notificación enviada a la Policía.";
    }
    @Override
    public String getNombre() {
        return "Policía";
    }
}
