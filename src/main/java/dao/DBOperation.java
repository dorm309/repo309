package dao;

import java.util.List;

public interface DBOperation<T> {
    /*
     * CRUD Operations
     */
    CommodityDAO commodityDAO=new CommodityDAO();
    boolean create(T t);

    List<T> retrieve();

    boolean update(T t);

    boolean delete(int id);
    T get(int id);
    T get(String name);
}
