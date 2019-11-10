package fr.uga.miashs.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * @author Cheng Xinyun
 * @version 1.0
 * @function plateau de jeu
 */

public class Grille {

	/**
	 * the name of game
	 */
	private static final String NAME = "Jeu de Morpion";
	private static JButton button1, button2, button3, button4, button5, button6, button7, button8, button9;
	private static JFrame grille; //600x600
	private static int mouvement = 0;
	private static boolean win = false; //check win
	public static JButton[][] buttons = new JButton[3][3]; //use to calculate result

	/**
	 * @function print chessboard
	 */
	public static void PrintGrille() {
		button1 = new JButton();
		setFont(button1);
		button1.setBackground(Color.WHITE);
		button2 = new JButton();
		setFont(button2);
		button2.setBackground(Color.WHITE);
		button3 = new JButton();
		setFont(button3);
		button3.setBackground(Color.WHITE);
		button4 = new JButton();
		setFont(button4);
		button4.setBackground(Color.WHITE);
		button5 = new JButton();
		setFont(button5);
		button5.setBackground(Color.WHITE);
		button6 = new JButton();
		setFont(button6);
		button6.setBackground(Color.WHITE);
		button7 = new JButton();
		setFont(button7);
		button7.setBackground(Color.WHITE);
		button8 = new JButton();
		setFont(button8);
		button8.setBackground(Color.WHITE);
		button9 = new JButton();
		setFont(button9);
		button9.setBackground(Color.WHITE);

		initializeButtons(buttons);

		grille = new JFrame(NAME);
		grille.setLayout(new GridLayout(3, 3));
		grille.add(button1);
		grille.add(button2);
		grille.add(button3);
		grille.add(button4);
		grille.add(button5);
		grille.add(button6);
		grille.add(button7);
		grille.add(button8);
		grille.add(button9);

		closeWindow();
		grille.setSize(400, 400);
		grille.setLocation(300, 200);
		grille.setVisible(true);
		grille.setResizable(false);

		actionButton();
	}


	/**
	 * @function close chessboard
	 * equals to grille.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	 */
	public static void closeWindow() {
		grille.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
	}

	/**
	 * @function count tour of players
	 * first player : X
	 * second player : O
	 */
	public static boolean countTour() {
		boolean fistPlayer;
		if (mouvement % 2 == 0) {
			//first player
			fistPlayer = true;
			return fistPlayer;

		} else {
			fistPlayer = false;
			return fistPlayer;
		}
	}

	/**
	 * @function : handle action of button
	 */
	public static void actionButton() {
		actionHandler(button1);
		actionHandler(button2);
		actionHandler(button3);
		actionHandler(button4);
		actionHandler(button5);
		actionHandler(button6);
		actionHandler(button7);
		actionHandler(button8);
		actionHandler(button9);
	}

	/**
	 * @param button
	 * @function set button font
	 */
	public static void setFont(JButton button) {
		Font font = new Font("Serief", Font.ITALIC, 58);
		button.setFont(font);
	}

