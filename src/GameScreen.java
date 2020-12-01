import javax.swing.*;
import java.awt.*;


public class GameScreen {

    private JFrame frame;
    private ImageIcon background;
    private JLabel label;

    // We would paste the objects into this method to draw them?
    // so eventually this method will take in the objects of our games
    // as parameters so we could draw them
    public void draw(Ground ground){

        //  background height = 322
        //  background width = 650
        //  i set bounds of a lot of things equal to 322, 650 so the background fits
        background = new ImageIcon(this.getClass().getResource("/Background.png"));
        label = new JLabel(background);
        label.setBounds(0,0, 650, 322);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 650, 322);

        // this adds all the ground lables into our layeredpane
        for(int i = 0; i < ground.getLabels().size(); i++){
            layeredPane.add(ground.getLabels().get(i), JLayeredPane.DRAG_LAYER);
        }

        layeredPane.add(label, JLayeredPane.DEFAULT_LAYER);

        frame = new JFrame("Jungle Dash!");
        frame.add(layeredPane);
        frame.setSize(background.getIconWidth(),background.getIconHeight());
        frame.setVisible(true);
        frame.setSize(new Dimension(650, 322));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);



    }

}
