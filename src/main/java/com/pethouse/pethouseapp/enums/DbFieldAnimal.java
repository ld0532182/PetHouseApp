package com.pethouse.pethouseapp.enums;

public enum DbFieldAnimal {
    SPECIES("species"), NAME("name"), GENDER("gender"), COLOR("color"), SIZE("size");

    private final String strField;

    DbFieldAnimal(String strField) {
        this.strField = strField;
    }

    public String getStrField() {
        return strField;
    }
}
