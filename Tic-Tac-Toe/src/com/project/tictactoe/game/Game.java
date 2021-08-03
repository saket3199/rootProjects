package com.project.tictactoe.game;

import java.util.ArrayList;

import com.project.tictactoe.analyzer.ResultAnalyzer;
import com.project.tictactoe.board.Board;
import com.project.tictactoe.mark.Mark;
import com.project.tictactoe.player.Player;

public class Game {
	private int size;
	private Board board;
	private ResultAnalyzer resultAnalyzer;
	private Player player;
	private int row, col;
	private Mark c;

	public Game(int size) {
		this.size = size;
		player = new Player();
		board = new Board(size);
		resultAnalyzer = new ResultAnalyzer();

	}

	public int getSize() {
		return size;
	}

	public Board getBoard() {
		return board;
	}

	public int putMark(ArrayList<Integer> positions) {
		c = Mark.E;
		if (player.isPlayer1() && !player.isPlayer2()) {
			c = Mark.X;

		} else if (player.isPlayer2() && !player.isPlayer1()) {
			c = Mark.O;

		}
		
		row = positions.get(0);
		col = positions.get(1);
		

		if (row < 0 || col < 0 || row > board.getSize() - 1 || col > board.getSize() - 1) {

			return 1;

		} else if (this.getBoard().getCells()[row][col].getMark() != Mark.E) {
			return 2;

		}
		return 0;

	}

	public int takeInput() {

		if (player.isPlayer1() && !player.isPlayer2()) {

			return 1;

		} else if (player.isPlayer2() && !player.isPlayer1()) {

			return 2;
		}
		return 0;

	}

	public int resultAnalysis() {
		Mark result = resultAnalyzer.playerHasWon(this.getBoard().getCells());
		System.out.print(result);
		if (result.equals(Mark.X)) {
			return 1;
		} else if (result.equals(Mark.O)) {
			return 2;
		} else {

			if (board.boardIsFull(this.getBoard().getCells())) {
				return 3;
			} else {
				player.setPlayer1(!player.isPlayer1());
				player.setPlayer2(!player.isPlayer2());

			}

		}

		return 0;
	}

	public void setMark() {
		// TODO Auto-generated method stub
		this.getBoard().getCells()[row][col].setMark(c);

	}

}
