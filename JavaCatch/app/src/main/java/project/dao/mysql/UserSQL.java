package project.Command.User;

import project.Command.Command.Util.SQL;

public class UserSQL extends User{

    public String insertUser(User user){
        return SQL.insert(table, "DEFAULT",user.name,user.pw,user.mbti,"NULL");
    }

    public String selectUser(){
        return SQL.select(table);
    }
}
