package util;

import java.sql.*;

public class DBUtil {
    /*
    Definitions：数据库连接 IP地址 端口 数据库名称 编码 用户名 密码
     */
    private static Connection con;
    private String ip = "127.0.0.1";
    private int port = 3306;
    private String database = "mess";
    private String encoding = "UTF-8";
    private String loginName = "root";
    private String password = "admin";

    /*
    Connect to MySQL server
         */
    public DBUtil() {
        String url = String.format(
                "jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=true&characterEncoding=%s",
                ip, port, database, loginName, password, encoding
        );

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url);
            System.out.println("数据库连接成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Administrator login
         */
    public static boolean adminLogin(String username, char[] password) {
        String sql = "SELECT username FROM Administrator WHERE username = ? AND password = ?";

        String myPassword = "";
        for (int i = 0; i < password.length; i++) {
            myPassword += password[i];
        }

        boolean flag = false;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, myPassword);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                flag = true;
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /*
    Getter
     */
    public static Connection getCon() {
        return con;
    }
}
