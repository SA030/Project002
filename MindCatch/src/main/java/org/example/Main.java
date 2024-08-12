package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        getConnection();
    }




    public static void getConnection() throws Exception {
        ResultSet rs = null;
        Statement stmt = null;
        Connection con = null;
        try {
//            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost/mindcatch";
            String userid = "study";
            String password = "1111";

//            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, password);


            String sql = "INSERT INTO users values(\"이선아\", \"0000\", \"ENFJ\")";

            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getInt("user_ID"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //Close
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        }
    }
}