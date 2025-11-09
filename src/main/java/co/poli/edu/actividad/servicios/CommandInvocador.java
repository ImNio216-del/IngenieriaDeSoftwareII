package co.poli.edu.actividad.servicios;


public class CommandInvocador {

    private Command comando;

    public void asignarComando(Command comando) {
        this.comando = comando;
    }

    public void ejecutarComando() {
        if (comando != null) {
            comando.ejecutar();
        }
    }
}
