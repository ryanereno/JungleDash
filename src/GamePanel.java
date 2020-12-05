import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

// This class represents the view
public class GamePanel extends JPanel implements Runnable, KeyListener {
	private Player p;
	private GameManager manager;
	private Ground ground;
	Thread thread;
	private int score;
	private boolean displayDeath;

	public GamePanel(Player p, GameManager manager, Ground ground) {
		this.p = p;
		this.manager = manager;
		this.ground= ground;
	}

	// These lines of code were originally in the GamePanel constructor, but that made the game start once the panel was
	// created. Moving it here allows the GamePanel to be made without having the game to start instantly
	public void startGame(){
		score = 0;
		displayDeath = false;
		thread = new Thread(this);
		thread.start();
		obstacleGeneration();
	}

	public void obstacleGeneration() {
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		            	manager.addObstacle();	 // Adding obstacles needs a separate delay to make sure objects are created at
		            }							 // a reasonable rate
		            
		        }, 
		       0, 1500
		);
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ground.draw(g);
		p.draw(g);
		manager.draw(g);
	    g.setColor(Color.WHITE);
	    g.setFont(new Font("Serif", Font.BOLD, 25));
	    g.drawString("Score: " + Integer.toString(score), 500, 30);		// display score
	    if(displayDeath) {												// display death screen
	 	    g.setFont(new Font("Serif", Font.BOLD, 35));
	 	    g.drawString("You Died", 245, 90);

			g.setFont(new Font("Serif", Font.BOLD, 20));
			g.drawString("Press Enter to play again", 205, 120);
			g.drawString("or Backspace to quit", 227, 145);
	    }
	}
	public void updateGame() {
		updateScore();
		ground.update();
		manager.update();
	}
	public void updateScore() {
		score++;
	}
	public void deathScreen() {
		displayDeath = true;
		repaint();
	}

	//Used to restart the game
	public void resetPanel() {
		manager.resetGame();
		displayDeath = false;
		score = 0;
		thread = new Thread(this);
		thread.start();
	}
	@Override
	public void run() {
		while(true) {
			updateGame();
			repaint();
			try {
				Thread.sleep(100);				// put a slight delay
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(p.isDead()) {
				deathScreen();
				break;
			}
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {				// note, there is a slight delay between space bar being press and jumping
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {		// spam clicking jump doesn't work and is unpredictable
			manager.playerJump();
			new java.util.Timer().schedule( 			// set a delay for how long the Player is in the air before returning back to the ground
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			            	manager.playerDefault();
			            }
			        }, 
			        400
			);
		}
		if(e.getKeyCode() == KeyEvent.VK_S){
			manager.playerDuck();
			new java.util.Timer().schedule(
					new java.util.TimerTask(){
						@Override
						public void run(){
							manager.playerDefault();
						}
					},400
			);
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			/*
				Something interesting to note when the if-statement is not added: If Enter is pressed in the middle of
				the game, the game resets, but it goes faster. If you press Enter multiple times, the game goes even
				faster. The program may crash sometimes when Enter is pressed multiple times.

				The if-statement was added to keep the game consistent with its speed, but it could be taken out to
				allow the user to increase the speed (and therefore difficulty). It may be risky to do this since the
				program can crash in some cases.
			 */
			if(p.isDead()) {
				resetPanel();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			// Makes sure game is over before game can be exited
			if(p.isDead()) {
				System.exit(0);
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
