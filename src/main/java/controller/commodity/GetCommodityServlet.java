package controller.commodity;

import dao.CommodityDAO;
import entity.Commodity;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class GetCommodityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ajax传递参数
        int cid = Integer.parseInt(request.getParameter("cid"));

        //设置session
        HttpSession session = request.getSession();
        Commodity commodity = new CommodityDAO().get(cid, request);
        session.setAttribute("commodity", commodity);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
