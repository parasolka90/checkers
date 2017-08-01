package com.parasolka.checkers;

import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<String>> board;
    private int size;

    public String getFigure(int x, int y) {
        return board.get(y).get(x);
    }

    public void setFigure(Pawn figure, int x, int y) {
        figure.getPawn();
        board.get(y).set(x, figure.getPawn());
    }

    public Board(int size) {
        this.size = size;
        this.board = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ArrayList<String> board1 = new ArrayList<String>();
            for (int j = 0; j < size; j++) {
                board1.add("_");
            }
            this.board.add(board1);
        }
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" " + getFigure(j, i) + " ");
            }
            System.out.println("");
        }

    }

    public boolean move(int x0, int y0, int x1, int y1) {
        String p = getFigure(x0, y0);
        if (checkMove(x0, y0, x1, y1) == false) {
            return false;
        }
        if (getFigure(x1, y1) != "_") {
            return hit(x0, y0, x1, y1);
        } else {
            //String p=getFigure(x0,y0);
            setFigure(new Pawn("_"), x0, y0);
            setFigure(new Pawn(p), x1, y1);
            return true;
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
        //White goes up
        if (getFigure(x0, y0) == "W") {
            if ((x0 + 1 == x1 && y0 - 1 == y1) || (x0 - 1 == x1 && y0 - 1 == y1)) {
                return true;
            } else {
                return false;
            }
            //Black goes down
        } else if (getFigure(x0, y0) == "B") {
            if ((x0 + 1 == x1 && y0 + 1 == y1) || (x0 - 1 == x1 && y0 + 1 == y1)) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    public boolean hit(int x0, int y0, int x1, int y1) {
        if (x1-1 <= 0 || x1+1 >=size) {
            return false;
        }
        if (y1-1 <= 0 || y1+1 >= size) {
            return false;
        }
        String beatingPawn = getFigure(x0, y0);
        String beatenPawn = getFigure(x1, y1);
        if (beatingPawn == "B" && beatenPawn == "W" || beatingPawn == "W" && beatenPawn == "B") {
            if (x0 + 1 == x1 && y0 - 1 == y1 && getFigure(x0 + 2, y0 - 2) == "_") {
                setFigure(new Pawn("_"), x0, y0);
                setFigure(new Pawn("_"), x1, y1);
                setFigure(new Pawn(beatingPawn), x0 + 2, y0 - 2);
                return true;
            } else if (x0 - 1 == x1 && y0 - 1 == y1 && getFigure(x0 - 2, y0 - 2) == "_") {
                setFigure(new Pawn("_"), x0, y0);
                setFigure(new Pawn("_"), x1, y1);
                setFigure(new Pawn(beatingPawn), x0 - 2, y0 - 2);
                return true;
            } else if (x0 + 1 == x1 && y0 + 1 == y1 && getFigure(x0 + 2, y0 + 2) == "_") {
                setFigure(new Pawn("_"), x0, y0);
                setFigure(new Pawn("_"), x1, y1);
                setFigure(new Pawn(beatingPawn), x0 + 2, y0 + 2);
        return true;
        } else if (x0 - 1 == x1 && y0 + 1 == y1 && getFigure(x0 - 2, y0 + 2) == "_") {
        setFigure(new Pawn("_"), x0, y0);
        setFigure(new Pawn("_"), x1, y1);
        setFigure(new Pawn(beatingPawn), x0 - 2, y0 + 2);
        return true;
        }
        }
        return false;
        }

        }

