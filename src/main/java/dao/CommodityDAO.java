package dao;

import entity.Commodity;
import entity.User;
import util.DBUtil;
import util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CommodityDAO implements DBOperation<Commodity> {


    @Override
    public boolean create(Commodity commodity) {
        String sql = "insert into commodity values(null,?,?,?,?,?)";
        try (PreparedStatement ps = DBUtil.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, commodity.getName());
            ps.setTimestamp(2, DateUtil.d2t(commodity.getCreateDate()));
            ps.setFloat(3, commodity.getPrice());
            ps.setString(4, commodity.getDescription());
            ps.setInt(5, commodity.getCategory().getId());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int Cid = rs.getInt(1);
                commodity.setCid(Cid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Commodity> retrieve() {
        String sql = "SELECT * FROM commodity";
        List<Commodity> list = new ArrayList<Commodity>();
        try {
            PreparedStatement ps = DBUtil.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Commodity commodity = new Commodity();
                commodity.setCid(rs.getInt(1));
                commodity.setName(rs.getString("name"));
                commodity.setCreateDate(DateUtil.t2d(rs.getTimestamp("data")));
                commodity.setPrice(rs.getFloat("price"));
                commodity.setDescription(rs.getString("description"));
                commodity.setCategory(new CategoryDAO().get(rs.getInt("commodity")));
                list.add(commodity);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean update(Commodity commodity) {
        String sql = "update commodity set name=?,date=?,price=?,description=?,category=? where cid=?";

        try (PreparedStatement ps = DBUtil.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, commodity.getName());
            ps.setTimestamp(2, DateUtil.d2t(commodity.getCreateDate()));
            ps.setFloat(3, commodity.getPrice());
            ps.setString(4, commodity.getDescription());
            ps.setInt(5, commodity.getCategory().getId());
            ps.setInt(6,commodity.getCid());
            ps.execute();

        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {

        String sql = "delete from commodity where cid = " + id;

        try (Connection c = DBUtil.getCon(); Statement s = c.createStatement()) {
            s.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Commodity get(int id) {
        Commodity commodity = null;

        String sql = "select * from commodity where cid = ?";
        try (PreparedStatement ps = DBUtil.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                commodity = new Commodity();
                commodity.setCid(rs.getInt("cid"));
                commodity.setName(rs.getString("name"));
                commodity.setCreateDate(DateUtil.t2d(rs.getTimestamp("data")));
                commodity.setPrice(rs.getFloat("price"));
                commodity.setDescription(rs.getString("description"));
                commodity.setCategory(new CategoryDAO().get(id));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commodity;
    }


}
