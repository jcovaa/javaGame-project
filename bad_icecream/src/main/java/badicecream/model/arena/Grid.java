package badicecream.model.arena;

import badicecream.model.elements.Element;

public class Grid {
    private final Cell[][] cells;

    public Grid(int width, int height) {
        cells = new Cell[height][width];
        for (int y = 0; y < height; y++) {   // passes through the height
            for (int x = 0; x < width; x++) {   // passes through the width
                cells[y][x] = new Cell(x, y);
            }
        }
    }

    public Cell getCell(int x, int y) {
        if (x < 0 || x >= cells[0].length || y < 0 || y >= cells.length) {
            return null;   //Out of bounds
        }
        return cells[y][x];
    }

    public void placeElement(Element element) {
        getCell(element.getX(), element.getY()).addOccupant(element);
    }

    public void removeElement(Element element) {
        getCell(element.getX(), element.getY()).removeOccupant(element);
    }

    public int getWidth() {
        return cells[0].length;
    }

    public  int getHeight() { return cells.length; }
}
