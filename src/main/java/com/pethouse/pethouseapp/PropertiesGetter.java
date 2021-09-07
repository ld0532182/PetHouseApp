package com.pethouse.pethouseapp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class PropertiesGetter {

    private final String DB_HOST;
    private final String DB_PORT;
    private final String DB_USER;
    private final String DB_PASS;
    private final String DB_NAME;
    private final String DB_TABLE_ANIMAL;
    private final String DB_TABLE_PERSON;
    private final String PATH_TO_PROPERTIES = "src/main/resources/dbConnect.properties";

    public PropertiesGetter(){
        Properties prop = getProperties();
        this.DB_HOST = prop.getProperty("dbHost");
        this.DB_PORT = prop.getProperty("dbPort");
        this.DB_USER = prop.getProperty("dbUser");
        this.DB_PASS = prop.getProperty("dbPass");
        this.DB_NAME = prop.getProperty("dbName");
        this.DB_TABLE_ANIMAL = prop.getProperty("dbTableAnimal");
        this.DB_TABLE_PERSON = prop.getProperty("dbTablePerson");


    }

    public String getDB_HOST() {
        return DB_HOST;
    }

    public String getDB_PORT() {
        return DB_PORT;
    }

    public String getDB_USER() {
        return DB_USER;
    }

    public String getDB_PASS() {
        return DB_PASS;
    }

    public String getDB_NAME() { return DB_NAME; }

    public String getDB_TABLE_ANIMAL() { return DB_TABLE_ANIMAL; }

    public String getDB_TABLE_PERSON() { return DB_TABLE_PERSON; }

    private Properties getProperties(){
        FileInputStream fileInputStream;
        Properties prop = new Properties();

        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);
        } catch (IOException e) {
            System.out.println("Property file not found or access denied");
            e.printStackTrace();
        }
        return prop;
    }
}
