package co.edu.poli.vista;

import java.util.Arrays;
import co.edu.poli.model.*;
import co.edu.poli.repositorio.*;

public class Cliente {
    public static void main(String[] args) {
        DatabaseConnection database = new DatabaseConnection();
        database.connect();

        PasaporteDAO dao = new PasaporteDAO();

        // Crear ciudades
        Ciudad bogota = new Ciudad(2, "Bogotá");
        Ciudad medellin = new Ciudad(3, "Medellín");

        // Crear país con lista de ciudades
        Pais colombia = new Pais(2, "Colombia", Arrays.asList(bogota, medellin));

        // Crear titular asociado al país
        Titular titular = new Titular("12345678", 2, colombia, "Juan Pérez", true, "juan@example.com");

        // Crear pasaporte con titular y país
        Pasaporte p1 = new Pasaporte(
            3,"ABC123456", "2025-08-23", "2030-08-23", titular, colombia);

        dao.create(p1);

        Pasaporte p2 = dao.read(2);
        System.out.println("Leído desde BD: " + p2);

        p1.setNumeroPasaporte("XYZ999999");
        dao.update(p1);
    }
}
