package co.poli.edu.actividad.modelo;
public abstract class Pasaporte {
    protected String id;
    protected Titular idTitular;
    protected String fechaExpedicion;
    protected Pais idPais;
    protected String motivoPasaporte;
    public String toString(){
        return "["+id+","+idTitular+","+idPais+","+fechaExpedicion+","+motivoPasaporte+"]";
    }
    public Titular getTitular(){
        return idTitular;
    }
    public String getId() { return id; }
    public String getfechaExpedicion() { return fechaExpedicion; }
    public String getmotivoPasaporte() { return motivoPasaporte; }

    public Pais getPais() { return idPais; }
    public void setId(String id){this.id=id;}
    public void setTitular(Titular idTitular){this.idTitular=idTitular;}
    public void setFechaExpedicion(String fechaExpedicion) { this.fechaExpedicion = fechaExpedicion;}
    public void setPais(Pais pais){this.idPais=idPais; }
    public void setmotivoPasaporte(String motivoPasaporte){this.motivoPasaporte=motivoPasaporte;}
}

