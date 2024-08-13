package project;

import project.Exam.ExamCommand;
import project.User.UserCommand;
import project.Util.Connect;

import java.sql.Statement;

public class CommandCollection {
    UserCommand uc;
    ExamCommand ec;

    CommandCollection(Statement stmt){
        uc = new UserCommand( stmt );
        ec = new ExamCommand( stmt );
    }

    //getter, setter
    public UserCommand getUc() {
        return uc;
    }

    public ExamCommand getEc() {
        return ec;
    }

}
