package dao;

import entity.User;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDAO implements DBOperation<User> {

    @Override
    public boolean create(User user) {
        String sql = "insert into user values(null,?,?)";
        try (PreparedStatement ps = new DBUtil().getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                user.setUid(id);
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> retrieve() {
        String sql = "SELECT * FROM user";
        List<User> list = new ArrayList<>();
        try {
            PreparedStatement ps = new DBUtil().getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUid(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));

                list.add(user);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean update(User user) {

        String sql = "update user set username= ?, password=? where uid = ?";

        try (PreparedStatement ps = new DBUtil().getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getUid());

            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delete(int id) {

        try (Statement s = new DBUtil().getCon().createStatement()) {

            String sql = "delete from user where uid = " + id;

            s.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User get(int id) {
        User user = null;

        String sql = "select * from user where uid = ?";
        try (PreparedStatement ps = new DBUtil().getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                String name = rs.getString("name");
                String password = rs.getString("password");
                user.setUsername(name);
                user.setPassword(password);
                user.setUid(id);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    //根据用户名获取对象
    @Override
    public User get(String name) {
        User user = null;

        String sql = "select * from user where username = ?";
        try (PreparedStatement ps = new DBUtil().getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                int id = rs.getInt("uid");
                user.setUsername(name);
                String password = rs.getString("password");
                user.setPassword(password);
                user.setUid(id);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}

