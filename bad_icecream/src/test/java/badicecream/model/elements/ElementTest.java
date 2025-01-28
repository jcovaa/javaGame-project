package badicecream.model.elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ElementTest {

    static class TestElement extends Element{
        public TestElement(int x, int y) {
            super(x, y);
        }
    }

    private TestElement testElement;

    @BeforeEach
    public void setup() {
        testElement = new TestElement(3, 4);
    }

    @Test
    public void elementConstructor() {
        Assertions.assertEquals(3, testElement.getX());
        Assertions.assertEquals(4, testElement.getY());
    }

    @Test
    public void modifyPosition() {
        testElement.setPosition(2, 7);
        Assertions.assertEquals(2, testElement.getX());
        Assertions.assertEquals(7, testElement.getY());
    }
}
