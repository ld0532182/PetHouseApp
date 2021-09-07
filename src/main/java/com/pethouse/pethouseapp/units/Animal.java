package com.pethouse.pethouseapp.units;

import com.pethouse.pethouseapp.PropertiesGetter;
import com.pethouse.pethouseapp.enums.*;

public class Animal extends TableUnit{

    private final String TABLE_NAME;

    public Animal(String name, Color color, Gender gender, Size size, Species species) {
        super(name, color, gender, size, species);
        this.TABLE_NAME = new PropertiesGetter().getDB_TABLE_ANIMAL();
    }

    @Override
    public String getDbFieldName() {
        return DbFieldAnimal.NAME.getStrField();
    }

    @Override
    public String getDbFieldSpecies() {
        return DbFieldAnimal.SPECIES.getStrField();
    }

    @Override
    public String getDbFieldGender() {
        return DbFieldAnimal.GENDER.getStrField();
    }

    @Override
    public String getDbFieldColor() {
        return DbFieldAnimal.COLOR.getStrField();
    }

    @Override
    public String getDbFieldSize() {
        return DbFieldAnimal.SIZE.getStrField();
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}
