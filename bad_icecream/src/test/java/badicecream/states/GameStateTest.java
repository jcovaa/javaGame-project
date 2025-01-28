package badicecream.states;

import badicecream.Game;
import badicecream.controller.Controller;
import badicecream.controller.game.ArenaController;
import badicecream.gui.Gui;
import badicecream.model.arena.Arena;
import badicecream.view.Viewer;
import badicecream.view.game.GameViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class GameStateTest {
    private GameState gameState;
    private Arena mockedArena;
    private ArenaController mockedController;
    private GameViewer mockedViewer;
    private Game mockedGame;

    @BeforeEach
    public void setup() throws IOException {
        mockedArena = mock(Arena.class);

        gameState = new GameState(mockedArena);
    }

    @Test
    public void getViewerTest() throws IOException {
        Viewer<Arena> viewer = gameState.getViewer();

        Assertions.assertNotNull(viewer);
        Assertions.assertInstanceOf(GameViewer.class, viewer);
    }

    @Test
    public void getControllerTest() {
        Controller<Arena> controller = gameState.getController();

        Assertions.assertNotNull(controller);
        Assertions.assertInstanceOf(ArenaController.class, controller);
    }

    @Test
    public void stateInitializationTest() {
        Assertions.assertEquals(mockedArena, gameState.getModel());
    }

    @Test
    public void stepTest() throws IOException {
        Gui mockedGui = mock(Gui.class);
        mockedController = mock(ArenaController.class);
        mockedViewer = mock(GameViewer.class);

        gameState = new GameState(mockedArena) {
            @Override
            protected Viewer<Arena> getViewer() {
                return mockedViewer;
            }

            @Override
            protected Controller<Arena> getController() {
                return mockedController;
            }
        };

        when(mockedGui.getNextAction()).thenReturn(Gui.Actions.QUIT);

        gameState.step(null, mockedGui, 0);

        verify(mockedGui).getNextAction();
        verify(mockedController).step(mockedGame, Gui.Actions.QUIT, 0);
        verify(mockedViewer).draw(mockedGui);
    }
}
