package controller.commodity;

import dao.CommodityDAO;
import dao.DBOperation;
import entity.Commodity;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteCommodityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ajax传递参数
        int cid = Integer.parseInt(request.getParameter("cid"));

        //比对数据库信息,删除商品
        DBOperation<Commodity> commodityDB = new CommodityDAO();
        Commodity commodity_dao = commodityDB.get(cid, request);
        User user = (User) request.getSession().getAttribute("loginUser");

        if (commodity_dao.getUid() == user.getUid()) {
            commodityDB.delete(commodity_dao.getCid(), request);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
