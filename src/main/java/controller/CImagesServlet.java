//package controller;
//
//import entity.Commodity;
//import entity.CommodityImages;
//import util.ImageUtil;
//
//import javax.imageio.ImageIO;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class CImagesServlet extends BaseBackServlet {
//    @Override
//    public String add(HttpServletRequest request, HttpServletResponse response) {
//        InputStream is = null;
//        //提交上传文件时的其他参数
//        Map<String, String> params = new HashMap<>();
//
//        //解析上传
//        is = parseUpload(request, params);
//
//        //根据上传的参数生成productImage对象
//        int cid = Integer.parseInt(params.get("cid"));
//
//        Commodity c=commodityDAO.get(cid);
//        CommodityImages ci=new CommodityImages();
//
//        ci.setCommodity(c);
//        cImagesDAO.create(ci);
//
//        //生成文件
//        String fileName = ci.getId() + ".jpg";
//        String imageFolder;
//        imageFolder = request.getSession().getServletContext().getRealPath("image/commodity");
//
//        File f = new File(imageFolder, fileName);
//        f.getParentFile().mkdirs();
//
//        //复制文件
//        try {
//            if (null != is && 0 != is.available()) {
//                try (FileOutputStream fos = new FileOutputStream(f))
//                {
//                    byte[] bytes = new byte[1024 * 1024];
//                    int length = 0;
//                    while (-1 != (length = is.read(bytes))) {
//                        fos.write(bytes, 0, length);
//                    }
//                    fos.flush();
//
//                    //通过如下代码，把文件保存为jpg格式
//                    BufferedImage img = ImageUtil.change2jpg(f);
//                    ImageIO.write(img, "jps", f);
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return "@admin_CImages_list?cid=" + c.getCid();
//
//    }
//
//    @Override
//    public String delete(HttpServletRequest request, HttpServletResponse response) {
//        //删除数据库的记录
//        int id = Integer.parseInt(request.getParameter("id"));
//        CommodityImages ci = cImagesDAO.get(id);
//        cImagesDAO.delete(id);
//
//        //删除文件
//        String imagesFolder = request.getSession().getServletContext().getRealPath("image/commodity");
//        File f = new File(imagesFolder, ci.getId() + ".jpg");
//        f.delete();
//
//        return "@admin_CImages_list?cid=" + ci.getCommodity().getCid();
//    }
//
//
//    @Override
//    public String edit(HttpServletRequest request, HttpServletResponse response) {
//        return null;
//    }
//
//    @Override
//    public String update(HttpServletRequest request, HttpServletResponse response) {
//        return null;
//    }
//
//    @Override
//    public String list(HttpServletRequest request, HttpServletResponse response) {
//        int cid = Integer.parseInt(request.getParameter("cid"));
//        Commodity c = commodityDAO.get(cid);
//
//        List<CommodityImages> commodityImagesList = cImagesDAO.list(c);
//
//        request.setAttribute("c", c);
//        request.setAttribute("commodityImagesList", commodityImagesList);
//
//        return "";
//    }
//}
