package co.edu.poli.repositorio;

import java.util.List;

public interface CRUD<T> {

    void create(T entidad);

    T read(int id);

    void update(T entidad);

    void delete(int id);

    // Nuevo método genérico de búsqueda
    List<T> search(String column, String criterio);
}
