package dao;

import java.util.List;

public interface DBOperation<T> {
    /*
        CRUD Operations
         */
    //1
    boolean create(T t);
    List<T> retrieve();
    boolean update(T t);
    boolean delete(int id);
}
