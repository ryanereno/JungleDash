public class Game {

    public static void main(String[] args){
        Ground ground = new Ground();
        Bird bird = new Bird();

        //  GameScreen will display all the UI of the game so it should
        //  eventually take in all the UI objects are arguments
        new GameScreen(ground, bird);


    }





}
