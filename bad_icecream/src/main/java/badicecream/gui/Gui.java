package badicecream.gui;

import com.googlecode.lanterna.TextColor;

import java.io.IOException;

public interface Gui {
    Actions getNextAction() throws IOException;

    void drawPlayer(int x, int y);

    void drawMonster(int x, int y);

    void drawWall(int x, int y);

    void drawIceWall(int x, int y);

    void drawBanana(int x, int y);

    void drawWaterMelon(int x, int y);

    void drawCharacter(int x, int y, char c, String color);

    void drawText(int x, int y, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum Actions {UP, DOWN, LEFT, RIGHT, QUIT, SELECT, BUILD, BREAK, NONE}

    void drawPixel(double x, double y, TextColor color);
}
