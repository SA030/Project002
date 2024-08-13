package project;

import java.sql.SQLException;

public interface Command {
    void add() throws SQLException;
    void select() throws SQLException;
    void printList() throws SQLException;
}
