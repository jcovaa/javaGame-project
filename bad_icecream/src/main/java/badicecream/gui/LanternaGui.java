package badicecream.gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class LanternaGui implements Gui{
    private final Screen screen;

    public LanternaGui(Screen screen) {
        this.screen = screen;
    }

    @Override
    public void drawPlayer(int x, int y) {
        drawCharacter(x, y, '@', "#FFD700");
    }

    @Override
    public void drawMonster(int x, int y) {
        drawCharacter(x, y, 'M', "#FF0000");
    }

    @Override
    public void drawWall(int x, int y) {
        drawCharacter(x, y, '#', "#0C082E");
    }

    @Override
    public void drawIceWall(int x, int y) {
        drawCharacter(x, y, '*', "#00FFFF");
    }

    @Override
    public void drawBanana(int x, int y) {
        drawCharacter(x, y, 'B', "#FFFF00");
    }

    @Override
    public void drawWaterMelon(int x, int y) {
        drawCharacter(x, y, 'W', "#00FF00");
    }

    @Override
    public void drawCharacter(int x, int y, char c, String color) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.putString(new TerminalPosition(x, y), String.valueOf(c));
    }

    @Override
    public void drawText(int x, int y, String text, String color) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.putString(x, y, text);
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

    public Actions getNextAction() throws IOException{
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return Actions.NONE;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return Actions.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return Actions.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return Actions.LEFT;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return Actions.RIGHT;

        if (keyStroke.getKeyType() == KeyType.EOF) return Actions.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return Actions.QUIT;

        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'e') return  Actions.BUILD;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'f') return  Actions.BREAK;

        if (keyStroke.getKeyType() == KeyType.Enter) return Actions.SELECT;

        return Actions.NONE;
    }

    @Override
    public void drawPixel(double x, double y, TextColor color) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(color);
        graphics.setCharacter((int) x, (int) y, ' ');
    }
}
