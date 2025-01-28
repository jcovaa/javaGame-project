package badicecream.states;

import badicecream.Game;
import badicecream.controller.Controller;
import badicecream.controller.menu.CreditsMenuController;
import badicecream.gui.Gui;
import badicecream.model.menu.CreditsMenu;
import badicecream.view.Viewer;
import badicecream.view.menu.CreditsMenuViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.mockito.Mockito.*;

public class CreditsMenuStateTest {
    private CreditsMenuState creditsMenuState;
    private CreditsMenu mockedCreditsMenu;
    private CreditsMenuController mockedController;
    private CreditsMenuViewer mockedViewer;

    @BeforeEach
    public void setup() throws IOException {
        mockedCreditsMenu = mock(CreditsMenu.class);

        creditsMenuState = new CreditsMenuState(mockedCreditsMenu);

        when(mockedCreditsMenu.createEntries()).thenReturn(Arrays.asList("Restart", "Quit"));
    }

    @Test
    public void getViewerTest() {
        Viewer<CreditsMenu> viewer = creditsMenuState.getViewer();

        Assertions.assertNotNull(viewer);
        Assertions.assertInstanceOf(CreditsMenuViewer.class, viewer);
    }

    @Test
    public void getControllerTest() {
        Controller<CreditsMenu> controller = creditsMenuState.getController();

        Assertions.assertNotNull(controller);
        Assertions.assertInstanceOf(CreditsMenuController.class, controller);
    }

    @Test
    public void stateInitialization() {
        Assertions.assertEquals(mockedCreditsMenu, creditsMenuState.getModel());
    }

    @Test
    public void stepTest() throws IOException {
        Game mockedGame = mock(Game.class);
        Gui mockedGui = mock(Gui.class);
        mockedController = mock(CreditsMenuController.class);
        mockedViewer = mock(CreditsMenuViewer.class);

        creditsMenuState = new CreditsMenuState(mockedCreditsMenu) {
            @Override
            protected Viewer<CreditsMenu> getViewer() {
                return mockedViewer;
            }

            @Override
            protected Controller<CreditsMenu> getController() {
                return mockedController;
            }
        };

        when(mockedGui.getNextAction()).thenReturn(Gui.Actions.SELECT);

        creditsMenuState.step(mockedGame, mockedGui, 0);

        verify(mockedGui).getNextAction();
        verify(mockedController).step(mockedGame, Gui.Actions.SELECT, 0);
        verify(mockedViewer).draw(mockedGui);

    }
}
