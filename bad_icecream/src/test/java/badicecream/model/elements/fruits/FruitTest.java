package badicecream.model.elements.fruits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FruitTest {

    static class TestFruit extends Fruit {
        public TestFruit(int x, int y) {
            super(x, y);
        }
    }

    private TestFruit testFruit;

    @BeforeEach
    public void setup() {
        testFruit = new TestFruit(2, 4);
    }

    @Test
    public void fruitConstructor() {
        Assertions.assertEquals(2, testFruit.getX());
        Assertions.assertEquals(4, testFruit.getY());
    }
}
