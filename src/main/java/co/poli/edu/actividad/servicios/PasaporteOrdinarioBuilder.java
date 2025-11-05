package co.poli.edu.actividad.servicios;

import co.poli.edu.actividad.modelo.Pais;
import co.poli.edu.actividad.modelo.PasaporteOrdinario;
import co.poli.edu.actividad.modelo.Titular;

public class PasaporteOrdinarioBuilder {
    private String id;
    private Titular idTitular;
    private String fechaExpedicion;
    private Pais idPais;
    private String motivoPasaporte;
    private String motivoUso;

    public PasaporteOrdinarioBuilder() {}

    public PasaporteOrdinarioBuilder id(String id) {
        this.id = id;
        return this;
    }

    public PasaporteOrdinarioBuilder titular(Titular titular) {
        this.idTitular = titular;
        return this;
    }

    public PasaporteOrdinarioBuilder fechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
        return this;
    }

    public PasaporteOrdinarioBuilder pais(Pais pais) {
        this.idPais = pais;
        return this;
    }

    public PasaporteOrdinarioBuilder motivoPasaporte(String motivoPasaporte) {
        this.motivoPasaporte = motivoPasaporte;
        return this;
    }

    public PasaporteOrdinarioBuilder motivoUso(String motivoUso) {
        this.motivoUso = motivoUso;
        return this;
    }

    public PasaporteOrdinario build() {
        PasaporteOrdinario pasaporte = new PasaporteOrdinario();
        pasaporte.setId(this.id);
        pasaporte.setTitular(this.idTitular);
        pasaporte.setFechaExpedicion(this.fechaExpedicion);
        pasaporte.setPais(this.idPais);
        pasaporte.setMotivoPasaporte(this.motivoPasaporte);
        pasaporte.setMotivoUso(this.motivoUso);
        return pasaporte;
    }
}

