package com.techlab.tictactoe;

public class ResultAnalysis {
	public static char[][] board = new char[3][3];
	private Board Board;

	public char playerHasWon(char[][] board) {

		
		for (int i = 0; i < Board.getSize(); i++) {
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
				return board[i][0];
			}
		}

	
		for (int j = 0; j < Board.getSize(); j++) {
			if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
				return board[0][j];
			}
		}

	
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
			return board[0][0];
		}
		if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-') {
			return board[2][0];
		}

		return ' ';

	}

}
