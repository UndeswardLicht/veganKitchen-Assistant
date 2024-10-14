package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCreator {
    public static Connection createConnection(){ //todo Change to connection pool
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e){
            e.printStackTrace();
        }
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/veganKitchen";
        Properties prop = new Properties();
        try{
            connection = DriverManager.getConnection(url, prop);
        } catch (SQLException e){
            throw new RuntimeException(e); //todo
        }
        return connection;
    }
}
