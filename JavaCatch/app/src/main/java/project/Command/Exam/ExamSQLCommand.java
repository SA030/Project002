package project.Command.Exam;

import project.Command.Command;
import project.Util.SystemPrint;
import project.Util.TableFormat;
import project.Util.prompt;
import project.dao.mysql.ExamSQL;
import project.vo.Exam;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExamCommand extends ExamSQL implements Command {
    static ResultSet rs = null;
    static Statement stmt = null;

    public ExamCommand(Statement st){
        stmt = st;
    }

    public void add() throws SQLException {

        String question = prompt.Input("퀴즈?");
        Exam e = new Exam(question);
        if(stmt.executeUpdate(insertExam(e))!=1){
            SystemPrint.Error("add Exam");
        }

//        select("question", question);
//        rs.next();
//
//        int id = rs.getInt(1);
//        for(int i=0; i<4; i++) {
//            ExamOption eo = new ExamOption(Input("보기?"),
//                    Input("정답 시 문구?"),
//                    Input("오답 시 문구?")
//            );
//            eo. setId(id);
//
//            if (stmt.executeUpdate(insertExamOption(eo)) != 1) {
//                Error("add ExamOption");
//            }
//        }
    }

    public void select() throws SQLException {
        rs = stmt.executeQuery(selectExam());
    }

    public void select(String colum, String data) throws SQLException {
        rs = stmt.executeQuery(selectExam(colum, data));
    }


    public void printList() throws SQLException {
        int[] width = {prompt.MIN, prompt.MAX};
        String[] data = {"ID", "question"};
        String[] userData = new String[data.length];
        select();

        TableFormat.printTableTitle(width, data);
        while(rs.next()){
            userData[0] = String.valueOf(rs.getInt(1));
            userData[1] = rs.getString(2);

            TableFormat.printTableData(width, userData);
        }
        TableFormat.printTableLine(width);
    }

}
