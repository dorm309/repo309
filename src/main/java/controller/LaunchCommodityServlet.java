package controller;

import dao.CommodityDAO;
import dao.DBOperation;
import entity.Commodity;
import entity.CommodityImages;
import util.DateUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 处理发布商品逻辑
 */
@WebServlet("/LaunchCommodityServlet")
public class LaunchCommodityServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取用户输入信息
        String commodity_name = request.getParameter("title");
        float commodity_price = Float.parseFloat(request.getParameter("price"));
        String description = request.getParameter("desc");

        //处理发布时间
        Date launchTime = DateUtil.d2t(new Date());

        //处理上传图片
        List<CommodityImages> commodityImages = new ArrayList<>();
        //..

        //处理商品种类
        //..

        //保存商品信息到数据库
        int uid=0;
        Commodity commodity = new Commodity(uid,commodity_name, launchTime, commodity_price, description, null);
        DBOperation<Commodity> db = new CommodityDAO();
        db.create(commodity);

        //保存图片至：webapp/images/commodity
        //..

        //添加已发布商品至：个人中心-我的发布


        //展示新发布商品信息

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
