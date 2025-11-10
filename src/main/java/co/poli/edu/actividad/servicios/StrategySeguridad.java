package co.poli.edu.actividad.servicios;
import co.poli.edu.actividad.servicios.PasaporteFicticio;

public class StrategySeguridad implements StrategyValidar{

    @Override
    public boolean validar(PasaporteFicticio p){
        if(p==null)return false;

        //Verificar campos
        boolean camposLlenos=p.getTipo()!=null && !p.getTipo().trim().isEmpty()
                && p.getColorCubierta()!=null && !p.getColorCubierta().trim().isEmpty()
                && p.getIdioma()!=null && !p.getIdioma().trim().isEmpty()
                && p.getEmisor()!=null && !p.getEmisor().trim().isEmpty();

        if(!camposLlenos)return false;

        //Validar: "Ordinario" o "Diplomático"
        String tipo=p.getTipo().trim();
        String color=p.getColorCubierta().trim();
        
        if(tipo.equalsIgnoreCase("Ordinario") || tipo.equalsIgnoreCase("Diplomático")){
        	
        	if(color.equalsIgnoreCase("Negro"))
        	
            return true;
        }
        return false;
    }

	
}