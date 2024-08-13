package project.Command.Exam;

public class Exam {
    public static final String table = "exam";
    String id;
    String question;


    public Exam(){

    }

    public Exam(String question){
        this.id = "DEFAULT";
        this.question = "'"+question+"'";
    }


    //getter, setter
    public int getId() {
        return Integer.parseInt(id);
    }

    public void setId(int id) {
        this.id = String.valueOf(id);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
