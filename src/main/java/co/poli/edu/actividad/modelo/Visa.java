package co.poli.edu.actividad.modelo;

public class Visa implements Cloneable{
    private String idVisa;
    private Pais idPais;
    private int mulEntry; // cantidad de entradas(1 por defecto)

    public Visa(String idVisa,Pais idPais){
        this(idVisa,idPais, 1);    
        }

    public Visa(String idVisa,Pais idPais,int mulEntry){
        this.idVisa=idVisa;
        this.idPais=idPais;
        this.mulEntry=mulEntry;
    }

    public String getNum(){
        return idVisa;
    }

    public Pais getPais(){
        return idPais;
    }

    public int getMulEntry(){
        return mulEntry;
    }

    @Override
    public String toString(){
        return "Visa Nº "+idVisa+" ("+(mulEntry>1 ? "Múltiple entrada":"Una entrada")+")"+" País destino: "+idPais.getNombre();
    }

    // Prototype
    @Override
    public Visa clone(){
        try{
            return(Visa)super.clone();
        } catch(CloneNotSupportedException e){
            throw new RuntimeException("Error al clonar Visa",e);
        }
    }
}