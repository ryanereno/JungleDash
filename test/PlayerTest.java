import org.junit.Test;

public class PlayerTest {

    @Test
    public void testPlayerCreation(){

        /*
        /   running = true;
		/   dead = false;
		/   jumping = false;
		/   ducking = false;
		/   x = 10;
		/   y = 213;
         */

        Player player = new Player();
        assert(player.getX() == 10);
        assert(player.getY() == 213);
        assert(player.isRunning());
        assert(!player.isDead());
        assert(!player.isDucking());
        assert(!player.isJumping());
    }
    @Test
    public void testJumpAndLand(){
        Player player = new Player();
        player.jump();

        /*
        /   running = false;
		/   jumping = true;
		/   y = 180;
         */

        assert(player.getY() == 180);
        assert(!player.isRunning());
        assert(!player.isDead());
        assert(!player.isDucking());
        assert(player.isJumping());

        player.defaultPosition();

        /*
        /   running = true;
		/   jumping = false;
	    /   y = 213;
        */
        assert(player.getY() == 213);
        assert(player.isRunning());
        assert(!player.isDead());
        assert(!player.isDucking());
        assert(!player.isJumping());
    }

    @Test
    public void testDuckAndStand(){
        Player player = new Player();
        player.duck();

        /*
        /   running = false;
		/   ducking = true;
		/   y = 220;
         */

        assert(player.getY() == 220);
        assert(!player.isRunning());
        assert(!player.isDead());
        assert(player.isDucking());
        assert(!player.isJumping());

        player.defaultPosition();

        /*
        /   running = true;
		/   ducking = false;
		/   y = 213;
        */

        assert(player.getY() == 213);
        assert(player.isRunning());
        assert(!player.isDead());
        assert(!player.isDucking());
        assert(!player.isJumping());

    }

    @Test
    public void testPlayerDead(){
        Player player = new Player();
        player.die();
        assert(player.isDead());
    }
}
