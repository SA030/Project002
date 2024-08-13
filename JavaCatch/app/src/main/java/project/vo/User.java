package project.Command.User;

public class User {
    public static final String table = "user";
    String id;
    String name;
    String pw;
    String mbti;
    int score;

    public User(){

    }

    public User(String name, String pw, String mbti){
        this.id = "DEFAULT";
        this.name = "'"+name+"'";
        this.pw = "'"+pw+"'";
        this.mbti = "'"+mbti+"'";
        int score = 0;
    }



    //getter, setter
    public int getId() {
        return Integer.parseInt(id);
    }

    public void setId(int id) {
        this.id = String.valueOf(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getMbti() {
        return mbti;
    }

    public void setMbti(String mbti) {
        this.mbti = mbti;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTable() {
        return table;
    }

}
