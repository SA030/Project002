package project.User;

import java.sql.*;
import static project.Util.prompt.*;
import static project.Util.SystemPrint.*;

public class UserCommand extends UserSQL{
    static ResultSet rs = null;
    static Statement stmt = null;

    public UserCommand(Statement st){
        stmt = st;
    }



    public void addUser() throws SQLException {
        User u = new User(Input("이름?"), Input("비밀번호?"), Input("MBTI?"));
        if(stmt.executeUpdate(insertUser())!=1){
            Error("add User");
        };
    }

    public void select() throws SQLException {
        rs = stmt.executeQuery(selectUser());
        printUser();
    }


    public void printUser() throws SQLException {
        System.out.printf("%-2s. %-10s %-10s %-10s\n","ID", "user_name", "user_PW", "user_MBTI");

        while(rs.next()){
            setId(rs.getInt(1));
            setName(rs.getString(2));
            setPw(rs.getString(3));
            setMbti(rs.getString(4));

            System.out.printf("%-2d. %-10s %-10s %-10s\n", getId(), getName(), getPw(), getMbti());
        }
    }

}
