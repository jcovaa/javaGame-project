package badicecream.view.game.characters;

import badicecream.gui.Gui;
import badicecream.model.elements.characters.Monster;
import badicecream.view.SpriteRenderer;
import badicecream.view.game.ElementViewer;

import java.io.IOException;

public class MonsterViewer implements ElementViewer<Monster> {
    private final SpriteRenderer upSprite;
    private final SpriteRenderer downSprite;
    private final SpriteRenderer leftSprite;
    private final SpriteRenderer rightSprite;

    public MonsterViewer() throws IOException {
        this(
                new SpriteRenderer("sprites/monster/monsterUp.png"),
                new SpriteRenderer("sprites/monster/monsterDown.png"),
                new SpriteRenderer("sprites/monster/monsterLeft.png"),
                new SpriteRenderer("sprites/monster/monsterRight.png")
        );
    }

    public MonsterViewer(SpriteRenderer upSprite, SpriteRenderer downSprite, SpriteRenderer leftSprite, SpriteRenderer rightSprite) {
        this.upSprite = upSprite;
        this.downSprite = downSprite;
        this.leftSprite = leftSprite;
        this.rightSprite = rightSprite;
    }

    @Override
    public void draw(Monster monster, Gui gui) throws IOException {
        SpriteRenderer sprite = getSpriteDirection(monster.getDirection());
        sprite.draw(gui, monster.getX(), monster.getY());
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
