package com.tictactoe.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.project.tictactoe.cell.Cell;
import com.project.tictactoe.game.Game;
import com.project.tictactoe.mark.Mark;
import com.project.tictactoe.mark.ResultEnum;
import com.project.tictactoe.player.Player;

public class TicTacToeFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	public final static int SIZE = 3;
	static JButton buttonArray[][];
	private Game game;
	static JFrame frame;
	static JPanel panel, panel_banner, panel_cmds, title_banner;
	static JLabel ltitle, player_1, ltotal, gameStatus;
	static JTextField tf1, gameStatusText, tf3;
	static JButton b_restart, b_help;
	static int pressed_cnt;
	private Player player;
	static String turn, msg;
	private static ArrayList<Integer> array;

	// Constructor.
	public TicTacToeFrame() {

		pressed_cnt = 0;
		turn = "player1";
		// setting up labels.
		ltitle = new JLabel("TIC TAC TOE");
		ltitle.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 48));
		player_1 = new JLabel("Current Turn : ");
		ltotal = new JLabel("Game Count: ");
		gameStatus = new JLabel("Game Status: ");

		// setting up text fields
		tf1 = new JTextField("Player1", 10);
		tf1.setEditable(false);
		gameStatusText = new JTextField("", 10);
		gameStatusText.setEditable(false);
		tf3 = new JTextField("0", 10);
		tf3.setEditable(false);

		// setting up buttons.
		b_restart = new JButton("START AGAIN");
		b_help = new JButton("HELP/ABOUT");
		// setting up panel.
		// panel for banner.
		panel_banner = new JPanel();
		panel_banner.setBackground(Color.lightGray);
		panel_banner.setLayout(new java.awt.GridLayout(4, 2));

		panel_banner.add(player_1);
		panel_banner.add(tf1);
		// panel_banner.add(player_2);

		panel_banner.add(ltotal);
		panel_banner.add(tf3);
		panel_banner.add(gameStatus);
		panel_banner.add(gameStatusText);

		panel_banner.add(b_restart);
		panel_banner.add(b_help);

		title_banner = new JPanel();
		title_banner.setLayout(new java.awt.GridLayout(2, 1));
		title_banner.add(ltitle);
		title_banner.add(panel_banner);
		// panel for buttons
		panel = new JPanel();
		panel.setLayout(new java.awt.GridLayout(3, 3));
		panel.setBounds(50, 10, 100, 100);
		// panel for commands and results

		panel_cmds = new JPanel();
		panel_cmds.add(title_banner);

		// Seeting up frame.
		frame = new JFrame("TIC TAC TOE ");
		frame.setSize(650, 300);
		frame.setResizable(true);

		frame.setLayout(new java.awt.GridLayout(1, 2));
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);

		// adding components.
		// frame.add(panel_banner);
		// frame.add(ltitle);
		frame.add(panel);
		frame.add(panel_cmds);

		// welcome message
		JOptionPane.showMessageDialog(frame, "WELCOME TO THIS GAME", "WELCOME", JOptionPane.INFORMATION_MESSAGE);

		// registering action listener
		b_help.addActionListener(this);
		b_restart.addActionListener(this);
		buttonArray = new JButton[SIZE][SIZE];
		this.drawButtons();
		this.startGame();
	}

	public void startGame() {
		game = new Game(SIZE);
		this.enableAll();
		this.drawBoard(game.getBoard().getCells());
		this.getUserName();
	}

	private void enableAll() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				buttonArray[i][j].setEnabled(true);
				;
			}
		}
	}

	public void drawButtons() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {

				buttonArray[i][j] = new JButton();
				buttonArray[i][j].addActionListener(this);
				buttonArray[i][j].setEnabled(true);
				buttonArray[i][j].setBackground(Color.white);
				panel.add(buttonArray[i][j]);
			}
		}
	}

	public void drawBoard(Cell[][] cells) {
		int count = 1;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				buttonArray[i][j].setActionCommand(String.valueOf(count++));
				buttonArray[i][j].setText(String.valueOf(cells[i][j].getMark()));
				buttonArray[i][j].setBackground(Color.white);
				if (buttonArray[i][j].getText() != Mark.E.toString()) {
					buttonArray[i][j].setEnabled(false);
				}
			}
		}
	}

	public void getUserName() {

		String p1 = "Saket";
		String p2 = "Racket";
		player = new Player(p1, p2);
		player.setPlayer1(true);
		player.setPlayer2(false);

	}

	public void play(ArrayList<Integer> array) {
		this.drawBoard(game.getBoard().getCells());
		gameStatusText.setText("Game In Progress");
		this.drawBoard(game.getBoard().getCells());
		this.whoseTurn(game.takeInput());
		int i = game.putMark(array);
		if (i == 1 || i == 2) {
			this.boardValidator(i);
		} else {
		}
		game.setMark();
		int i1 = game.resultAnalysis();
		if (i1 == 1 || i1 == 2 || i1 == 3) {
			this.printResult(i1);
		}
		this.drawBoard(game.getBoard().getCells());
	}

	public void boardValidator(int i) {
		if (i == 1) {
			msg = "This position is off the bounds of the board! Try again.";
			JOptionPane.showMessageDialog(frame, msg, "Select Again", JOptionPane.INFORMATION_MESSAGE);
			this.drawBoard(game.getBoard().getCells());
		} else if (i == 2) {
			msg = "Someone has already made a move at this position! Try again.";
			JOptionPane.showMessageDialog(frame, msg, "Select Again", JOptionPane.INFORMATION_MESSAGE);
			this.drawBoard(game.getBoard().getCells());
		} else if (i == 0)
			System.err.println("System Error");
	}

	public void printResult(int i) {
		if (i == 1) {
			msg = player.getP1() + " has " + ResultEnum.Won;
			JOptionPane.showMessageDialog(frame, msg, "Game Over", JOptionPane.INFORMATION_MESSAGE);
			gameStatusText.setText("Game Ended");
			this.disableAll();
		} else if (i == 2) {
			msg = player.getP2() + " has " + ResultEnum.Won;
			JOptionPane.showMessageDialog(frame, msg, "Game Over", JOptionPane.INFORMATION_MESSAGE);
			gameStatusText.setText("Game Ended");
			this.disableAll();
		} else if (i == 3) {
			msg = "It's a " + com.project.tictactoe.mark.ResultEnum.Tie;
			JOptionPane.showMessageDialog(frame, msg, "Game Over", JOptionPane.INFORMATION_MESSAGE);
			gameStatusText.setText("Game Ended");
			this.disableAll();
		} else {
			System.err.print("System Error");
		}

	}

	public void disableAll() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				buttonArray[i][j].setEnabled(false);
			}
		}
	}

	public void whoseTurn(int i) {
		if (i == 1) {
			tf1.setText(player.getP1() + "'s Turn (" + Mark.X + "):");
		} else if (i == 2) {
			tf1.setText(player.getP2() + "'s Turn (" + Mark.O + "):");
		} else {

		}
	}

	public void resetAll() {
		int status;
		status = JOptionPane.showConfirmDialog(panel_banner, "ARE YOU SURE", "RESTART", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if (status == 0) {
			this.startGame();
		}
		tf3.setText(String.valueOf(TicTacToeFrame.pressed_cnt++));
	}

	public void helpUser() {
		msg = "\tTIC TAC TOE PROGRAM \n" + "/_______________________________\\\n" + "|    Its a two player game. \n"
				+ "| \tDefault Symbol:              \n" + "| \tPlayer 1= X                  \n"
				+ "| \tPlayer 2= O                  \n" + "\\______________________________/\n"
				+ " _______________________________\n";
		JOptionPane.showMessageDialog(panel_banner, msg, "HELP", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		array = new ArrayList<Integer>();
		switch (e.getActionCommand()) {
		case "1":
			array.add(0);
			array.add(0);
			play(array);
			break;
		case "2":
			array.add(0);
			array.add(1);
			play(array);
			break;
		case "3":
			array.add(0);
			array.add(2);
			play(array);
			break;
		case "4":
			array.add(1);
			array.add(0);
			play(array);
			break;
		case "5":
			array.add(1);
			array.add(1);
			play(array);
			break;
		case "6":
			array.add(1);
			array.add(2);
			play(array);
			break;
		case "7":
			array.add(2);
			array.add(0);
			play(array);
			break;
		case "8":
			array.add(2);
			array.add(1);
			play(array);
			break;
		case "9":
			array.add(2);
			array.add(2);
			play(array);
			break;
		case "START AGAIN":
			resetAll();
			break;
		case "HELP/ABOUT":
			helpUser();
			break;
		}

	}

}
