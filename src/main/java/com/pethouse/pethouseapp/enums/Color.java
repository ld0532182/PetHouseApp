package com.pethouse.pethouseapp.enums;

public enum Color {
    BLACK("Black"), GREY("Grey"), WHITE("White"), ORANGE("Orange"), BROWN("Brown");

    private final String strColor;

    Color(String color){
        this.strColor = color;
    }

    public String getStrColor(){
        return strColor;
    }

}
