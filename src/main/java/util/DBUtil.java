package util;

import java.sql.*;

public class DBUtil {
    private static Connection con;

    public DBUtil() {
        /*
        Connect to MySQL server
         */
        String ip = "127.0.0.1";
        int port = 3306;
        String database = "mess";
        String encoding = "UTF-8";
        String loginName = "root";
        String password = "admin";

        String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=true&characterEncoding=%s", ip, port, database, loginName, password, encoding);

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
