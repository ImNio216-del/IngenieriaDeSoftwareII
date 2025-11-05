package co.poli.edu.actividad.modelo;

public class PasaporteDiplomatico extends Pasaporte {
    private String motivoDiplomatico;

    public PasaporteDiplomatico() {}

    public String getMotivoDiplomatico() { 
        return motivoDiplomatico; 
    }

    public void setMotivoDiplomatico(String mision) { 
        this.motivoDiplomatico = mision; 
    }

    @Override
    public void imprimirDetalles() {
        System.out.println("Pasaporte Diplomático: " + toString());
        System.out.println("Motivo diplomático: " + motivoDiplomatico);
        // mostrar elementos de seguridad también
        getElementosSeguridad().forEach(e -> System.out.println(e.validar()));
    }

    @Override
    public String toString(){
        return super.toString() + " | motivoDiplomatico=" + motivoDiplomatico;
    }
}
