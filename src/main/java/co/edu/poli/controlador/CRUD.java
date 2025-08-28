package co.edu.poli.controlador;

public interface CRUD<T> {

    void create(T entidad);

  
    T read(int id);

 
    void update(T entidad);


    void delete(int id);
}
