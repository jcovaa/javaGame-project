package badicecream.model.arena;

import badicecream.model.elements.Element;
import badicecream.model.elements.characters.Monster;
import badicecream.model.elements.walls.IceWall;
import badicecream.model.elements.walls.Wall;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private final int x;
    private final int y ;
    private final List<Element> occupants = new ArrayList<>();// Could be a player, enemy, or block

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void addOccupant(Element element) {
        if (!occupants.contains(element)) {
            occupants.add(element);
        }
    }

    public void removeOccupant(Element element) {
        occupants.remove(element);
    }

    public List<Element> getOccupants() {
        return occupants;
    }

    public Element getOccupant() {
        return occupants.isEmpty() ? null : occupants.get(0);
    }

    public boolean impassableElement() {
        for (Element occupant : occupants) {
            if (occupant instanceof Wall || occupant instanceof IceWall || occupant instanceof Monster) {
                return true;
            }
        }
        return false;
    }
}
