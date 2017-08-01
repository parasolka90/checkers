package com.parasolka.checkers;

import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<String>> board;

    public String getFigure(int x, int y) {
        return board.get(y).get(x);
    }

    public void setFigure(Pawn figure, int x, int y) {
        figure.getPawn();
        board.get(y).set(x, figure.getPawn());
    }

    public Board() {
        this.board = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<String> board1 = new ArrayList<String>();
            for (int j = 0; j < 10; j++) {
                board1.add("_");
            }
            this.board.add(board1);
        }
    }

    public void printBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
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
        //String p=getFigure(x0,y0);
        setFigure(new Pawn("_"), x0, y0);
        setFigure(new Pawn(p), x1, y1);
        return true;
    }

    public boolean checkMove(int x0, int y0, int x1, int y1) {
        if (getFigure(x1, y1) != "_") {
            return false;
        }
        if (getFigure(x0, y0) == "W") {
            if ((x0 + 1 == x1 && y0 - 1 == y1) || (x0 - 1 == x1 && y0 - 1 == y1)) {
                return true;
            } else {
                return false;
            }
        } else if (getFigure(x0, y0) == "B") {
            if ((x0 + 1 == x1 && y0 + 1 == y1) || (x0 - 1 == x1 && y0 + 1 == y1)) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }
}

