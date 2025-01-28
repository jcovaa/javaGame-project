package badicecream.gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class LanternGuiTest {

    private LanternaGui lanternaGui;
    private Screen screen;
    private TextGraphics textGraphics;
    private TextColor color;

    @BeforeEach
     void setup(){

        screen = Mockito.mock(Screen.class);
        textGraphics = Mockito.mock(TextGraphics.class);
        color = Mockito.mock(TextColor.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(textGraphics);
        lanternaGui = new LanternaGui(screen);
    }

    @Test
    void drawCharacter(){
        lanternaGui.drawCharacter(5,5,'a',"#FFD700");
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255,215,0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(new TerminalPosition(5,5), "a");
    }


    @Test
    void drawPlayer(){
        lanternaGui.drawPlayer(5,5);
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255,215,0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(new TerminalPosition(5,5), "@");
    }

    @Test
    void drawMonster(){
        lanternaGui.drawMonster(5,5);
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255,0,0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(new TerminalPosition(5,5), "M");
    }

    @Test
    void drawWall(){
        lanternaGui.drawWall(5,5);
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(12,8,46));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(new TerminalPosition(5,5), "#");
    }

    @Test
    void drawIceWall(){
        lanternaGui.drawIceWall(5,5);
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0,255,255));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(new TerminalPosition(5,5), "*");
    }

    @Test
    void drawBanana(){
        lanternaGui.drawBanana(5,5);
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255,255,0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(new TerminalPosition(5,5), "B");
    }

    @Test
    void drawWatermelon(){
        lanternaGui.drawWaterMelon(5,5);
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0,255,0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(new TerminalPosition(5,5), "W");
    }

    @Test
    void drawTest(){
        lanternaGui.drawText(5,5,"BadIceCream Game", "#FFD700");
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255,215,0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(5,5, "BadIceCream Game");
    }

    @Test
    void clear(){
        lanternaGui.clear();
        Mockito.verify(screen, Mockito.atLeastOnce()).clear();
    }

    @Test
    void refresh() throws IOException {
        lanternaGui.refresh();
        Mockito.verify(screen, Mockito.atLeastOnce()).refresh();
    }

    @Test
    void close() throws IOException {
        lanternaGui.close();
        Mockito.verify(screen, Mockito.atLeastOnce()).close();
    }

    @Test
    void drawPixel(){
        lanternaGui.drawPixel(5,5, color);
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(color);
        Mockito.verify(textGraphics, Mockito.times(1)).setCharacter(5,5, ' ');
    }

    @Test
    public void getNextActionUpTest() throws IOException {
        KeyStroke mockKeyStroke = mock(KeyStroke.class);
        when(mockKeyStroke.getKeyType()).thenReturn(KeyType.ArrowUp);
        when(screen.pollInput()).thenReturn(mockKeyStroke);

        Gui.Actions action = lanternaGui.getNextAction();

        Assertions.assertEquals(Gui.Actions.UP, action);
    }

    @Test
    public void getNextActionDownTest() throws IOException {
        KeyStroke mockKeyStroke = mock(KeyStroke.class);
        when(mockKeyStroke.getKeyType()).thenReturn(KeyType.ArrowDown);
        when(screen.pollInput()).thenReturn(mockKeyStroke);

        Gui.Actions action = lanternaGui.getNextAction();

        Assertions.assertEquals(Gui.Actions.DOWN, action);
    }

    @Test
    public void getNextActionLeftTest() throws IOException {
        KeyStroke mockKeyStroke = mock(KeyStroke.class);
        when(mockKeyStroke.getKeyType()).thenReturn(KeyType.ArrowLeft);
        when(screen.pollInput()).thenReturn(mockKeyStroke);

        Gui.Actions action = lanternaGui.getNextAction();

        Assertions.assertEquals(Gui.Actions.LEFT, action);
    }

    @Test
    public void getNextActionRightTest() throws IOException {
        KeyStroke mockKeyStroke = mock(KeyStroke.class);
        when(mockKeyStroke.getKeyType()).thenReturn(KeyType.ArrowRight);
        when(screen.pollInput()).thenReturn(mockKeyStroke);

        Gui.Actions action = lanternaGui.getNextAction();

        Assertions.assertEquals(Gui.Actions.RIGHT, action);
    }

    @Test
    public void getNextActionQuit2Test() throws IOException {
        KeyStroke mockKeyStroke = mock(KeyStroke.class);
        when(mockKeyStroke.getKeyType()).thenReturn(KeyType.EOF);
        when(screen.pollInput()).thenReturn(mockKeyStroke);

        Gui.Actions action = lanternaGui.getNextAction();

        Assertions.assertEquals(Gui.Actions.QUIT, action);
    }

    @Test
    public void getNextActionQuit1Test() throws IOException {
        KeyStroke mockKeyStroke = mock(KeyStroke.class);
        when(mockKeyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(mockKeyStroke.getCharacter()).thenReturn('q');
        when(screen.pollInput()).thenReturn(mockKeyStroke);

        Gui.Actions action = lanternaGui.getNextAction();

        Assertions.assertEquals(Gui.Actions.QUIT, action);
    }

    @Test
    public void getNextActionBuildTest() throws IOException {
        KeyStroke mockKeyStroke = mock(KeyStroke.class);
        when(mockKeyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(mockKeyStroke.getCharacter()).thenReturn('e');
        when(screen.pollInput()).thenReturn(mockKeyStroke);

        Gui.Actions action = lanternaGui.getNextAction();

        Assertions.assertEquals(Gui.Actions.BUILD, action);
    }

    @Test
    public void getNextActionBreakTest() throws IOException {
        KeyStroke mockKeyStroke = mock(KeyStroke.class);
        when(mockKeyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(mockKeyStroke.getCharacter()).thenReturn('f');
        when(screen.pollInput()).thenReturn(mockKeyStroke);

        Gui.Actions action = lanternaGui.getNextAction();

        Assertions.assertEquals(Gui.Actions.BREAK, action);
    }


    @Test
    public void getNextActionSelectTest() throws IOException {
        KeyStroke mockKeyStroke = mock(KeyStroke.class);
        when(mockKeyStroke.getKeyType()).thenReturn(KeyType.Enter);
        when(screen.pollInput()).thenReturn(mockKeyStroke);

        Gui.Actions action = lanternaGui.getNextAction();

        Assertions.assertEquals(Gui.Actions.SELECT, action);
    }

    @Test
    public void getNextActionNoneTest() throws IOException {
        when(screen.pollInput()).thenReturn(null);

        Gui.Actions action = lanternaGui.getNextAction();

        Assertions.assertEquals(Gui.Actions.NONE, action);
    }

    @Test
    public void getNextActionNothingTest() throws IOException{
        KeyStroke mockKeyStroke = mock(KeyStroke.class);
        when(mockKeyStroke.getKeyType()).thenReturn(KeyType.Escape);
        when(screen.pollInput()).thenReturn(mockKeyStroke);

        Gui.Actions action = lanternaGui.getNextAction();

        Assertions.assertEquals(Gui.Actions.NONE, action);
    }
}
