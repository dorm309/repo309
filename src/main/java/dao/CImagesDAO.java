package dao;

import entity.Commodity;
import entity.CommodityImages;
import util.DBUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CImagesDAO implements DBOperation<CommodityImages> {
    DBUtil util = new DBUtil();

    @Override
    public boolean create(CommodityImages commodityImages, HttpServletRequest request) {
        String sql = "insert into images values(null,?)";
        boolean result = false;
        try (PreparedStatement ps = util.createStatement(sql, request)) {

            ps.setInt(1, commodityImages.getCommodity().getCid());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                commodityImages.setId(id);
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
    public List<CommodityImages> retrieve(HttpServletRequest request) {
        String sql = "SELECT * FROM images";
        List<CommodityImages> list = new ArrayList<>();
        try {

            PreparedStatement ps = util.createStatement(sql, request);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CommodityImages commodityImages = new CommodityImages();
                commodityImages.setId(rs.getInt("id"));
                Commodity commodity = new CommodityDAO().get(rs.getInt("cid"), request);
                commodityImages.setCommodity(commodity);

                list.add(commodityImages);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(request);
        }

        return list;
    }

    @Override
    public boolean update(CommodityImages commodityImages, HttpServletRequest request) {
        return false;
    }

    @Override
    public boolean delete(int id, HttpServletRequest request) {
        boolean result = false;
        try {

            String sql = "delete from images where id = " + id;
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
    public CommodityImages get(int id, HttpServletRequest request) {
        String sql = "select * from images where id = " + id;
        CommodityImages commodityImages = null;
        try (PreparedStatement s = util.createStatement(sql, request)) {

            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                commodityImages = new CommodityImages();
                Commodity commodity = new CommodityDAO().get(rs.getInt("cid"), request);
                commodityImages.setCommodity(commodity);
                commodityImages.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(request);
        }

        return commodityImages;
    }


    @Override
    public CommodityImages get(String name, HttpServletRequest request) {
        return null;
    }

    public List<CommodityImages> list(Commodity commodity, HttpServletRequest request) {
        String sql = "select * from images where cid =?";
        List<CommodityImages> list = new ArrayList<>();

        try (PreparedStatement ps = util.createStatement(sql, request)) {

            ps.setInt(1, commodity.getCid());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CommodityImages commodityImages = new CommodityImages();
                int id = rs.getInt("id");

                commodityImages.setId(id);
                commodityImages.setCommodity(commodity);

                list.add(commodityImages);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(request);
        }

        return list;
    }
}
