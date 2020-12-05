import java.awt.Graphics;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class is the controller of MVC pattern
 * This class is responsible for controlling the flow of the game and what the Player does when it is
 * called from GamePanel.
 * It also contains a Queue of obstacles that are continually added and removed as the game progresses.
 */
public class GameManager {
	private Queue<Obstacle> obstacles;
	private Player p;

	/**
	 * Constructs a GameManager
	 *
	 * @param p Player
	 */
	public GameManager(Player p) {
		this.p = p;
		obstacles = new LinkedList<Obstacle>();
	}

	/**
	 * Tells player to Jump
	 */
	public void playerJump() {
		p.jump();
	}

	/**
	 * Tells player to go back to its default running position
	 */
	public void playerDefault() {
		p.defaultPosition();
	}

	/**
	 * Tells player to duck
	 */
	public void playerDuck() { p.duck(); }

	/**
	 * Updates all the obstacles currently projected on the screen (changes the position of obstacles) and
	 * checks for a collision between an obstacle and player.
	 * If a collision is found, then it kills the player.
	 * Also checks if obstacle is off the screen (obstacle is removed from the Queue if it is).
	 */
	public void update() {
		for (Obstacle obs : obstacles) {
			obs.update();
			if (obs.checkCollision(p.getX(), p.getY())) { // If player collided with object, they are dead
				p.die();
			}
		}
		if (obstacles.peek() == null) {
			// Do nothing if there's nothing in the queue
		} else if (obstacles.peek().outOfBounds()) {
			obstacles.remove();
		}
	}

	/**
	 * Draws all the obstacles to the screen
	 *
	 * @param g Graphics objects that draws all the obstacles to the screen
	 */
	public void draw(Graphics g) {
		try {
			for (Obstacle obs : obstacles) {
				obs.draw(g);
			}
		} catch (ConcurrentModificationException e) {
			// Don't draw if we are currently iterating through the Queue
		}
	}

	/**
	 * Randomly generates either a bird or stump obstacle
	 */
	public void addObstacle() {
		int random = (int) (Math.random() * 2);
		if (random == 0) {
			obstacles.add(new Stump());
		} else {
			obstacles.add(new Bird());
		}
	}

	/**
	 * Resets Player and creates a new LinkedList for obstacles Queue to start a new game
	 */
	public void resetGame() {
		p.revive();
		obstacles = new LinkedList<>();
	}
}

