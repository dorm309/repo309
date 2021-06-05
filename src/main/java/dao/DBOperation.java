package dao;

import util.DBUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface DBOperation<T> {
    /*
     * CRUD Operations
     */
    boolean create(T t, HttpServletRequest request);

    List<T> retrieve(HttpServletRequest request);

    boolean update(T t, HttpServletRequest request);

    boolean delete(int id, HttpServletRequest request);

    T get(int id, HttpServletRequest request);

    T get(String name, HttpServletRequest request);
}
