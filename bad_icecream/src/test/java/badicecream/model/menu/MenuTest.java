package badicecream.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MenuTest {
    private TestMenu testMenu;

    static class TestMenu extends Menu {
        @Override
        protected List<String> createEntries() {
            return List.of("Start", "Exit");
        }
    }

    @BeforeEach
    public void setup() {
        testMenu = new TestMenu();
    }

    @Test
    public void nextEntryTest() {
        Assertions.assertEquals("Start", testMenu.getEntry(0));

        testMenu.nextEntry();
        Assertions.assertEquals("Exit", testMenu.getEntry(1));

        testMenu.nextEntry();
        Assertions.assertEquals("Start", testMenu.getEntry(0));
    }

    @Test
    public void previousEntryTest() {
        Assertions.assertEquals("Start", testMenu.getEntry(0));

        testMenu.previousEntry();
        Assertions.assertEquals("Exit", testMenu.getEntry(1));

        testMenu.previousEntry();
        Assertions.assertEquals("Start", testMenu.getEntry(0));
    }

    @Test
    public void isSelectedTest() {
        Assertions.assertTrue(testMenu.isSelected(0));
        Assertions.assertFalse(testMenu.isSelected(1));

        testMenu.nextEntry();
        Assertions.assertFalse(testMenu.isSelected(0));
        Assertions.assertTrue(testMenu.isSelected(1));
    }

    @Test
    public void getEntryTest() {
        Assertions.assertEquals("Start", testMenu.getEntry(0));
        Assertions.assertEquals("Exit", testMenu.getEntry(1));
    }
}
