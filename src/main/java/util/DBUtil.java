package util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

public class DBUtil {
    /*
    Definitions：数据库连接 预处理语句 IP地址 端口 数据库名称 编码 用户名 密码
     */
    private Connection con = null;
    private PreparedStatement ps = null;
    private String ip = "127.0.0.1";
    private int port = 3306;
    private String database = "mess";
    private String encoding = "UTF-8";
    private String loginName = "root";
    private String password = "admin";

    public DBUtil() {
        //测试数据库驱动连接
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //封装连接通道创建细节
    public Connection getCon() {
        String url = String.format(
                "jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=true&characterEncoding=%s",
                ip, port, database, loginName, password, encoding
        );

        try {
            con = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    //封装连接通道创建细节 - 重载
    public Connection getCon(HttpServletRequest request) {
        ServletContext application = request.getServletContext();
        Map map = (Map) application.getAttribute("con");
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            con = (Connection) it.next();
            boolean flag = (boolean) map.get(con);
            if (flag) {
                map.put("con", false);
                break;
            }
        }

        return con;
    }

    //封装预处理语句创建细节
    public PreparedStatement createStatement(String sql, HttpServletRequest request) {
        try {
            ps = getCon(request).prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }

    //关闭连接
    public void close(HttpServletRequest request) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        ServletContext application = request.getServletContext();
        Map map = (Map) application.getAttribute("con");
        map.put(con, true);
    }

    //    /*
//    后台系统管理员登录（保留）
//         */
//    public  boolean adminLogin(String username, char[] password) {
//        String sql = "SELECT username FROM Administrator WHERE username = ? AND password = ?";
//
//        String myPassword = "";
//        for (int i = 0; i < password.length; i++) {
//            myPassword += password[i];
//        }
//
//        boolean flag = false;
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, username);
//            ps.setString(2, myPassword);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                flag = true;
//            }
//            rs.close();
//            ps.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return flag;
//    }
}
