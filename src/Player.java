import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Player extends JPanel implements ActionListener {

    // These are just random values for now until we can
    // see where it will be placed in the game
    final int xPos = 10;
    final int jumpPos = 2;
    final int ANIMATION_TIME = 5;
    int yPos = 220;
    int img_count = 0;


    Image runPlayer1 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_run1.png")).getImage();
    Image runPlayer2 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_run2.png")).getImage();
    Image runPlayer3 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_run3.png")).getImage();
    Image runPlayer4 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_run4.png")).getImage();

    Image jumpPlayer1 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_jump1.png")).getImage();
    Image jumpPlayer2 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_jump2.png")).getImage();
    Image jumpPlayer3 = new ImageIcon(this.getClass().getResource("Woodcutter/woodcutter_jump3.png")).getImage();

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

    public void jump(){


        //  While our player ascends up
        //  Should be using the first picture
        while (yPos > 175){

            yPos -= jumpPos;
            Temp = jumpPlayer1;
            repaint();
        }

        //  Once player reaches height of jump
        //  Should be in 2nd phase of animation
        Temp = jumpPlayer3;
        repaint();
        //  While our player is descending
        //  Use the third animation
        while (yPos < 220) {

            yPos += jumpPos;
            Temp = jumpPlayer2;
            repaint();
        }

        // Reset back to our base running image and img_count
        yPos = 220;
        Temp = runPlayer1;
        img_count = 0;
        repaint();
    }


}
