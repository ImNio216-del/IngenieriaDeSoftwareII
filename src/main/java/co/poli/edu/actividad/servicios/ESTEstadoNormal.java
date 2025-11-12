package co.poli.edu.actividad.servicios;
import java.util.List;


public class ESTEstadoNormal implements ESTEstadoPais {

    @Override
    public String solicitarEntrada(ESTPaisContext context) {
        return "Entrada permitida al país " + context.getAdaptadorPais().getNombre() + ". ¡Bienvenido!";
    }

    @Override
    public String ponerEnRevision(ESTPaisContext context) {
        context.setEstado(new ESTEstadoRevision());
        return "El país " + context.getAdaptadorPais().getNombre() + " ha entrado en estado de REVISIÓN.";
    }

    @Override
    public String exigirVisa(ESTPaisContext context) {
        context.setEstado(new ESTEstadoSolicitudVisa());
        return "El país " + context.getAdaptadorPais().getNombre() + " ahora requiere VISA para la entrada.";
    }

    @Override
    public String cerrarFronteras(ESTPaisContext context) {
        context.setEstado(new ESTEstadoFronteraCerrada());
        return "¡ALERTA! El país " + context.getAdaptadorPais().getNombre() + " ha CERRADO sus fronteras.";
    }

    @Override
    public List<String> getTransicionesPosibles() {

        return List.of("Poner en Revisión", "Exigir Visa", "Cerrar Fronteras");
    }
}
