package co.poli.edu.actividad.modelo;

public class PasaporteOrdinario extends Pasaporte {
    private String motivoUso;

    public PasaporteOrdinario() {}

    public String getMotivoUso() { 
        return motivoUso; 
    }

    public void setMotivoUso(String motivoUso) { 
        this.motivoUso = motivoUso; 
    }

    @Override
    public void imprimirDetalles() {
        System.out.println("Pasaporte Ordinario: " + toString());
        System.out.println("Motivo ordinario: " + motivoUso);
        // mostrar elementos de seguridad también
        getElementosSeguridad().forEach(e -> System.out.println(e.validar()));
    }

    @Override
    public String toString(){
        return super.toString() + " | motivoUso=" + motivoUso;
    }
}
