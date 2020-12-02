public class Stump implements Obstacle {


    public Stump(){

        // These are just random values for now until we can
        // see where it will be placed in the game

        //  XPos should start at 700 (50 longer than the width of our game screen
        //  because it will give it the affect of the object coming from off screen
        //  into our screen
        int xPos = 700;
        int YPos = 250;     //  Ypos should remain the same since stump doesnt go up or down
    }


    @Override
    public void hasCollided() {

    }

    @Override
    public void create() {
    }


}
