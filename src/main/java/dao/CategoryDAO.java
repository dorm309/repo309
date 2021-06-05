package dao;

import entity.Category;
import util.DBUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements DBOperation<Category> {
    DBUtil util = new DBUtil();

    @Override
    public boolean create(Category category, HttpServletRequest request) {
        String sql = "insert into category values(null,?)";
        boolean result = false;
        try (PreparedStatement ps = util.createStatement(sql, request)) {

            ps.setString(1, category.getName());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                category.setId(id);
            }
            result = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(request);
        }

        return result;
    }


    @Override
    public List<Category> retrieve(HttpServletRequest request) {
        String sql = "SELECT * FROM category";
        List<Category> list = new ArrayList<>();
        try {

            PreparedStatement ps = util.createStatement(sql, request);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));

                list.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(request);
        }

        return list;
    }

    @Override
    public boolean update(Category category, HttpServletRequest request) {
        String sql = "update category set name=? where id=?";
        boolean result = false;
        try (PreparedStatement ps = util.createStatement(sql, request)) {

            ps.setString(1, category.getName());
            ps.setInt(2, category.getId());

            ps.execute();
            result = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(request);
        }

        return result;
    }


    @Override
    public boolean delete(int id, HttpServletRequest request) {
        String sql = "delete from Category where id = " + id;
        boolean result = false;
        try {

            PreparedStatement ps = util.createStatement(sql, request);
            ps.execute(sql);

            result = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(request);
        }

        return result;
    }

    @Override
    public Category get(int id, HttpServletRequest request) {
        Category category = null;
        String sql = "select * from Category where id = " + id;
        try (PreparedStatement s = util.createStatement(sql, request)) {

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                category = new Category();
                String name = rs.getString(2);
                category.setName(name);
                category.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(request);
        }

        return category;
    }

    @Override
    public Category get(String name, HttpServletRequest request) {
        Category category = null;
        String sql = "select * from Category where name = " + name;
        try (PreparedStatement s = util.createStatement(sql, request)) {

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(request);
        }

        return category;
    }
}
