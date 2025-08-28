package co.edu.poli.model;

import java.util.*;

public class Pais {

    public Pais() {
    }
    private int idPais;
    private String nombrePais;
    private List <Ciudad> Ciudad;


    //CONSTRUCTOR
	public Pais(int idPais, String nombrePais, List<co.edu.poli.model.Ciudad> ciudad) {
		super();
		this.idPais = idPais;
		this.nombrePais = nombrePais;
		Ciudad = ciudad;
	}

	
	//GETTERS AND SETTERS

	public int getIdPais() {
		return idPais;
	}
	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
	public String getNombrePais() {
		return nombrePais;
	}
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}
	public List<Ciudad> getCiudad() {
		return Ciudad;
	}
	public void setCiudad(List<Ciudad> ciudad) {
		Ciudad = ciudad;
	}


	//TO STRING
	@Override
	public String toString() {
		return "Pais [idPais=" + idPais + ", nombrePais=" + nombrePais + ", Ciudad=" + Ciudad + "]";
	}
	
}