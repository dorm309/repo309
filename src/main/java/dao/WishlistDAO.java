package dao;

import entity.Wishlist;
import util.DBUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理愿望单数据库操作逻辑
 */
public class WishlistDAO {
    DBUtil util = new DBUtil();

    public boolean create(Wishlist wishlist, HttpServletRequest request) {
        String sql = "insert into wishlist values(?, ?, ?)";
        boolean result = false;
        try (PreparedStatement ps = util.createStatement(sql, request)) {

            ps.setInt(1, wishlist.getId());
            ps.setInt(2, wishlist.getProducts().getUid());
            ps.setInt(3, wishlist.getProducts().getCid());
            ps.execute();

            result = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(request);
        }

        return result;
    }

    public List<Wishlist> retrieve(HttpServletRequest request) {
        String sql = "SELECT * FROM wishlist";
        List<Wishlist> list = new ArrayList<>();
        try {
            PreparedStatement ps = util.createStatement(sql, request);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Wishlist wishlist = new Wishlist();
                wishlist.setId((rs.getInt("id")));
                wishlist.setProducts(new CommodityDAO().get(rs.getInt("cid"), request));

                list.add(wishlist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(request);
        }

        return list;
    }

    public boolean delete(Wishlist wishlist, HttpServletRequest request) {
        String sql = "delete from wishlist where id = " + wishlist.getId()
                + " and uid = " + wishlist.getProducts().getUid() + " and cid = "
                + wishlist.getProducts().getCid();
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

    public boolean isExist(Wishlist wishlist, HttpServletRequest request) {
        String sql = "select * from wishlist where id = " + wishlist.getId() +
                " and uid = " + wishlist.getProducts().getUid()
                + " and cid = " + wishlist.getProducts().getCid();
        boolean result = false;
        try (PreparedStatement ps = util.createStatement(sql, request)) {

            ResultSet rs = ps.executeQuery();
            if (rs.next())
                result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(request);
        }

        return result;
    }
}
