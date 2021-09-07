package com.pethouse.pethouseapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pethouse.pethouseapp.units.TableUnit;

public class SQLService {

    PropertiesGetter dbProp = new PropertiesGetter();


    private Connection getDbConnection() throws SQLException {
        String connectURL = "jdbc:mysql://" + dbProp.getDB_HOST() + ":" + dbProp.getDB_PORT() + "/" + dbProp.getDB_NAME();
        return DriverManager.getConnection(connectURL, dbProp.getDB_USER(), dbProp.getDB_PASS());
    }

    public synchronized void pushUnit(TableUnit unit) throws SQLException {

        String sqlRequest = "INSERT INTO " + unit.getTableName() + "(" + unit.getDbFieldName() + "," + unit.getDbFieldSpecies() +
                "," + unit.getDbFieldGender() + "," + unit.getDbFieldColor() + "," + unit.getDbFieldSize() + ")" + "VALUES(?, ?, ?, ?, ?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(sqlRequest);
        prSt.setString(1, unit.getName());
        prSt.setString(2, unit.getSpecies().getStrSpecies());
        prSt.setString(3, unit.getGender().getStrGender());
        prSt.setString(4, unit.getColor().getStrColor());
        prSt.setString(5, unit.getSize().getStrSize());
        prSt.executeUpdate();
        prSt.close();
    }


}
