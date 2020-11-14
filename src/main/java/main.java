import pl.system.Entity.Users;
import pl.system.daoImpl.UsersDaoImpl;
import pl.system.jdbc.utils.JdbcUtils;

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
        Users user1 = new Users();
        Users user2 = new Users(1, "Marcin", "Młyunarski", "umpalumpas");
        Users user3 = new Users(2, "Aga", "Sobol", "dupa");
//        usersDao.save(user2);
//        usersDao.save(user3);

        usersDao.findByName("Aga");
    }
}
