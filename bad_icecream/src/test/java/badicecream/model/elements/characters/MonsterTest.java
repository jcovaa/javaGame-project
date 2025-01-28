package badicecream.model.elements.characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MonsterTest {

    private Monster monster;

    @BeforeEach
    public void setup() {
        monster = new Monster(5, 3, "DOWN");
    }

    @Test
    public void playerConstructor() {
        Assertions.assertEquals(5, monster.getX());
        Assertions.assertEquals(3, monster.getY());
        Assertions.assertEquals("DOWN", monster.getDirection());
    }

    @Test
    public void modifyPosition() {
        monster.setPosition(6, 3);
        Assertions.assertEquals(6, monster.getX());
        Assertions.assertEquals(3, monster.getY());
    }
}
