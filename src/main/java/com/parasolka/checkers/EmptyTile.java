package com.parasolka.checkers;

import sun.invoke.empty.Empty;

public class EmptyTile extends Figure {

    public EmptyTile(){
        super("_");

    }

    @Override
    public String getColor() {
        return "_";
    }
}
