import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stump extends JPanel implements ActionListener, Obstacle {


    int xPos = 680;
    int yPos = 210;
    final int VELOCITY = 4;

    Image Stump;
    Timer tm;

    public Stump(){
        Stump = new ImageIcon(this.getClass().getResource("stump.png")).getImage();

        tm = new Timer(20,this);
        tm.start();

    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(Stump, xPos, yPos, null);



    }

    @Override
    public void hasCollided() {

    }

    @Override
    public void create() {
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        xPos -= VELOCITY;
        repaint();
    }
}
