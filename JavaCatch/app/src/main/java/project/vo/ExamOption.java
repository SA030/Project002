package project.vo;

public class Exam extends Con{




    public static final String table = "exam";
    private String id;
    private String question;

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



    public static class ExamOption{
        public static final String table = "exam_option";
        String choiceId;
        String choice;
        String examId;
        String userId;

        ExamOption(){

        }

        public ExamOption(String choice, String examId, String userId){
            this.choiceId = "DEFAULT";
            this.choice = choice;
            this.examId = examId;
            this.userId = userId;
        }

        //getter, setter
        public int getChoiceId() {
            return Integer.parseInt(choiceId);
        }

        public void setChoiceId(int choiceId) {
            this.choiceId = String.valueOf(choiceId);
        }

        public String getChoice() {
            return choice;
        }

        public void setChoice(String choice) {
            this.choice = choice;
        }

        public int getExamId() {
            return Integer.parseInt(examId);
        }

        public void setExamId(int examId) {
            this.examId = String.valueOf(examId);
        }

        public int getUserId() {
            return Integer.parseInt(userId);
        }

        public void setUserId(String userId) {
            this.userId = String.valueOf(userId);
        }
    }
}
