import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ground extends JPanel implements ActionListener{


    //  x is the starting position for each ground
    //  it increments by 384 because that is the width of the ground image
    int x1 = 0;
    int x2 = 384;
    int x3 = 768;
    int x4 = 1152;
    final int VELOCITY = 3;
    Image ground;
    Image background;


    Timer tm;

    public Ground(){
        ground = new ImageIcon(this.getClass().getResource("Ground.png")).getImage();
        background = new ImageIcon(this.getClass().getResource("Background.png")).getImage();

        tm = new Timer(10, this);
        tm.start();
    }

    //Displays the background and ground on this label
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(background, 0, 0,null);

        //  Theres 4 ground images because i connected them all together
        //  to make it animate and then keep repainting it at the end of the screen
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

        //  I think -384 is when 1 entire ground object
        //  is no longer seen
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
