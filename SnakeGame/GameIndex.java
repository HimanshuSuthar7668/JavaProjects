package SnakeGame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class GameFirstInterface extends JFrame implements ActionListener {
	private JButton b1,b2,b3,b4;
	private JLabel l1,l2,l3;
	private Timer t;
	private JWindow w;
	private JProgressBar pb;

	GameFirstInterface(){
		displayWelcomeScreen();

		setSize(450,400);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		getContentPane().setBackground(Color.DARK_GRAY);
		setTitle("-: Snake Game :-");
		
		Font f=new Font("Arial", Font.BOLD+Font.ITALIC, 20);
		Font f1=new Font("Arial", Font.BOLD, 18);

		l1=new JLabel();
		l1.setText("-: Snake Game :-");
		l1.setBounds(50,10,350,100);
		l1.setForeground(Color.orange);
		l1.setFont(new Font("Brush Script MT", Font.BOLD, 46));
		add(l1);

		JLabel u=new JLabel("=============================");
		u.setBounds(50,80,350,20);
		u.setForeground(Color.YELLOW);
		u.setFont(new Font("Brush Script MT", Font.BOLD, 16));
		add(u);

		b1=new JButton("Start");
		b1.setBounds(250,120,120,50);
		b1.setBackground(Color.white);
		b1.setForeground(Color.BLACK);
		b1.setFont(f1);
		add(b1);

		b2=new JButton("Controls");
		b2.setBounds(250,180,120,50);
		b2.setBackground(Color.white);
		b2.setForeground(Color.BLACK);
		b2.setFont(f1);
		add(b2);

		b3=new JButton("About");
		b3.setBounds(150,260,100,30);
		b3.setBackground(Color.lightGray);
		b3.setForeground(Color.black);
		add(b3);

		b4=new JButton("More Games");
		b4.setBounds(260,260,150,30);
		b4.setBackground(Color.lightGray);
		b4.setForeground(Color.black);
		add(b4);

		l2=new JLabel("New Game");
		l2.setBounds(50,120,150,50);
		l2.setForeground(Color.WHITE);
		l2.setFont(f);
		add(l2);

		l3=new JLabel("Game Controls");
		l3.setBounds(50,180,150,50);
		l3.setForeground(Color.WHITE);
		l3.setFont(f);
		add(l3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		setVisible(true);
	}
	private void displayWelcomeScreen(){
		w=new JWindow(this);
        w.setSize(550,500);
        w.setLocationRelativeTo(null);
        w.setVisible(true);
		w.getContentPane().setBackground(Color.darkGray);
        JPanel p=new JPanel();
        w.add(p);
        p.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel l=new JLabel();
		l.setBounds(10,10,515,445);
		l.setForeground(Color.gray);
		p.add(l);
		l.setIcon(new ImageIcon(getClass().getResource("Welcome.png")));

        pb=new JProgressBar(0,100);
        w.add(BorderLayout.PAGE_END,pb);
        w.revalidate();
        
        t=new Timer(30,this);
        t.start();
	}
	public void actionPerformed(java.awt.event.ActionEvent e){
		int x=pb.getValue();
        if(x==100){
            w.dispose();
            GameFirstInterface.this.setVisible(true);
            t.stop();
        }
        else{
            pb.setValue(x+5);
        }
		try{
			if(e.getSource()==b1){
				new SankeMain();
				dispose();
			}
			if(e.getSource()==b2){
				new GameControls();
			}
			if(e.getSource()==b3){
				new GameAbout();
			}
			if(e.getSource()==b4){
				openWebPage("https://www.miniclip.com/games");
			}
		}
		catch(Exception ex){
			l1.setText("Something Went Wrong...!");
		}
	}
	public void openWebPage(String url){
		try {         
		  java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
		}
		catch (java.io.IOException e) {
			System.out.println(e.getMessage());
		}
	 }
}
public class GameIndex {
	public static void main(String[] args) {
		new GameFirstInterface().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;	
	}
}