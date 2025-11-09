package co.poli.edu.actividad.servicios;

public class PasaporteFicticio {

    private final String tipo;
    private final String colorCubierta;
    private final String idioma;
    private final String emisor;

    public PasaporteFicticio(String tipo, String colorCubierta, String idioma, String emisor) {
        this.tipo = tipo;
        this.colorCubierta = colorCubierta;
        this.idioma = idioma;
        this.emisor = emisor;
    }

    
    
    public String getTipo() {
		return tipo;
	}
	public String getColorCubierta() {
		return colorCubierta;
	}
	public String getIdioma() {
		return idioma;
	}
	public String getEmisor() {
		return emisor;
	}



	public void mostrarPasaporteCompleto(int idPasaporte, String numeroPasaporte, String fechaEmision, String fechaExpiracion) {
        System.out.println("--- Pasaporte Detallado ---");
        System.out.println("Tipo: " + this.tipo);
        System.out.println("ID: " + idPasaporte);
        System.out.println("Número: " + numeroPasaporte);
        System.out.println("Fecha de Emisión: " + fechaEmision);
        System.out.println("Fecha de Expiración: " + fechaExpiracion);
        System.out.println("Color de Cubierta: " + this.colorCubierta);
        System.out.println("Idioma: " + this.idioma);
        System.out.println("Emisor: " + this.emisor);
    }
}
