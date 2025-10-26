package co.poli.edu.actividad.servicios;

public class ProxyAdaptadorPasaporte implements ProxyPasaporte {
    private ProxyRealPasaporte realPasaporte = new ProxyRealPasaporte();

    @Override
    public void visualizarInformacion(String rol) {
        if (rol.equalsIgnoreCase("Administrador")) {
            System.out.println("Acceso completo autorizado para Administrador.");
            realPasaporte.visualizarInformacion(rol);
        } else if (rol.equalsIgnoreCase("Funcionario")) {
            System.out.println("Acceso parcial autorizado para Funcionario.");
            System.out.println("Nombre: Juan Pérez");
            System.out.println("Nacionalidad: Colombiana");
        } else if (rol.equalsIgnoreCase("Visitante")) {
            System.out.println("Acceso denegado para Visitante.");
        } else {
            System.out.println("Rol no reconocido.");
        }
    }
}
