package SnakeGame;

import java.awt.Color;

import javax.swing.*;

public class GameAbout extends JFrame {
	GameAbout(){
		setSize(450,400);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setTitle("About");
		getContentPane().setBackground(Color.black);

		JTextArea t=new JTextArea();
		t.setBounds(10,10,415,345);
		t.setEditable(false);
		t.setLineWrap(true);
		t.setText("The history of the Snake game goes back to the 1970's. However, it was the \n1980's when the game took on the look that we will be using. It was sold under \nnumerous names and many platforms but probably gained widespread \nrecognition when it was shipped as standard on Nokia mobile phones in the \nlate 1990's.\n\nThe game involves controlling a single block or snakehead by turning only left or \nright by ninety degrees until you manage to eat an apple. When you get the \napple, the Snake grows an extra block or body segment.\n\nIf, or rather when, the snake bumps into the edge of the screen or accidentally \neats himself the game is over. The more apples the snake eats the higher the \nscore.");
		t.getText();
		t.setText(t.getText()+"\n\n\n\n\n\n-:- Himanshu Suthar\n-:- himanshusu02091@gmail.com\n-:- Contact no.=> +91 7014850144");

		add(t);
		setVisible(true);
	}
}