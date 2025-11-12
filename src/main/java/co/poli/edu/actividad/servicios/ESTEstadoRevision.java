package co.poli.edu.actividad.servicios;
import java.util.List;


public class ESTEstadoRevision implements ESTEstadoPais {

    @Override
    public String solicitarEntrada(ESTPaisContext context) {
        return "Acceso denegado. El país " + context.getAdaptadorPais().getNombre() + " está bajo revisión de seguridad.";
    }

    @Override
    public String ponerEnRevision(ESTPaisContext context) {
        return "El país ya se encuentra en estado de REVISIÓN.";
    }

    @Override
    public String exigirVisa(ESTPaisContext context) {

        context.setEstado(new ESTEstadoNormal());
        return "Revisión finalizada. El país " + context.getAdaptadorPais().getNombre() + " ha vuelto a la NORMALIDAD.";
    }

    @Override
    public String cerrarFronteras(ESTPaisContext context) {
        context.setEstado(new ESTEstadoFronteraCerrada());
        return "¡ALERTA! Por motivos de seguridad, el país " + context.getAdaptadorPais().getNombre() + " ha CERRADO sus fronteras.";
    }

    @Override
    public List<String> getTransicionesPosibles() {

        return List.of("Aprobar y volver a Normal", "Cerrar Fronteras");
    }
}
