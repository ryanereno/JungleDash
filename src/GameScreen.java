import javax.swing.*;


public class GameScreen {

    private JFrame frame;

    // We would paste the objects into this method to draw them?
    // so eventually this method will take in the objects of our games
    // as parameters so we could draw them
    public GameScreen(){
        frame = new JFrame("Jungle Dash!");
        frame.setSize(1200,800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);



    }

}
