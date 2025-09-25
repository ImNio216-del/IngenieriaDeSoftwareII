package co.poli.edu.actividad.repositorio;

public interface CRUD<T> {
    Boolean insertar(T entidad);
    
    
    String actualizar(String id, T entidad);
    
    
    String eliminar(String id);
    
    
    T Search(String id);
    java.util.List<T> SearchAll();  
    
}
