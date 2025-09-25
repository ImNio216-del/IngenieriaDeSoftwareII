package co.poli.edu.actividad.repositorio;

import co.poli.edu.actividad.modelo.*;
import co.poli.edu.actividad.servicios.SingletonBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO implements CRUD<Pasaporte> {

    // ------------------ INSERTAR ------------------
    @Override
    public Boolean insertar(Pasaporte pasaporte) {
        String sqlPasaporte = "INSERT INTO Pasaporte (idPasaporte, idTitular, idPais, fechaExpedicion) VALUES (?,?,?,?)";
        String sqlOrdinario = "INSERT INTO pasaporte_ordinario (idPasaporte, motivoUso) VALUES (?,?)";
        String sqlDiplomatico = "INSERT INTO pasaporte_diplomatico (idPasaporte, motivoDiplomatico) VALUES (?,?)";

        try (Connection conn = SingletonBD.getConnection()) {
            conn.setAutoCommit(false);

            // Insertar en tabla base
            try (PreparedStatement st = conn.prepareStatement(sqlPasaporte)) {
                st.setString(1, pasaporte.getId());
       
                st.setString(2, pasaporte.getTitular() != null ? pasaporte.getTitular().getId() : null);
                st.setString(3, pasaporte.getPais() != null ? pasaporte.getPais().getId() : null);
                st.setString(4, pasaporte.getFechaExpedicion());
                st.executeUpdate();
            }

            // Insertar según subtipo
            if (pasaporte instanceof PasaporteOrdinario) {
                PasaporteOrdinario po = (PasaporteOrdinario) pasaporte;
                try (PreparedStatement st = conn.prepareStatement(sqlOrdinario)) {
                    st.setString(1, po.getId());
                    st.setString(2, po.getMotivoUso());
                    st.executeUpdate();
                }
            } else if (pasaporte instanceof PasaporteDiplomatico) {
                PasaporteDiplomatico pd = (PasaporteDiplomatico) pasaporte;
                try (PreparedStatement st = conn.prepareStatement(sqlDiplomatico)) {
                    st.setString(1, pd.getId());
                    st.setString(2, pd.getMotivoDiplomatico());
                    st.executeUpdate();
                }
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ------------------ ACTUALIZAR ------------------
    @Override
    public String actualizar(String id, Pasaporte pasaporte) {
        String sqlPasaporte = "UPDATE Pasaporte SET idTitular=?, idPais=?, fechaExpedicion=? WHERE idPasaporte=?";
        String sqlOrdinario = "UPDATE pasaporte_ordinario SET motivoUso=? WHERE idPasaporte=?";
        String sqlDiplomatico = "UPDATE pasaporte_diplomatico SET motivoDiplomatico=? WHERE idPasaporte=?";

        try (Connection conn = SingletonBD.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement st = conn.prepareStatement(sqlPasaporte)) {
                st.setString(1, pasaporte.getTitular() != null ? pasaporte.getTitular().getId() : null);
                st.setString(2, pasaporte.getPais() != null ? pasaporte.getPais().getId() : null);
                st.setString(3, pasaporte.getFechaExpedicion());
                st.setString(4, id);
                st.executeUpdate();
            }

            // Actualizar subtipo (si existe, actualiza; si no existe, no hace insert acá)
            if (pasaporte instanceof PasaporteOrdinario) {
                PasaporteOrdinario po = (PasaporteOrdinario) pasaporte;
                try (PreparedStatement st = conn.prepareStatement(sqlOrdinario)) {
                    st.setString(1, po.getMotivoUso());
                    st.setString(2, id);
                    st.executeUpdate();
                }
            } else if (pasaporte instanceof PasaporteDiplomatico) {
                PasaporteDiplomatico pd = (PasaporteDiplomatico) pasaporte;
                try (PreparedStatement st = conn.prepareStatement(sqlDiplomatico)) {
                    st.setString(1, pd.getMotivoDiplomatico());
                    st.setString(2, id);
                    st.executeUpdate();
                }
            }

            conn.commit();
            return "✅ Pasaporte actualizado";

        } catch (SQLException e) {
            e.printStackTrace();
            return "❌ Error actualizando: " + e.getMessage();
        }
    }

    // ------------------ ELIMINAR ------------------
    @Override
    public String eliminar(String id) {
        String sqlOrdinario = "DELETE FROM pasaporte_ordinario WHERE idPasaporte=?";
        String sqlDiplomatico = "DELETE FROM pasaporte_diplomatico WHERE idPasaporte=?";
        String sqlPasaporte = "DELETE FROM Pasaporte WHERE idPasaporte=?";

        try (Connection conn = SingletonBD.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement st = conn.prepareStatement(sqlOrdinario)) {
                st.setString(1, id);
                st.executeUpdate();
            }
            try (PreparedStatement st = conn.prepareStatement(sqlDiplomatico)) {
                st.setString(1, id);
                st.executeUpdate();
            }
            try (PreparedStatement st = conn.prepareStatement(sqlPasaporte)) {
                st.setString(1, id);
                st.executeUpdate();
            }

            conn.commit();
            return "✅ Pasaporte eliminado";

        } catch (SQLException e) {
            e.printStackTrace();
            return "❌ Error eliminando: " + e.getMessage();
        }
    }

    // ------------------ BUSCAR UNO ------------------
    @Override
    public Pasaporte Search(String id) {
        String sqlPasaporte = "SELECT idPasaporte, idTitular, idPais, fechaExpedicion FROM Pasaporte WHERE idPasaporte=?";
        String sqlOrdinario = "SELECT motivoUso FROM pasaporte_ordinario WHERE idPasaporte=?";
        String sqlDiplomatico = "SELECT motivoDiplomatico FROM pasaporte_diplomatico WHERE idPasaporte=?";

        try (Connection conn = SingletonBD.getConnection()) {
            // 1) leer datos base
            String idPasaporte = null;
            String idTitular = null;
            String idPais = null;
            String fechaExpedicion = null;

            try (PreparedStatement st = conn.prepareStatement(sqlPasaporte)) {
                st.setString(1, id);
                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        idPasaporte = rs.getString("idPasaporte");
                        idTitular = rs.getString("idTitular");
                        idPais = rs.getString("idPais");
                        fechaExpedicion = rs.getString("fechaExpedicion");
                    }
                }
            }

            if (idPasaporte == null) return null; // no existe

          
            try (PreparedStatement st = conn.prepareStatement(sqlOrdinario)) {
                st.setString(1, idPasaporte);
                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        PasaporteOrdinario po = new PasaporteOrdinario();
                        po.setId(idPasaporte);
                        po.setFechaExpedicion(fechaExpedicion);
                     
                        po.setTitular(new Titular(idTitular != null ? idTitular : "", "", ""));
                        po.setPais(new Pais(idPais != null ? idPais : "", "", new ArrayList<>()));
                        po.setMotivoUso(rs.getString("motivoUso"));
                        return po;
                    }
                }
            }

       
            try (PreparedStatement st = conn.prepareStatement(sqlDiplomatico)) {
                st.setString(1, idPasaporte);
                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        PasaporteDiplomatico pd = new PasaporteDiplomatico();
                        pd.setId(idPasaporte);
                        pd.setFechaExpedicion(fechaExpedicion);
                        pd.setTitular(new Titular(idTitular != null ? idTitular : "", "", ""));
                        pd.setPais(new Pais(idPais != null ? idPais : "", "", new ArrayList<>()));
                        pd.setMotivoDiplomatico(rs.getString("motivoDiplomatico"));
                        return pd;
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ------------------ BUSCAR TODOS ------------------
    @Override
    public List<Pasaporte> SearchAll() {
        List<Pasaporte> lista = new ArrayList<>();
        String sql = "SELECT idPasaporte FROM Pasaporte";

        try (Connection conn = SingletonBD.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString("idPasaporte");
                Pasaporte p = Search(id);
                if (p != null) lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // ------------------ MÉTODOS AUX (tipo) ------------------
    public boolean esDiplomatico(String id) {
        String sql = "SELECT 1 FROM pasaporte_diplomatico WHERE idPasaporte=?";
        try (Connection conn = SingletonBD.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, id);
            try (ResultSet rs = st.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean esOrdinario(String id) {
        String sql = "SELECT 1 FROM pasaporte_ordinario WHERE idPasaporte=?";
        try (Connection conn = SingletonBD.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, id);
            try (ResultSet rs = st.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
