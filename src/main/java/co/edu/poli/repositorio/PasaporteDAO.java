package co.edu.poli.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.poli.controlador.CRUD;
import co.edu.poli.model.Pasaporte;

public class PasaporteDAO implements CRUD<Pasaporte> {

    // Conexión única del Singleton
    private final Connection conn;

    public PasaporteDAO() {
        this.conn = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public void create(Pasaporte pasaporte) {
        String sql = "INSERT INTO pasaporte (idPasaporte, numeroPasaporte, fechaEmision, fechaExpiracion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pasaporte.getIdPasaporte());
            stmt.setString(2, pasaporte.getNumeroPasaporte());
            stmt.setString(3, pasaporte.getFechaEmision());
            stmt.setString(4, pasaporte.getFechaExpiracion());
            stmt.executeUpdate();
            System.out.println("✅ Pasaporte insertado correctamente");
        } catch (SQLException e) {
            System.out.println("❌ Error insertando pasaporte: " + e.getMessage());
        }
    }

    @Override
    public Pasaporte read(int id) {
        String sql = "SELECT * FROM pasaporte WHERE idPasaporte = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Pasaporte(
                    rs.getInt("idPasaporte"),
                    rs.getString("numeroPasaporte"),
                    rs.getString("fechaEmision"),
                    rs.getString("fechaExpiracion"),
                    null,
                    null
                );
            }
        } catch (SQLException e) {
            System.out.println("❌ Error leyendo pasaporte: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void update(Pasaporte pasaporte) {
        String sql = "UPDATE pasaporte SET numeroPasaporte = ?, fechaEmision = ?, fechaExpiracion = ? WHERE idPasaporte = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pasaporte.getNumeroPasaporte());
            stmt.setString(2, pasaporte.getFechaEmision());
            stmt.setString(3, pasaporte.getFechaExpiracion());
            stmt.setInt(4, pasaporte.getIdPasaporte());
            stmt.executeUpdate();
            System.out.println("✅ Pasaporte actualizado correctamente");
        } catch (SQLException e) {
            System.out.println("❌ Error actualizando pasaporte: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM pasaporte WHERE idPasaporte = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Pasaporte eliminado correctamente");
        } catch (SQLException e) {
            System.out.println("❌ Error eliminando pasaporte: " + e.getMessage());
        }
    }
}
