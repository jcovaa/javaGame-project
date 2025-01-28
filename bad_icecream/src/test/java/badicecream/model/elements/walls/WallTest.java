package badicecream.model.elements.walls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WallTest {

    private Wall wall;

    @BeforeEach
    public void setup() {
        wall = new Wall(2, 8);
    }

    @Test
    public void WallConstructor() {
        Assertions.assertEquals(2, wall.getX());
        Assertions.assertEquals(8, wall.getY());
    }
}
