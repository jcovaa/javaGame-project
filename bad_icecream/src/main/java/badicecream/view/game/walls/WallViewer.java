package badicecream.view.game.walls;

import badicecream.gui.Gui;
import badicecream.model.elements.walls.Wall;
import badicecream.view.SpriteRenderer;
import badicecream.view.game.ElementViewer;

import java.io.IOException;

public class WallViewer implements ElementViewer<Wall> {
    private final SpriteRenderer sprite;

    public WallViewer() throws IOException {
        this(new SpriteRenderer("sprites/walls/wall.png"));
    }

    public WallViewer(SpriteRenderer sprite) {
        this.sprite = sprite;
    }

    @Override
    public void draw(Wall wall, Gui gui) {
        sprite.draw(gui, wall.getX(), wall.getY());
    }
}
