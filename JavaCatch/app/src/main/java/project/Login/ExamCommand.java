package project.Login;

import project.Command.CommandCollection;
import project.Command.User.ScoreSQLCommand;
import project.vo.Exam;
import project.vo.ExamOption;

import java.sql.SQLException;
import java.sql.Statement;

import static project.Util.prompt.*;
import static project.dao.SQL.*;

public class Attack extends ScoreSQLCommand {
    int attackerId, defenderId;
    int score;
    int examTotalCnt;
//    HashMap<Integer, String> answer= new HashMap<>();


    public Attack(CommandCollection col) throws SQLException {
        super(col.getCon());
        this.col = col;
        this.con = col.getCon();
        setExamCnt();
    }


    public void run(int userId) throws SQLException {
        attackerId = userId;
        defenderId = col.getUser().getId("user_name", Input("상대방 이름?"));
        runExam();
        setScore();

        System.out.print("score: "+score+"\n");
    }


    private void setScore() throws SQLException {
        score = (100/examTotalCnt)*score;

        add(String.valueOf(attackerId), String.valueOf(defenderId), String.valueOf(score));
    }


    private void runExam() throws SQLException {
        for(int examId =1 ; examId<=examTotalCnt; examId++){
            isCorrectionAnswer(examId, getExamAns(examId));
        }
    }

    private String getExamAns(int examId) throws SQLException{
        try(Statement stmt = con.create()) {
            rs = stmt.executeQuery(select(Exam.table, "exam_ID", examId));
            rs.next();

            return Input((rs.getString(2)));
        }
    }


    private void isCorrectionAnswer(int examId, String ans) throws SQLException{
        try(Statement stmt = con.create()) {
            rs = stmt.executeQuery(select(ExamOption.table, "user_id", String.valueOf(defenderId))+
                                    "and "+setWhereSql("exam_id", String.valueOf(examId))
                                  );
            rs.next();

            if( (rs.getString(2)).equals(ans) ){
                score++;
            }
        }
    }

    private void setExamCnt() throws SQLException{
        try(Statement stmt = con.create()) {
            rs = stmt.executeQuery("SELECT COUNT(*) FROM "+Exam.table);
            rs.next();
            examTotalCnt =rs.getInt(1);
        }
    }

//    private int getUserId(String defenderUserName) throws SQLException {
//        try(Statement stmt = con.create()) {
//            rs = stmt.executeQuery(select(User.table, "user_name", defenderUserName));
//
//            rs.next();
//            return rs.getInt(1);
//        }
//    }
}
