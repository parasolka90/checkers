package com.parasolka.checkers;

public class Queen extends Figure{

    public Queen(String color) {
        super(color);
    }
    @Override
    public String getColor() {
        return this.color;
    }
}
