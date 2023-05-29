package SnakeGame;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class GameBody extends JPanel implements ActionListener,KeyListener{
	//Snake Body Size
	private int[] snake_x_length=new int[750];
	private int[] snake_y_length=new int[750];
	private int snakelength=3;
	//Snake Direction
	private Boolean left=false;
	private Boolean right=true;
	private Boolean up=false;
	private Boolean down=false;

	//initial state
	private int moves=0;
	private int score=0;
	private Boolean gameOver=false;
	private ImageIcon title=new ImageIcon(getClass().getResource("title.png"));//Title Image
	//Snake Body parts
	private ImageIcon leftmouth=new ImageIcon(getClass().getResource("leftmouth.png"));
	private ImageIcon rightmouth=new ImageIcon(getClass().getResource("rightmouth.png"));
	private ImageIcon upmouth=new ImageIcon(getClass().getResource("upmouth.png"));
	private ImageIcon downmouth=new ImageIcon(getClass().getResource("downmouth.png"));
	private ImageIcon snake_image=new ImageIcon(getClass().getResource("snakeimage.png")); 

	//Enemy random Position
	private ImageIcon enemy=new ImageIcon(getClass().getResource("enemy.png"));
	private int[] xpos={25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,
		400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
	private int[] ypos={75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};

	private Random random=new Random();
	private int enemy_x,enemy_y;

	private Timer timer;
	private int delay=100;
	GameBody(){
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		timer=new Timer(delay, this);
		timer.start();
		newEnemy();
	}
	private void attackEnemy(){
		if(snake_x_length[0]==enemy_x && snake_y_length[0]==enemy_y){
			newEnemy();
			snakelength++;
			score=score+2;
		}
	}
	private void newEnemy(){
		enemy_x=xpos[random.nextInt(34)];
		enemy_y=ypos[random.nextInt(23)];

		//Enemy snake k upar na jae isliye
		for(int i=snakelength-1;i>=0;i--){
			if(snake_x_length[i]==enemy_x && snake_y_length[i]==enemy_y){
				newEnemy();
			}
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		//Game Body
		g.setColor(Color.WHITE);
		g.drawRect(24, 10, 851, 55);
		g.drawRect(24, 74, 851, 576);
		title.paintIcon(this, g, 25, 11);
		g.setColor(Color.BLACK);
		g.fillRect(25, 75, 850, 575);

		// Sanke Body
		if(moves==0){
			snake_x_length[0]=100;
			snake_x_length[1]=75;
			snake_x_length[2]=50;

			snake_y_length[0]=100;
			snake_y_length[1]=100;
			snake_y_length[2]=100;
		}
		if(left){
			leftmouth.paintIcon(this, g, snake_x_length[0], snake_y_length[0]);
		}
		if(right){
			rightmouth.paintIcon(this, g, snake_x_length[0], snake_y_length[0]);
		}
		if(up){
			upmouth.paintIcon(this, g, snake_x_length[0], snake_y_length[0]);
		}
		if(down){
			downmouth.paintIcon(this, g, snake_x_length[0], snake_y_length[0]);
		}
		for(int i=1;i<snakelength;i++){
			snake_image.paintIcon(this, g, snake_x_length[i], snake_y_length[i]);
		}
		enemy.paintIcon(this, g, enemy_x, enemy_y);

		if(gameOver){
			g.setColor(Color.YELLOW);
			g.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 50));
			g.drawString("Game Over", 300, 300);
			
			g.setFont(new Font("Arial", Font.PLAIN, 20));
			g.drawString("Press SPACE for restart", 325, 350);
		}

		g.setColor(Color.yellow);
		g.setFont(new Font("Arial",Font.BOLD,14));
		g.drawString("Q=Quit", 55, 30);
		g.drawString("P=Pause/Play", 55, 50);

		g.setColor(Color.YELLOW);
		g.setFont(new Font("Arial",Font.BOLD,14));
		g.drawString("Score : "+score*3, 750, 30);
		g.drawString("Length : "+snakelength, 750, 50);
		g.dispose();
	}
	public void actionPerformed(ActionEvent e){
		for(int i=snakelength-1;i>0;i--){
			snake_x_length[i]=snake_x_length[i-1];
			snake_y_length[i]=snake_y_length[i-1];
		}
		if(left){
			snake_x_length[0]=snake_x_length[0]-25;
		}
		if(right){
			snake_x_length[0]=snake_x_length[0]+25;
		}
		if(up){
			snake_y_length[0]=snake_y_length[0]-25;
		}
		if(down){
			snake_y_length[0]=snake_y_length[0]+25;
		}
		if(snake_x_length[0]>850){
			snake_x_length[0]=25;
		}
		if(snake_x_length[0]<25){
			snake_x_length[0]=850;
		}
		if(snake_y_length[0]>625){
			snake_y_length[0]=75;
		}
		if(snake_y_length[0]<75){
			snake_y_length[0]=625;
		}
		
		attackEnemy();
		attackItSelf();

		repaint();
	}
	public void keyPressed(KeyEvent e){
		try{
			if(e.getKeyCode()==KeyEvent.VK_P){
				if(timer.isRunning()){
					timer.stop();
				}
				else{
					timer.start();
				}
			}
			if(e.getKeyCode()==KeyEvent.VK_Q){
				timer.stop();
				quitgame();
			}
			if(e.getKeyCode()==KeyEvent.VK_SPACE){
				restart();
			}
			if(e.getKeyCode()==KeyEvent.VK_LEFT && (!right)){
				left=true;
				right=false;
				up=false;
				down=false;
				moves++;
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT && (!left)){
				left=false;
				right=true;
				up=false;
				down=false;
				moves++;
			}
			if(e.getKeyCode()==KeyEvent.VK_UP && (!down)){
				left=false;
				right=false;
				up=true;
				down=false;
				moves++;
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN && (!up)){
				left=false;
				right=false;
				up=false;
				down=true;
				moves++;
			}
			if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
				new GameFirstInterface();
			}
		}
		catch(UnsupportedOperationException ex){
			System.out.println(ex);
		}
	}
	public void keyReleased(KeyEvent e){
		
	}
	public void keyTyped(KeyEvent e){
		
	}
	private void attackItSelf(){
		for(int i=snakelength-1;i>0;i--){
			if(snake_x_length[i]==snake_x_length[0] && snake_y_length[i]==snake_y_length[0]){
				timer.stop();
				gameOver=true;
			}
		}
	}
	private void quitgame(){
		int a=JOptionPane.showConfirmDialog(this,"Do you wnat to quit ?" , "Quit Game", JOptionPane.YES_NO_OPTION);
		if(a==JOptionPane.YES_OPTION){
			System.exit(0);
		}
		if(a==JOptionPane.NO_OPTION){
			timer.stop();
			new GameBody();
		}
	}
	private void restart(){
		gameOver=false;
		moves=0;
		score=0;
		snakelength=3;
		left=false;
		right=true;
		up=false;
		down=false;
		timer.start();
		newEnemy();
		repaint();
	}
}