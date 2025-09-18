package co.poli.edu.actividad.modelo;

public class Ciudad {

	  private String id;
	    private String nombre;

	    public Ciudad(String codigo, String nombre) {
	        this.id = codigo;
	        this.nombre = nombre;
	    }

	    public String getCodigo() {
	        return id;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    @Override
	    public String toString() {
	        return nombre + " [" + id + "]";
	
	
    

}
	    }


