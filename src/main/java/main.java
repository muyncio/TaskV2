import pl.system.Entity.Users;
import pl.system.daoImpl.UsersDaoImpl;
import pl.system.jdbc.utils.JdbcUtils;
import pl.system.table.Import;
import pl.system.table.TableImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main {

    private static void printAllData() throws SQLException {
        Statement statement = JdbcUtils.getInstance().getConnection().createStatement();
        ResultSet result = statement.executeQuery("select * from users");
        while(result.next()) {
            System.out.println(result.getInt("id") + " " + result.getString("name") + " " + result.getString("surname"));
        }
    }

    public static void main(String[] args) throws SQLException {
        UsersDaoImpl usersDao = new UsersDaoImpl();


        TableImpl table = new TableImpl();

//        table.createTable();

        Import imp = new Import();

        imp.importXmlFile("C:\\Users\\muyne\\OneDrive\\Desktop\\TaskV2\\text.xml");

        usersDao.findAll();
    }
}
