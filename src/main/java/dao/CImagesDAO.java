package dao;

import entity.Commodity;
import entity.CommodityImages;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CImagesDAO implements DBOperation<CommodityImages>{


    @Override
    public boolean create(CommodityImages commodityImages) {
        String sql = "insert into images values(null,?)";
        try (Connection c = DBUtil.getCon(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, commodityImages.getCommodity().getCid());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                commodityImages.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<CommodityImages> retrieve() {

        String sql = "SELECT * FROM images";
        List<CommodityImages> list = new ArrayList<CommodityImages>();
        try {

            PreparedStatement ps = DBUtil.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                CommodityImages commodityImages = new CommodityImages();
                commodityImages.setId(rs.getInt("id"));
                Commodity commodity = new CommodityDAO().get(rs.getInt("cid"));
                commodityImages.setCommodity(commodity);

                list.add(commodityImages);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean update(CommodityImages commodityImages) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        try (Connection c = DBUtil.getCon(); Statement s = c.createStatement()) {

            String sql = "delete from images where id = " + id;

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
        return true;

    }
}
