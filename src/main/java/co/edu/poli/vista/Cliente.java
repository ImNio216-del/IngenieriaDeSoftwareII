package co.edu.poli.vista;

import co.edu.poli.model.Pasaporte;
import co.edu.poli.model.Titular;
import co.edu.poli.model.Pais; // si tienes esta clase
import co.edu.poli.repositorio.PasaporteDAO;
import co.edu.poli.repositorio.TitularDAO;

import java.time.LocalDate;
import java.util.List;

public class Cliente {
    public static void main(String[] args) {

        // DAOs
        PasaporteDAO pasaporteDAO = new PasaporteDAO();
        TitularDAO titularDAO = new TitularDAO();

        // ====== 1️⃣ Crear Titular ======
        Titular t1 = new Titular(
            "Juan Pérez",
            1,
            new Pais("Colombia"), // objeto Pais si lo tienes
            "Bogotá",
            true,
            LocalDate.of(1990, 5, 20)
        );
        titularDAO.create(t1);

        // ====== 2️⃣ Crear Pasaporte ======
        Pasaporte p1 = new Pasaporte(
            1,
            "ABC12345",
            "2025-01-01",
            "2030-01-01",
            t1,      // asignamos el Titular creado
            new Pais("Colombia")
        );
        pasaporteDAO.create(p1);

        // ====== 3️⃣ Leer Pasaporte ======
        Pasaporte pLeido = pasaporteDAO.read(1);
        if (pLeido != null) {
            System.out.println("📌 Pasaporte leído: " + pLeido);
        }

        // ====== 4️⃣ Actualizar Pasaporte ======
        p1.setNumeroPasaporte("XYZ99999");
        pasaporteDAO.update(p1);

        Pasaporte actualizado = pasaporteDAO.read(1);
        System.out.println("✏️ Pasaporte actualizado: " + actualizado.getNumeroPasaporte());

        // ====== 5️⃣ Buscar por criterio ======
        List<Pasaporte> encontrados = pasaporteDAO.search("NUMERO", "XYZ");
        System.out.println("🔎 Pasaportes encontrados con 'XYZ': ");
        for (Pasaporte p : encontrados) {
            System.out.println(p);
        }

        // ====== 6️⃣ Listar todos los titulares ======
        List<Titular> todos = titularDAO.findAll();
        System.out.println("📋 Todos los titulares:");
        for (Titular t : todos) {
            System.out.println(t);
        }

        // ====== 7️⃣ Eliminar pasaporte y titular (opcional) ======
        // pasaporteDAO.delete(1);
        // titularDAO.delete(1);
    }
}
