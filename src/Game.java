public class Game {

    public static void main(String[] args){
        Ground ground = new Ground();
        Bird bird = new Bird();

        //  GameScreen will display all the UI of the game so it should
        //  eventually take in all the UI objects are arguments
        new GameScreen(ground, bird);

        boolean run = true;

        //  this is the gameloop. It should keep running until
        //  user collides with an object. Then it should display
        //  game ending screen with score
        while(run){

        }


    }







}
