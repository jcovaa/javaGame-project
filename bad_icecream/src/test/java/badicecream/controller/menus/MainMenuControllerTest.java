package badicecream.controller.menus;

import badicecream.Game;
import badicecream.controller.menu.MainMenuController;
import badicecream.gui.Gui;
import badicecream.model.menu.MainMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoInteractions;

public class MainMenuControllerTest {
    private MainMenuController mainMenuController;
    private MainMenu mockedMainMenu;
    private Game mockedGame;

    @BeforeEach
    public void setup() {
        mockedMainMenu = mock(MainMenu.class);
        mockedGame = mock(Game.class);

        mainMenuController = new MainMenuController(mockedMainMenu);
    }

    @Test
    public void stepUpActionTest() throws IOException {
        mainMenuController.step(mockedGame, Gui.Actions.UP, 0);


        verify(mockedMainMenu).previousEntry();
        verifyNoInteractions(mockedGame);
    }

    @Test
    public void stepDownActionTest() throws IOException {
        mainMenuController.step(mockedGame, Gui.Actions.DOWN, 0);

        verify(mockedMainMenu).nextEntry();
        verifyNoInteractions(mockedGame);
    }

    @Test
    public void stepSelectStartTest() throws IOException {
        when(mockedMainMenu.isSelectedStart()).thenReturn(true);
        when(mockedMainMenu.isSelectedExit()).thenReturn(false);

        mainMenuController.step(mockedGame, Gui.Actions.SELECT, 0);

        verify(mockedMainMenu).isSelectedStart();
        verify(mockedGame).setState(any());
    }

    @Test
    public void stepSelectExitTest() throws IOException {
        when(mockedMainMenu.isSelectedStart()).thenReturn(false);
        when(mockedMainMenu.isSelectedExit()).thenReturn(true);

        mainMenuController.step(mockedGame, Gui.Actions.SELECT, 0);

        verify(mockedMainMenu).isSelectedExit();
        verify(mockedGame).setState(null);
    }
}
