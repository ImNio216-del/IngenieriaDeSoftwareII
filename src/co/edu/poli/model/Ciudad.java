package co.edu.poli.model;

public class Ciudad  {

    public Ciudad() {
    }

    private int IdCiudad;
    private String Nombre;
    
    //CONSTRUCTOR
    public Ciudad(int idCiudad, String nombre) {
		super();
		IdCiudad = idCiudad;
		Nombre = nombre;
	}
    
    
    //GETTERS AND SETTERS
	public int getIdCiudad() {
		return IdCiudad;
	}
	
	public void setIdCiudad(int idCiudad) {
		IdCiudad = idCiudad;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

    
	
	//TO STRING
	@Override
	public String toString() {
		return "Ciudad [IdCiudad=" + IdCiudad + ", Nombre=" + Nombre + "]";
	}
	
	
    

}