package co.poli.edu.actividad.servicios;

public class CommandEditarPasaporte implements Command {
    private final CommandPasaporte servicio;
    private final PasaporteFicticio pasaporte;

    public CommandEditarPasaporte(CommandPasaporte servicio, PasaporteFicticio pasaporte) {
        this.servicio = servicio;
        this.pasaporte = pasaporte;
    }

    @Override
    public void ejecutar() {
        servicio.editar(pasaporte);
    }
}
