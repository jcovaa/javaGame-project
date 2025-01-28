package badicecream.view.game.fruits;

import badicecream.gui.Gui;
import badicecream.model.elements.fruits.WaterMelon;
import badicecream.view.SpriteRenderer;
import badicecream.view.game.ElementViewer;

import java.io.IOException;

public class WaterMelonViewer implements ElementViewer<WaterMelon> {
    private final SpriteRenderer sprite;

    public WaterMelonViewer() throws IOException {
        this(new SpriteRenderer("sprites/fruits/watermelon.png"));
    }

    public WaterMelonViewer(SpriteRenderer sprite) {
        this.sprite = sprite;
    }

    @Override
    public void draw(WaterMelon waterMelon, Gui gui) {
        sprite.draw(gui, waterMelon.getX(), waterMelon.getY());
    }
}
