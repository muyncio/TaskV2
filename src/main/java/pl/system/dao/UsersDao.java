package pl.system.dao;

import pl.system.Entity.Users;

import java.sql.SQLException;
import java.util.List;

public interface UsersDao {
    void save(Users users) throws SQLException;
    Users findById(Integer id) throws SQLException;
    Users findByName(String name) throws SQLException;
    Users findBySurname(String surname) throws SQLException;
    Users findByLogin(String login) throws SQLException;
    List<Users> findAll() throws SQLException;
    void deleteById (Integer id) throws SQLException;
}
