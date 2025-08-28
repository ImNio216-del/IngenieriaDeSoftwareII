package co.edu.poli.model;

public class Visa {

    public Visa() {
    }

    private int idVisa;
    private Pais pais;
    private String tipoVisa;
    private String fechaVencimiento;
    private Pasaporte pasaporte;
    
    
    //CONSTRUCTOR
	public Visa(int idVisa, Pais pais, String tipoVisa, String fechaVencimiento, Pasaporte pasaporte) {
		super();
		this.idVisa = idVisa;
		this.pais = pais;
		this.tipoVisa = tipoVisa;
		this.fechaVencimiento = fechaVencimiento;
		this.pasaporte = pasaporte;
	}

	
	//GETTERS AND SETTERS
	

	public int getIdVisa() {
		return idVisa;
	}
	public void setIdVisa(int idVisa) {
		this.idVisa = idVisa;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public String getTipoVisa() {
		return tipoVisa;
	}
	public void setTipoVisa(String tipoVisa) {
		this.tipoVisa = tipoVisa;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Pasaporte getPasaporte() {
		return pasaporte;
	}
	public void setPasaporte(Pasaporte pasaporte) {
		this.pasaporte = pasaporte;
	}

	
	//TO STRING

	@Override
	public String toString() {
		return "Visa [idVisa=" + idVisa + ", pais=" + pais + ", tipoVisa=" + tipoVisa + ", fechaVencimiento="
				+ fechaVencimiento + ", pasaporte=" + pasaporte + "]";
	}

}