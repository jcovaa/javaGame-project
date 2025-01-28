package badicecream.model.arena;

import badicecream.model.elements.Element;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class GridTest {

    private Grid grid;

    @BeforeEach
    public void setup() {
        grid = new Grid(20, 10);
    }

    @Test
    public void gridConstructor() {
        Assertions.assertEquals(20, grid.getWidth());
        Assertions.assertEquals(10, grid.getHeight());

        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                Cell cell = grid.getCell(x, y);
                Assertions.assertNotNull(cell);
            }
        }
    }

    @Test
    public void cellWithinBounds() {
        Assertions.assertNotNull(grid.getCell(3, 6));
    }

    @Test
    public void cellOutOfBounds() {
        Assertions.assertNull(grid.getCell(-1, 0));
        Assertions.assertNull(grid.getCell(0, -1));
        Assertions.assertNull(grid.getCell(21, 10));
        Assertions.assertNull(grid.getCell(20, 11));
        Assertions.assertNull(grid.getCell(0, 10));
    }

    @Test
    public void placeElementTest() {
        Element mockedElement = mock(Element.class);
        when(mockedElement.getX()).thenReturn(5);
        when(mockedElement.getY()).thenReturn(3);

        grid.placeElement(mockedElement);

        Cell cell = grid.getCell(5, 3);
        Assertions.assertEquals(mockedElement, cell.getOccupant());
    }

    @Test
    public void removeElementTest() {
        Element mockedElement = mock(Element.class);
        when(mockedElement.getX()).thenReturn(2);
        when(mockedElement.getY()).thenReturn(3);

        grid.placeElement(mockedElement);

        grid.removeElement(mockedElement);
        Assertions.assertNull(grid.getCell(2, 3).getOccupant());
    }
}
