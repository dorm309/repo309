package dao;

import entity.Category;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CategoryDAO implements DBOperation{
    @Override
    public boolean create(Object o) {
        return false;
    }

    @Override
    public List retrieve() {
        return null;
    }

    @Override
    public boolean update(Object o) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    public Category get(int id) {
        Category bean = null;

        try (Connection c = DBUtil.getCon(); Statement s = c.createStatement()) {

            String sql = "select * from Category where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                bean = new Category();
                String name = rs.getString(2);
                bean.setName(name);
                bean.setId(id);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }
}
