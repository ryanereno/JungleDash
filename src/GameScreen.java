import javax.swing.*;
import java.awt.*;



public class GameScreen extends JFrame{


    // We would paste the objects into this method to draw them?
    // so eventually this method will take in the objects of our games
    // as parameters so we could draw them
    public GameScreen(Ground ground, Bird bird){

        //  When adding JLables to JlayeredPanes you HAVE to set its bounds otherwise it wont show
        ground.setBounds(0, 0, 650,322);

        bird.setBounds(0, 0, 650,322);


        //  JLayeredPane allows you to layer JLabels on each other.
        JLayeredPane pane = new JLayeredPane();
        pane.setBounds(0,0,650,322);

        //  Default_Layer is the very back of the JLayeredPane
        pane.add(ground);

        //  Drag_Layer is the very front
        pane.add(bird);


        new JFrame("Jungle Dash!");
        add(pane);
        //  background height = 322
        //  background width = 650
        setSize(650,322);
        setVisible(true);
        setSize(new Dimension(650, 322));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

    }



}
