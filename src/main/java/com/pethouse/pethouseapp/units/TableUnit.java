package com.pethouse.pethouseapp.units;

import com.pethouse.pethouseapp.enums.*;

public  abstract class TableUnit {

    private String name;
    private Color color;
    private Gender gender;
    private Size size;
    private Species species;

    public TableUnit(String name, Color color, Gender gender, Size size, Species species) {
        this.name = name;
        this.color = color;
        this.gender = gender;
        this.size = size;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Gender getGender() {
        return gender;
    }

    public Size getSize() {
        return size;
    }

    public Species getSpecies() {
        return species;
    }

    public abstract String getDbFieldName();
    public abstract String getDbFieldSpecies();
    public abstract String getDbFieldGender();
    public abstract String getDbFieldColor();
    public abstract String getDbFieldSize();
    public abstract String getTableName();

    @Override
    public String toString() {
        return "TableUnit{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", gender=" + gender +
                ", size=" + size +
                ", species=" + species +
                '}';
    }
}
