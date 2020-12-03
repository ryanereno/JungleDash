
import javax.swing.JFrame;

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
		addKeyListener(panel);
		add(panel);
		setVisible(true);
		
	}
	
	public static void main(String args[]) {
		GameFrame frame = new GameFrame();
	}
}
