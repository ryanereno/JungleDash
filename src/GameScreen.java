import javax.swing.*;


public class GameScreen {

    private JFrame frame;
    private ImageIcon background;
    private JLabel label;

    // We would paste the objects into this method to draw them?
    // so eventually this method will take in the objects of our games
    // as parameters so we could draw them
    public void draw(){

        //  background height = 322
        //  background width = 650
        background = new ImageIcon(this.getClass().getResource("/Background.png"));
        label = new JLabel(background);


        frame = new JFrame("Jungle Dash!");
        frame.add(label);
        frame.setSize(background.getIconWidth(),background.getIconHeight());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);



    }

}
