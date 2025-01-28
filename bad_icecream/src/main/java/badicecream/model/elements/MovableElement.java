package badicecream.model.elements;

import badicecream.model.arena.Grid;
import badicecream.model.elements.walls.IceWall;
import badicecream.model.elements.walls.Wall;

import java.util.List;

public abstract class MovableElement extends Element {
    public String direction;

    public MovableElement(int x, int y, String direction) {
        super(x, y);
        this.direction = direction;
    }

    public boolean canMove(int x, int y, Grid grid) {
        if (x >= grid.getWidth() || x < 0 || y >= grid.getHeight() || y < 0)
            return false;  // Out of bounds check

        List<Element> occupants = grid.getCell(x, y).getOccupants();

        for (Element occupant : occupants) {
            if (occupant instanceof Wall || occupant instanceof IceWall) {
                return false;
            }
        }

        return true;
    }

    public void move(int x, int y, Grid grid) {
        int newX = getX() + x;
        int newY = getY() + y;

        if(canMove(newX, newY, grid)){
            grid.removeElement(this);
            this.setPosition(newX, newY);
            grid.placeElement(this);
        }
    }

    public void moveUp(Grid grid) {
        move(0, -1, grid);
        this.direction = "UP";
    }

    public void moveDown(Grid grid) {
        move(0, 1, grid);
        this.direction = "DOWN";
    }

    public void moveLeft(Grid grid) {
        move(-1, 0, grid);
        this.direction = "LEFT";
    }

    public void moveRight(Grid grid) {
        move(1, 0, grid);
        this.direction = "RIGHT";
    }

    public String getDirection() { return this.direction; }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
