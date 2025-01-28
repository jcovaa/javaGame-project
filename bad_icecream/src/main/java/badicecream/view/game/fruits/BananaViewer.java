package badicecream.view.game.fruits;

import badicecream.gui.Gui;
import badicecream.model.elements.fruits.Banana;
import badicecream.view.SpriteRenderer;
import badicecream.view.game.ElementViewer;

import java.io.IOException;

public class BananaViewer implements ElementViewer<Banana> {
    private final SpriteRenderer sprite;

    public BananaViewer() throws IOException {
        this(new SpriteRenderer("sprites/fruits/banana.png"));
    }

    public BananaViewer(SpriteRenderer sprite) {
        this.sprite = sprite;
    }

    @Override
    public void draw(Banana banana, Gui gui) {
        sprite.draw(gui, banana.getX(), banana.getY());
    }
}
