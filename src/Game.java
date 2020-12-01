import java.util.Timer;

public class Game {

    public static void main(String[] args) {
        GameScreen screen = new GameScreen();
        Ground ground = new Ground();

        gameLoop(screen, ground);

    }

    public static void gameLoop(GameScreen screen, Ground ground){
        boolean run = true;

        while(run){
            screen.draw(ground);
        }
    }



}
