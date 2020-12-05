import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Class that represents a bird obstacle that the user must duck under to not collide with it
 * Represents one of the Models in the MVC design pattern
 */
public class Bird implements Obstacle {
	private int x;               // Bird's x-coordinate
	private int y;	             // Bird's y-coordinate		
	private int animationIndex;  // represents the current animation number of the bird
	Image birdImage1 = new ImageIcon(this.getClass().getResource("bird1.png")).getImage();  // first image/animation for bird
	Image birdImage2 = new ImageIcon(this.getClass().getResource("bird2.png")).getImage();  // second image/animation for bird
	Image birdImage3 = new ImageIcon(this.getClass().getResource("bird3.png")).getImage();  // third image/animation for bird

	/**
	 * Constructs the Bird object
	 */
	public Bird() {
		x = 680;
		y = 208;
		animationIndex = 1;
	}

	/**
	 * Checks and returns if the Bird is out of bounds
	 */
	@Override
	public boolean outOfBounds() {
		if (x < -20) {               // if most of the bird is offscreen, then it is out of bounds
			return true;
		}
		return false;					
	}

	/**
	 * @param g Graphics
	 * Draws the bird and makes it look animated
	 */
	@Override
	public void draw(Graphics g) {
		if (animationIndex == 1) {               // draws the bird image based on the current animationIndex
			g.drawImage(birdImage1, x, y, null);
		} else if (animationIndex == 2) {
			g.drawImage(birdImage2, x, y, null);
		} else {
			g.drawImage(birdImage3, x, y, null);
		}
		animationIndex++;                       // increment animationIndex to get the next animation next time we call draw
		if (animationIndex == 4) {              // if animationIndex is 4, reset it back to 1
			animationIndex = 1;
		}
	}

	/**
	 * Updates the x-position of the Bird 
	 */
	@Override
	public void update() {
		x -= 40;
	}
	
	/**
	 * @param playerX represents the Player's x-coordinate
	 * @param playerY represents the Player's y-coordinate
	 * Checks if Player's x and y-coordinates are approximately at the Bird's x and y-coordinates to check and return if they collided
	 */
	public boolean checkCollision(int playerX, int playerY) {
		if ((Math.abs(playerX - x)) <= 24 && (playerY - 10 < y)) {  // if player's model is in the hitbox of bird, then they collided
			return true;
		}
		return false;
	}
	// the following three methods are used for JUnit testing purposes
	/**
	 * @return x-coordinate of Bird
	 */
	public int getX() {
		return x;
	} 
	/**
	 * @return y-coordinate of Bird
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param x x-coordinate to set Bird's x-coordinate to
	 * Sets x-coordinate of Bird to parameter's x
	 */
	public void setX(int x) {
		this.x = x;
	} 
}
