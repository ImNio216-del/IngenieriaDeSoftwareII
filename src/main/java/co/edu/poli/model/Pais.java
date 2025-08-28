package co.edu.poli.model;

import java.util.ArrayList;
import java.util.List;

public class Pais {

    private int idPais;
    private String nombrePais;
    private List<Ciudad> ciudades;

    // ====== 1️⃣ Constructor completo ======
    public Pais(int idPais, String nombrePais, List<Ciudad> ciudades) {
        this.idPais = idPais;
        this.nombrePais = nombrePais;
        this.ciudades = ciudades;
    }

    // ====== 2️⃣ Constructor simplificado (solo nombre) ======
    public Pais(String nombrePais) {
        this.nombrePais = nombrePais;
        this.ciudades = new ArrayList<>();
    }

    // ====== 3️⃣ Getters y Setters ======
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

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    // ====== 4️⃣ toString ======
    @Override
    public String toString() {
        return "Pais [idPais=" + idPais + ", nombrePais=" + nombrePais + ", ciudades=" + ciudades + "]";
    }
}
