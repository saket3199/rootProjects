package com.project.tictactoe.analyzer;

import com.project.tictactoe.cell.Cell;
import com.project.tictactoe.mark.Mark;

public class ResultAnalyzer implements IResultable {

	public Mark playerHasWon(Cell[][] board) {
		
		for(int i = 0; i < 3; i++) {
			if(board[i][0].getMark().equals(board[i][1].getMark()) && board[i][1].getMark().equals(board[i][2].getMark())&& board[i][0].getMark() != Mark.E) {
				return board[i][0].getMark();
			}
		}

		//Check each column
		for(int j = 0; j < 3; j++) {
			if(board[0][j].getMark().equals(board[1][j].getMark()) && board[1][j].getMark().equals(board[2][j].getMark()) && board[0][j].getMark() != Mark.E) {
				return board[0][j].getMark();
			}
		}

		//Check the diagonals
		if(board[0][0].getMark().equals(board[1][1].getMark()) && board[1][1].getMark().equals(board[2][2].getMark()) && board[0][0].getMark() != Mark.E) {
			return board[0][0].getMark();
		}
		if(board[2][0].getMark().equals(board[1][1].getMark())&& board[1][1].getMark().equals(board[0][2].getMark()) && board[2][0].getMark() != Mark.E) {
			return board[2][0].getMark();
		}
		

		//Otherwise nobody has not won yet
		return Mark.E;

	}

	

}
