package project.dao.mysql;

import project.Util.prompt;

public class SQL extends prompt {

    public static String insert(String table, String...sql){
        return "INSERT INTO " + table + " values("+setSql(sql)+")";
    }

    public static String select(String table){
        return "SELECT * FROM " + table;
    }

    public static String innerJoin(String table, String innerTable, String pk, String fk){
        return select(table)+" INNER JOIN " + innerTable + " ON " +setJoinSql(table, innerTable, pk, fk);
    }


    private static String setSql(String[] sql){
        StringBuilder str = new StringBuilder();

        for(String s : sql){
            str.append(s).append(",");
        }
        str.deleteCharAt(str.length() -1);

        return str.toString();
    }

    private static String setJoinSql(String table, String innerTable, String pk, String fk){
        return table + "." + pk + "=" + innerTable + "." + fk;
    }

}
