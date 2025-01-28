package badicecream.view.game;

import badicecream.gui.Gui;
import badicecream.view.SpriteRenderer;

import java.io.IOException;

public class BackgroundRenderer {
    private final SpriteRenderer sprite;

    public BackgroundRenderer() throws IOException {
        this.sprite = new SpriteRenderer("sprites/background.png");
    }

    public void drawBackground(Gui gui, int gridWidth, int gridHeight) {
        for (int y = 0; y < gridHeight; y++) {
            for (int x = 0; x < gridWidth; x++) {
                sprite.draw(gui, x, y);
            }
        }
    }
}
