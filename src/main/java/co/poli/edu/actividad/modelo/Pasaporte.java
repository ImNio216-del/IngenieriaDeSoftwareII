package co.poli.edu.actividad.modelo;

public abstract class Pasaporte implements Cloneable{

    protected String id;
    protected Titular idTitular;
    protected String fechaExpedicion;
    protected Pais idPais;
    protected String motivoPasaporte;

    // Elemento de Seguridad
    protected ElementoSeguridad elementoSeguridad;

    @Override
    public String toString(){
        return"["+id+","+idTitular+","+idPais+","+fechaExpedicion+","+motivoPasaporte+"]"+(elementoSeguridad !=null?" "+elementoSeguridad.toString():"");
    }

    public Titular getTitular(){return idTitular;}
    public String getId(){return id;}
    public String getFechaExpedicion(){return fechaExpedicion;}
    public String getMotivoPasaporte(){return motivoPasaporte;}
    public Pais getPais(){return idPais;}
    public ElementoSeguridad getElementoSeguridad(){return elementoSeguridad;}

    public void setId(String id){this.id=id;}
    public void setTitular(Titular idTitular){this.idTitular=idTitular;}
    public void setFechaExpedicion(String fechaExpedicion){this.fechaExpedicion=fechaExpedicion;}
    public void setPais(Pais idPais){this.idPais=idPais;}
    public void setMotivoPasaporte(String motivoPasaporte){this.motivoPasaporte=motivoPasaporte;}
    public void setElementoSeguridad(ElementoSeguridad elementoSeguridad){this.elementoSeguridad=elementoSeguridad;}

    // Prototype
    @Override
    public Pasaporte clone(){
        try{
            Pasaporte copia=(Pasaporte)super.clone();
            if (this.elementoSeguridad !=null){
                copia.setElementoSeguridad(this.elementoSeguridad.clone());
            }
            return copia;
        } catch (CloneNotSupportedException e){
            throw new RuntimeException("Error al clonar Pasaporte",e);
        }
    }
}

