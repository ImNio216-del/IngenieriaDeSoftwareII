package co.edu.poli.model;

import java.time.LocalDate;

public class Titular {

    private String nombre;
    private int idPasajero;
    private Pais pais;
    private String ciudad;
    private boolean tieneVisa;
    private LocalDate fechaNacimiento;

    // Constructor completo
    public Titular(String nombre, int idPasajero, Pais pais, String ciudad, boolean tieneVisa, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.idPasajero = idPasajero;
        this.pais = pais;
        this.ciudad = ciudad;
        this.tieneVisa = tieneVisa;
        this.fechaNacimiento = fechaNacimiento;
    }

    // ✅ Constructor simplificado (sin Pais, útil para DAO)
    public Titular(String nombre, int idPasajero, String ciudad, boolean tieneVisa, LocalDate fechaNacimiento) {
        this(nombre, idPasajero, null, ciudad, tieneVisa, fechaNacimiento);
    }

    public Titular() {}

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getIdPasajero() { return idPasajero; }
    public void setIdPasajero(int idPasajero) { this.idPasajero = idPasajero; }

    public Pais getPais() { return pais; }
    public void setPais(Pais pais) { this.pais = pais; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public boolean isTieneVisa() { return tieneVisa; }
    public void setTieneVisa(boolean tieneVisa) { this.tieneVisa = tieneVisa; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    @Override
    public String toString() {
        return "Titular [nombre=" + nombre + ", idPasajero=" + idPasajero + ", pais=" + pais +
               ", ciudad=" + ciudad + ", tieneVisa=" + tieneVisa + ", fechaNacimiento=" + fechaNacimiento + "]";
    }
}
