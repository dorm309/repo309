package dao;

import entity.Category;
import util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements DBOperation<Category>{
    @Override
    public boolean create(Category category) {
        String sql = "insert into category values(null,?)";
        try (Connection c = DBUtil.getCon(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, category.getName());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                category.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    @Override
    public List<Category> retrieve() {
        String sql = "SELECT * FROM category";
        List<Category> list = new ArrayList<Category>();
        try {
            PreparedStatement ps = DBUtil.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));

                list.add(category);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean update(Category category) {
        String sql = "update category set name=? where id=?";
        try (Connection c = DBUtil.getCon(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, category.getName());
            ps.setInt(2, category.getId());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    @Override
    public boolean delete(int id) {
        try (Connection c = DBUtil.getCon(); Statement s = c.createStatement()) {

            String sql = "delete from Category where id = " + id;

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    public Category get(int id) {
        Category category = null;

        try (Connection c = DBUtil.getCon(); Statement s = c.createStatement()) {

            String sql = "select * from Category where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                category = new Category();
                String name = rs.getString(2);
                category.setName(name);
                category.setId(id);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return category;
    }

    @Override
    public Category get(String name) {
        return null;
    }

}
