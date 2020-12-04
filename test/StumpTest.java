import org.junit.Test;

public class StumpTest {

    @Test
    public void testBirdCreation(){
        Stump stump = new Stump();

        /*
        /   x = 680;
		/   y = 210;
         */

        assert(stump.getX() == 680);
        assert(stump.getY() == 210);
    }

    @Test
    public void testOutOfBounds(){
        Stump stump = new Stump();
        assert(!stump.outOfBounds());
        stump.setX(-21);
        assert(stump.outOfBounds());    // stump out of bounds is at -20
    }

    @Test
    public void testUpdate(){
        Stump stump = new Stump();

        // testing until it goes out of bounds
        for (int i = 0, num = 652; i < 25; i++, num -= 28 ){        // num decreases by 28 because thats the speed we used in update
            stump.update();
            assert(stump.getX() == num);
        }
    }

    @Test
    public void testCheckCollision(){
        Stump stump = new Stump();
        Player player = new Player();
        assert(!stump.checkCollision(player.getX(), player.getY()));     // They dont collide as soon as stump is created
        stump.setX(10);
        assert(stump.checkCollision(player.getX(), player.getY()));      // They collide if stumps xPos reaches PlayerX without Player jumping
        player.jump();
        assert(!stump.checkCollision(player.getX(), player.getY()));     // They dont collide if player jumps
    }
}
