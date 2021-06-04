package dao;

import entity.Commodity;
import util.DBUtil;
import util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CommodityDAO implements DBOperation<Commodity> {

    @Override
    public boolean create(Commodity commodity) {
        String sql = "insert into commodity values(null,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = new DBUtil().getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, commodity.getUid());
            ps.setString(2, commodity.getName());
            ps.setString(3, commodity.getContact());
            ps.setTimestamp(4, DateUtil.d2t(commodity.getCreateDate()));
            ps.setFloat(5, commodity.getPrice());
            ps.setString(6, commodity.getDescription());
            ps.setInt(7, commodity.getCategory().getId());
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
        List<Commodity> list = new ArrayList<>();

        try {
            PreparedStatement ps = new DBUtil().getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Commodity commodity = new Commodity();
                commodity.setCid(rs.getInt("cid"));
                commodity.setUid(rs.getInt("uid"));
                commodity.setName(rs.getString("name"));
                commodity.setContact(rs.getString("contact"));
                commodity.setCreateDate(DateUtil.t2d(rs.getTimestamp("date")));
                commodity.setPrice(rs.getFloat("price"));
                commodity.setDescription(rs.getString("description"));
                commodity.setCategory(new CategoryDAO().get(rs.getInt("category")));

                list.add(commodity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

    @Override
    public boolean update(Commodity commodity) {
        String sql = "update commodity set uid=?,name=?,contact=?,date=?,price=?,description=?,category=? where cid=?";

        try (PreparedStatement ps = new DBUtil().getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, commodity.getUid());
            ps.setString(2, commodity.getName());
            ps.setString(3, commodity.getContact());
            ps.setTimestamp(4, DateUtil.d2t(commodity.getCreateDate()));
            ps.setFloat(5, commodity.getPrice());
            ps.setString(6, commodity.getDescription());
            ps.setInt(7, commodity.getCategory().getId());
            ps.setInt(8, commodity.getCid());
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

        try (Connection c = new DBUtil().getCon(); Statement s = c.createStatement()) {
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
        try (PreparedStatement ps = new DBUtil().getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                commodity = new Commodity();
                commodity.setCid(rs.getInt("cid"));
                commodity.setUid(rs.getInt("uid"));
                commodity.setName(rs.getString("name"));
                commodity.setCreateDate(DateUtil.t2d(rs.getTimestamp("date")));
                commodity.setPrice(rs.getFloat("price"));
                commodity.setDescription(rs.getString("description"));
                commodity.setCategory(new CategoryDAO().get(id));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commodity;
    }

    @Override
    public Commodity get(String name) {
        Commodity commodity = null;

        String sql = "select * from commodity where name = ?";
        try (PreparedStatement ps = new DBUtil().getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                commodity = new Commodity();
                commodity.setCid(rs.getInt("cid"));
                commodity.setUid(rs.getInt("uid"));
                commodity.setName(rs.getString("name"));
                commodity.setCreateDate(DateUtil.t2d(rs.getTimestamp("date")));
                commodity.setPrice(rs.getFloat("price"));
                commodity.setDescription(rs.getString("description"));
                commodity.setCategory(new CategoryDAO().get(commodity.getCid()));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commodity;
    }
}
