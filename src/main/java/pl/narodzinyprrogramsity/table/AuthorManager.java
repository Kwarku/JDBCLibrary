package pl.narodzinyprrogramsity.table;

import pl.narodzinyprrogramsity.api.ActionAdapter;
import pl.narodzinyprrogramsity.api.Executor;
import pl.narodzinyprrogramsity.config.Config;
import pl.narodzinyprrogramsity.model.Author;
import pl.narodzinyprrogramsity.parser.DataParser;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AuthorManager extends BaseManager<Author> {
    public AuthorManager(Executor executor, Config config, DataParser parser) {
        super(executor, config, parser);
    }

    @Override
    public void createRepository() {
        executor.execute(new ActionAdapter() {
            @Override
            public void onExecute(Statement statement) {
                try {
                    System.out.println("create table");
                    statement.executeUpdate(getCreateTableQuery());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void add(final Author object) {
        executor.execute(new ActionAdapter() {
            @Override
            public void onExecute(Statement statement) {
                try {
                    statement.executeUpdate(getInsertQuery(object));
                    System.out.println("add element");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void update(final Author object) {
        executor.execute(new ActionAdapter() {
            @Override
            public void onExecute(PreparedStatement statement) {
                try {
                    statement.setString(1, object.getFirstName());
                    statement.setString(2, object.getLastName());
                    statement.setInt(3, object.getYearOfBirth());
                    statement.setString(4, object.getId());
                    statement.executeUpdate();
                    System.out.println("update element");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }, getUpdateQuery());

    }

    @Override
    public List<Author> getList() {
        ResultSet resultSet = executor.executeQuery(new ActionAdapter() {
            @Override
            public ResultSet onExecuteQuery(Statement statement) {
                try {
                    return statement.executeQuery(getSelectQuery());
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });
        List<Author> list = parser.parseToList(resultSet);
        return list;
    }

    @Override
    public String getCreateTableQuery() {
        return String.format("CREATE TABLE if not exists %s%s " +
                        "(%s varchar(32) NOT NULL ," +
                        " %s varchar(32) NOT NULL, " +
                        "%s varchar(50) NOT NULL, " +
                        "%s integer NOT NULL, " +
                        "PRIMARY KEY(%s))",
                config.getDbName(), Author.AUTHOR_TABLE,
                Author.AUTHOR_ID_COLUMN,
                Author.FIRST_NAME_COLUMN,
                Author.LAST_NAME_COLUMN,
                Author.YEAR_OF_BIRTH_COLUMN,
                Author.AUTHOR_ID_COLUMN);

    }

    @Override
    public String getSelectQuery() {
        return String.format("SELECT * from %s%s",
                config.getDbName(),Author.AUTHOR_TABLE);
    }

    @Override
    public String getInsertQuery(Author obj) {
        return String.format("INSERT INTO %s%s VALUES ('%s', '%s', '%s', '%s')",
                config.getDbName(), Author.AUTHOR_TABLE,
                obj.getId(), obj.getFirstName(), obj.getLastName(), obj.getYearOfBirth());


    }

    @Override
    public String getUpdateQuery() {
        return String.format("update %s%s set %s = ?, %s = ?, %s = ? WHERE %s = ?",
                config.getDbName(), Author.AUTHOR_TABLE, Author.FIRST_NAME_COLUMN, Author.LAST_NAME_COLUMN,
                Author.YEAR_OF_BIRTH_COLUMN, Author.AUTHOR_ID_COLUMN);
    }
}
