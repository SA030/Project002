package project.Command.Exam;

import project.Command.Command.Util.SQL;

public class ExamSQL extends Exam {
    public String insertExam(Exam exam){
        return SQL.insert(table, "DEFAULT",exam.question);
    }

    public String selectExam(){
        return SQL.select(table);
    }

    public String selectExam(String column, String data){
        return SQL.select(table)+" where "+column+"=\""+data+"\"";
    }
}
