import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ground implements ActionListener{

    int x1 = -150;
    int x2 = 150;
    int VELOCITY = 5;
    private ImageIcon ground1;
    private JLabel label1;
    private ImageIcon ground2;
    private JLabel label2;

    Timer tm = new Timer(500,this);

    //  Size of the ground image was too short so I created 2 labels with the same ground image
    //  and stuck them together and put the labels in an array that will be sent to the game screen
    // so it can draw both labels
    public ArrayList<JLabel> labels;
    public Ground(){
        labels = new ArrayList<JLabel>();

        ground1 = new ImageIcon(this.getClass().getResource("/Ground.png"));
        label1 = new JLabel(ground1);
        label1.setBounds(0,0,650, 322);
        label1.setLocation(x1, 110);

        ground2 = new ImageIcon(this.getClass().getResource("/Ground.png"));
        label2 = new JLabel(ground2);
        label2.setBounds(0,0,650, 322);
        label2.setLocation(x2, 110);

        labels.add(label1);
        labels.add(label2);

        tm.start();
    }

    public ArrayList<JLabel> getLabels(){
        // by changing the x positions it will make the ground look like its moving
        labels.get(0).setLocation(x1, 110);
        labels.get(1).setLocation(x2, 110);
        return labels;
    }

    //  this method animates the ground
    public void actionPerformed(ActionEvent e){
        x1 -= VELOCITY;
        x2 -= VELOCITY;

        //  I think -325 is the edge of the screen on the left side
        //  so if the ground leaves the screen it should be redrawn on
        // on the right side to give it the illusion of moving
       if(x1 + ground1.getIconWidth() < -325)
            x1 = x2 + ground1.getIconWidth();

        if(x2 + ground1.getIconWidth() < -325)
            x2 = x1 + ground1.getIconWidth();

    }
}
