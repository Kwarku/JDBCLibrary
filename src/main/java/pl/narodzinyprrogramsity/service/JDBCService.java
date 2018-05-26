package pl.narodzinyprrogramsity.service;

import java.sql.Connection;
/**
 * service used for base jdbc operations
 * */
public interface JDBCService {

    boolean connect();

    boolean disconnect();

    Connection getConnection();
}
