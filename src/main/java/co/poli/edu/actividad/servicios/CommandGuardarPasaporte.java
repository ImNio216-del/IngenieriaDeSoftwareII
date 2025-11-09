package co.poli.edu.actividad.servicios;

public class CommandGuardarPasaporte implements Command {
    private final CommandPasaporte servicio;
    private final PasaporteFicticio pasaporte;

    public CommandGuardarPasaporte(CommandPasaporte servicio, PasaporteFicticio pasaporte) {
        this.servicio = servicio;
        this.pasaporte = pasaporte;
    }

    @Override
    public void ejecutar() {
        servicio.guardar(pasaporte);
    }
}
