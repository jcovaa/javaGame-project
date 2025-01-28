package badicecream.model.arena;

import badicecream.model.elements.Element;
import badicecream.model.elements.characters.Monster;
import badicecream.model.elements.fruits.WaterMelon;
import badicecream.model.elements.walls.IceWall;
import badicecream.model.elements.walls.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;

public class CellTest {

    private Cell cell;
    private Element mockElement1;
    private Element mockElement2;

    @BeforeEach
    public void setup() {
        cell = new Cell(5, 3);
        mockElement1 = mock(Element.class);
        mockElement2 = mock(Element.class);
    }

    @Test
    public void cellConstructorTest() {
        Assertions.assertEquals(5, cell.getX());
        Assertions.assertEquals(3, cell.getY());
    }

    @Test
    public void addOccupantTest() {
        cell.addOccupant(mockElement1);

        List<Element> occupants = cell.getOccupants();

        Assertions.assertEquals(1, occupants.size());
        Assertions.assertTrue(occupants.contains(mockElement1));
    }

    @Test
    public void addDuplicateOccupantTest() {
        cell.addOccupant(mockElement1);
        cell.addOccupant(mockElement1);

        List<Element> occupants = cell.getOccupants();

        Assertions.assertEquals(1, occupants.size());
    }

    @Test
    public void addMoreElementsTest() {
        cell.addOccupant(mockElement1);
        cell.addOccupant(mockElement2);

        List<Element> occupants = cell.getOccupants();

        Assertions.assertEquals(2, occupants.size());
    }

    @Test
    public void removeOccupantTest() {
        cell.addOccupant(mockElement1);

        cell.removeOccupant(mockElement1);
        List<Element> occupants = cell.getOccupants();
        Assertions.assertFalse(occupants.contains(mockElement1));
        Assertions.assertEquals(0, occupants.size());
    }

    @Test
    public void getOccupantTest() {
        Assertions.assertNull(cell.getOccupant());

        cell.addOccupant(mockElement1);
        Assertions.assertEquals(mockElement1, cell.getOccupant());
    }

    @Test
    public void cellWithWallTest() {
        Element mockedWall = mock(Wall.class);

        cell.addOccupant(mockedWall);

        Assertions.assertTrue(cell.impassableElement());
    }

    @Test
    public void cellWithIceWallTest() {
        Element mockedIceWall = mock(IceWall.class);

        cell.addOccupant(mockedIceWall);

        Assertions.assertTrue(cell.impassableElement());
    }

    @Test
    public void cellWithMonsterTest() {
        Element mockedMonster = mock(Monster.class);

        cell.addOccupant(mockedMonster);

        Assertions.assertTrue(cell.impassableElement());
    }

    @Test
    public void cellWithFruitTest() {
        Element mockedFruit = mock(WaterMelon.class);

        cell.addOccupant(mockedFruit);

        Assertions.assertFalse(cell.impassableElement());
    }
}
