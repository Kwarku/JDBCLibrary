package pl.narodzinyprrogramsity.api;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class ActionAdapter implements Action {


    @Override
    public void onExecute(Statement statement) {

    }

    @Override
    public void onExecute(PreparedStatement statement) {

    }

    @Override
    public ResultSet onExecuteQuery(Statement statement) {
        return null;
    }
}
