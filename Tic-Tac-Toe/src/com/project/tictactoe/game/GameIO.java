package com.project.tictactoe.game;

import java.util.ArrayList;
import java.util.Scanner;

import com.project.tictactoe.cell.Cell;
import com.project.tictactoe.mark.Mark;
import com.project.tictactoe.player.Player;
import com.techlab.tictactoe.ResultEnum;

public class GameIO implements IGameioable {
	private int size;
	private Player player;
	private Scanner input = new Scanner(System.in);;
	private Game game;
	private ArrayList<Integer> array;

	public GameIO() {
		game = new Game(boardSize());

	}

	public int boardSize() {
		System.out.println("Enter Board Size");
		return this.size = input.nextInt();

	}

	public void getUserName() {

		System.out.println("Let's play Tic Tac Toe!");
		System.out.print("Player 1, what is your name? \n");
		String p1 = input.next();
		System.out.print("Player 2, what is your name? \n");
		String p2 = input.next();
		player = new Player(p1, p2);

		player.setPlayer1(true);
		player.setPlayer2(false);

	}

	public void play() {
		this.drawBoard(game.getBoard().getCells());
		this.getUserName();

		while (true) {

			this.drawBoard(game.getBoard().getCells());

			this.whoseTurn(game.takeInput());
			while (true) {
				int i = game.putMark(this.userPosition());
				if (i == 1 || i == 2) {
					this.boardValidator(i);
				} else {
					break;
				}
			}
			game.setMark();
			int i = game.resultAnalysis();
			if (i == 1 || i == 2 || i == 3) {
				this.printResult(i);
				break;
			}
		}
		this.drawBoard(game.getBoard().getCells());

	}

	public void boardValidator(int i) {
		if (i == 1) {
			System.out.println("This position is off the bounds of the board! Try again.");
			this.drawBoard(game.getBoard().getCells());
		} else if (i == 2) {
			System.out.println("Someone has already made a move at this position! Try again.");
			this.drawBoard(game.getBoard().getCells());
		} else if (i == 0)
			System.err.println("System Error");
	}

	public ArrayList<Integer> userPosition() {
		array = new ArrayList<Integer>();
		System.out.print("Enter a row number (0, 1, or 2): ");
		int row = input.nextInt();
		System.out.print("Enter a column number (0, 1, or 2): ");
		int col = input.nextInt();

		array.add(row);
		array.add(col);
		return array;

	}

	public void printResult(int i) {
		if (i == 1)
			System.out.println(player.getP1() + " has " + ResultEnum.Won);
		else if (i == 2)
			System.out.println(player.getP2() + " has " + ResultEnum.Won);
		else if (i == 3)
			System.out.println("It's a " + ResultEnum.Tie);
		else {
			System.err.print("System Error");
		}

	}

	public void whoseTurn(int i) {
		if (i == 1)
			System.out.println(player.getP1() + "'s Turn (" + Mark.X + "):");
		else if (i == 2) {
			System.out.println(player.getP2() + "'s Turn (" + Mark.O + "):");
		} else {

		}
	}

	@Override
	public void drawBoard(Cell[][] board) {
		// TODO Auto-generated method stub

		System.out.println("Board:");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(board[i][j].getMark());
			}
			System.out.println();
		}

	}

}
