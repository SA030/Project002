package project.User;

import static project.Util.SQL.insert;
import static project.Util.SQL.select;

public class UserSQL extends User{

    public String insertUser(){
        return insert(table, "DEFAULT,"+ name +","+ pw +","+ mbti +",NULL");
    }

    public String selectUser(){
        return select(table);
    }
}
