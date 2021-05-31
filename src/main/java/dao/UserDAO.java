package dao;

import entity.User;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDAO implements DBOperation<User> {

    @Override
    public boolean create(User user) {
        String sql = "insert into user values(null,?,?,?,?,?)";
        try (PreparedStatement ps = DBUtil.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getStu_num());
            ps.setString(4, user.getQq());
            ps.setString(5, user.getPhone());

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
    public List<User> retrieve(int id) {
        String sql = "SELECT * FROM user WHERE uid = ?";
        List<User> list = new ArrayList<User>();
        try {
            PreparedStatement ps = DBUtil.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUid(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setStu_num(rs.getString(4));
                user.setQq(rs.getString(5));
                user.setPhone(rs.getString(6));
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

        String sql = "update user set username= ?, password=?, stu_num=?, qq=?, phone=? where uid = ?";

        try (PreparedStatement ps = DBUtil.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getStu_num());
            ps.setString(4, user.getQq());
            ps.setString(5, user.getPhone());
            ps.setInt(6, user.getUid());

            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delete(int id) {

        try (Statement s = DBUtil.getCon().createStatement()) {

            String sql = "delete from user where uid = " + id;

            s.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //查询用户名是否存在
    public boolean isExist(String name) {
        User user = get(name);
        if (user == null)
            return false;

        return true;
    }

    //根据用户名获取对象
    public User get(String name) {
        User user = null;

        String sql = "select * from user where username = ?";
        try (PreparedStatement ps = DBUtil.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
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
        }
        return user;
    }

    //根据用户名与密码获取对象
    public User get(String name, String password) {
        User user = null;

        String sql = "select * from user where username = ? and password=?";
        try (PreparedStatement ps = DBUtil.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                int id = rs.getInt("uid");
                user.setUsername(name);
                user.setPassword(password);
                user.setUid(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}

