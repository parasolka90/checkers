package com.parasolka.checkers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CheckersApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckersApplication.class, args);

		Pawn white = new Pawn("w");
		Pawn black = new Pawn("b");
		Queen blackQ = new Queen("B");

		Board board = new Board(8);
		board.setFigure(blackQ,1,7);
		board.setFigure(white, 5, 6);
		board.setFigure(black, 7, 7);
		board.setFigure(white, 6, 2);
		board.setFigure(white, 2, 3);
		board.setFigure(black, 4, 4);
		board.setFigure(black,4,5);
		board.printBoard();
		board.move(1,7,1,1);
		System.out.println();
		board.printBoard();
	}
}
