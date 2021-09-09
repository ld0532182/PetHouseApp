package com.pethouse.pethouseapp;

import java.sql.*;

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

    /**
     * Здесь в метод можно было передать объект Person, и по его полям искать совпадения примерно так:
     * "SELECT id FROM animal
     * WHERE species = " + person.getSpecies + " AND (color = " + person.getColor + " OR "+ ............. +");"
     * На мой взгляд, это было бы быстрее. Но моей задачей была работа с SQL и JOIN запросами, поэтому метод
     * использует JOIN.
     * <p>
     * !!!p.s в запросе ниже намеренно не применяются константы для упрощения восприятия, это нужно учитывать при сборке
     * приложения.
     */

    public void deletePairAnimalPerson() throws SQLException {
        Connection connection = getDbConnection();
        String sqlRequest = "SELECT P.id, P.name, A.id AS idAnimal FROM animal AS A " +
                "JOIN person AS P ON P.favouriteSpecies = A.species AND " +
                "(P.favouriteGender = A.gender OR P.favouriteColor = A.color OR P.favouriteSize = A.size)" +
                "ORDER BY P.id;";
        ResultSet resultSet = connection.prepareStatement(sqlRequest).executeQuery();
        //Берем первое совпадение, если оно имеется.
        int currentIdPerson = 0;
        int idAnimal;
        while (resultSet.next())
            if (resultSet.getInt(1) != currentIdPerson) {
                currentIdPerson = resultSet.getInt(1);
                idAnimal = resultSet.getInt(3);
                sqlRequest = "DELETE FROM animal WHERE id =" + idAnimal + ";";
                connection.prepareStatement(sqlRequest).executeUpdate();
                sqlRequest = "DELETE FROM person WHERE id =" + currentIdPerson + ";";
                connection.prepareStatement(sqlRequest).executeUpdate();
            }
        connection.close();
    }


}
