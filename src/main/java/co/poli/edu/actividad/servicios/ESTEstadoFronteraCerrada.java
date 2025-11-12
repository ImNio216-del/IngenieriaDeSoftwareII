package co.poli.edu.actividad.servicios;
import java.util.List;


public class ESTEstadoFronteraCerrada implements ESTEstadoPais {

    @Override
    public String solicitarEntrada(ESTPaisContext context) {
        return "¡ACCESO DENEGADO! Las fronteras del país " + context.getAdaptadorPais().getNombre() + " están cerradas.";
    }

    @Override
    public String ponerEnRevision(ESTPaisContext context) {

        context.setEstado(new ESTEstadoNormal());
        return "¡Fronteras REABIERTAS! El país " + context.getAdaptadorPais().getNombre() + " ha vuelto a la normalidad.";
    }

    @Override
    public String exigirVisa(ESTPaisContext context) {
        return "Acción no permitida. Las fronteras del país " + context.getAdaptadorPais().getNombre() + " están cerradas.";
    }

    @Override
    public String cerrarFronteras(ESTPaisContext context) {
        return "El país ya tiene sus fronteras CERRADAS.";
    }

    @Override
    public List<String> getTransicionesPosibles() {

        return List.of("Reabrir Fronteras");
    }
}
