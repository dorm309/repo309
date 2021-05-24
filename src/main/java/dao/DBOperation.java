package dao;

import java.util.List;

public interface DBOperation<T> {
    /*
        CRUD Operations
         */
    boolean create(T t);
    List<T> retrieve(int id);
    boolean update(T t);
    boolean delete(int id);
}
