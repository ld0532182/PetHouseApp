package com.pethouse.pethouseapp.enums;

public enum DbFieldPerson {
    NAME("name"), SPECIES("favouriteSpecies"), GENDER("favouriteGender"),
    COLOR("favouriteColor"), SIZE("favouriteSize");

    private final String strField;

    DbFieldPerson(String strField) {
        this.strField = strField;
    }

    public String getStrField() {
        return strField;
    }
}
