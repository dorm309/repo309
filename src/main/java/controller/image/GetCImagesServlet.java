package controller.image;

import dao.CImagesDAO;
import dao.CommodityDAO;
import entity.Commodity;
import entity.CommodityImages;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetCImagesServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int cid = Integer.parseInt(request.getParameter("cid"));
        Commodity c = new CommodityDAO().get(cid, request);
        List<CommodityImages> ci = new CImagesDAO().list(c, request);
        request.setAttribute("commodity", c);
        request.setAttribute("CommodityImages", ci);
        //这里写返回参数的jsp
        request.getRequestDispatcher("testGet.jsp").forward(request, response);

    }


}
