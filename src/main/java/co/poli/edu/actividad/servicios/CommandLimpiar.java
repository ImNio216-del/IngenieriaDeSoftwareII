package co.poli.edu.actividad.servicios;

public class CommandLimpiar implements Command {

    private final CommandPasaporte servicio;

    public CommandLimpiar(CommandPasaporte servicio) {
        this.servicio = servicio;
    }

    @Override
    public void ejecutar() {
        servicio.limpiar(); // ya no necesita ningún argumento
    }
}
