package co.poli.edu.actividad.modelo;

public class Biometrico extends ElementoDeSeguridad {
    private String tipo; // huella, iris, rostro

    public Biometrico(String id, String descripcion, String nivelSeguridad, String tipo) {
        super(id, descripcion, nivelSeguridad);
        this.tipo = tipo;
    }

    @Override
    public String validar() {
        return "Biométrico tipo " + tipo + " validado correctamente.";
    }

    @Override
    public String toString() {
        return super.toString() + " Biometrico [tipo=" + tipo + "]";
    }
}
