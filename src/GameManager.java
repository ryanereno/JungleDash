import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// control class
public class GameManager {
	private Queue<Obstacle> obstacles;
	private Player p;

	public GameManager(Player p) {
		this.p = p;
		obstacles = new LinkedList<Obstacle>();
	}

	public void playerJump() {
		p.jump();
	}

	public void playerLand() {
		p.land();
	}

	public void update() {
		for (Obstacle obs : obstacles) {
			obs.update();
			if (obs.checkCollision(p.getX(), p.getY())) { // if player collided with object, they are dead
				p.die();
			}
		}
		if (obstacles.peek() == null) {
			// do nothing if there's nothing in the queue
		} else if (obstacles.peek().outOfBounds()) {
			obstacles.remove();
		}

	}

	public void draw(Graphics g) {
		try {
			for (Obstacle obs : obstacles) {
				obs.draw(g);
			}
		} catch (ConcurrentModificationException e) {
			// don't draw if we are currently iterating through the Queue
		}
	}

	public void addObstacle() {
		int random = (int) (Math.random() * 2); // generate a random number 0 or 1 that determines whether we generate a
												// stump or bird obstacle
		if (random == 0) {
			obstacles.add(new Stump());
		} else {
			obstacles.add(new Bird());
		}
	}
}
