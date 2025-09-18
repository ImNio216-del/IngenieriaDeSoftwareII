package co.poli.edu.actividad.modelo;

public class PasaporteDiplomatico extends Pasaporte implements Cloneable{

	private String mision;

    public PasaporteDiplomatico(){}
    public String getMision(){
        return mision;
    }

    public void setMision(String mision){
        this.mision=mision;
    }

    @Override
    public String toString(){
        return super.toString()+" -> D "+mision;
    }

    // Prototype 
    @Override
    public PasaporteDiplomatico clone(){
        return(PasaporteDiplomatico)super.clone();
    }

    // Builder
    public static class Builder{
        private String id;
        private Titular titular;
        private Pais pais;
        private String fechaExpedicion;
        private String mision;

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

        public Builder setMision(String mision){
            this.mision=mision;
            return this;
        }

        public PasaporteDiplomatico build(){
            PasaporteDiplomatico pd=new PasaporteDiplomatico();
            pd.setId(this.id);
            pd.setTitular(this.titular);
            pd.setPais(this.pais);
            pd.setFechaExpedicion(this.fechaExpedicion);
            pd.setMision(this.mision);
            return pd;
        }
    }
}