package pl.narodzinyprrogramsity.table;

import pl.narodzinyprrogramsity.api.Executor;
import pl.narodzinyprrogramsity.config.Config;
import pl.narodzinyprrogramsity.model.BaseModel;
import pl.narodzinyprrogramsity.parser.DataParser;

public abstract class BaseManager <T extends BaseModel> implements DataManager<T>,SqlQueries<T> {

    protected Executor executor;
    protected Config config;
    protected DataParser<T> parser;

    public BaseManager(Executor executor, Config config ,DataParser<T> parser) {
        this.executor = executor;
        this.config = config;
        this.parser = parser;
    }
}
