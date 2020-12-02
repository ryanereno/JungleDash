import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ground extends JPanel implements ActionListener{


    //  x is the starting position for each ground
    //  it increments by 384 because that is the width of the ground image
    int x1 = 0;
    int x2 = 384;
    int x3 = 768;
    int x4 = 1152;
    final int VELOCITY = 10;
    Image ground;
    Image background;


    Timer tm;


    public ArrayList<JLabel> labels;
    public Ground(){
        ground = new ImageIcon(this.getClass().getResource("Ground.png")).getImage();
        background = new ImageIcon(this.getClass().getResource("Background.png")).getImage();

        tm = new Timer(40, this);
        tm.start();
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(background, 0, 0,null);
        g2.drawImage(ground, x1, 240, null);
        g2.drawImage(ground, x2, 240, null);
        g2.drawImage(ground, x3, 240, null);
        g2.drawImage(ground, x4, 240, null);


    }


    //  this method animates the ground
    public void actionPerformed(ActionEvent e){
        x1 -= VELOCITY;
        x2 -= VELOCITY;
        x3 -= VELOCITY;
        x4 -= VELOCITY;

        int width = ground.getWidth(null);

        //  I think -325 is the edge of the screen on the left side
        //  so if the ground leaves the screen it should be redrawn on
        // on the right side to give it the illusion of moving
       if(x1 + width < -384)
            x1 = x4 + width;

       if(x2 + width < -384)
            x2 = x1 + width;

       if(x3 + width < -384)
            x3 = x2 + width;

       if(x4 + width < -384)
            x4 = x3 + width;

       repaint();

    }
}
