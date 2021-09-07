package com.pethouse.pethouseapp.units;


import com.pethouse.pethouseapp.PropertiesGetter;
import com.pethouse.pethouseapp.enums.*;

public class Person extends TableUnit {

    private final String TABLE_NAME;

    public Person(String name, Color favouriteColor, Gender favouriteGender, Size favouriteSize, Species favouriteSpecies) {
        super(name, favouriteColor, favouriteGender, favouriteSize, favouriteSpecies);
        this.TABLE_NAME = new PropertiesGetter().getDB_TABLE_PERSON();
    }

    @Override
    public String getDbFieldName() {
        return DbFieldPerson.NAME.getStrField();
    }

    @Override
    public String getDbFieldSpecies() {
        return DbFieldPerson.SPECIES.getStrField();
    }

    @Override
    public String getDbFieldGender() {
        return DbFieldPerson.GENDER.getStrField();
    }

    @Override
    public String getDbFieldColor() {
        return DbFieldPerson.COLOR.getStrField();
    }

    @Override
    public String getDbFieldSize() {
        return DbFieldPerson.SIZE.getStrField();
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

}
