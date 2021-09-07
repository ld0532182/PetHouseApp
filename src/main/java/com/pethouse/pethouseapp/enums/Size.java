package com.pethouse.pethouseapp.enums;

public enum Size {
    SMALL("Small"), MEDIUM("Medium"), BIG("Big");

    private final String strSize;

    Size(String size) {
        this.strSize = size;
    }

    public String getStrSize() {
        return strSize;
    }
}
