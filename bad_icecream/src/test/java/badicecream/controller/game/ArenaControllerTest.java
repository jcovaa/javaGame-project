package badicecream.controller.game;

import badicecream.Game;
import badicecream.controller.GameConfig;
import badicecream.gui.Gui;
import badicecream.model.arena.Arena;
import badicecream.model.elements.characters.Player;
import badicecream.states.CreditsMenuState;
import badicecream.states.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ArenaControllerTest {
    private ArenaController arenaController;
    private Game mockedGame;
    private Arena mockedArena;
    private Player mockedPlayer;
    private  PlayerController mockedPlayerController;
    private MonsterController mockedMonsterController;
    private FruitController mockedFruitController;

    @BeforeEach
    public void setup() throws Exception {
        mockedGame = mock(Game.class);
        mockedArena = mock(Arena.class);
        mockedPlayer = mock(Player.class);
        mockedPlayerController = mock(PlayerController.class);
        mockedMonsterController = mock(MonsterController.class);
        mockedFruitController = mock(FruitController.class);

        when(mockedArena.getPlayer()).thenReturn(mockedPlayer);
        when(mockedArena.getLevel()).thenReturn(1);

        arenaController = new ArenaController(mockedArena, mockedPlayerController, mockedMonsterController, mockedFruitController);
    }

    @Test
    public void stepPlayerQuitTest() throws IOException {
        when(mockedFruitController.allFruitsCollected()).thenReturn(false);
        when(mockedPlayer.isAlive()).thenReturn(true);

        arenaController.step(mockedGame, Gui.Actions.QUIT, 0);

        verify(mockedGame).setState(any(CreditsMenuState.class));
    }

    @Test
    public void stepPlayerDiesTest() throws IOException {
        when(mockedFruitController.allFruitsCollected()).thenReturn(false);
        when(mockedPlayer.isAlive()).thenReturn(false);

        arenaController.step(mockedGame, Gui.Actions.NONE, 0);

        verify(mockedGame).setState(any(CreditsMenuState.class));
    }

    @Test
    public void stepAllFruitsCollectedTest() throws IOException {
        when(mockedFruitController.allFruitsCollected()).thenReturn(true);
        when(mockedArena.getLevel()).thenReturn(GameConfig.TOTAL_LEVELS);
        when(mockedPlayer.isAlive()).thenReturn(true);

        arenaController.step(mockedGame, Gui.Actions.NONE, 0);

        verify(mockedGame).setState(any(CreditsMenuState.class));
    }

    @Test
    public void stepAllFruitsCollectedNextLevelTest() throws IOException {
        when(mockedFruitController.allFruitsCollected()).thenReturn(true);
        when(mockedArena.getLevel()).thenReturn(1);
        when(mockedPlayer.isAlive()).thenReturn(true);

        arenaController.step(mockedGame, Gui.Actions.NONE, 0);

        verify(mockedGame).setState(any(GameState.class));
    }

    @Test
    public void stepContinuesGameTest() throws IOException {
        when(mockedFruitController.allFruitsCollected()).thenReturn(false);
        when(mockedPlayer.isAlive()).thenReturn(true);

        arenaController.step(mockedGame, Gui.Actions.NONE, 0);

        verify(mockedPlayerController).step(mockedGame, Gui.Actions.NONE, 0);
        verify(mockedMonsterController).step(mockedGame, Gui.Actions.NONE, 0);
        verify(mockedFruitController).step(mockedGame, Gui.Actions.NONE, 0);

        verify(mockedGame, never()).setState(any());
    }
}
