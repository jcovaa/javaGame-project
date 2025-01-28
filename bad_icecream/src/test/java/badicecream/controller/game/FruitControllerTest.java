package badicecream.controller.game;

import badicecream.model.arena.Arena;
import badicecream.model.arena.Cell;
import badicecream.model.arena.Grid;
import badicecream.model.elements.characters.Monster;
import badicecream.model.elements.characters.Player;
import badicecream.model.elements.fruits.Banana;
import badicecream.model.elements.fruits.WaterMelon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class FruitControllerTest {
    private FruitController fruitController;
    private Cell mockedCell;
    private Banana mockedBanana;
    private WaterMelon mockedWaterMelon;
    private Monster mockedMonster;

    private List<Banana> mockedBananas;
    private List<WaterMelon> mockedWaterMelons;


    @BeforeEach
    public void setup() {
        FruitController.resetFruitsCollected();

        Arena mockedArena = mock(Arena.class);
        Grid mockedGrid = mock(Grid.class);
        Player mockedPlayer = mock(Player.class);
        mockedCell = mock(Cell.class);
        mockedBanana = mock(Banana.class);
        mockedWaterMelon = mock(WaterMelon.class);
        mockedMonster = mock(Monster.class);

        when(mockedPlayer.getX()).thenReturn(5);
        when(mockedPlayer.getY()).thenReturn(5);
        when(mockedArena.getPlayer()).thenReturn(mockedPlayer);

        when(mockedArena.getGrid()).thenReturn(mockedGrid);
        when(mockedGrid.getCell(5, 5)).thenReturn(mockedCell);

        mockedBananas = new ArrayList<>();
        mockedWaterMelons = new ArrayList<>();
        mockedBananas.add(mockedBanana);
        mockedWaterMelons.add(mockedWaterMelon);

        when(mockedArena.getBananas()).thenReturn(mockedBananas);
        when(mockedArena.getWaterMelons()).thenReturn(mockedWaterMelons);

        fruitController = new FruitController(mockedArena);
    }

    @Test
    public void stepCollectsBananaTest() {
        when(mockedCell.getOccupants()).thenReturn(List.of(mockedBanana));

        fruitController.step(null, null, 0);

        Assertions.assertEquals(1, fruitController.getBananasCollected());
        Assertions.assertEquals(0, fruitController.getWatermelonsCollected());
        Assertions.assertTrue(mockedBananas.isEmpty());
        verify(mockedCell).removeOccupant(mockedBanana);
    }

    @Test
    public void stepCollectsWaterMelonTest() {
        when(mockedCell.getOccupants()).thenReturn(List.of(mockedWaterMelon));

        fruitController.step(null, null, 0);

        Assertions.assertEquals(0, fruitController.getBananasCollected());
        Assertions.assertEquals(1, fruitController.getWatermelonsCollected());
        Assertions.assertTrue(mockedWaterMelons.isEmpty());
        verify(mockedCell).removeOccupant(mockedWaterMelon);
    }

    @Test
    public void monsterInCellTest() {
        when(mockedCell.getOccupants()).thenReturn(List.of(mockedBanana, mockedMonster));

        fruitController.checkFruitsCollect();

        Assertions.assertEquals(0, fruitController.getBananasCollected());
        Assertions.assertEquals(0, fruitController.getWatermelonsCollected());
        Assertions.assertFalse(mockedBananas.isEmpty());
        verify(mockedCell, never()).removeOccupant(mockedBanana);
    }

    @Test
    public void allFruitsCollectedTest() {
        Assertions.assertFalse(fruitController.allFruitsCollected());

        mockedBananas.clear();
        mockedWaterMelons.clear();

        Assertions.assertTrue(fruitController.allFruitsCollected());
    }

    @Test
    public void resetFruitsCollectedTest() {
        when(mockedCell.getOccupants()).thenReturn(List.of(mockedBanana, mockedWaterMelon));
        fruitController.checkFruitsCollect();

        Assertions.assertEquals(1, fruitController.getBananasCollected());
        Assertions.assertEquals(1, fruitController.getWatermelonsCollected());

        FruitController.resetFruitsCollected();

        Assertions.assertEquals(0, fruitController.getBananasCollected());
        Assertions.assertEquals(0, fruitController.getWatermelonsCollected());
    }
}
