import javax.swing.*;
import java.awt.*;



public class GameScreen{

    private JFrame frame;
    Ground ground;

    // We would paste the objects into this method to draw them?
    // so eventually this method will take in the objects of our games
    // as parameters so we could draw them
    public GameScreen(){

        ground = new Ground();

        frame = new JFrame("Jungle Dash!");
        frame.add(ground);
        //  background height = 322
        //  background width = 650
        frame.setSize(650,322);
        frame.setVisible(true);
        frame.setSize(new Dimension(650, 322));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }



}
