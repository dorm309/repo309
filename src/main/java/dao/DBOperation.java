package dao;

import util.DBUtil;

import java.util.List;

public interface DBOperation<T> {
    /*
     * CRUD Operations
     */
    DBUtil database = new DBUtil();

    boolean create(T t);

    List<T> retrieve();

    boolean update(T t);

    boolean delete(int id);

    T get(int id);

    T get(String name);
}
