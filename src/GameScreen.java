import javax.swing.*;
import java.awt.*;



public class GameScreen{

    private JFrame frame;
    Ground ground;
    Bird bird;

    // We would paste the objects into this method to draw them?
    // so eventually this method will take in the objects of our games
    // as parameters so we could draw them
    public GameScreen(){

        ground = new Ground();
        ground.setBounds(0, 0, 650,322);

        bird = new Bird();
        bird.setBounds(0, 0, 650,322);


        JLayeredPane pane = new JLayeredPane();
        pane.setBounds(0,0,650,322);
        pane.add(ground);
        pane.add(bird);


        frame = new JFrame("Jungle Dash!");
        frame.add(pane);
        //  background height = 322
        //  background width = 650
        frame.setSize(650,322);
        frame.setVisible(true);
        frame.setSize(new Dimension(650, 322));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }



}
