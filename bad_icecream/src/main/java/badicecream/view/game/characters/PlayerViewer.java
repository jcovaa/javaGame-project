package badicecream.view.game.characters;

import badicecream.gui.Gui;
import badicecream.model.elements.characters.Player;
import badicecream.view.SpriteRenderer;
import badicecream.view.game.ElementViewer;

import java.io.IOException;


public class PlayerViewer implements ElementViewer<Player> {
    private final SpriteRenderer upSprite;
    private final SpriteRenderer downSprite;
    private final SpriteRenderer leftSprite;
    private final SpriteRenderer rightSprite;

    public PlayerViewer() throws IOException {
        this(
                new SpriteRenderer("sprites/player/playerUp.png"),
                new SpriteRenderer("sprites/player/playerDown.png"),
                new SpriteRenderer("sprites/player/playerLeft.png"),
                new SpriteRenderer("sprites/player/playerRight.png")
        );
    }

    public PlayerViewer(SpriteRenderer upSprite, SpriteRenderer downSprite, SpriteRenderer leftSprite, SpriteRenderer rightSprite) {
        this.upSprite = upSprite;
        this.downSprite = downSprite;
        this.leftSprite = leftSprite;
        this.rightSprite = rightSprite;
    }

    @Override
    public void draw(Player player, Gui gui) {
        SpriteRenderer sprite = getSpriteDirection(player.getDirection());
        sprite.draw(gui, player.getX(), player.getY());
    }

    private SpriteRenderer getSpriteDirection(String direction) {
        return switch (direction.toUpperCase()) {
            case "UP" -> upSprite;
            case "DOWN" -> downSprite;
            case "LEFT" -> leftSprite;
            case "RIGHT" -> rightSprite;
            default -> throw new IllegalArgumentException("Invalid direction: " + direction);
        };
    }
}
