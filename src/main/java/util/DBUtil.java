package util;

import java.sql.*;

public class DBUtil {
    private static Connection con;

    public DBUtil() {
        /*
        Connect to MySQL server
         */
        String uri =
                "jdbc:mysql://localhost:3306/mess?user=root&password=123456&useSSL=true&characterEncoding=utf-8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(uri);
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
