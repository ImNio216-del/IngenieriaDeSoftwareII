package co.edu.poli.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Datos de conexión a Supabase (usando Pooler IPv4)
    String url = "jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:5432/postgres";
    String user = "postgres.lrptirloinlkwxjhewlo";
    String password = "JNYingieneriasoftware2025.";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("conectao");
        } catch (SQLException e) {
            System.out.println("desconectao " + e.getMessage());
        }
        return conn;
    }
    
}
