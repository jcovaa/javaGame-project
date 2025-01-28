package badicecream.view.game.walls;

import badicecream.gui.Gui;
import badicecream.model.elements.walls.Wall;
import badicecream.view.SpriteRenderer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class WallViewerTest {
    private SpriteRenderer mockedSpriteRenderer;
    private Gui mockedGui;
    private Wall mockedWall;
    private WallViewer wallViewer;

    @BeforeEach
    public void setup() {
        mockedSpriteRenderer = mock(SpriteRenderer.class);
        mockedGui = mock(Gui.class);
        mockedWall = mock(Wall.class);

        wallViewer = new WallViewer(mockedSpriteRenderer);
    }

    @Test
    public void drawWallTest() {
        when(mockedWall.getX()).thenReturn(2);
        when(mockedWall.getY()).thenReturn(3);

        wallViewer.draw(mockedWall, mockedGui);

        verify(mockedSpriteRenderer).draw(mockedGui, mockedWall.getX(), mockedWall.getY());
    }

}

