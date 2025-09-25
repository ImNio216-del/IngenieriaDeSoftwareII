package co.poli.edu.actividad.modelo;

public class ElementoDeSeguridad {
	
	private String id;
	private String descripcion;
	private String nivelSeguridad;
	/**
	 * @param id
	 * @param descripcion
	 * @param nivelSeguridad
	 */
	public ElementoDeSeguridad(String id, String descripcion, String nivelSeguridad) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.nivelSeguridad = nivelSeguridad;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNivelSeguridad() {
		return nivelSeguridad;
	}
	public void setNivelSeguridad(String nivelSeguridad) {
		this.nivelSeguridad = nivelSeguridad;
	}
	
	
	@Override
	public String toString() {
		return "ElementoDeSeguridad [id=" + id + ", descripcion=" + descripcion + ", nivelSeguridad=" + nivelSeguridad
				+ "]";
	}
	
	
	

}
