package co.poli.edu.actividad.servicios;

public class ObserverPublisher {

    private ObserverSuscriber cancilleria;
    private ObserverSuscriber policia;
    private ObserverSuscriber migracion;

    public ObserverPublisher() {
        // Los observadores están fijos
    	cancilleria = new ObserverCancilleria();
    	policia = new ObserverPolicia();
    	migracion = new ObserverMigracion();
    }

    public String notificarSuscribers() {
        StringBuilder confirmacion = new StringBuilder();

        confirmacion.append(cancilleria.enviarNotificacion()).append("\n");
        confirmacion.append(policia.enviarNotificacion()).append("\n");
        confirmacion.append(migracion.enviarNotificacion()).append("\n");

        return confirmacion.toString();
    }

    public String verLista() {
        return cancilleria.getNombre() + " " +
               policia.getNombre() + " " +
               migracion.getNombre();
    }
}
