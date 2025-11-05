package co.poli.edu.actividad.servicios;

public class ProxyRealPasaporte {

    public void visualizarInformacion(String rol) {
        System.out.println("[ProxyRealPasaporte] Mostrando información confidencial de pasaportes...");
        System.out.println("- Total pasaportes activos: 1250");
        System.out.println("- Último emitido: 25/10/2025");
        System.out.println("- País principal: Colombia");
        System.out.println("[ProxyRealPasaporte] Acceso otorgado al rol: " + rol);
    }
}
