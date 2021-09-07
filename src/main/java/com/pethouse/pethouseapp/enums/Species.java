package com.pethouse.pethouseapp.enums;

public enum Species {
    CAT("Cat"), DOG("Dog");

    private final String strSpecies;

    Species(String species){
        this.strSpecies = species;
    }

    public String getStrSpecies() {
        return strSpecies;
    }
}
