package co.poli.edu.actividad.servicios;

public class MementoPasaporte {

    private final String idPasaporte;
    private final String numeroPasaporte;
    private final String fechaEmision;
    private final String nombrePasajero;
    private final String paisDeViaje;
    private final String tipoDePasaporte;

    public MementoPasaporte(String idPasaporte, String numeroPasaporte, String fechaEmision, String nombrePasajero, String paisDeViaje, String tipoDePasaporte) {
        this.idPasaporte = idPasaporte;
        this.numeroPasaporte = numeroPasaporte;
        this.fechaEmision = fechaEmision;
        this.nombrePasajero = nombrePasajero;
        this.paisDeViaje = paisDeViaje;
        this.tipoDePasaporte = tipoDePasaporte;
    }

    public String getIdPasaporte() {
        return idPasaporte;
    }

    public String getNumeroPasaporte() {
        return numeroPasaporte;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public String getPaisDeViaje() {
        return paisDeViaje;
    }

    public String getTipoDePasaporte() {
        return tipoDePasaporte;
    }
}
