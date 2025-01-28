package badicecream.model.elements;

import badicecream.model.arena.Cell;
import badicecream.model.arena.Grid;
import badicecream.model.elements.walls.IceWall;
import badicecream.model.elements.walls.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MovableElementTest {

    static class TestMovableElement extends MovableElement {
        public TestMovableElement(int x, int y, String direction) {
            super(x, y, direction);
        }
    }

    private TestMovableElement testMovableElement;
    private Grid mockedGrid;
    private Cell mockedCell;

    @BeforeEach
    public void setup() {
        mockedGrid = mock(Grid.class);
        mockedCell = mock(Cell.class);

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                Mockito.when(mockedGrid.getCell(x, y)).thenReturn(mockedCell);
            }
        }

        testMovableElement = new TestMovableElement(5, 5, "UP");

        Mockito.when(mockedGrid.getWidth()).thenReturn(10);
        Mockito.when(mockedGrid.getHeight()).thenReturn(10);
    }

    @Test
    public void movableElementConstructorTest() {
        Assertions.assertEquals(5, testMovableElement.getX());
        Assertions.assertEquals(5, testMovableElement.getY());
        Assertions.assertEquals("UP", testMovableElement.getDirection());
    }

    @Test
    public void setDirectionTest() {
        testMovableElement.setDirection("DOWN");

        Assertions.assertEquals("DOWN", testMovableElement.getDirection());
    }

    @Test
    public void canMoveEmptyCellTest() {
        Mockito.when(mockedCell.getOccupants()).thenReturn(new ArrayList<>());

        Assertions.assertTrue(testMovableElement.canMove(5, 4, mockedGrid));
    }

    @Test
    public void canMoveWithWallTest() {
        List<Element> occupants = new ArrayList<>();
        occupants.add(mock(Wall.class));

        when(mockedCell.getOccupants()).thenReturn(occupants);

        Assertions.assertFalse(testMovableElement.canMove(5, 4, mockedGrid));
    }

    @Test
    public void canMoveWithIceWallTest() {
        List<Element> occupants = new ArrayList<>();
        occupants.add(mock(IceWall.class));

        when(mockedCell.getOccupants()).thenReturn(occupants);

        Assertions.assertFalse(testMovableElement.canMove(5, 4, mockedGrid));
    }

    @Test
    public void canMoveOutOfBoundsTest() {
        Assertions.assertFalse(testMovableElement.canMove(-1, 0, mockedGrid));
        Assertions.assertFalse(testMovableElement.canMove(10, 0, mockedGrid));
        Assertions.assertFalse(testMovableElement.canMove(0, -1, mockedGrid));
        Assertions.assertFalse(testMovableElement.canMove(0, 10, mockedGrid));
    }

    @Test
    public void moveTest() {
        Cell initialCell = Mockito.mock(Cell.class);
        Cell destinationCell = Mockito.mock(Cell.class);

        Mockito.when(mockedGrid.getCell(5, 5)).thenReturn(initialCell);
        Mockito.when(mockedGrid.getCell(6,6)).thenReturn(destinationCell);

        testMovableElement.move(1, 1, mockedGrid);

        Mockito.verify(mockedGrid).removeElement(testMovableElement);
        Mockito.verify(mockedGrid).removeElement(testMovableElement);

        Assertions.assertEquals(6, testMovableElement.getX());
        Assertions.assertEquals(6, testMovableElement.getY());
    }

    @Test
    public void moveUpTest() {
        Mockito.when(mockedCell.getOccupants()).thenReturn(new ArrayList<>());

        testMovableElement.moveUp(mockedGrid);

        Mockito.verify(mockedGrid).removeElement(testMovableElement);
        Mockito.verify(mockedGrid).placeElement(testMovableElement);

        Assertions.assertEquals(5, testMovableElement.getX());
        Assertions.assertEquals(4, testMovableElement.getY());
        Assertions.assertEquals("UP", testMovableElement.getDirection());
    }

    @Test
    public void moveUpBlockedByWallTest() {
        List<Element> occupants = new ArrayList<>();
        occupants.add(mock(Wall.class));
        Mockito.when(mockedCell.getOccupants()).thenReturn(occupants);

        testMovableElement.moveUp(mockedGrid);

        Assertions.assertEquals(5, testMovableElement.getX());
        Assertions.assertEquals(5, testMovableElement.getY());
        Assertions.assertEquals("UP", testMovableElement.getDirection());
    }

    @Test
    public void moveDownTest() {
        Mockito.when(mockedCell.getOccupants()).thenReturn(new ArrayList<>());

        testMovableElement.moveDown(mockedGrid);

        Assertions.assertEquals(5, testMovableElement.getX());
        Assertions.assertEquals(6, testMovableElement.getY());
        Assertions.assertEquals("DOWN", testMovableElement.getDirection());
    }

    @Test
    public void moveLeftTest() {
        Mockito.when(mockedCell.getOccupants()).thenReturn(new ArrayList<>());

        testMovableElement.moveLeft(mockedGrid);

        Assertions.assertEquals(4, testMovableElement.getX());
        Assertions.assertEquals(5, testMovableElement.getY());
        Assertions.assertEquals("LEFT", testMovableElement.getDirection());
    }

    @Test
    public void moveRightTest() {
        Mockito.when(mockedCell.getOccupants()).thenReturn(new ArrayList<>());

        testMovableElement.moveRight(mockedGrid);

        Assertions.assertEquals(6, testMovableElement.getX());
        Assertions.assertEquals(5, testMovableElement.getY());
        Assertions.assertEquals("RIGHT", testMovableElement.getDirection());
    }
}
