package badicecream.model.elements.walls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IceWallTest {

    private IceWall iceWall;

    @BeforeEach
    public void setup() {
        iceWall = new IceWall(3, 7);
    }

    @Test
    public void iceWallConstructor() {
        Assertions.assertEquals(3, iceWall.getX());
        Assertions.assertEquals(7, iceWall.getY());
    }
}
