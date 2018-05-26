package pl.narodzinyprrogramsity.service;

import pl.narodzinyprrogramsity.config.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLService implements JDBCService{
    private Config config;
    private Connection connection;

    public MySQLService(Config config) {
        this.config = config;
    }

    @Override
    public boolean connect() {
        try{
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUserName(),
                    config.getPassword()
            );
            System.out.println("DB connection created");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean disconnect() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("DB connection closed");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            connection = null;
        }

        return false;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}
