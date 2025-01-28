package badicecream.view.game;

import badicecream.gui.Gui;
import badicecream.model.arena.Arena;
import badicecream.model.arena.Grid;
import badicecream.model.elements.characters.Monster;
import badicecream.model.elements.characters.Player;
import badicecream.model.elements.fruits.Banana;
import badicecream.model.elements.fruits.WaterMelon;
import badicecream.model.elements.walls.IceWall;
import badicecream.model.elements.walls.Wall;
import badicecream.view.game.characters.MonsterViewer;
import badicecream.view.game.characters.PlayerViewer;
import badicecream.view.game.fruits.BananaViewer;
import badicecream.view.game.fruits.WaterMelonViewer;
import badicecream.view.game.walls.IceWallViewer;
import badicecream.view.game.walls.WallViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.*;

public class GameViewerTest {
    private PlayerViewer mockedPlayerViewer;
    private MonsterViewer mockedMonsterViewer;
    private BananaViewer mockedBananaViewer;
    private WaterMelonViewer mockedWaterMelonViewer;
    private WallViewer mockedWallViewer;
    private IceWallViewer mockedIceWallViewer;
    private BackgroundRenderer mockedBackgroundRenderer;
    private Gui mockedGui;

    private Player mockedPlayer;
    private Monster mockedMonster;
    private Wall mockedWall;
    private IceWall mockedIceWall;
    private Banana mockedBanana;
    private WaterMelon mockedWaterMelon;
    private GameViewer gameViewer;

    @BeforeEach
    public void setup() throws IOException {
        mockedPlayerViewer = mock(PlayerViewer.class);
        mockedMonsterViewer = mock(MonsterViewer.class);
        mockedBananaViewer = mock(BananaViewer.class);
        mockedWaterMelonViewer = mock(WaterMelonViewer.class);
        mockedWallViewer = mock(WallViewer.class);
        mockedIceWallViewer = mock(IceWallViewer.class);
        mockedBackgroundRenderer = mock(BackgroundRenderer.class);
        mockedGui = mock(Gui.class);
        Arena mockedArena = mock(Arena.class);

        Grid mockedGrid = mock(Grid.class);
        mockedPlayer = mock(Player.class);
        mockedMonster = mock(Monster.class);
        mockedWall = mock(Wall.class);
        mockedIceWall = mock(IceWall.class);
        mockedBanana = mock(Banana.class);
        mockedWaterMelon = mock(WaterMelon.class);

        when(mockedArena.getGrid()).thenReturn(mockedGrid);
        when(mockedGrid.getHeight()).thenReturn(16); // Example grid height
        when(mockedGrid.getWidth()).thenReturn(16);  // Example grid width
        when(mockedArena.getPlayer()).thenReturn(mockedPlayer);
        when(mockedArena.getMonsters()).thenReturn(List.of(mockedMonster));
        when(mockedArena.getWalls()).thenReturn(List.of(mockedWall));
        when(mockedArena.getIceWalls()).thenReturn(List.of(mockedIceWall));
        when(mockedArena.getBananas()).thenReturn(List.of(mockedBanana));
        when(mockedArena.getWaterMelons()).thenReturn(List.of(mockedWaterMelon));

        gameViewer = new GameViewer(mockedArena, mockedPlayerViewer, mockedMonsterViewer, mockedBananaViewer, mockedWaterMelonViewer, mockedWallViewer, mockedIceWallViewer, mockedBackgroundRenderer);
    }

    @Test
    public void drawElementsTest() throws IOException {
        gameViewer.drawElements(mockedGui);

        verify(mockedPlayerViewer).draw(mockedPlayer, mockedGui);
        verify(mockedMonsterViewer).draw(mockedMonster, mockedGui);
        verify(mockedBananaViewer).draw(mockedBanana, mockedGui);
        verify(mockedWaterMelonViewer).draw(mockedWaterMelon, mockedGui);
        verify(mockedWallViewer).draw(mockedWall, mockedGui);
        verify(mockedIceWallViewer).draw(mockedIceWall, mockedGui);
        verify(mockedBackgroundRenderer).drawBackground(mockedGui, 16, 16);
    }
}
