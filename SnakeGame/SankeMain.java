package SnakeGame;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class SankeMain extends JFrame implements WindowListener{
	SankeMain(){
			setSize(905,700);
			setLocationRelativeTo(null);
			setResizable(false);
			setTitle("Snake Game");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
			GameBody gb=new GameBody();
			gb.setBackground(Color.DARK_GRAY);
			add(gb);
			addWindowListener(this);
			setVisible(true);
		}
		@Override
	public void windowOpened(WindowEvent e) {}
	@Override
	public void windowClosing(WindowEvent e) {
		int a=JOptionPane.showConfirmDialog(this,"Do you wnat to quit ?" , "Quit Game", JOptionPane.YES_NO_OPTION);
		if(a==JOptionPane.YES_OPTION){
			System.exit(0);
		}
		if(a==JOptionPane.NO_OPTION){
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		}
	}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}
	}
