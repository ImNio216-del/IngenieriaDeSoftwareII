package co.poli.edu.actividad.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pais{
    private String idPais;
    private String nombre;
    private List<Ciudad>ciudades;

    // Constructor
    public Pais(String idPais,String nombre,List<Ciudad>ciudades){
        this.idPais=idPais;
        this.nombre=nombre;
        this.ciudades=(ciudades !=null)?ciudades:new ArrayList<Ciudad>();
    }

    // Constructor vacío
    public Pais(){
        this.idPais="";
        this.nombre="";
        this.ciudades=new ArrayList<Ciudad>();
    }

    public String getId(){
        return idPais;
    }

    public String getNombre(){
        return nombre;
    }

    public List<Ciudad>getCiudades(){
        return ciudades;
    }

    public void setId(String idPais){
        this.idPais=idPais;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setCiudades(List<Ciudad>ciudades){
        this.ciudades=(ciudades !=null)?ciudades:new ArrayList<Ciudad>();
    }

    @Override
    public String toString(){
        return nombre+" ["+idPais+"]";
    }
}
