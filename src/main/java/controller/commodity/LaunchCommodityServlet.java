package controller.commodity;

import dao.CategoryDAO;
import dao.CommodityDAO;
import dao.DBOperation;
import entity.Category;
import entity.Commodity;
import entity.User;
import util.DateUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
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
        Date launchTime = DateUtil.d2t(new Date());
        String description = request.getParameter("desc");
        Category category = new CategoryDAO().get(Integer.parseInt(request.getParameter("category")), request);

        //保存商品信息到数据库
        User user = (User) request.getSession().getAttribute("loginUser");
        Commodity commodity = new Commodity(
                user.getUid(), commodity_name, contact, launchTime, commodity_price, description, category
        );
        DBOperation<Commodity> commodityDB = new CommodityDAO();
        commodityDB.create(commodity, request);

        //转发请求处理图片 -- 在这里转发请求给AddImageServlet处理图片
//        request.getRequestDispatcher("/AddCImagesServlet").forward(request, response);

        PrintWriter out = response.getWriter();
        out.write("<script>alert('商品发布成功！'); window.location='index.jsp' </script>");

        out.flush();
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
