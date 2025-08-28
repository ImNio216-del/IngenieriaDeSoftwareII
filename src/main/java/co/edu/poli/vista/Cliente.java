package co.edu.poli.vista;

import co.edu.poli.model.Pasaporte;
import co.edu.poli.repositorio.PasaporteDAO;

public class Cliente {
    public static void main(String[] args) {
        // Instancia del DAO
        PasaporteDAO dao = new PasaporteDAO();

        // 1️⃣ Crear pasaporte
        Pasaporte p1 = new Pasaporte(
            1, 
            "ABC12345", 
            "2025-01-01", 
            "2030-01-01", 
            null,   // Titular
            null    // País
        );
        dao.create(p1);

        // 2️⃣ Leer pasaporte
        Pasaporte pLeido = dao.read(1);
        if (pLeido != null) {
            System.out.println("📌 Pasaporte leído: ");
            System.out.println("ID: " + pLeido.getIdPasaporte());
            System.out.println("Número: " + pLeido.getNumeroPasaporte());
            System.out.println("Emisión: " + pLeido.getFechaEmision());
            System.out.println("Expiración: " + pLeido.getFechaExpiracion());
        } else {
            System.out.println("❌ No se encontró el pasaporte con ID 1");
        }

        // 3️⃣ Actualizar pasaporte
        p1.setNumeroPasaporte("XYZ99999");
        dao.update(p1);

        // Verificamos que se actualizó
        Pasaporte actualizado = dao.read(1);
        System.out.println("✏️ Pasaporte actualizado: " + actualizado.getNumeroPasaporte());

        /*  4️⃣ Eliminar pasaporte
        dao.delete(1);

        Eliminar
        Pasaporte eliminado = dao.read(1);
        if (eliminado == null) {
            System.out.println("🗑️ Pasaporte eliminado correctamente");
        }*/
    }
}
