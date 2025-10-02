package co.poli.edu.actividad.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Pasaporte {
    private String id;
    private Titular idTitular;
    private String fechaExpedicion;
    private Pais idPais;
    private String motivoPasaporte;

    // Bridge → lista de elementos de seguridad
    private List<ElementoDeSeguridad> elementos = new ArrayList<>();

    // Getters y setters
    public Titular getTitular() {
        return idTitular;
    }

    public void setTitular(Titular idTitular) {
        this.idTitular = idTitular;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Pais getPais() {
        return idPais;
    }

    public void setPais(Pais idPais) {
        this.idPais = idPais;
    }

    public String getMotivoPasaporte() {
        return motivoPasaporte;
    }

    public void setMotivoPasaporte(String motivoPasaporte) {
        this.motivoPasaporte = motivoPasaporte;
    }

    // Métodos Bridge
    public void addElementoSeguridad(ElementoDeSeguridad elemento) {
        elementos.add(elemento);
    }

    public List<ElementoDeSeguridad> getElementosSeguridad() {
        return elementos;
    }

    // Método abstracto para especializar comportamiento
    public abstract void imprimirDetalles();

    @Override
    public String toString() {
        return "Pasaporte [id=" + id 
                + ", idTitular=" + idTitular 
                + ", fechaExpedicion=" + fechaExpedicion 
                + ", idPais=" + idPais 
                + ", motivoPasaporte=" + motivoPasaporte 
                + ", elementos=" + elementos + "]";
    }
}
