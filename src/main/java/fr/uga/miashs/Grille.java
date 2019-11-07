package fr.uga.miashs;

import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;

/**
 * @author Cheng Xinyun
 * @function plateau de jeu
 */

public class Grille {

	private static JButton button1, button2, button3, button4, button5, button6, button7, button8, button9;

	public static void PrintGrille() {
		button1 = new JButton();
		button1.setBackground(Color.WHITE);
		button2 = new JButton();
		button2.setBackground(Color.WHITE);
		button3 = new JButton();
		button3.setBackground(Color.WHITE);
		button4 = new JButton();
		button4.setBackground(Color.WHITE);
		button5 = new JButton();
		button5.setBackground(Color.WHITE);
		button6 = new JButton();
		button6.setBackground(Color.WHITE);
		button7 = new JButton();
		button7.setBackground(Color.WHITE);
		button8 = new JButton();
		button8.setBackground(Color.WHITE);
		button9 = new JButton();
		button9.setBackground(Color.WHITE);

		JFrame frame = new JFrame("Jeu de Morpion");
		frame.setLayout(new GridLayout(3, 3));
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);
		frame.add(button5);
		frame.add(button6);
		frame.add(button7);
		frame.add(button8);
		frame.add(button9);

		frame.setSize(400, 400);
		frame.setLocation(300, 200);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		PrintGrille();
	}
}
