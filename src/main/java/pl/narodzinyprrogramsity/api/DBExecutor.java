package pl.narodzinyprrogramsity.api;

import com.sun.rowset.CachedRowSetImpl;
import pl.narodzinyprrogramsity.service.JDBCService;

import javax.sql.rowset.CachedRowSet;
import java.sql.*;

public class DBExecutor implements Executor {
    private JDBCService jdbcService;

    public DBExecutor(JDBCService jdbcService) {
        this.jdbcService = jdbcService;
    }

    @Override
    public void execute(Action action) {
        Statement statement = null;
        //tworzymy połączenie z JDBC
        jdbcService.connect();
        Connection connection = jdbcService.getConnection();
        try {
            //na jego podstawie tworzymy Statement
            statement = connection.createStatement();
            action.onExecute(statement);
            System.out.println("create executor completed!");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection(statement);
        }
    }

    @Override
    public void execute(Action action, String sql) {
        PreparedStatement statement = null;

        jdbcService.connect();
        Connection connection = jdbcService.getConnection();
        try {
            statement = connection.prepareStatement(sql);
            action.onExecute(statement);
            System.out.println("create executor completed!");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection(statement);
        }
    }

    @Override
    public ResultSet executeQuery(Action action) {
        ResultSet resultSet;
        Statement statement = null;
        jdbcService.connect();
        Connection connection = jdbcService.getConnection();

        try {
            statement = connection.createStatement();
            resultSet = action.onExecuteQuery(statement);
            CachedRowSet cachedRowSet = new CachedRowSetImpl();
            cachedRowSet.populate(resultSet);
            System.out.println("create execute completed!");
            return cachedRowSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection(statement);
        }

        return null;
    }

    private void closeConnection(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        jdbcService.disconnect();
    }
}
