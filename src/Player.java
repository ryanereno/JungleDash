import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player extends JPanel implements ActionListener {

    // These are just random values for now until we can
    // see where it will be placed in the game
    final int xPos = 10;
    int yPos = 220;
    int img_count = 0;
    final int ANIMATION_TIME = 5;

    Image runPlayer1 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_run1.png")).getImage();
    Image runPlayer2 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_run2.png")).getImage();
    Image runPlayer3 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_run3.png")).getImage();
    Image runPlayer4 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_run4.png")).getImage();

    Image Temp;

    Timer tm;
    public Player(){
        Temp = runPlayer1;

        tm = new Timer(10,this);
        tm.start();

    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(Temp, xPos, yPos, null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        img_count ++;
        if(img_count < ANIMATION_TIME)
            Temp = runPlayer1;
        else if(img_count < ANIMATION_TIME * 2)
            Temp = runPlayer2;
        else if(img_count < ANIMATION_TIME * 3)
            Temp = runPlayer3;
        else if(img_count < ANIMATION_TIME * 4)
            Temp = runPlayer4;
        else if(img_count < ANIMATION_TIME * 5)
            Temp = runPlayer3;
        else if(img_count < ANIMATION_TIME * 6)
            Temp = runPlayer2;
        else if (img_count < ANIMATION_TIME * 6 + 1) {
            Temp = runPlayer1;
            img_count = 0;
        }
        repaint();
    }
}
