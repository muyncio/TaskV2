import pl.system.Entity.Users;
import pl.system.daoImpl.UsersDaoImpl;
import pl.system.table.TableImpl;

import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {
        UsersDaoImpl usersDao = new UsersDaoImpl();
        Users user1 = new Users(1, "Marcin", "Młynraski", "umpalumpas");
        Users user2 = new Users(2, "Aga", "Sobol", "bigusdikus");

        TableImpl table = new TableImpl();

       table.createTable();

       usersDao.save(user1);
       usersDao.save(user2);

//
//        Import imp = new Import();
//
//        imp.importXmlFile("C:/text.xml");
//
        usersDao.findAll();
        table.dropTable();


    }
}
