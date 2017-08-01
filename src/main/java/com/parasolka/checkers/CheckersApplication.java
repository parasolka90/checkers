package com.parasolka.checkers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CheckersApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckersApplication.class, args);

		Pawn white = new Pawn("W");
		Pawn black = new Pawn("B");
		Board board = new Board(8);
		board.setFigure(white, 5, 6);
		board.setFigure(black, 7, 7);
		board.setFigure(white, 6, 2);
		board.setFigure(white, 2, 3);
		board.setFigure(black, 4, 4);
		board.setFigure(black,4,5);
		board.printBoard();
		board.move(7,7,8,6);
		System.out.println();
		board.printBoard();
	}
}
