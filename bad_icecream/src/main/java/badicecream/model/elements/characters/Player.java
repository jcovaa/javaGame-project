package badicecream.model.elements.characters;

import badicecream.model.elements.MovableElement;

public class Player extends MovableElement {
    public boolean isAlive;

    public Player(int x, int y, String direction) {
        super(x, y, direction);
        this.isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void die() {
        this.isAlive = false;
    }
}
