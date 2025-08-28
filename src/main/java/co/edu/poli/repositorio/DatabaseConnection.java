package co.edu.poli.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Instancia única del Singleton
    private static DatabaseConnection instance;
    private Connection connection;

    // Constructor privado
    private DatabaseConnection() {
        try {
            // 🔹 Asegúrate que tu driver esté cargado
        	Class.forName("org.postgresql.Driver");


            // 🔹 Ajusta la URL a tu base de datos
            String url = "jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:5432/postgres?sslmode=require";
            String user = "postgres.lrptirloinlkwxjhewlo";
            String password = "JNYingieneriasoftware2025.";
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Conectado a la base de datos correctamente");

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("❌ Error al conectar a la base de datos.", e);
        }
    }

    // Método público para obtener la instancia única
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // 🔹 Método que te faltaba
    public Connection getConnection() {
        return connection;
    }
}
