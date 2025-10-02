package co.poli.edu.actividad.servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonBD {
    private static final String URL = "jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:5432/postgres?sslmode=require";
    private static final String USER = "postgres.lrptirloinlkwxjhewlo";
    private static final String PASSWORD = "JNYingieneriasoftware2025.";


    private static Connection connection;


    private SingletonBD() {}


    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
}
