package fr.uga.miashs;

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
	 * the value of name
	 */
	private static final String NAME = "Jeu de Morpion";
	private static JButton button1, button2, button3, button4, button5, button6, button7, button8, button9;
	private static JFrame grille; //600x600
	private static int mouve = 0;
	private static boolean win = false;
	private static JButton but = null;
	private static int[][] res = new int [3][3]; //use to calculate result

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
		grille.setSize(600, 600);
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
		if (mouve % 2 == 0) {
			//first player
			fistPlayer = true;
			return fistPlayer;

		} else {
			fistPlayer = false;
			return fistPlayer;
		}
	}

	/**
	 * function : handle action of button
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

	public static void setFont(JButton button) {
		Font font = new Font("Serief", Font.ITALIC, 78);
		button.setFont(font);
	}

	/**
	 * @param button
	 * @function handle action
	 */
	public static void actionHandler(final JButton button) {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button && countTour() && mouve <=9) {
					//first player
					button.setForeground(Color.BLACK);//??? no effect
					button.setText("X");
					button.setEnabled(false);
					mouve++;
					switch (button.getText()){
						case "button1" :
							res[0][0] = 1;
							break;
						case "button2" :
							res[0][1] = 1;
							break;
						case "button3" :
							res[0][2] = 1;
							break;
						case "button4" :
							res[1][0] = 1;
							break;
						case "button5" :
							res[1][1] = 1;
							break;
						case "button6" :
							res[1][2] = 1;
							break;
						case "button7" :
							res[2][0] = 1;
							break;
						case "button8" :
							res[1][0] = 1;
							break;
					}

				} else if (e.getSource() == button && !countTour() && mouve <= 9) {
					//second player
					button.setForeground(Color.RED);//??? no effect
					button.setText("O");
					button.setBackground(Color.YELLOW);
					button.setEnabled(false);
					but = button;
					mouve++;
				}
			}
		});
	}

	public static void checkWin(){
     int count = 0;


	}

}
