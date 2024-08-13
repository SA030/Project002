package project.User;

import java.sql.*;

import static project.Util.TableFormat.*;
import static project.Util.prompt.*;

public class UserCommand extends UserSQL{
    static ResultSet rs = null;
    static Statement stmt = null;

    public UserCommand(Statement st){
        stmt = st;
    }



    public void add() throws SQLException {
        User u = new User(Input("이름?"), Input("비밀번호?"), Input("MBTI?"));
        if(stmt.executeUpdate(insertUser(u))!=1){
            Error("add User");
        }
    }

    public void select() throws SQLException {
        rs = stmt.executeQuery(selectUser());
        printUserList();
    }


    public void printUserList() throws SQLException {
        int[] width = {2, 10, 10, 10};
        String[] data = {"ID", "user_name", "user_PW", "user_MBTI"};
        String[] userData = new String[data.length];


        printTableTitle(width, data);

        while(rs.next()){
            userData[0] = String.valueOf(rs.getInt(1));
            userData[1] = rs.getString(2);
            userData[2] = rs.getString(3);
            userData[3] = rs.getString(4);

            printTableData(width, userData);
        }
        printTableLine(width);
    }

}
