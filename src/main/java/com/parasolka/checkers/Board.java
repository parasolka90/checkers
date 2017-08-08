package com.parasolka.checkers;

import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<Figure>> board;
    private int size;

    public Figure getFigure(int x, int y) {
        return board.get(y).get(x);
    }

    public void setFigure(Figure figure, int x, int y) {

        board.get(y).set(x, figure);
    }

    public Board(int size) {
        this.size = size;
        this.board = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ArrayList<Figure> board1 = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                board1.add(new EmptyTile());
            }
            this.board.add(board1);
        }
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" " + getFigure(j, i).getColor() + " ");
            }
            System.out.println();
        }

    }

    public boolean move(int x0, int y0, int x1, int y1) {
        String p = getFigure(x0, y0).getColor();
        if (checkMove(x0, y0, x1, y1) == false) {
            return false;
        }
        if (getFigure(x1, y1).getColor() != "_") {
            //todo:make hit great again (for pawn and queen)
            return hit(x0, y0, x1, y1);
        } else {
            //String p=getFigure(x0,y0);
            setFigure(new EmptyTile(), x0, y0);
            setFigure(new Pawn(p), x1, y1);
            return true;
        }
        if(getFigure(x1,size-1).getColor() =="w"){
            //todo: change Pawn to Queen
            return false;
        }
    }

    public boolean checkMove(int x0, int y0, int x1, int y1) {
        //checking if y1 and x1 is valid
        if (x1 < 0 || x1 > size) {
            return false;
        }
        if (y1 < 0 || y1 > size) {
            return false;
        }
        boolean checkPawn = checkMovePawn(x0, y0, x1, y1);
        boolean checkQueen = checkMoveQueen(x0, y0, x1, y1);

        if (checkPawn == true && checkQueen == false) {
            return true;
        } else if (checkPawn == false && checkQueen == true) {
            return true;
        } else if(checkPawn == false && checkQueen == false){
            return false;
        } else {
            return false;
        }
    }

    public boolean checkMovePawn(int x0, int y0, int x1, int y1) {
        //White goes up
        if (getFigure(x0, y0).getColor() == "w") {
            if ((x0 + 1 == x1 && y0 - 1 == y1) || (x0 - 1 == x1 && y0 - 1 == y1)) {
                return true;
            } else {
                return false;
            }
            //Black goes down
        } else if (getFigure(x0, y0).getColor() == "b") {
            if ((x0 + 1 == x1 && y0 + 1 == y1) || (x0 - 1 == x1 && y0 + 1 == y1)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean checkMoveQueen(int x0, int y0, int x1, int y1) {
        if (getFigure(x0, y0).getColor() == "W" || getFigure(x0, y0).getColor() == "B") {
            if (Math.abs(x1 - x0) == Math.abs(y1 - y0)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean hit(int x0, int y0, int x1, int y1) {
        if (x1 - 1 <= 0 || x1 + 1 >= size) {
            return false;
        }
        if (y1 - 1 <= 0 || y1 + 1 >= size) {
            return false;
        }
        String beatingPawn = getFigure(x0, y0).getColor();
        String beatenPawn = getFigure(x1, y1).getColor();
        if (beatingPawn == "B" && beatenPawn == "W" || beatingPawn == "W" && beatenPawn == "B") {
            if (x0 + 1 == x1 && y0 - 1 == y1 && getFigure(x0 + 2, y0 - 2).getColor() == "_") {
                setFigure(new EmptyTile(), x0, y0);
                setFigure(new EmptyTile(), x1, y1);
                setFigure(new Pawn(beatingPawn), x0 + 2, y0 - 2);
                return true;
            } else if (x0 - 1 == x1 && y0 - 1 == y1 && getFigure(x0 - 2, y0 - 2).getColor() == "_") {
                setFigure(new EmptyTile(), x0, y0);
                setFigure(new EmptyTile(), x1, y1);
                setFigure(new Pawn(beatingPawn), x0 - 2, y0 - 2);
                return true;
            } else if (x0 + 1 == x1 && y0 + 1 == y1 && getFigure(x0 + 2, y0 + 2).getColor() == "_") {
                setFigure(new EmptyTile(), x0, y0);
                setFigure(new EmptyTile(), x1, y1);
                setFigure(new Pawn(beatingPawn), x0 + 2, y0 + 2);
                return true;
            } else if (x0 - 1 == x1 && y0 + 1 == y1 && getFigure(x0 - 2, y0 + 2).getColor() == "_") {
                setFigure(new EmptyTile(), x0, y0);
                setFigure(new EmptyTile(), x1, y1);
                setFigure(new Pawn(beatingPawn), x0 - 2, y0 + 2);
                return true;
            }
        }
        return false;
    }

}

