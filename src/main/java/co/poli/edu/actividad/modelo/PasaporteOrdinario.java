package co.poli.edu.actividad.modelo;

public class PasaporteOrdinario extends Pasaporte implements Cloneable{
    private String motivoViaje;

    public PasaporteOrdinario(){}

    public String getMotivoViaje(){
        return motivoViaje;
    }

    public void setMotivoViaje(String motivoViaje){
        this.motivoViaje=motivoViaje;
    }

    @Override
    public String toString(){
        return super.toString()+" -> O "+motivoViaje;
    }

    // Prototype 
    @Override
    public PasaporteOrdinario clone(){
        return(PasaporteOrdinario)super.clone();
    }

    // Builder 
    public static class Builder{
        private String id;
        private Titular titular;
        private Pais pais;
        private String fechaExpedicion;
        private String motivoViaje;

        public Builder setId(String id){
            this.id=id;
            return this;
        }

        public Builder setTitular(Titular titular){
            this.titular=titular;
            return this;
        }

        public Builder setPais(Pais pais){
            this.pais=pais;
            return this;
        }

        public Builder setFechaExpedicion(String fechaExpedicion){
            this.fechaExpedicion=fechaExpedicion;
            return this;
        }

        public Builder setMotivoViaje(String motivoViaje){
            this.motivoViaje=motivoViaje;
            return this;
        }

        public PasaporteOrdinario build(){
            PasaporteOrdinario po=new PasaporteOrdinario();
            po.setId(this.id);
            po.setTitular(this.titular);
            po.setPais(this.pais);
            po.setFechaExpedicion(this.fechaExpedicion);
            po.setMotivoViaje(this.motivoViaje);
            return po;
        }
    }
}