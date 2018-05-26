package pl.narodzinyprrogramsity.table;

import pl.narodzinyprrogramsity.model.BaseModel;

public interface SqlQueries<T extends BaseModel> {
    String getCreateTableQuery();

    String getSelectQuery();

    String getInsertQuery(T obj);

    String getUpdateQuery();
}
