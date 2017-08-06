package com.parasolka.checkers;

public class Pawn extends Figure {

    public Pawn(String color){
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }
}
