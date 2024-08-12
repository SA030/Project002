package project.Util;

public class SQL extends prompt{

    public static String insert(String table, String sql){
        return "INSERT INTO "+table+" values("+sql+")";
    }

    public static String select(String table){
        return "SELECT * FROM "+table;
    }

}
