package controller.image;

import dao.CImagesDAO;
import entity.CommodityImages;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 处理删除图片逻辑
 */
public class DeleteCImagesServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        CommodityImages ci = new CImagesDAO().get(id, request);
        new CImagesDAO().delete(id, request);

        String imageFolder = request.getSession().getServletContext().getRealPath("image/commodity");
        File f = new File(imageFolder, ci.getId() + ".jpg");
        f.delete();

        //测试代码
        try {
            PrintWriter pw = response.getWriter();
            pw.println("<h1>删除了</h1>");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
