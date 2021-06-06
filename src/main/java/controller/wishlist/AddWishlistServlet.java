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
import java.io.PrintWriter;

/**
 * 处理商品加入愿望单逻辑
 */
public class AddWishlistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ajax传递参数
        int cid = Integer.parseInt(request.getParameter("cid"));

        //添加收藏商品
        DBOperation<Commodity> commodityDB = new CommodityDAO();
        User user = (User) request.getSession().getAttribute("loginUser");
        Commodity commodity_dao = commodityDB.get(cid, request);

        Wishlist wishlist = new Wishlist(user.getUid(), commodity_dao.getUid(), cid);

        boolean flag = new WishlistDAO().isExist(wishlist, request);
        PrintWriter out = response.getWriter();
        if (!flag)
            new WishlistDAO().create(wishlist, request);

        //回传参数给ajax
        out.print(flag);

        out.close();
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
