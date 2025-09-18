package co.poli.edu.actividad.repositorio;

import co.poli.edu.actividad.modelo.*;
import co.poli.edu.actividad.servicios.*;
import co.poli.edu.actividad1.modelo.Pasaporte;
import co.poli.edu.actividad1.repositorio.Metodos;

import java.sql.*;
import java.util.*;

public class DAO implements CRUD<Pasaporte> {
	  String sqlPasaporte = "INSERT INTO pasaporte (idPasaporte,idTitular,idPais,fechaExpedicion,motivoPasaporte) VALUES (?,?, ?, ?, ?)";
   public Boolean insertar (Pasaporte pasaporte) {
	   
	   try (
		Connection conn = SingletonBD.getConnection();
		
	PreparedStatement statement = conn.prepareStatement(sqlPasaporte)) {
		statement.setString (1,pasaporte.getId());
		statement.setString (2,pasaporte.getTitular().getId());
		statement.setString (3,pasaporte.getPais().getId());
		statement.setString (4,pasaporte.getfechaExpedicion());
		statement.setString (4,pasaporte.);
	return true;
	} catch (SQLException e) {
		
		e.printStackTrace();
		return false;
	}
    }   
   
}

