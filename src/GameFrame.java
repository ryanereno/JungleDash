import javax.swing.*;

public class GameFrame extends JFrame {

	public GameFrame() {
		super("Jungle Dash");
		setSize(650, 322);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		Player p = new Player();
		Ground g = new Ground();
		GameManager m = new GameManager(p);
		GamePanel panel = new GamePanel(p, m, g);
		StartPanel start = new StartPanel(g);
		//Added button in GameFrame instead of StartPanel so that it can be used to activate the game
		//Button is transparent and takes up whole screen so that user can click anywhere to start
		JButton startButton = new JButton("Start game");
		startButton.setOpaque(false);
		startButton.setContentAreaFilled(false);
		startButton.setBorderPainted(false);
		start.add(startButton);
		startButton.setFocusable(false);
		startButton.addActionListener(event -> {
			startGame(start, panel);
		});
		add(start);
		setVisible(true);
	}

	//Added this so that game starts only when user clicks the screen
	public void startGame(StartPanel start, GamePanel panel) {
		start.setVisible(false);
		add(panel);
		addKeyListener(panel);
		panel.startGame();
	}

	public static void main(String args[]) {
		GameFrame frame = new GameFrame();
	}
}
