package com.pethouse.pethouseapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLService {


    public Connection getDbConnection() throws SQLException {
        PropertiesGetter dbProp = new PropertiesGetter();
        String connectURL = "jdbc:mysql://" + dbProp.getDB_HOST() + ":" + dbProp.getDB_PORT() + "/" + dbProp.getDB_NAME();
        return DriverManager.getConnection(connectURL, dbProp.getDB_USER(), dbProp.getDB_PASS());
    }


}
