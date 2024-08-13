package project.Command.User;

import project.Command.Command;
import project.Util.SystemPrint;
import project.Util.TableFormat;
import project.Util.prompt;
import project.dao.mysql.UserSQL;
import project.vo.User;

import java.sql.*;

public class UserCommand extends UserSQL implements Command {
    static ResultSet rs = null;
    static Statement stmt = null;

    public UserCommand(Statement st){
        stmt = st;
    }

    public void add() throws SQLException {
        User u = new User(prompt.Input("이름?"), prompt.Input("비밀번호?"), prompt.Input("MBTI?"));
        if(stmt.executeUpdate(insertUser(u))!=1){
            SystemPrint.Error("add User");
        }
    }

    public void select() throws SQLException {
        rs = stmt.executeQuery(selectUser());
    }


    public void printList() throws SQLException {
        int[] width = {prompt.MIN, prompt.MIDDLE, prompt.MIDDLE, prompt.MIDDLE};
        String[] data = {"ID", "user_name", "user_PW", "user_MBTI"};
        String[] userData = new String[data.length];
        select();

        TableFormat.printTableTitle(width, data);
        while(rs.next()){
            userData[0] = String.valueOf(rs.getInt(1));
            userData[1] = rs.getString(2);
            userData[2] = rs.getString(3);
            userData[3] = rs.getString(4);

            TableFormat.printTableData(width, userData);
        }
        TableFormat.printTableLine(width);
    }

}
