package co.edu.poli.model;

public class Pasaporte {

    public Pasaporte() {
    }

    private int idPasaporte;
    private String numeroPasaporte;
    private String fechaEmision;
    private String fechaExpiracion;
    private Titular titular;
    private Pais pais;


    
   //CONSTRUCTOR
	public Pasaporte(int idPasaporte, String numeroPasaporte, String fechaEmision, String fechaExpiracion,
			co.edu.poli.model.Titular titular, Pais pais) {
		super();
		this.idPasaporte = idPasaporte;
		this.numeroPasaporte = numeroPasaporte;
		this.fechaEmision = fechaEmision;
		this.fechaExpiracion = fechaExpiracion;
		this.titular = titular;
		this.pais = pais;
	}


	//GETTERS AND SETTERS
	public int getIdPasaporte() {
		return idPasaporte;
	}
	public void setIdPasaporte(int idPasaporte) {
		this.idPasaporte = idPasaporte;
	}
	public String getNumeroPasaporte() {
		return numeroPasaporte;
	}
	public void setNumeroPasaporte(String numeroPasaporte) {
		this.numeroPasaporte = numeroPasaporte;
	}
	public String getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public String getFechaExpiracion() {
		return fechaExpiracion;
	}
	public void setFechaExpiracion(String fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}
	public Titular getTitular() {
		return titular;
	}
	public void setTitular(Titular titular) {
		this.titular = titular;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}


	//TO STRING
	
	@Override
	public String toString() {
		return "Pasaporte [idPasaporte=" + idPasaporte + ", numeroPasaporte=" + numeroPasaporte + ", fechaEmision="
				+ fechaEmision + ", fechaExpiracion=" + fechaExpiracion + ", Titular=" + titular + ", pais=" + pais
				+ "]";
	}
	






}