package pl.system.daoImpl;

import pl.system.Entity.Users;
import pl.system.dao.UsersDao;
import pl.system.jdbc.utils.JdbcUtils;
import pl.system.md5.MD5;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl implements UsersDao {
    public UsersDaoImpl() {
    }

    public UsersDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    MD5 md5 = new MD5();

    private DataSource dataSource;


    public void ProductDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public void save(Users users) throws SQLException {
        PreparedStatement statement = JdbcUtils
                .getInstance()
                .getConnection()
                .prepareStatement("insert into users (id, name, surname, login) values (?, ?, ?, ?)");
        statement.setInt(1, users.getId());
        statement.setString(2, users.getName());
        statement.setString(3, users.getSurname());
        statement.setString(4, users.getLogin());

        statement.executeUpdate();
        statement.close();
    }

    public Users findById(Integer id) throws SQLException {

        Statement statement = JdbcUtils.getInstance()
                .getConnection()
                .createStatement();
        ResultSet result = statement.executeQuery("select * from users where id=" + id);
        while(result.next()) {
            System.out.println(result.getInt("id") + " " + md5.MD5Crypt(result.getString("name")) + " " + result.getString("surname") + " " + result.getString("login"));
        }
        return null;
    }


    public Users findByName(String name) throws SQLException {
        Statement statement = JdbcUtils.getInstance()
                .getConnection()
                .createStatement();
        ResultSet result = statement.executeQuery("select * from users where name=" + "\"" + name + "\"");
        while(result.next()) {
            System.out.println(result.getInt("id") + " " + md5.MD5Crypt(result.getString("name")) + " " + result.getString("surname") + " " + result.getString("login"));
        }
        return null;
    }

    public Users findBySurname(String surname) throws SQLException {
        Statement statement = JdbcUtils.getInstance()
                .getConnection()
                .createStatement();
        ResultSet result = statement.executeQuery("select * from users where surname=" + "\"" + surname + "\"");
        while(result.next()) {
            System.out.println(result.getInt("id") + " " + md5.MD5Crypt(result.getString("name")) + " " + result.getString("surname") + " " + result.getString("login"));
        }
        return null;
    }

    public Users findByLogin(String login) throws SQLException {
        Statement statement = JdbcUtils.getInstance()
                .getConnection()
                .createStatement();
        ResultSet result = statement.executeQuery("select * from users where login=" + "\"" + login + "\"");
        while(result.next()) {
            System.out.println(result.getInt("id") + " " + md5.MD5Crypt(result.getString("name")) + " " + result.getString("surname") + " " + result.getString("login"));
        }
        return null;
    }

    public List<Users> findAll() throws SQLException {
        Statement statement = JdbcUtils.getInstance().getConnection().createStatement();
        ResultSet result = statement.executeQuery("select * from users");
        while(result.next()) {
            System.out.println(result.getInt("id") + " " + md5.MD5Crypt(result.getString("name")) + " " + result.getString("surname") + " " + result.getString("login"));
        }
        return null;
    }

    public void deleteById (Integer id) throws SQLException {
        Statement statement = JdbcUtils.getInstance().getConnection().createStatement();
        statement.executeUpdate("DELETE  FROM users WHERE id = " + id);
        statement.close();
    }

    public List<Users> list() throws SQLException {
        List<Users> users = new ArrayList<Users>();

        try (
                Statement statement = JdbcUtils.getInstance().getConnection().createStatement();
                ResultSet result = statement.executeQuery("SELECT id, name, surname, login FROM users");
        ) {
            while (result.next()) {
                Users user = new Users();
                user.setId(result.getInt("id"));
                user.setName(result.getString("name"));
                user.setSurname(result.getString("surname"));
                user.setLogin(result.getString("login"));
                users.add(user);
            }
        }

        return users;
    }
}
