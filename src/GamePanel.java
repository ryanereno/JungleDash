import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 * GamePanel class that creates the game screen
 * This class is one of the Views in the MVC design patteern
 */
public class GamePanel extends JPanel implements Runnable, KeyListener {
	private Player p;		// The player character
	private GameManager manager;		// The manager (control) of the game
	private Ground ground;		// The ground of the game
	Thread thread;
	private int score;			// Keeps track of game score
	private boolean displayDeath;		//Indicates whether player is dead

	/**
	 * Constructs GamePanel object
	 *
	 * @param p the player character of the game
	 * @param manager the manager (control) of the game
	 * @param ground the ground of the game
	 */
	public GamePanel(Player p, GameManager manager, Ground ground) {
		this.p = p;
		this.manager = manager;
		this.ground= ground;
	}

	/**
	 * Starts the program's game
	 */
	public void startGame(){
		score = 0;
		displayDeath = false;
		thread = new Thread(this);
		thread.start();
		obstacleGeneration();
	}

	/**
	 * Generates obstacles that will be added during the game
	 */
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

	/**
	 * Adds the game content to the game
	 *
	 * @param g Graphics object that is used to add the game content
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ground.draw(g);
		p.draw(g);
		manager.draw(g);

	    g.setColor(Color.WHITE);
	    g.setFont(new Font("Serif", Font.BOLD, 25));
	    g.drawString("Score: " + Integer.toString(score), 500, 30);	// Display score

	    if(displayDeath) {		// Display death screen
	 	    g.setFont(new Font("Serif", Font.BOLD, 35));
	 	    g.drawString("You Died", 245, 90);

			g.setFont(new Font("Serif", Font.BOLD, 20));
			g.drawString("Press Enter to play again", 205, 120);
			g.drawString("or Backspace to quit", 227, 145);		// Game restart/exit message
	    }
	}

	/**
	 * Updates the game
	 */
	public void updateGame() {
		updateScore();
		ground.update();
		manager.update();
	}

	/**
	 * Updates the score of the game
	 */
	public void updateScore() {
		score++;
	}

	/**
	 * Invokes death screen
	 */
	public void deathScreen() {
		displayDeath = true;
		repaint();
	}

	/**
	 * Resets the game screen and starts a new game
	 */
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
				Thread.sleep(100);		// Puts a slight delay
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
	public void keyPressed(KeyEvent e) {		// Makes the Player character jump
		// Note: There is a slight delay between space bar being press and jumping
		// spam clicking jump doesn't work and is unpredictable
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			manager.playerJump();
			new java.util.Timer().schedule( 	// Sets a delay for how long the Player is in the air before returning back to the ground
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			            	manager.playerDefault();
			            }
			        }, 
			        400
			);
		}
		if(e.getKeyCode() == KeyEvent.VK_S){		// Makes the Player character duck
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
		if(e.getKeyCode() == KeyEvent.VK_ENTER){		// Starts a new game
			// Makes sure current game is over before user can start a new game
			if(p.isDead()) {
				resetPanel();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {		// Exits ga,e
			// Makes sure current game is over before game can be exited
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
