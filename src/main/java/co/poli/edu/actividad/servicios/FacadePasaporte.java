package co.poli.edu.actividad.servicios;

public class FacadePasaporte {

    private FacadeVerificacionId verificacionId;
    private FacadeVerificacionAntecedentes verificacionAntecedentes;
    private FacadeGeneracionPasaporte generacion;

    public FacadePasaporte() {
        verificacionId = new FacadeVerificacionId();
        verificacionAntecedentes = new FacadeVerificacionAntecedentes();
        generacion = new FacadeGeneracionPasaporte();
    }

    public void procesar(String id, String nombre, String pais) {
        System.out.println("\n=== INICIANDO PROCESO FACHADA ===");
        boolean idValido = verificacionId.verificar(id);
        boolean limpio = verificacionAntecedentes.verificarAntecedentes(id);

        if (idValido && limpio) {
            generacion.generar(id, nombre, pais);
        } else {
            System.out.println("[FacadePasaporte] No se puede generar el pasaporte (ID o antecedentes inválidos).");
        }
    }
}
