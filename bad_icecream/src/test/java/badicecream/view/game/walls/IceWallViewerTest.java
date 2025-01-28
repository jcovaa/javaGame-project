package badicecream.view.game.walls;

import badicecream.gui.Gui;
import badicecream.model.elements.walls.IceWall;
import badicecream.view.SpriteRenderer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.mockito.Mockito.*;

public class IceWallViewerTest {
    private SpriteRenderer mockedSpriteRenderer;
    private Gui mockedGui;
    private IceWall mockedIceWall;
    private IceWallViewer iceWallViewer;

    @BeforeEach
    public void setup() {
        mockedSpriteRenderer = mock(SpriteRenderer.class);
        mockedGui = mock(Gui.class);
        mockedIceWall = mock(IceWall.class);

        iceWallViewer = new IceWallViewer(mockedSpriteRenderer);
    }

    @Test
    public void drawIceWallTest() throws IOException {
        when(mockedIceWall.getX()).thenReturn(2);
        when(mockedIceWall.getY()).thenReturn(3);

        iceWallViewer.draw(mockedIceWall, mockedGui);

        verify(mockedSpriteRenderer).draw(mockedGui, 2, 3);
    }
}
