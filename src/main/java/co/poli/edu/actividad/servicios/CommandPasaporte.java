package co.poli.edu.actividad.servicios;

public class CommandPasaporte {

    public void guardar(PasaporteFicticio pasaporte) {
        System.out.println("💾 Pasaporte guardado: " + pasaporte.getTipo());
    }

    public void editar(PasaporteFicticio pasaporte) {
        System.out.println("✏️ Pasaporte editado: " + pasaporte.getTipo());
    }

    public void eliminar(PasaporteFicticio pasaporte) {
        System.out.println("🗑️ Pasaporte eliminado: " + pasaporte.getTipo());
    }

    public void limpiar() {
        System.out.println("🧹 Se ejecutó la limpieza de campos.");
    }
}
