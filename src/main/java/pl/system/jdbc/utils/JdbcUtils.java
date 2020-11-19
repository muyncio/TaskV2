package pl.system.jdbc.utils;

import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private static JdbcUtils instance = null;
    private Connection connection;

    String login = "root";
    String password = "password";
    String connectionString ="jdbc:mysql://localhost:3306/users?allowLoadLocalInfile=true";

    private JdbcUtils(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception ex) {
                ex.setStackTrace(ex.getStackTrace());
            }
        Properties prop = new Properties();
        prop.put("password", password);
        prop.put("user", login);
        prop.put("serverTimezone", "Europe/Warsaw");
        try {
            connection = DriverManager.getConnection(connectionString, prop);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public static JdbcUtils getInstance(){
        if(instance == null){
            instance = new JdbcUtils();
        }
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }
}
