package badicecream.view.game.characters;

import badicecream.gui.Gui;
import badicecream.model.elements.characters.Monster;
import badicecream.view.SpriteRenderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class MonsterViewerTest {
    private SpriteRenderer mockedUpSprite;
    private SpriteRenderer mockedDownSprite;
    private SpriteRenderer mockedLeftSprite;
    private SpriteRenderer mockedRightSprite;
    private Gui mockedGui;
    private Monster mockedMonster;
    private MonsterViewer monsterViewer;

    @BeforeEach
    public void setup() {
        mockedUpSprite = mock(SpriteRenderer.class);
        mockedDownSprite = mock(SpriteRenderer.class);
        mockedLeftSprite = mock(SpriteRenderer.class);
        mockedRightSprite = mock(SpriteRenderer.class);
        mockedGui = mock(Gui.class);
        mockedMonster = mock(Monster.class);

        monsterViewer = new MonsterViewer(mockedUpSprite, mockedDownSprite, mockedLeftSprite, mockedRightSprite);
    }

    @Test
    public void drawUpSpriteTest() throws IOException {
        when(mockedMonster.getDirection()).thenReturn("UP");
        when(mockedMonster.getX()).thenReturn(3);
        when(mockedMonster.getY()).thenReturn(2);

        monsterViewer.draw(mockedMonster, mockedGui);

        verify(mockedUpSprite).draw(mockedGui, 3, 2);
    }

    @Test
    public void drawDownSpriteTest() throws IOException {
        when(mockedMonster.getDirection()).thenReturn("DOWN");
        when(mockedMonster.getX()).thenReturn(3);
        when(mockedMonster.getY()).thenReturn(4);

        monsterViewer.draw(mockedMonster, mockedGui);

        verify(mockedDownSprite).draw(mockedGui, 3, 4);
    }

    @Test
    public void drawLeftSpriteTest() throws IOException {
        when(mockedMonster.getDirection()).thenReturn("LEFT");
        when(mockedMonster.getX()).thenReturn(5);
        when(mockedMonster.getY()).thenReturn(6);

        monsterViewer.draw(mockedMonster, mockedGui);

        verify(mockedLeftSprite).draw(mockedGui, 5, 6);
    }

    @Test
    public void drawRightSpriteTest() throws IOException {
        when(mockedMonster.getDirection()).thenReturn("RIGHT");
        when(mockedMonster.getX()).thenReturn(7);
        when(mockedMonster.getY()).thenReturn(8);

        monsterViewer.draw(mockedMonster, mockedGui);

        verify(mockedRightSprite).draw(mockedGui, 7, 8);
    }

    @Test
    public void drawInvalidDirectionTest() {
        when(mockedMonster.getDirection()).thenReturn("INVALID");

        Assertions.assertThrows(IllegalArgumentException.class, () -> monsterViewer.draw(mockedMonster, mockedGui));
    }
}
