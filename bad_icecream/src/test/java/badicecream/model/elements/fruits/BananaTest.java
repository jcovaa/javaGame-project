package badicecream.model.elements.fruits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BananaTest {

    private Banana banana;

    @BeforeEach
    public void setup() {
        banana = new Banana(4, 6);
    }

    @Test
    public void bananaConstructor() {
        Assertions.assertEquals(4, banana.getX());
        Assertions.assertEquals(6, banana.getY());
    }
}
