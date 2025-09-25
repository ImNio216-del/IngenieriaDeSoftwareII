package co.poli.edu.actividad.modelo;

public abstract class Pasaporte {
    private String id;
    private Titular idTitular;
    private String fechaExpedicion;
    private Pais idPais;
    private String motivoPasaporte;

    // Getters
    public Titular getTitular() {
        return idTitular;
    }

    public String getId() {
        return id;
    }

    public String getFechaExpedicion() {
        return fechaExpedicion;
    }

    public String getMotivoPasaporte() {
        return motivoPasaporte;
    }

    public Pais getPais() {
        return idPais;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setTitular(Titular idTitular) {
        this.idTitular = idTitular;
    }

    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public void setPais(Pais pais) {
        this.idPais = pais;
    }

    public void setMotivoPasaporte(String motivoPasaporte) {
        this.motivoPasaporte = motivoPasaporte;
    }

    @Override
    public String toString() {
        return "Pasaporte [id=" + id 
                + ", idTitular=" + idTitular 
                + ", fechaExpedicion=" + fechaExpedicion 
                + ", idPais=" + idPais 
                + ", motivoPasaporte=" + motivoPasaporte + "]";
    }
}
