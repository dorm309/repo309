package controller;

import dao.CommodityDAO;
import dao.DBOperation;
import entity.Commodity;
import entity.User;
import util.DateUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;

/**
 * 处理发布商品逻辑
 */
public class LaunchCommodityServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取用户输入信息
        String commodity_name = request.getParameter("title");
        float commodity_price = Float.parseFloat(request.getParameter("price"));
        String contact = request.getParameter("contact");
        String description = request.getParameter("desc");

        //处理发布时间
        Date launchTime = DateUtil.d2t(new Date());

        //处理上传图片

        //处理商品种类(保留)

        //保存商品信息到数据库
        User user = (User) request.getSession().getAttribute("loginUser");
        Commodity commodity = new Commodity(
                user.getUid(), commodity_name, contact, launchTime, commodity_price, description, null
        );
        DBOperation<Commodity> commodityDB = new CommodityDAO();
        commodityDB.create(commodity);

        //保存图片至：webapp/images/commodity

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
