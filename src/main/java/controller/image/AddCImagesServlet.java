package controller.image;

import dao.CImagesDAO;
import dao.CategoryDAO;
import dao.CommodityDAO;
import dao.DBOperation;
import entity.Category;
import entity.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import entity.Commodity;
import entity.CommodityImages;
import util.DateUtil;
import util.ImageUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import static util.ImageUtil.resizeImage;

/**
 * 处理新增图片逻辑
 */
public class AddCImagesServlet extends HttpServlet {
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

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        CommodityDAO commodityDAO = new CommodityDAO();
        CImagesDAO cImagesDAO = new CImagesDAO();

        InputStream is = null;
        //提交上传文件时的其他参数
        Map<String, String> params = new HashMap<>();

        //解析上传
        is = parseUpload(request, params);

        //测试代码，查看参数
        Map<String, String[]> parameters = request.getParameterMap();
        Set<String> paramNames = parameters.keySet();
        for (String param : paramNames) {
            String[] value = parameters.get(param);
            System.out.println(param + ":" + Arrays.asList(value));
        }

        //取用户输入信息
        String commodity_name = params.get("title");
        float commodity_price = Float.parseFloat(params.get("price"));
        String contact = params.get("contact");
        Date launchTime = DateUtil.d2t(new Date());
        String description = params.get("desc");
        Category category = new CategoryDAO().get(Integer.parseInt(params.get("category")), request);

        //保存商品信息到数据库
        User user = (User) request.getSession().getAttribute("loginUser");
        Commodity commodity = new Commodity(
                user.getUid(), commodity_name, contact, launchTime, commodity_price, description, category
        );
        DBOperation<Commodity> commodityDB = new CommodityDAO();
        commodityDB.create(commodity, request);

        int cid = commodityDB.get(commodity.getName(), request).getCid();


        Commodity c = commodityDAO.get(cid, request);
        CommodityImages ci = new CommodityImages();

        ci.setCommodity(c);
        cImagesDAO.create(ci, request);

        //生成文件
        String fileName = ci.getId() + ".jpg";
        String imageFolder;
        imageFolder = request.getSession().getServletContext().getRealPath("image/commodity");

        File f = new File(imageFolder, fileName);
        f.getParentFile().mkdirs();

        //复制文件
        try {
            if (null != is && 0 != is.available()) {
                try (FileOutputStream fos = new FileOutputStream(f)) {
                    byte[] bytes = new byte[1024 * 1024];
                    int length = 0;
                    while (-1 != (length = is.read(bytes))) {
                        fos.write(bytes, 0, length);
                    }
                    fos.flush();

                    //通过如下代码，把文件保存为jpg格式
                    BufferedImage img = ImageUtil.change2jpg(f);
                    ImageIO.write(img, "jps", f);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            PrintWriter out = response.getWriter();
            out.write("<script>alert('商品发布成功！'); window.location='index.jsp' </script>");

            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
