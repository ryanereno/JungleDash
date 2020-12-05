import java.awt.*;
import javax.swing.*;
//StartPanel is used to create the title screen for the game
public class StartPanel extends JPanel {
    private Ground ground;
    private boolean start;

    public StartPanel(Ground ground) {
        this.ground = ground;
        setLayout(new GridLayout(1,1));
    }

    public void paint(Graphics g) {
        ground.draw(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Serif", Font.BOLD, 35));
        g.drawString("Jungle Dash!", 225, 90);
        g.setFont(new Font("Serif", Font.BOLD, 20));
        g.drawString("Click anywhere to start game", 190,150);
        g.setFont(new Font("Serif", Font.BOLD, 15));
        g.drawString("How to play: Press S to duck and Space to jump.",160, 200);
        g.drawString("Game is over once you collide with an obstacle.",165, 220);
    }

}
