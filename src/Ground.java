import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Ground {
	private int x;
	private int y;

	public Ground() {
		x = 0;
		y = 0;
	}

	public void update() {
		x += 12; // add 12 to x (1/128 the size of the entire ground). Note, number is pretty
					// arbitrary, just there to make ground animation look nice
		if (x >= 1152) { // If x exceeds the x-coordinate of the 4th ground image, reset it to 0
			x = 0;
		}
	}

	public void draw(Graphics g) {
		Image groundImage = new ImageIcon(this.getClass().getResource("Ground.png")).getImage();
		Image backgroundImage = new ImageIcon(this.getClass().getResource("Background.png")).getImage();
		g.drawImage(backgroundImage, 0, 0, null);
		g.drawImage(groundImage, 0 - x, 240, null);
		g.drawImage(groundImage, 384 - x, 240, null);
		g.drawImage(groundImage, 768 - x, 240, null);
		g.drawImage(groundImage, 1152 - x, 240, null);
		g.drawImage(groundImage, 1536 - x, 240, null);
	}
}
