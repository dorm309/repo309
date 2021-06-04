package controller;

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
        request.setCharacterEncoding("utf-8");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        //获取ajax传递参数
        String commodity_name = request.getParameter("name");
        System.out.println(commodity_name);

        //比对数据库信息,删除商品
        DBOperation<Commodity> commodityDB = new CommodityDAO();
        Commodity commodity_dao = commodityDB.get(commodity_name);

        User user = (User) request.getSession().getAttribute("loginUser");

        if (commodity_dao.getUid() == user.getUid()) {
            commodityDB.delete(commodity_dao.getCid());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
