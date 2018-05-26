package pl.narodzinyprrogramsity.config;

public class Config {
    private final String url;
    private final String dbName;
    private final String userName;
    private final String password;

    public Config(String url, String dbName, String userName, String password) {
        this.url = url;
        this.dbName = dbName;
        this.userName = userName;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public String getDbName() {
        return dbName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
