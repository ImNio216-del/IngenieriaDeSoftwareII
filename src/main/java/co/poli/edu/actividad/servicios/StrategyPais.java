package co.poli.edu.actividad.servicios;
import co.poli.edu.actividad.servicios.PasaporteFicticio;


public class StrategyPais implements StrategyValidar{

    @Override
    public boolean validar(PasaporteFicticio p){
        if(p==null)return false;

        String pais = p.getEmisor();
        if(pais==null || pais.isEmpty())return false;
        
        String[]paisesPermitidos={"Colombia", "México", "Argentina", "España"};

        for(String permitido:paisesPermitidos){
            if(pais.equalsIgnoreCase(permitido)){
                return true;
            }
        }
        return false;
    }
}