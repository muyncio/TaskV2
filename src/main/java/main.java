
import pl.system.daoImpl.UsersDaoImpl;
import pl.system.jdbc.utils.JdbcUtils;
import pl.system.table.Import;
import pl.system.table.TableImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class main {


    static void slogin(){
        Scanner input = new Scanner(System.in);
        String login;
        System.out.println("login:");
        login = input.nextLine();
        JdbcUtils.getInstance().setLogin(login);
    }
    static void spassword(){
        Scanner input = new Scanner(System.in);
        String password;
        System.out.println("login:");
        password = input.nextLine();
        JdbcUtils.getInstance().setLogin(password);
    }
    static void surl(){
        Scanner input = new Scanner(System.in);
        String url;
        System.out.println("login:");
        url = input.nextLine();
        JdbcUtils.getInstance().setConnectionString("jdbc:mysql://localhost:3306/users?allowLoadLocalInfile=true");
    }
    public static void main(String[] args) throws SQLException {
        TableImpl table = new TableImpl();
        UsersDaoImpl usersDao = new UsersDaoImpl();
        Import imp = new Import();


//       table.createTable();
//        Users u1 = new Users(1, "Marcin", "Młynarski", "alla");

//        usersDao.save(u1);
//            imp.importXmlFile("C:/text.xml");

//        slogin();
//        spassword();
//        surl();

//        table.dropTable();



    }

}
