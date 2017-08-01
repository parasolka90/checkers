package com.parasolka.checkers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CheckersApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckersApplication.class, args);

		Pawn white = new Pawn("W");
		Pawn black = new Pawn("B");
		Board board = new Board(10);
		board.setFigure(white, 5, 6);
		board.setFigure(black, 9, 7);
		board.setFigure(white, 6, 2);
		board.setFigure(white, 2, 8);
		board.setFigure(black, 4, 9);
		board.setFigure(black,4,5);
		board.printBoard();
		board.move(5,6,4,5);
		System.out.println();
		board.printBoard();
	}
}
