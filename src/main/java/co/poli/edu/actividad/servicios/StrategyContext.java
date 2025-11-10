package co.poli.edu.actividad.servicios;
import co.poli.edu.actividad.servicios.PasaporteFicticio;

public class StrategyContext{

    public boolean ejecutarValidacion(StrategyValidar estrategia,PasaporteFicticio pasaporte){
        if (estrategia==null || pasaporte==null) {
            System.out.println("Pasaporte no válidos.");
            return false;
        }
        return estrategia.validar(pasaporte);
    }

    // Ejecucion de las 3 Strategy 
    public String validarTodo(PasaporteFicticio p){
        if (p==null){
            return "No se puede validar: el pasaporte es nulo.";
        }
        StringBuilder resultado=new StringBuilder();

        // Lista de Strategy
        StrategyValidar[]estrategias={
            new StrategyIdioma(),
            new StrategyPais(),
            new StrategySeguridad()
        };
        String[]nombres={
            "Validación de idioma",
            "Validación por país de emisión",
            "Validación de seguridad"
        };
        for(int i=0;i<estrategias.length; i++){
            boolean ok;
            try{
                ok=estrategias[i].validar(p);
            } catch(Exception e){
                ok=false;
            }
            resultado.append(nombres[i])
                     .append(": ")
                     .append(ok ? "✅ Correcta\n" : "❌ Error en los datos\n");
        }
        return resultado.toString();
    }
}