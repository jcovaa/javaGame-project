package badicecream.states;

import badicecream.Game;
import badicecream.controller.Controller;
import badicecream.controller.menu.MainMenuController;
import badicecream.gui.Gui;
import badicecream.model.menu.MainMenu;
import badicecream.view.Viewer;
import badicecream.view.menu.MainMenuViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.mockito.Mockito.*;

public class MainMenuStateTest {
    private MainMenuState mainMenuState;
    private MainMenu mockedMainMenu;
    private MainMenuController mockedController;
    private MainMenuViewer mockedViewer;

    @BeforeEach
    public void setup() throws IOException {
        mockedMainMenu = mock(MainMenu.class);

        mainMenuState = new MainMenuState(mockedMainMenu);

        when(mockedMainMenu.createEntries()).thenReturn(Arrays.asList("Start", "Quit"));
    }

    @Test
    public void getViewerTest() {
        Viewer<MainMenu> viewer = mainMenuState.getViewer();

        Assertions.assertNotNull(viewer);
        Assertions.assertInstanceOf(MainMenuViewer.class, viewer);
    }

    @Test
    public void getControllerTest() {
        Controller<MainMenu> controller = mainMenuState.getController();

        Assertions.assertNotNull(controller);
        Assertions.assertInstanceOf(MainMenuController.class, controller);
    }

    @Test
    public void stateInitialization() {
        Assertions.assertEquals(mockedMainMenu, mainMenuState.getModel());
    }

    @Test
    public void stepTest() throws IOException {
        Gui mockedGui = mock(Gui.class);
        Game mockedGame = mock(Game.class);
        mockedController = mock(MainMenuController.class);
        mockedViewer = mock(MainMenuViewer.class);

        when(mockedGui.getNextAction()).thenReturn(Gui.Actions.DOWN);

        mainMenuState = new MainMenuState(mockedMainMenu) {
            @Override
            protected Viewer<MainMenu> getViewer() {
                return mockedViewer;
            }

            @Override
            protected Controller<MainMenu> getController() {
                return mockedController;
            }
        };

        when(mockedGui.getNextAction()).thenReturn(Gui.Actions.DOWN);

        mainMenuState.step(mockedGame, mockedGui, 0);

        verify(mockedGui).getNextAction();
        verify(mockedController).step(mockedGame, Gui.Actions.DOWN, 0);
        verify(mockedViewer).draw(mockedGui);
    }
}
