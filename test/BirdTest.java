import org.junit.Test;

public class BirdTest {

    @Test
    public void testBirdCreation(){
        Bird bird = new Bird();

        /*
        /   x = 680;
		/   y = 208;
         */

        assert(bird.getX() == 680);
        assert(bird.getY() == 208);
    }

    @Test
    public void testOutOfBounds(){
        Bird bird = new Bird();
        assert(!bird.outOfBounds());
        bird.setX(-21);
        assert(bird.outOfBounds());        // out of bounds is below -20
    }

    @Test
    public void testUpdate(){
        Bird bird = new Bird();

        // testing until it goes out of bounds
        for (int i = 0, num = 650; i < 17; i++, num -= 30 ){        // num decreases by 40 because thats the speed we used in update
            bird.update();
            assert(bird.getX() == num);
        }
    }

    @Test
    public void testCheckCollision(){
        Bird bird = new Bird();
        Player player = new Player();
        assert(!bird.checkCollision(player.getX(), player.getY()));     // They dont collide as soon as bird is created
        bird.setX(10);
        assert(bird.checkCollision(player.getX(), player.getY()));      // They collide if birds xPos reaches PlayerX without Player ducking
        player.duck();
        assert(!bird.checkCollision(player.getX(), player.getY()));     // They dont collide if player ducks
    }


}
