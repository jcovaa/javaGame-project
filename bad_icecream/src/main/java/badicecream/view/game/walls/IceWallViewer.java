package badicecream.view.game.walls;

import badicecream.gui.Gui;
import badicecream.model.elements.walls.IceWall;
import badicecream.view.SpriteRenderer;
import badicecream.view.game.ElementViewer;

import java.io.IOException;

public class IceWallViewer implements ElementViewer<IceWall> {
    private final SpriteRenderer sprite;

    public IceWallViewer() throws IOException {
        this(new SpriteRenderer("sprites/walls/iceWall.png"));
    }

    public IceWallViewer(SpriteRenderer sprite) {
        this.sprite = sprite;
    }

    @Override
    public void draw(IceWall iceWall, Gui gui) throws IOException {
        sprite.draw(gui, iceWall.getX(), iceWall.getY());
    }
}
