package badicecream.controller.menus;

import badicecream.Game;
import badicecream.controller.menu.CreditsMenuController;
import badicecream.gui.Gui;
import badicecream.model.menu.CreditsMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class CreditsMenuControllerTest {
    private CreditsMenuController creditsMenuController;
    private CreditsMenu mockedCreditsMenu;
    private Game mockedGame;

    @BeforeEach
    public void setup() {
        mockedCreditsMenu = mock(CreditsMenu.class);
        mockedGame = mock(Game.class);

        creditsMenuController = new CreditsMenuController(mockedCreditsMenu);
    }

    @Test
    public void stepUpActionTest() throws IOException {
        creditsMenuController.step(mockedGame, Gui.Actions.UP, 0);


        verify(mockedCreditsMenu).previousEntry();
        verifyNoInteractions(mockedGame);
    }

    @Test
    public void stepDownActionTest() throws IOException {
        creditsMenuController.step(mockedGame, Gui.Actions.DOWN, 0);

        verify(mockedCreditsMenu).nextEntry();
        verifyNoInteractions(mockedGame);
    }

    @Test
    public void stepSelectStartTest() throws IOException {
        when(mockedCreditsMenu.isSelectedStart()).thenReturn(true);
        when(mockedCreditsMenu.isSelectedExit()).thenReturn(false);

        creditsMenuController.step(mockedGame, Gui.Actions.SELECT, 0);

        verify(mockedCreditsMenu).isSelectedStart();
        verify(mockedGame).setState(any());
    }

    @Test
    public void stepSelectExitTest() throws IOException {
        when(mockedCreditsMenu.isSelectedStart()).thenReturn(false);
        when(mockedCreditsMenu.isSelectedExit()).thenReturn(true);

        creditsMenuController.step(mockedGame, Gui.Actions.SELECT, 0);

        verify(mockedCreditsMenu).isSelectedExit();
        verify(mockedGame).setState(null);
    }
}
