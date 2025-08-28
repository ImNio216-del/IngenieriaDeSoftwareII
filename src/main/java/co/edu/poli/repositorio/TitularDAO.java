package co.edu.poli.repositorio;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import co.edu.poli.model.Titular;

public class TitularDAO implements CRUD<Titular> {

    private final Connection conn;

    public TitularDAO() {
        this.conn = DatabaseConnection.getInstance().getConnection();
    }

    // Enum seguro para columnas permitidas en search
    public enum TitularColumn {
        NOMBRE("nombre"),
        CIUDAD("ciudad"),
        FECHA_NAC("fechaNacimiento");

        private final String col;
        TitularColumn(String col) { this.col = col; }
        public String getCol() { return col; }
    }

    @Override
    public void create(Titular titular) {
        String sql = "INSERT INTO titular (idPasajero, nombre, pais, ciudad, tieneVisa, fechaNacimiento) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, titular.getIdPasajero());
            stmt.setString(2, titular.getNombre());
            stmt.setString(3, titular.getPais() != null ? titular.getPais().toString() : null);
            stmt.setString(4, titular.getCiudad());
            stmt.setBoolean(5, titular.isTieneVisa());
            stmt.setDate(6, titular.getFechaNacimiento() != null ? Date.valueOf(titular.getFechaNacimiento()) : null);
            stmt.executeUpdate();
            System.out.println("✅ Titular insertado correctamente");
        } catch (SQLException e) {
            System.out.println("❌ Error insertando titular: " + e.getMessage());
        }
    }

    @Override
    public Titular read(int id) {
        String sql = "SELECT * FROM titular WHERE idPasajero = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Titular(
                    rs.getString("nombre"),
                    rs.getInt("idPasajero"),
                    rs.getString("ciudad"),
                    rs.getBoolean("tieneVisa"),
                    rs.getDate("fechaNacimiento") != null ? rs.getDate("fechaNacimiento").toLocalDate() : null
                );
            }
        } catch (SQLException e) {
            System.out.println("❌ Error leyendo titular: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void update(Titular titular) {
        String sql = "UPDATE titular SET nombre = ?, pais = ?, ciudad = ?, tieneVisa = ?, fechaNacimiento = ? WHERE idPasajero = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, titular.getNombre());
            stmt.setString(2, titular.getPais() != null ? titular.getPais().toString() : null);
            stmt.setString(3, titular.getCiudad());
            stmt.setBoolean(4, titular.isTieneVisa());
            stmt.setDate(5, titular.getFechaNacimiento() != null ? Date.valueOf(titular.getFechaNacimiento()) : null);
            stmt.setInt(6, titular.getIdPasajero());
            stmt.executeUpdate();
            System.out.println("✅ Titular actualizado correctamente");
        } catch (SQLException e) {
            System.out.println("❌ Error actualizando titular: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM titular WHERE idPasajero = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Titular eliminado correctamente");
        } catch (SQLException e) {
            System.out.println("❌ Error eliminando titular: " + e.getMessage());
        }
    }

    @Override
    public List<Titular> search(String column, String criterio) {
        List<Titular> resultados = new ArrayList<>();
        // Validar columna segura con enum
        TitularColumn colEnum;
        try {
            colEnum = TitularColumn.valueOf(column.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Columna inválida para búsqueda");
            return resultados;
        }

        String sql = "SELECT * FROM titular WHERE " + colEnum.getCol() + " LIKE ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + criterio + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Titular t = new Titular(
                    rs.getString("nombre"),
                    rs.getInt("idPasajero"),
                    rs.getString("ciudad"),
                    rs.getBoolean("tieneVisa"),
                    rs.getDate("fechaNacimiento") != null ? rs.getDate("fechaNacimiento").toLocalDate() : null
                );
                resultados.add(t);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error en búsqueda de titular: " + e.getMessage());
        }
        return resultados;
    }

    // ✅ Método extra para traer todos los titulares
    public List<Titular> findAll() {
        List<Titular> resultados = new ArrayList<>();
        String sql = "SELECT * FROM titular";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Titular t = new Titular(
                    rs.getString("nombre"),
                    rs.getInt("idPasajero"),
                    rs.getString("ciudad"),
                    rs.getBoolean("tieneVisa"),
                    rs.getDate("fechaNacimiento") != null ? rs.getDate("fechaNacimiento").toLocalDate() : null
                );
                resultados.add(t);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error obteniendo todos los titulares: " + e.getMessage());
        }
        return resultados;
    }
}
