package co.edu.poli.repositorio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import co.edu.poli.model.Pasaporte;

public class PasaporteDAO implements CRUD<Pasaporte> {

    private final Connection conn;

    public PasaporteDAO() {
        this.conn = DatabaseConnection.getInstance().getConnection();
    }

    // Enum seguro para columnas permitidas en search
    public enum PasaporteColumn {
        NUMERO("numeroPasaporte"),
        FECHA_EMISION("fechaEmision"),
        FECHA_EXPIRACION("fechaExpiracion");

        private final String col;
        PasaporteColumn(String col) { this.col = col; }
        public String getCol() { return col; }
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
                    rs.getString("fechaExpiracion")
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

    @Override
    public List<Pasaporte> search(String column, String criterio) {
        List<Pasaporte> resultados = new ArrayList<>();
        // Validar columna segura con enum
        PasaporteColumn colEnum;
        try {
            colEnum = PasaporteColumn.valueOf(column.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Columna inválida para búsqueda");
            return resultados;
        }

        String sql = "SELECT * FROM pasaporte WHERE " + colEnum.getCol() + " LIKE ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + criterio + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pasaporte p = new Pasaporte(
                    rs.getInt("idPasaporte"),
                    rs.getString("numeroPasaporte"),
                    rs.getString("fechaEmision"),
                    rs.getString("fechaExpiracion")
                );
                resultados.add(p);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error en búsqueda de pasaporte: " + e.getMessage());
        }
        return resultados;
    }

    // ✅ Método para traer todos los pasaportes
    public List<Pasaporte> findAll() {
        List<Pasaporte> resultados = new ArrayList<>();
        String sql = "SELECT * FROM pasaporte";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pasaporte p = new Pasaporte(
                    rs.getInt("idPasaporte"),
                    rs.getString("numeroPasaporte"),
                    rs.getString("fechaEmision"),
                    rs.getString("fechaExpiracion")
                );
                resultados.add(p);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error obteniendo todos los pasaportes: " + e.getMessage());
        }
        return resultados;
    }
}
