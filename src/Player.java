import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Class that represents the Player, who tries to dodge obstacles by jumping and ducking while running
 * If they collide with an Obstacle, they die, and the longer they stay alive, the higher their score will be 
 * Represents one of the Models in the MVC design pattern
 */
public class Player {
	private int x; 								// Player's x-coordinate
	private int y; 								// Player's y-coordinate
	private boolean running; 					// checks if Player is in the running state
	private boolean dead; 						// checks if Player is dead
	private boolean ducking; 					// checks if Player is in the ducking state
	private boolean jumping; 					// checks if Player is in the jumping state
	private int animationIndex; 				// keeps track of what running animation we currently have
	Image runPlayer1 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_run1.png")).getImage(); // Player's first running image/animation
	Image runPlayer2 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_run2.png")).getImage(); // Player's second running image/animation
	Image runPlayer3 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_run3.png")).getImage(); // Player's third running image/animation
	Image runPlayer4 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_run4.png")).getImage(); // Player's fourth running image/animation
	Image jumpPlayer = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_jump.png")).getImage(); // Player's jumping image
	Image deadPlayer = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_death.png")).getImage();// Player's death image
	Image duckPlayer = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_duck.png")).getImage(); // Player's ducking image

	/**
	 * Constructs the Player object
	 */
	public Player() {
		running = true;
		dead = false;
		jumping = false;
		ducking = false;
		x = 10;
		y = 213;
		animationIndex = 1;
	}

	/**
	 * @return Player's x-coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return Player's y-coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Make the Player die
	 */
	public void die() {
		dead = true;
	}
		
	/**
	 * Revive the Player after restarting game
	 */
	public void revive() {
		dead = false;
	} 

	/**
	 * @return whether the Player is dead or alive
	 */
	public boolean isDead() {
		return dead;
	}

	// The following three methods are used in JUnit testing
	/**
	 * @return whether or not the Player is in the running state
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * @return whether or not the Player is in the ducking state
	 */
	public boolean isDucking() {
		return ducking;
	}

	/**
	 * @return whether or not the Player is in the jumping state
	 */
	public boolean isJumping() {
		return jumping;
	}

	/**
	 * Make the Player jump
	 */
	public void jump() {
		running = false;
		jumping = true;
		y = 180;  // After jumping, change the player's height
	}

	/**
	 * Make the Player reset to normal running position
	 */
	public void defaultPosition() {
		running = true;
		jumping = false;
		ducking = false;
		y = 213;  // After player finishes jumping or ducking, set y coordinate back to normal
	}

	/**
	 * Make the Player duck
	 */
	public void duck() {
		running = false;
		ducking = true;
		y = 220;  // After ducking, change players height
	}

	/**
	 * @param g Graphics
	 * Draws the Player based on their current state
	 */
	public void draw(Graphics g) {
		if (running) {											 // If the Player is running, draw them based on the current animationIndex
			if (animationIndex == 1) {
				g.drawImage(runPlayer1, getX(), getY(), null);
			} else if (animationIndex == 2) {
				g.drawImage(runPlayer2, getX(), getY(), null);
			} else if (animationIndex == 3) {
				g.drawImage(runPlayer3, getX(), getY(), null);
			} else {
				g.drawImage(runPlayer4, getX(), getY(), null);
			}
			animationIndex++;                                    // increment animationIndex to get the next animation next time we call draw
			if (animationIndex == 5) {                           // if animationIndex is 5, reset it back to 1
				animationIndex = 1;
			}
		} else if (dead) {
			g.drawImage(deadPlayer, getX(), getY(), null);
		} else if (jumping) {
			g.drawImage(jumpPlayer, getX(), getY(), null); 
		} else if (ducking) {
			g.drawImage(duckPlayer, getX(), getY(), null);
		}
	}
}
