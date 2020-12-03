import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Player {
	private int x;
	private int y;
	private boolean running;
	private boolean dead;
	private boolean duck;
	private boolean jump;
	private int animationIndex;  // keeps track of what running animation we currently have
	Image runPlayer1 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_run1.png")).getImage();
	Image runPlayer2 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_run2.png")).getImage();
	Image runPlayer3 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_run3.png")).getImage();
	Image runPlayer4 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_run4.png")).getImage();
	Image jumpPlayer1 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_jump1.png")).getImage();
	Image deadPlayer = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_death1.png")).getImage();
	Image duckPlayer = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_death2.png")).getImage();

	public Player() {
		running = true;
		dead = false;
		jump = false;
		duck = false;
		x = 10;
		y = 213;
		animationIndex = 1;
	}
//	public boolean isRunning() { // if player is not running, they are jumping
//		return running;
//	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void jump() {
		running = false;
		jump = true;
		y = 180;				// After jumping, change the player's height
	}
	public void land() {
		running = true;
		jump = false;
		y = 213;				// After player finishes jumping, set y coordinate back to normal
	}
	public void duck(){
		running = false;
		duck = true;
		y = 220;				// After ducking, change players height
	}
	public void stand(){
		running = true;
		duck = false;
		y = 213;				// When player stands back up, set y coordinate back to normal
	}
	public void die() {
		dead = true;
	}
	public boolean isDead() {
		return dead;
	}
	public void draw(Graphics g) {
		if(running) {
			if(animationIndex == 1) {
			g.drawImage(runPlayer1, getX(), getY() , null);
			}
			else if (animationIndex == 2) {
			g.drawImage(runPlayer2, getX(), getY() , null);
			}
			else if (animationIndex == 3) {
				g.drawImage(runPlayer3, getX(), getY() , null);
			}
			else {
				g.drawImage(runPlayer4, getX(), getY() , null);
			}
			animationIndex++;			// increment animationIndex to get the next animation next time we call draw
			if(animationIndex == 5) {	// if animationIndex is 5, reset it back to 1
				animationIndex = 1;
			}
		}
		else if (dead) {
			g.drawImage(deadPlayer, getX(), getY() , null);
		}
		else if(jump) {
			g.drawImage(jumpPlayer1, getX(), getY(), null);				// if player is not dead or running, they are jumping
		}
		else if(duck){
			g.drawImage(duckPlayer, getX(), getY(), null);
		}
		
	}
	
}
