package co.poli.edu.actividad.servicios;
import java.util.List;


public class ESTEstadoSolicitudVisa implements ESTEstadoPais {

    @Override
    public String solicitarEntrada(ESTPaisContext context) {
        return "Entrada pendiente. Por favor, presente su VISA para el país " + context.getAdaptadorPais().getNombre() + ".";
    }

    @Override
    public String ponerEnRevision(ESTPaisContext context) {
        context.setEstado(new ESTEstadoRevision());
        return "El país " + context.getAdaptadorPais().getNombre() + " ha entrado en REVISIÓN y suspende la emisión de visas.";
    }

    @Override
    public String exigirVisa(ESTPaisContext context) {
        return "El país ya exige VISA para la entrada.";
    }

    @Override
    public String cerrarFronteras(ESTPaisContext context) {
        context.setEstado(new ESTEstadoFronteraCerrada());
        return "¡ALERTA! El país " + context.getAdaptadorPais().getNombre() + " ha CERRADO sus fronteras y cancelado todas las visas.";
    }

    @Override
    public List<String> getTransicionesPosibles() {

        return List.of("Poner en Revisión", "Cerrar Fronteras");
    }
}
