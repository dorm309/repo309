package dao;

import entity.Commodity;
import util.DBUtil;
import util.DateUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CommodityDAO implements DBOperation<Commodity> {
    DBUtil util = new DBUtil();

    @Override
    public boolean create(Commodity commodity, HttpServletRequest request) {
        String sql = "insert into commodity values(null,?,?,?,?,?,?,?)";
        boolean result = false;
        try (PreparedStatement ps = util.createStatement(sql, request)) {

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
            result = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(request);
        }

        return result;
    }

    @Override
    public List<Commodity> retrieve(HttpServletRequest request) {
        String sql = "SELECT * FROM commodity";
        List<Commodity> list = new ArrayList<>();
        try {

            PreparedStatement ps = util.createStatement(sql, request);
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
                commodity.setCategory(new CategoryDAO().get(rs.getInt("category"), request));

                list.add(commodity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(request);
        }

        return list;
    }

    @Override
    public boolean update(Commodity commodity, HttpServletRequest request) {
        String sql = "update commodity set uid=?,name=?,contact=?,date=?,price=?,description=?,category=? where cid=?";
        boolean result = false;
        try (PreparedStatement ps = util.createStatement(sql, request)) {

            ps.setInt(1, commodity.getUid());
            ps.setString(2, commodity.getName());
            ps.setString(3, commodity.getContact());
            ps.setTimestamp(4, DateUtil.d2t(commodity.getCreateDate()));
            ps.setFloat(5, commodity.getPrice());
            ps.setString(6, commodity.getDescription());
            ps.setInt(7, commodity.getCategory().getId());
            ps.setInt(8, commodity.getCid());
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
        String sql = "delete from commodity where cid = " + id;
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

    public Commodity get(int id, HttpServletRequest request) {
        Commodity commodity = null;
        String sql = "select * from commodity where cid = ?";
        try (PreparedStatement ps = util.createStatement(sql, request)) {

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
                commodity.setCategory(new CategoryDAO().get(id, request));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(request);
        }

        return commodity;
    }

    @Override
    public Commodity get(String name, HttpServletRequest request) {
        return null;
    }
}
