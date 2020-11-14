package pl.system.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static JdbcUtils instance = null;
    private Connection connection;


    private JdbcUtils(){
        String connectionString = "jdbc:mysql://localhost:3306/users";

        Properties prop = new Properties();
        prop.put("password", "Eloeloelo1");
        prop.put("user", "root");
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
