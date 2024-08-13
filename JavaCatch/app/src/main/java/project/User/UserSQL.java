package project.User;

import static project.Util.SQL.insert;
import static project.Util.SQL.select;

public class UserSQL extends User{

    public String insertUser(User user){
        return insert(table, "DEFAULT,"+ user.name +","+ user.pw +","+ user.mbti +",NULL");
    }

    public String selectUser(){
        return select(table);
    }
}
