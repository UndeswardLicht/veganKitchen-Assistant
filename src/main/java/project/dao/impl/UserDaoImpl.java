package project.dao.impl;

import project.dao.ConnectionCreator;
import project.dao.UserDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImpl implements UserDao {
    //todo: add statement, return password from ResultSet from DB by login,
    private static final String SQL_STATEMENT = "";
    @Override
    public String authenticate(String login, String passEncrypted) {
        try (
                Connection connection = ConnectionCreator.createConnection();
                Statement statement = connection.createStatement()) {
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }
}
