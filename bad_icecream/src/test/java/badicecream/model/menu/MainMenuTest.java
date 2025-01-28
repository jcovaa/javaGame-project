package badicecream.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainMenuTest {
    private MainMenu mainMenu;

    @BeforeEach
    public void setup() {
        mainMenu = new MainMenu();
    }

    @Test
    public void entriesTest() {
        Assertions.assertEquals("Start", mainMenu.getEntry(0));
        Assertions.assertEquals("Quit", mainMenu.getEntry(1));
    }

    @Test
    public void isSelectedTest() {
        Assertions.assertTrue(mainMenu.isSelectedStart());
        Assertions.assertFalse(mainMenu.isSelectedExit());

        mainMenu.nextEntry();
        Assertions.assertFalse(mainMenu.isSelectedStart());
        Assertions.assertTrue(mainMenu.isSelectedExit());
    }
}
