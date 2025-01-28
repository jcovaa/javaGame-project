package badicecream.view.game.fruits;

import badicecream.gui.Gui;
import badicecream.model.elements.fruits.Banana;
import badicecream.view.SpriteRenderer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class BananaViewerTest {
    private SpriteRenderer mockedSpriteRenderer;
    private Gui mockedGui;
    private Banana mockedBanana;
    private BananaViewer bananaViewer;

    @BeforeEach
    public void setup() {
        mockedSpriteRenderer = mock(SpriteRenderer.class);
        mockedGui = mock(Gui.class);
        mockedBanana = mock(Banana.class);

        bananaViewer = new BananaViewer(mockedSpriteRenderer);
    }

    @Test
    public void bananaDrawTest() {
        when(mockedBanana.getX()).thenReturn(2);
        when(mockedBanana.getY()).thenReturn(3);

        bananaViewer.draw(mockedBanana, mockedGui);

        verify(mockedSpriteRenderer).draw(mockedGui, 2, 3);
    }
}
