
import pl.system.Entity.Users;
import pl.system.daoImpl.UsersDaoImpl;
import pl.system.servlets.NewServlet;
import pl.system.table.Import;
import pl.system.table.TableImpl;

import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {
        TableImpl table = new TableImpl();
        UsersDaoImpl usersDao = new UsersDaoImpl();
        Import imp = new Import();
//       table.createTable();
//        Users u1 = new Users(1, "Marcin", "Młynarski", "alla");

//        usersDao.save(u1);
//            imp.importXmlFile("C:/text.xml");
//        table.dropTable();


    }
}
