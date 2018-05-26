package pl.narodzinyprrogramsity.api;

import java.sql.ResultSet;

public interface Executor {

    void execute(Action action);

    void execute(Action action, String sql);

    ResultSet executeQuery(Action action);
}
