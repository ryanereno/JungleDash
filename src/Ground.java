import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ground extends JPanel implements ActionListener{

    int x1 = -150;
    int x2 = 150;
    int VELOCITY = 10;
    Image ground1;
    Image background;
    Image ground2;

    Timer tm;


    public ArrayList<JLabel> labels;
    public Ground(){
        ground1 = new ImageIcon(this.getClass().getResource("Ground.png")).getImage();
        ground2 = new ImageIcon(this.getClass().getResource("Ground.png")).getImage();
        background = new ImageIcon(this.getClass().getResource("Background.png")).getImage();

        tm = new Timer(40, this);
        tm.start();
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(background, 0, 0,null);
        g2.drawImage(ground1, x1, 240, null);
        g2.drawImage(ground1, x2, 240, null);


    }


    //  this method animates the ground
    public void actionPerformed(ActionEvent e){
        x1 -= VELOCITY;
        x2 -= VELOCITY;

        //  I think -325 is the edge of the screen on the left side
        //  so if the ground leaves the screen it should be redrawn on
        // on the right side to give it the illusion of moving
       if(x1 + ground1.getWidth(null) < -325)
            x1 = x2 + ground1.getWidth(null);

       if(x2 + ground1.getWidth(null) < -325)
            x2 = x1 + ground1.getWidth(null);

       repaint();

    }
}
