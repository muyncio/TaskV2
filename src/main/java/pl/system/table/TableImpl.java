package pl.system.table;

import pl.system.jdbc.utils.JdbcUtils;

import java.sql.SQLException;
import java.sql.Statement;

public class TableImpl {
    public void createTable() throws SQLException{
        Statement statement = JdbcUtils
                .getInstance()
                .getConnection()
                .createStatement();
        statement.executeUpdate(
                "Create Table users(\n" +
                "id integer primary key auto_increment,\n" +
                "name Char(30),\n" +
                "surname char(30),\n" +
                "login char (20));");
        statement.close();
    }

    public void dropTable() throws SQLException{
        Statement statement = JdbcUtils
                .getInstance()
                .getConnection()
                .createStatement();
        statement.executeUpdate(
                "drop table users");
        statement.close();
    }
}
