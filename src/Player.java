import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Player {
	private int x;
	private int y;
	private boolean running;
	private boolean dead;
	private boolean ducking;
	private boolean jumping;
	private int animationIndex;  // keeps track of what running animation we currently have
	Image runPlayer1 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_run1.png")).getImage();
	Image runPlayer2 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_run2.png")).getImage();
	Image runPlayer3 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_run3.png")).getImage();
	Image runPlayer4 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_run4.png")).getImage();
	Image jumpPlayer1 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_jump.png")).getImage();
	Image deadPlayer = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_death.png")).getImage();
	Image duckPlayer = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_duck.png")).getImage();

	public Player() {
		running = true;
		dead = false;
		jumping = false;
		ducking = false;
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
	public void die() { dead = true; }
	public void revive() { dead = false; }	// Added this so user can restart the game
	public boolean isDead() { return dead; }

	// These are used for our JUnit testing
	public boolean isRunning(){return running;}
	public boolean isDucking(){return ducking;}
	public boolean isJumping(){return jumping;}

	public void jump() {
		running = false;
		jumping = true;
		y = 180;				// After jumping, change the player's height
	}
	public void defaultPosition() {
		running = true;
		jumping = false;
		ducking = false;
		y = 213;				// After player finishes jumping, set y coordinate back to normal
	}
	public void duck(){
		running = false;
		ducking = true;
		y = 220;				// After ducking, change players height
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
		else if(jumping) {
			g.drawImage(jumpPlayer1, getX(), getY(), null);				// if player is not dead or running, they are jumping
		}
		else if(ducking){
			g.drawImage(duckPlayer, getX(), getY(), null);
		}
		
	}

}
