package badicecream.model.elements.characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PlayerTest {

    private Player player;

    @BeforeEach
    public void setup() {
        player = new Player(5, 3, "DOWN");
    }

    @Test
    public void playerConstructor() {
        Assertions.assertEquals(5, player.getX());
        Assertions.assertEquals(3, player.getY());
        Assertions.assertEquals("DOWN", player.getDirection());
        Assertions.assertTrue(player.isAlive());
    }

    @Test
    public void modifyPosition() {
        player.setPosition(2, 1);
        Assertions.assertEquals(2, player.getX());
        Assertions.assertEquals(1, player.getY());
    }

    @Test
    public void isAliveTest() {
        Assertions.assertTrue(player.isAlive);

        player.die();

        Assertions.assertFalse(player.isAlive());
    }
}
