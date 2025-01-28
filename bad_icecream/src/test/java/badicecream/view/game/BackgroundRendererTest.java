package badicecream.view.game;

import badicecream.gui.Gui;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class BackgroundRendererTest {

    @Property
    public void drawBackgroundTest(
        @ForAll @IntRange(min = 1, max = 16) int gridWidth,
        @ForAll @IntRange(min = 1, max = 16) int gridHeight) throws IOException {

        Gui mockedGui = mock(Gui.class);
        BackgroundRenderer backgroundRenderer = new BackgroundRenderer();

        int nrTests = gridWidth * gridHeight;
        backgroundRenderer.drawBackground(mockedGui, gridWidth, gridHeight);

        verify(mockedGui, atLeast(nrTests)).drawPixel(anyDouble(), anyDouble(), any());
    }
}
