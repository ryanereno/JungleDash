import javax.swing.*;
import java.awt.*;


public class GameScreen {

    static GraphicsConfiguration gc;


    // We would paste the objects into this method to draw them?
    // so eventually this method will take in the objects of our games
    // as parameters so we could draw them
    public static void drawWindow(){
        JFrame frame = new JFrame(gc);
        frame.setTitle("Jungle Dash!");
        frame.setSize(1200,800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }

}