	/**
	 * @param button
	 * @function handle action
	 */
	public static void actionHandler(final JButton button) {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button && countTour() && mouvement <= 9 && !win) {
					//first player X
					button.setForeground(Color.BLACK);//??? no effect
					button.setText("X");
					button.setEnabled(false);
					mouvement++;
					printButtons(buttons);
					checkWin();
				} else if (e.getSource() == button && !countTour() && mouvement <= 9 && !win) {
					//second player O
					button.setForeground(Color.RED);//??? no effect
					button.setText("O");
					button.setBackground(Color.YELLOW);
					button.setEnabled(false);
					mouvement++;
					printButtons(buttons);
					checkWin();
				}
			}
		});
	}

	/**
	 * @function if win stop game else continue game
	 * mouvement <= 9
	 */
	public static void checkWin() {
		if (buttons[0][2].getText().equals(buttons[1][2].getText()) && buttons[1][2].getText().equals(buttons[2][2].getText()) && buttons[2][2].getText().equals(buttons[0][2].getText()) && !buttons[1][2].getText().equals("")) {
			win = true;
			System.out.println(buttons[1][2].getText() + " wins!!!");
			JOptionPane.showMessageDialog(grille, buttons[1][2].getText() + " wins!!!");
			closeWindow();
		} else if (mouvement == 9) {
			win = true;
			System.out.println("Draw");
			JOptionPane.showMessageDialog(grille, "Draw");
			closeWindow();
		}
		if (buttons[0][1].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][1].getText()) && buttons[2][1].getText().equals(buttons[0][1].getText()) && !buttons[1][1].getText().equals("")) {
			win = true;
			System.out.println(buttons[1][1].getText() + " wins!!!");
			JOptionPane.showMessageDialog(grille, buttons[1][1].getText() + " wins!!!");
			closeWindow();
		} else if (mouvement == 9) {
			win = true;
			System.out.println("Draw");
			JOptionPane.showMessageDialog(grille, "Draw");
			closeWindow();
		}
		if (buttons[0][0].getText().equals(buttons[1][0].getText()) && buttons[1][0].getText().equals(buttons[2][0].getText()) && buttons[2][0].getText().equals(buttons[0][0].getText()) && !buttons[1][0].getText().equals("")) {
			win = true;
			System.out.println(buttons[1][0].getText() + " wins!!!");
			JOptionPane.showMessageDialog(grille, buttons[1][0].getText() + " wins!!!");
			closeWindow();
		} else if (mouvement == 9) {
			win = true;
			System.out.println("Draw");
			JOptionPane.showMessageDialog(grille, "Draw");
			closeWindow();
		}
		if (buttons[2][0].getText().equals(buttons[2][1].getText()) && buttons[2][1].getText().equals(buttons[2][2].getText()) && buttons[2][2].getText().equals(buttons[2][0].getText()) && !buttons[2][1].getText().equals("")) {
			win = true;
			System.out.println(buttons[2][1].getText() + " wins!!!");
			JOptionPane.showMessageDialog(grille, buttons[2][1].getText() + " wins!!!");
			closeWindow();
		} else if (mouvement == 9) {
			win = true;
			System.out.println("Draw");
			JOptionPane.showMessageDialog(grille, "Draw");
			closeWindow();
		}
		if (buttons[1][0].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[1][2].getText()) && buttons[1][2].getText().equals(buttons[1][0].getText()) && !buttons[1][1].getText().equals("")) {
			win = true;
			System.out.println(buttons[1][1].getText() + " wins!!!");
			JOptionPane.showMessageDialog(grille, buttons[1][1].getText() + " wins!!!");
			closeWindow();
		} else if (mouvement == 9) {
			win = true;
			System.out.println("Draw");
			JOptionPane.showMessageDialog(grille, "Draw");
			closeWindow();
		}
		if (buttons[0][0].getText().equals(buttons[0][1].getText()) && buttons[0][1].getText().equals(buttons[0][2].getText()) && buttons[0][2].getText().equals(buttons[0][0].getText()) && !buttons[0][1].getText().equals("")) {
			win = true;
			System.out.println(buttons[0][1].getText() + " wins!!!");
			JOptionPane.showMessageDialog(grille, buttons[0][1].getText() + " wins!!!");
			closeWindow();
		} else if (mouvement == 9) {
			win = true;
			System.out.println("Draw");
			JOptionPane.showMessageDialog(grille, "Draw");
			closeWindow();
		}
		if (buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][2].getText()) && buttons[2][2].getText().equals(buttons[0][0].getText()) && !buttons[1][1].getText().equals("")) {
			win = true;
			System.out.println(buttons[1][1].getText() + " wins!!!");
			JOptionPane.showMessageDialog(grille, buttons[1][1].getText() + " wins!!!");
			closeWindow();
		} else if (mouvement == 9) {
			win = true;
			System.out.println("Draw");
			JOptionPane.showMessageDialog(grille, "Draw");
			closeWindow();
		}
		if (buttons[0][2].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][0].getText()) && buttons[2][0].getText().equals(buttons[0][2].getText()) && !buttons[1][1].getText().equals("")) {
			win = true;
			System.out.println(buttons[1][1].getText() + " wins!!!");
			JOptionPane.showMessageDialog(grille, buttons[1][1].getText() + " wins!!!");
			closeWindow();
		} else if (mouvement == 9) {
			win = true;
			System.out.println("Draw");
			JOptionPane.showMessageDialog(grille, "Draw");
			closeWindow();
		}
	}

	/**
	 * @param buttons
	 * @function initialize table buttons to record status
	 */
	public static void initializeButtons(JButton[][] buttons) {
		buttons[0][0] = button1;
		buttons[0][1] = button2;
		buttons[0][2] = button3;
		buttons[1][0] = button4;
		buttons[1][1] = button5;
		buttons[1][2] = button6;
		buttons[2][0] = button7;
		buttons[2][1] = button8;
		buttons[2][2] = button9;
	}

	/**
	 * @param buttons
	 * @function print buttons table
	 */
	public static void printButtons(JButton[][] buttons) {

		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				if ("".equals(buttons[i][j].getText())) {
					System.out.print("-\t");
				} else {
					System.out.print(buttons[i][j].getText() + "\t");
				}
			}
			System.out.println();
		}
		System.out.println("-- " + mouvement + " tour --");
	}
}
