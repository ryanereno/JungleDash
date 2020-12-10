import javax.swing.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * GameFrame class that creates the frame of the game and starts the program
 */
public class GameFrame extends JFrame {
	/**
	 * Constructs GameFrame object
	 */
	public GameFrame() {
		super("Jungle Dash");
		setSize(650, 322);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		Player p = new Player();
		Ground g = new Ground();
		BlockingQueue<Message> queue = new LinkedBlockingQueue();
		GamePanel panel = new GamePanel(p, g, queue);
		GameManager m = new GameManager(p, panel, queue);
		StartPanel start = new StartPanel(g);

		// Button is added to allow user to start game
		JButton startButton = new JButton("Start game");
		startButton.setOpaque(false);
		startButton.setContentAreaFilled(false);
		startButton.setBorderPainted(false);
		start.add(startButton);
		startButton.setFocusable(false);
		// Thread is created and used in action listener in order to be able to start the game
		startButton.addActionListener(event -> {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					startGame(start, panel, m);
				}
			});
			thread.start();
		});

		add(start);
		setVisible(true);
	}

	/**
	 * Transitions title panel to game panel and starts the game for the user
	 *
	 * @param start the panel that contains the title screen
	 * @param panel the panel that contains the game screen
	 * @param m the GameManager that contains the controller
	 */
	public void startGame(StartPanel start, GamePanel panel, GameManager m) {
		start.setVisible(false);
		add(panel);
		addKeyListener(panel);
		m.mainLoop();
	}

	public static void main(String args[]) {
		new GameFrame();
	}
}
