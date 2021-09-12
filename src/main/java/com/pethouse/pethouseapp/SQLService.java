package com.pethouse.pethouseapp;

import java.sql.*;

import com.pethouse.pethouseapp.javafxclasses.Container;
import com.pethouse.pethouseapp.units.Person;
import com.pethouse.pethouseapp.units.TableUnit;

public final class SQLService {

    private final static PropertiesGetter dbProp = new PropertiesGetter();


    private static Connection getDbConnection() throws SQLException {
        String connectURL = "jdbc:mysql://" + dbProp.getDB_HOST() + ":" + dbProp.getDB_PORT() + "/" + dbProp.getDB_NAME();
        return DriverManager.getConnection(connectURL, dbProp.getDB_USER(), dbProp.getDB_PASS());
    }

    public static synchronized void pushUnit(TableUnit unit) {
        String sqlRequest = "INSERT INTO " + unit.getTableName() + "(" + unit.getDbFieldName() + "," + unit.getDbFieldSpecies() +
                "," + unit.getDbFieldGender() + "," + unit.getDbFieldColor() + "," + unit.getDbFieldSize() + ")" + "VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sqlRequest);
            prSt.setString(1, unit.getName());
            prSt.setString(2, unit.getSpecies().getStrSpecies());
            prSt.setString(3, unit.getGender().getStrGender());
            prSt.setString(4, unit.getColor().getStrColor());
            prSt.setString(5, unit.getSize().getStrSize());
            prSt.executeUpdate();
            prSt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public static void deleteAllPairAnimalPerson() throws SQLException {
        Connection connection = getDbConnection();
        String sqlRequest = "SELECT P.id, P.name, A.id AS idAnimal, A.name FROM animal AS A " +
                "JOIN person AS P ON P.favouriteSpecies = A.species AND " +
                "(P.favouriteGender = A.gender OR P.favouriteColor = A.color OR P.favouriteSize = A.size)" +
                "ORDER BY P.id;";
        ResultSet resultSet = connection.prepareStatement(sqlRequest).executeQuery();
        //Берем первое совпадение, если оно имеется.
        int currentIdPerson = 0;
        int idAnimal;
        while (resultSet.next())
            if (resultSet.getInt(1) != currentIdPerson) {
                idAnimal = resultSet.getInt(3);
                sqlRequest = "DELETE FROM animal WHERE id =" + idAnimal + ";";
                int isAnimalDeleted = connection.prepareStatement(sqlRequest).executeUpdate();
                if (isAnimalDeleted != 0) {
                    Container.addAnimalName(resultSet.getString(4));
                    Container.addPersonName(resultSet.getString(2));
                    currentIdPerson = resultSet.getInt(1);
                    sqlRequest = "DELETE FROM person WHERE id =" + currentIdPerson + ";";
                    connection.prepareStatement(sqlRequest).executeUpdate();
                }
            }
        connection.close();
    }

    public static int deleteOnePairAnimalPerson(Person person) throws SQLException {
        String sqlRequest = "SELECT id, name FROM animal WHERE species = '" + person.getSpecies().getStrSpecies() +
                "' AND (gender = '" + person.getGender().getStrGender() + "' OR color = '" + person.getColor().getStrColor() +
                "' OR size = '" + person.getSize().getStrSize() + "');";
        Connection connection = getDbConnection();
        ResultSet resultSet = connection.prepareStatement(sqlRequest).executeQuery();
        if (!resultSet.next())
            return 1;
        int idAnimal = resultSet.getInt(1);
        Container.addAnimalName(resultSet.getString(2));
        sqlRequest = "DELETE FROM animal WHERE id =" + idAnimal + ";";
        connection.prepareStatement(sqlRequest).executeUpdate();
        sqlRequest = "DELETE FROM person WHERE (name = '" + person.getName() + "' AND favouriteSpecies = '" +
                person.getSpecies().getStrSpecies() + "') AND (favouriteGender = '" + person.getGender().getStrGender() +
                "' OR favouriteColor = '" + person.getColor().getStrColor() +
                "' OR favouriteSize = '" + person.getSize().getStrSize() + "');";
        connection.prepareStatement(sqlRequest).executeUpdate();
        connection.close();
        return 0;
    }

    public static int animalsCount() throws SQLException {
        Connection connection = getDbConnection();
        String sqlRequest = "SELECT COUNT(*) FROM " + dbProp.getDB_TABLE_ANIMAL();
        ResultSet resultSet = connection.prepareStatement(sqlRequest).executeQuery();
        resultSet.next();
        int count = resultSet.getInt(1);
        connection.close();
        return count;
    }


}
