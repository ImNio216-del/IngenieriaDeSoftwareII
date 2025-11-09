package co.poli.edu.actividad.servicios;

public class CommandEliminarPasaporte implements Command {
    private final CommandPasaporte servicio;
    private final PasaporteFicticio pasaporte;

    public CommandEliminarPasaporte(CommandPasaporte servicio, PasaporteFicticio pasaporte) {
        this.servicio = servicio;
        this.pasaporte = pasaporte;
    }

    @Override
    public void ejecutar() {
        servicio.eliminar(pasaporte);
    }
}
