package badicecream.view.game.fruits;

import badicecream.gui.Gui;
import badicecream.model.elements.fruits.WaterMelon;
import badicecream.view.SpriteRenderer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class WaterMelonViewerTest {
    private SpriteRenderer mockedSpriteRenderer;
    private Gui mockedGui;
    private WaterMelon mockedWaterMelon;
    private WaterMelonViewer waterMelonViewer;

    @BeforeEach
    public void setup() {
        mockedSpriteRenderer = mock(SpriteRenderer.class);
        mockedGui = mock(Gui.class);
        mockedWaterMelon = mock(WaterMelon.class);

        waterMelonViewer = new WaterMelonViewer(mockedSpriteRenderer);
    }

    @Test
    public void drawWaterMelonTest() {
        when(mockedWaterMelon.getX()).thenReturn(2);
        when(mockedWaterMelon.getY()).thenReturn(3);

        waterMelonViewer.draw(mockedWaterMelon, mockedGui);

        verify(mockedSpriteRenderer).draw(mockedGui, 2, 3);
    }
}
