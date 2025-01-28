package badicecream.view;

import badicecream.gui.Gui;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class SpriteRendererTest {
    private SpriteRenderer spriteRenderer;
    private Gui mockedGui;

    private TextColor getColor(int r, int g, int b) {
        return new TextColor.RGB(r, g, b);
    }

    @BeforeEach
    public void setup() throws IOException {
        String image = "sprites/sprite-test.png";
        spriteRenderer = new SpriteRenderer(image);

        mockedGui = mock(Gui.class);
    }

    @Test
    public void drawTest() {
        spriteRenderer.draw(mockedGui, 0, 0);

        verify(mockedGui).drawPixel(0, 0, getColor(0, 0, 0));
        verify(mockedGui).drawPixel(1, 0, getColor(255, 255, 255));
        verify(mockedGui).drawPixel(0, 1, getColor(255, 255, 255));
        verify(mockedGui).drawPixel(1, 1, getColor(0, 0, 0));

    }
}
