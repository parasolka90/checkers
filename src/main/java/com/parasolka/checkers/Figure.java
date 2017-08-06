package com.parasolka.checkers;

public abstract class Figure {
    String color;

    public Figure(String color){
        this.color=color;
    }
    public abstract String getColor();
}
