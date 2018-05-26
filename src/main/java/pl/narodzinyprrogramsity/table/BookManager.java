package pl.narodzinyprrogramsity.table;

import pl.narodzinyprrogramsity.api.ActionAdapter;
import pl.narodzinyprrogramsity.api.Executor;
import pl.narodzinyprrogramsity.config.Config;
import pl.narodzinyprrogramsity.model.Book;
import pl.narodzinyprrogramsity.parser.DataParser;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BookManager extends BaseManager<Book> {

    public BookManager(Executor executor, Config config, DataParser parser) {
        super(executor, config, parser);
    }

    @Override
    public void createRepository() {
        executor.execute(new ActionAdapter() {
            @Override
            public void onExecute(Statement statement) {
                try {
                    statement.executeUpdate(getCreateTableQuery());
                    System.out.println("create table");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void add(Book object) {

    }

    @Override
    public void update(Book object) {

    }

    @Override
    public List<Book> getList() {
        return null;
    }

    @Override
    public String getCreateTableQuery() {
        return null;
    }

    @Override
    public String getSelectQuery() {
        return null;
    }

    @Override
    public String getInsertQuery(Book obj) {
        return null;
    }

    @Override
    public String getUpdateQuery() {
        return null;
    }
}
