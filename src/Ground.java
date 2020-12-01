import javax.swing.*;
import java.util.ArrayList;

public class Ground {

    private ImageIcon ground1;
    private JLabel label1;
    private ImageIcon ground2;
    private JLabel label2;

    //  Size of the ground image was too short so I created 2 labels with the same ground image
    //  and stuck them together and put the labels in an array that will be sent to the game screen
    // so it can draw both labels
    public ArrayList<JLabel> labels;
    public Ground(){
        labels = new ArrayList<JLabel>();

        ground1 = new ImageIcon(this.getClass().getResource("/Ground.png"));
        label1 = new JLabel(ground1);
        label1.setBounds(0,0,650, 322);
        label1.setLocation(-150, 110);

        ground2 = new ImageIcon(this.getClass().getResource("/Ground.png"));
        label2 = new JLabel(ground2);
        label2.setBounds(0,0,650, 322);
        label2.setLocation(150, 110);

        labels.add(label1);
        labels.add(label2);
    }

    public ArrayList<JLabel> getLabels(){
        return labels;
    }
}
