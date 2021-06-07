package controller;

import dao.CImagesDAO;
import dao.CategoryDAO;
import dao.CommodityDAO;
import dao.UserDAO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class BaseBackServlet extends HttpServlet {

    public abstract String add(HttpServletRequest request, HttpServletResponse response);

    public abstract String delete(HttpServletRequest request, HttpServletResponse response);

    public abstract String edit(HttpServletRequest request, HttpServletResponse response);

    public abstract String update(HttpServletRequest request, HttpServletResponse response);

    public abstract String list(HttpServletRequest request, HttpServletResponse response);

    protected CategoryDAO categoryDAO = new CategoryDAO();
    protected CommodityDAO commodityDAO = new CommodityDAO();
    protected CImagesDAO cImagesDAO = new CImagesDAO();
    protected UserDAO userDAO = new UserDAO();

    //解析上传
    public InputStream parseUpload(HttpServletRequest request, Map<String, String> params) {
        InputStream is = null;
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 设置上传文件的大小限制为10M
            factory.setSizeThreshold(1024 * 10240);

            List items = upload.parseRequest(request);
            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (!item.isFormField()) {
                    System.out.println("上传文件：进入获取输入流。！item.isFormField为true");
                    // item.getInputStream() 获取上传文件的输入流
                    is = item.getInputStream();
                } else {
                    System.out.println("上传文件：未进入获取输入流。！item.isFormField为false");

                    String paramName = item.getFieldName();
                    String paramValue = item.getString();
                    System.out.println(paramName + ":" + paramValue);
                    paramValue = new String(paramValue.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                    params.put(paramName, paramValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return is;
    }


}