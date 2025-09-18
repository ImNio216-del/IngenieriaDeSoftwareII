package co.poli.edu.actividad.repositorio;

import java.util.List;

public interface CRUD<T>{
	Boolean insertar(T entidad);
    String actualizar(String id,T entidad);
    String eliminar(String id);
    T Search(String id);
    List<T> SearchAll();
    List<T> SearchWithChar(String c);  
}