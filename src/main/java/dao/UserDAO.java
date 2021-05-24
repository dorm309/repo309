package dao;
import entity.User;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDAO implements DBOperation<User> {

    @Override
    public boolean create(User user){
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
    public List retrieve() {
        return null;
    }

    @Override
    public boolean update(User user) {
        return false;
    }


    @Override
    public boolean delete(int id) {
        return false;
    }
}
