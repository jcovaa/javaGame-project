package badicecream.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreditsMenuTest {
    private CreditsMenu creditsMenu;

    @BeforeEach
    public void setup() {
        creditsMenu = new CreditsMenu(10, 5, "Game over");
    }

    @Test
    public void createEntriesTest() {
        Assertions.assertEquals(2, creditsMenu.createEntries().size());
        Assertions.assertEquals("Restart", creditsMenu.getEntry(0));
        Assertions.assertEquals("Quit", creditsMenu.getEntry(1));
    }

    @Test
    public void isSelectedTest() {
        Assertions.assertTrue(creditsMenu.isSelectedStart());
        Assertions.assertFalse(creditsMenu.isSelectedExit());

        creditsMenu.nextEntry();
        Assertions.assertFalse(creditsMenu.isSelectedStart());
        Assertions.assertTrue(creditsMenu.isSelectedExit());
    }

    @Test
    public void getBananasCollectedTest() {
        Assertions.assertEquals(10, creditsMenu.getBananasCollected());
    }

    @Test
    public void getWaterMelonsCollectedTest() {
        Assertions.assertEquals(5, creditsMenu.getWaterMelonsCollected());
    }

    @Test
    public void getGameStatus() {
        Assertions.assertEquals("Game over", creditsMenu.getGameStatus());
    }
}
