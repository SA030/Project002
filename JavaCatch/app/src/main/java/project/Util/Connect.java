package project.Command.Util;

import java.sql.*;

public class Connect {
    static ResultSet rs = null;
    static Statement stmt = null;
    static java.sql.Connection con = null;


    public void open() throws Exception {

        try {
            String url = "jdbc:mysql://localhost/mindcatch";
            String userid = "study";
            String password = "1111";
            String sql = "";

            con = DriverManager.getConnection(url, userid, password);
            stmt = con.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void close() throws SQLException {
        //Close
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (con != null) con.close();
    }

    public static ResultSet getRs() {
        return rs;
    }

    public static Statement getStmt() {
        return stmt;
    }

    public static Connection getCon() {
        return con;
    }
}
