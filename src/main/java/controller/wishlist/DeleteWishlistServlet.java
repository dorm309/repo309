package controller.wishlist;

import dao.CommodityDAO;
import dao.DBOperation;
import dao.WishlistDAO;
import entity.Commodity;
import entity.User;
import entity.Wishlist;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 处理商品从愿望单删除逻辑
 */
public class DeleteWishlistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ajax传递参数
        int cid = Integer.parseInt(request.getParameter("cid"));

        //取消收藏商品
        DBOperation<Commodity> commodityDB = new CommodityDAO();
        User user = (User) request.getSession().getAttribute("loginUser");
        Commodity commodity_dao = commodityDB.get(cid, request);
        new WishlistDAO().delete(new Wishlist(user.getUid(), commodity_dao.getUid(), cid), request);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
