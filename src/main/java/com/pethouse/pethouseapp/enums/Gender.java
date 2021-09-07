package com.pethouse.pethouseapp.enums;

public enum Gender {

    MALE("Male"), FEMALE("Female");

    private final String strGender;

    Gender(String gender){
        this.strGender = gender;
    }

    public String getStrGender(){
        return strGender;
    }




}
