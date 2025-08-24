package co.edu.poli.model;

public class Titular {

    public Titular() {
    }

    private String Nombre;
    private int idPasajero;
    private Pais pais;
    private String ciudad;
    private boolean tieneVisa;
    private String fechaNacimiento;
    
    
    //CONSTRUCTOR
	public Titular(String nombre, int idPasajero, Pais pais, String ciudad, boolean tieneVisa, String fechaNacimiento) {
		super();
		Nombre = nombre;
		this.idPasajero = idPasajero;
		this.pais = pais;
		this.ciudad = ciudad;
		this.tieneVisa = tieneVisa;
		this.fechaNacimiento = fechaNacimiento;
	}

	
    //GETTERS AND SETTERS

	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getIdPasajero() {
		return idPasajero;
	}
	public void setIdPasajero(int idPasajero) {
		this.idPasajero = idPasajero;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public boolean isTieneVisa() {
		return tieneVisa;
	}
	public void setTieneVisa(boolean tieneVisa) {
		this.tieneVisa = tieneVisa;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	//TO STRING
	@Override
	public String toString() {
		return "Titular [Nombre=" + Nombre + ", idPasajero=" + idPasajero + ", pais=" + pais + ", ciudad=" + ciudad
				+ ", tieneVisa=" + tieneVisa + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
    
    
	
    

}