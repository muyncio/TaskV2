package pl.system.table;

import pl.system.jdbc.utils.JdbcUtils;

import java.sql.SQLException;
import java.sql.Statement;

public class Import {
    public void importXmlFile(String path) throws SQLException {
        Statement statement = JdbcUtils
                .getInstance()
                .getConnection()
                .createStatement();
        statement.executeUpdate(
                "LOAD XML LOCAL INFILE '" + path + "' INTO TABLE users ROWS IDENTIFIED BY '<login>';");
        statement.close();
    }
}
