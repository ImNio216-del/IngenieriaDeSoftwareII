package co.poli.edu.actividad.servicios;
import co.poli.edu.actividad.servicios.PasaporteFicticio;

public class StrategyIdioma implements StrategyValidar{

    @Override
    public boolean validar(PasaporteFicticio p){
        String idioma=p.getIdioma();

        if(idioma==null || idioma.trim().isEmpty()){
            return false; 
        }
        if(idioma.equalsIgnoreCase("Inglés")){
            return false;
        }
        return true;
    }
}