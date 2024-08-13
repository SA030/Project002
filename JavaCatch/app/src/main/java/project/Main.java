package project;

import project.User.UserCommand;
import project.Util.Connect;

//[Util]                            [User]
//SystemPrint      Connect          User
//|                Kor              |
//prompt           |                UserSQL
//|                TableFormat      |
//SQL                               UserCommand



public class Main {
    static Connect con = new Connect();

    public static void main(String[] args) throws Exception {

        try {
            con.open();

            UserCommand uc = new UserCommand(Connect.getStmt());
            uc.add();
            uc.select();

        }finally {
            con.close();
        }
    }


}