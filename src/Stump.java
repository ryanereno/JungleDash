import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Stump implements Obstacle {
	private int x;
	private int y;

	public Stump() {
		x = 680;
		y = 210;
	}

	@Override
	public boolean outOfBounds() {
		if (x < -20) { // if most of the stump is offscreen, it is out of bounds
			return true;
		}
		return false;
	}

	@Override
	public void draw(Graphics g) {
		Image stumpImage = new ImageIcon(this.getClass().getResource("stump.png")).getImage();
		g.drawImage(stumpImage, x, y, null);
	}

	@Override
	public void update() {
		x -= 28;
	}

	public boolean checkCollision(int playerX, int playerY) {
		if ((Math.abs(playerX - x)) <= 24 && (playerY > y)) { // if player's model is in the hitbox of stump,
		                								      // they collided
			return true;
		}
		return false;
	}

	public int getX(){ return x;}			// used for JUnit testing
	public int getY(){ return y;}			// used for JUnit testing
	public void setX(int x){ this.x = x;}	// used for JUnit testing
}
