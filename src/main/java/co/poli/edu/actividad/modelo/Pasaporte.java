package co.poli.edu.actividad.modelo;

import co.poli.edu.actividad.servicios.MementoPasaporte;
import java.util.ArrayList;
import java.util.List;

public abstract class Pasaporte {
    // Atributos originales
    private String id;
    private Titular idTitular;
    private String fechaExpedicion;
    private Pais idPais;
    private String motivoPasaporte;

    // Atributos para el Memento
    private String numeroPasaporte;
    private String nombrePasajero;
    private String paisDeViaje;
    private String tipoDePasaporte;
    private String fechaEmision; // Atributo corregido

    // Bridge
    private List<ElementoDeSeguridad> elementos = new ArrayList<>();

    // Getters y setters
    public Titular getTitular() { return idTitular; }
    public void setTitular(Titular idTitular) { this.idTitular = idTitular; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getFechaExpedicion() { return fechaExpedicion; }
    public void setFechaExpedicion(String fechaExpedicion) { this.fechaExpedicion = fechaExpedicion; }
    public Pais getPais() { return idPais; }
    public void setPais(Pais idPais) { this.idPais = idPais; }
    public String getMotivoPasaporte() { return motivoPasaporte; }
    public void setMotivoPasaporte(String motivoPasaporte) { this.motivoPasaporte = motivoPasaporte; }
    public String getNumeroPasaporte() { return numeroPasaporte; }
    public void setNumeroPasaporte(String numeroPasaporte) { this.numeroPasaporte = numeroPasaporte; }
    public String getNombrePasajero() { return nombrePasajero; }
    public void setNombrePasajero(String nombrePasajero) { this.nombrePasajero = nombrePasajero; }
    public String getPaisDeViaje() { return paisDeViaje; }
    public void setPaisDeViaje(String paisDeViaje) { this.paisDeViaje = paisDeViaje; }
    public String getTipoDePasaporte() { return tipoDePasaporte; }
    public void setTipoDePasaporte(String tipoDePasaporte) { this.tipoDePasaporte = tipoDePasaporte; }
    public String getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(String fechaEmision) { this.fechaEmision = fechaEmision; }

    // Métodos Bridge
    public void addElementoSeguridad(ElementoDeSeguridad elemento) { elementos.add(elemento); }
    public List<ElementoDeSeguridad> getElementosSeguridad() { return elementos; }

    // --- Métodos del Patrón Memento ---
    public MementoPasaporte guardarEstado() {
        return new MementoPasaporte(this.id, this.numeroPasaporte, this.fechaEmision, this.nombrePasajero, this.paisDeViaje, this.tipoDePasaporte);
    }

    public void restaurarEstado(MementoPasaporte memento) {
        this.numeroPasaporte = memento.getNumeroPasaporte();
        this.fechaEmision = memento.getFechaEmision();
        this.nombrePasajero = memento.getNombrePasajero();
        this.paisDeViaje = memento.getPaisDeViaje();
        this.tipoDePasaporte = memento.getTipoDePasaporte();
    }

    public abstract void imprimirDetalles();

    @Override
    public String toString() {
        return "Pasaporte [id=" + id + ", fechaEmision=" + fechaEmision + ", numeroPasaporte=" + numeroPasaporte + ", nombrePasajero=" + nombrePasajero + "]";
    }
}
