import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Bird implements Obstacle {
	private int x;
	private int y;
	private int animationIndex;
	Image birdImage1 = new ImageIcon(this.getClass().getResource("bird1.png")).getImage();
	Image birdImage2 = new ImageIcon(this.getClass().getResource("bird2.png")).getImage();
	Image birdImage3 = new ImageIcon(this.getClass().getResource("bird3.png")).getImage();

	public Bird() {
		x = 680;
		y = 208;
		animationIndex = 1;
	}

	@Override
	public boolean outOfBounds() {
		if (x < -20) { // if most of the bird is offscreen, it is out of bounds
			return true;
		}
		return false;
	}

	@Override
	public void draw(Graphics g) {
		if(animationIndex == 1) {					// draws the bird image based on the current animationIndex
		g.drawImage(birdImage1, x, y, null);
		}
		else if(animationIndex == 2) {
		g.drawImage(birdImage2, x, y, null);
		}
		else {
		g.drawImage(birdImage3, x, y, null);
		}
		animationIndex++;							// increment animationIndex to get the next animation next time we call draw
		if(animationIndex == 4) {					// if animationIndex is 4, reset it back to 1
			animationIndex = 1;
		}
	}

	@Override
	public void update() {
		x -= 40;
	}

	public boolean checkCollision(int playerX, int playerY) {
		if ((Math.abs(playerX - x)) <= 24 && (playerY-10 < y)) { // if player's model is in the hitbox of bird,
			// they collided
			return true;
		}
		return false;
	}
}
