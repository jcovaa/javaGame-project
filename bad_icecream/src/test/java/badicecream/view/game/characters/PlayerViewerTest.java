package badicecream.view.game.characters;

import badicecream.gui.Gui;
import badicecream.model.elements.characters.Player;
import badicecream.view.SpriteRenderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class PlayerViewerTest {
    private SpriteRenderer mockedUpSprite;
    private SpriteRenderer mockedDownSprite;
    private SpriteRenderer mockedLeftSprite;
    private SpriteRenderer mockedRightSprite;
    private Gui mockedGui;
    private Player mockedPlayer;
    private PlayerViewer playerViewer;

    @BeforeEach
    public void setup() {
        mockedUpSprite = mock(SpriteRenderer.class);
        mockedDownSprite = mock(SpriteRenderer.class);
        mockedLeftSprite = mock(SpriteRenderer.class);
        mockedRightSprite = mock(SpriteRenderer.class);
        mockedGui = mock(Gui.class);
        mockedPlayer = mock(Player.class);

        playerViewer = new PlayerViewer(mockedUpSprite, mockedDownSprite, mockedLeftSprite, mockedRightSprite);
    }

    @Test
    public void drawUpSpriteTest() {
        when(mockedPlayer.getDirection()).thenReturn("UP");
        when(mockedPlayer.getX()).thenReturn(3);
        when(mockedPlayer.getY()).thenReturn(2);

        playerViewer.draw(mockedPlayer, mockedGui);

        verify(mockedUpSprite).draw(mockedGui, 3, 2);
    }

    @Test
    public void drawDownSpriteTest() {
        when(mockedPlayer.getDirection()).thenReturn("DOWN");
        when(mockedPlayer.getX()).thenReturn(3);
        when(mockedPlayer.getY()).thenReturn(4);

        playerViewer.draw(mockedPlayer, mockedGui);

        verify(mockedDownSprite).draw(mockedGui, 3, 4);
    }

    @Test
    public void drawLeftSpriteTest() {
        when(mockedPlayer.getDirection()).thenReturn("LEFT");
        when(mockedPlayer.getX()).thenReturn(5);
        when(mockedPlayer.getY()).thenReturn(6);

        playerViewer.draw(mockedPlayer, mockedGui);

        verify(mockedLeftSprite).draw(mockedGui, 5, 6);
    }

    @Test
    public void drawRightSpriteTest() {
        when(mockedPlayer.getDirection()).thenReturn("RIGHT");
        when(mockedPlayer.getX()).thenReturn(7);
        when(mockedPlayer.getY()).thenReturn(8);

        playerViewer.draw(mockedPlayer, mockedGui);

        verify(mockedRightSprite).draw(mockedGui, 7, 8);
    }

    @Test
    public void drawInvalidDirectionTest() {
        when(mockedPlayer.getDirection()).thenReturn("INVALID");

        Assertions.assertThrows(IllegalArgumentException.class, () -> playerViewer.draw(mockedPlayer, mockedGui));
    }
}
