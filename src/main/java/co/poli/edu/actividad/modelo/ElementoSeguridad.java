package co.poli.edu.actividad.modelo;

public class ElementoSeguridad implements Cloneable{
    private String hol;
    private String sAgua;
    private String tEspecial;
    private String chipElec;

    private ElementoSeguridad(Builder builder){
        this.hol=builder.hol;
        this.sAgua=builder.sAgua;
        this.tEspecial=builder.tEspecial;
        this.chipElec=builder.chipElec;
    }

    @Override
    public String toString(){
        return "ElementoSeguridad {holograma='"+hol+"', selloAgua='"+sAgua+"', tintaEspecial='"+tEspecial+"', chipElectronico='"+chipElec+"'}";
    }

    // Prototype
    @Override
    public ElementoSeguridad clone(){
        try{
            return(ElementoSeguridad)super.clone();
        }catch(CloneNotSupportedException e){
            throw new RuntimeException("Error al clonar ElementoSeguridad",e);
        }
    }

    // Builder
    public static class Builder{
        private String hol;
        private String sAgua;
        private String tEspecial;
        private String chipElec;

        public Builder setHol(String hol){
            this.hol=hol;
            return this;
        }

        public Builder setSAgua(String sAgua){
            this.sAgua=sAgua;
            return this;
        }

        public Builder setTEspecial(String tEspecial){
            this.tEspecial=tEspecial;
            return this;
        }

        public Builder setChipElec(String chipElec){
            this.chipElec=chipElec;
            return this;
        }

        public ElementoSeguridad build(){
            return new ElementoSeguridad(this);
        }
    }
}
