package co.poli.edu.actividad.modelo;

import co.poli.edu.actividad.modelo.Pasaporte;

public class PasaporteOrdinario extends Pasaporte {
    private String MotivoUso;
    public PasaporteOrdinario(){}
    
    
    public String getMotivoUso() { return MotivoUso; }
    
    public void setMotivoUso(String MotivoUso) { this.MotivoUso = MotivoUso; }
    
    
    
    public String toString(){
        return super.toString() + "Motivo ordinario " + MotivoUso;
    }
}
