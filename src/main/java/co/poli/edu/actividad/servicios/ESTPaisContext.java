package co.poli.edu.actividad.servicios;
import co.poli.edu.actividad.modelo.Pais;


public class ESTPaisContext {

    private ESTEstadoPais estadoActual;
    private ESTAdaptadorPais adaptadorPais;

    public ESTPaisContext(Pais pais) {

        this.estadoActual = new ESTEstadoNormal();
        this.adaptadorPais = new ESTAdaptadorPais(pais);
    }



    public void setEstado(ESTEstadoPais nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }

    public ESTEstadoPais getEstado() {
        return estadoActual;
    }

    public ESTAdaptadorPais getAdaptadorPais() {
        return adaptadorPais;
    }



    public String solicitarEntrada() {

        return estadoActual.solicitarEntrada(this);
    }

    public String ponerEnRevision() {

        return estadoActual.ponerEnRevision(this);
    }

    public String exigirVisa() {

        return estadoActual.exigirVisa(this);
    }

    public String cerrarFronteras() {

        return estadoActual.cerrarFronteras(this);
    }
}
