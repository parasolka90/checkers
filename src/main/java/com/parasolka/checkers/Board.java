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
}
