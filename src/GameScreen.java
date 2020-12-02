import javax.swing.*;
import java.awt.*;



public class GameScreen extends JFrame{

    JLayeredPane pane;

    // We would paste the objects into this method to draw them?
    // so eventually this method will take in the objects of our games
    // as parameters so we could draw them
    public GameScreen(Ground ground, Bird bird, Stump stump, Player player){

        //  When adding JLables to JlayeredPanes you HAVE to set its bounds otherwise it wont show
        ground.setBounds(0, 0, 650,322);
        bird.setBounds(0, 0, 650,322);
        stump.setBounds(0, 0, 650,322);
        player.setBounds(0, 0, 650,322);


        //  JLayeredPane allows you to layer JLabels on each other.
        pane = new JLayeredPane();
        pane.setBounds(0,0,650,322);
        pane.add(ground);
        pane.add(bird);
        pane.add(stump);
        pane.add(player);



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
