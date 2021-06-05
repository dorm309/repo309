package dao;

import entity.User;
import util.DBUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDAO implements DBOperation<User> {
    DBUtil util = new DBUtil();

    @Override
    public boolean create(User user, HttpServletRequest request) {
        String sql = "insert into user values(null,?,?)";
        boolean result = false;
        try (PreparedStatement ps = util.createStatement(sql, request)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                int id = rs.getInt(1);
                user.setUid(id);
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
    public List<User> retrieve(HttpServletRequest request) {
        String sql = "SELECT * FROM user";
        List<User> list = new ArrayList<>();
        try {
            PreparedStatement ps = util.createStatement(sql, request);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                User user = new User();
                user.setUid(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));

                list.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(request);
        }

        return list;
    }

    @Override
    public boolean update(User user, HttpServletRequest request) {
        String sql = "update user set username = ?, password=? where uid = ?";
        boolean result = false;
        try (PreparedStatement ps = util.createStatement(sql, request)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getUid());

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
        String sql = "delete from user where uid = " + id;
        boolean result = false;
        try (PreparedStatement ps = util.createStatement(sql, request)) {

            ps.execute(sql);
            result = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(request);
        }

        return result;
    }

    //根据用户id获取对象
    @Override
    public User get(int id, HttpServletRequest request) {
        String sql = "select * from user where uid = ?";
        User user = null;
        try (PreparedStatement ps = util.createStatement(sql, request)) {

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

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(request);
        }

        return user;
    }

    //根据用户名获取对象
    @Override
    public User get(String name, HttpServletRequest request) {
        String sql = "select * from user where username = ?";
        User user = null;
        try (PreparedStatement ps = util.createStatement(sql, request)) {

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

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(request);
        }

        return user;
    }
}

