package co.edu.poli.repositorio;

import java.util.ArrayList;
import java.util.List;

import co.edu.poli.controlador.CRUD;

public abstract class DAO<T> implements CRUD<T> {

    protected List<T> dataSource;

    public DAO() {
        this.dataSource = new ArrayList<>();
    }


}
