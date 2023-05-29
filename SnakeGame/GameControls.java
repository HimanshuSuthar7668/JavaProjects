package SnakeGame;
import java.awt.*;
import javax.swing.*;

public class GameControls extends JFrame {
	GameControls(){
		setSize(450,400);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setTitle("Controls");
		getContentPane().setBackground(Color.black);

		JLabel l=new JLabel();
		l.setBounds(10,10,415,345);
		l.setForeground(Color.gray);
		l.setIcon(new ImageIcon(getClass().getResource("Game_Control.png")));
		add(l);
		setVisible(true);
	}
}