import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bird extends JPanel implements ActionListener {

    int xPos = 650;
    int yPos = 115;
    final int VELOCITY = 3;

    //  different bird images for animation
    Image Birds1 = new ImageIcon(this.getClass().getResource("bird1.png")).getImage();
    Image Birds2 = new ImageIcon(this.getClass().getResource("bird2.png")).getImage();
    Image Birds3 = new ImageIcon(this.getClass().getResource("bird3.png")).getImage();
    Image Temp;
    Timer tm;
    int img_count = 0;
    int animation_time = 8;

    public Bird(){

        Temp = Birds1;

        tm = new Timer(5,this);
        tm.start();
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(Temp, xPos, yPos, null);



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        xPos -= VELOCITY;

        //This algorithm helps cycle through the bird images
        img_count ++;
        if(img_count < animation_time)
            Temp = Birds1;
        else if(img_count < animation_time * 2)
            Temp = Birds2;
        else if(img_count < animation_time * 3)
            Temp = Birds3;
        else if(img_count < animation_time * 4)
            Temp = Birds2;
        else if (img_count < animation_time * 4 + 1) {
            Temp = Birds1;
            img_count = 0;
        }

        repaint();

    }
}
