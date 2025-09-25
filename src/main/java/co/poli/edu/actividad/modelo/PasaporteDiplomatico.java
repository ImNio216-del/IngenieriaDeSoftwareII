package co.poli.edu.actividad.modelo;

import co.poli.edu.actividad.modelo.Pasaporte;

public class PasaporteDiplomatico extends Pasaporte {
    private String MotivoDiplomatico;

    public PasaporteDiplomatico(){}

    	public String getMotivoDiplomatico() { return MotivoDiplomatico; }
    	public void setMotivoDiplomatico(String mision) { this.MotivoDiplomatico = mision; }
    	public String toString(){
    	
    	
    	
    		return super.toString() + "motivo diplomatico: " + MotivoDiplomatico;
    }
}
