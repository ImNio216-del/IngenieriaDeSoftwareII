package co.poli.edu.actividad.modelo;

public class Visa {
    private String idVisa;
    private Pais IdPais;

 
    public Visa(String num, Pais pais) {
        this.idVisa = num;
        this.IdPais = pais;
    }

 
    public String getNum() {
        return idVisa;
    }

   
    public Pais getPais() {
        return IdPais;
    }

    @Override
    public String toString() {
        return "Visa Nº " + idVisa +
               " (Una entrada)" +
               " País destino: " + IdPais.getNombre();
    }
}
