package co.poli.edu.actividad.servicios;
import java.util.List;

public interface ESTEstadoPais {

    String solicitarEntrada(ESTPaisContext context);
    String ponerEnRevision(ESTPaisContext context);
    String exigirVisa(ESTPaisContext context);
    String cerrarFronteras(ESTPaisContext context);

    List<String> getTransicionesPosibles();
}
