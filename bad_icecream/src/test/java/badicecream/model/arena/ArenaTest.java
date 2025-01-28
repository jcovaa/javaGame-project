package badicecream.model.arena;

import badicecream.model.elements.characters.Monster;
import badicecream.model.elements.characters.Player;
import badicecream.model.elements.fruits.Banana;
import badicecream.model.elements.fruits.WaterMelon;
import badicecream.model.elements.walls.IceWall;
import badicecream.model.elements.walls.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class ArenaTest {
    private Arena arena;
    private Grid mockedGrid;
    private Player mockedPlayer;
    private List<Monster> mockedMonsters;
    private List<Wall> mockedWalls;
    private List<IceWall> mockedIceWalls;
    private List<Banana> mockedBananas;
    private List<WaterMelon> mockedWaterMelons;

    @BeforeEach
    public void setup() {
        mockedGrid = mock(Grid.class);
        for (int x = 0; x < 14; x++) {
            for (int y = 0; y < 14; y++) {
                when(mockedGrid.getCell(x, y)).thenReturn(mock(Cell.class));
            }
        }

        mockedPlayer = mock(Player.class);

        mockedMonsters = new ArrayList<>();
        mockedWalls = new ArrayList<>();
        mockedIceWalls = new ArrayList<>();
        mockedBananas = new ArrayList<>();
        mockedWaterMelons = new ArrayList<>();

        arena = new Arena(mockedGrid, 1);
    }

    @Test
    public void ArenaConstructorTest() {
        Assertions.assertEquals(1, arena.getLevel());
        Assertions.assertEquals(mockedGrid, arena.getGrid());
    }

    @Test
    public void setAndGetPlayerTest() {
        arena.setPlayer(mockedPlayer);

        Assertions.assertEquals(mockedPlayer, arena.getPlayer());
    }

    @Test
    public void setAndGetMonstersTest() {
        Monster mockedMonster = mock(Monster.class);
        mockedMonsters.add(mockedMonster);

        arena.setMonsters(mockedMonsters);

        Assertions.assertEquals(mockedMonsters, arena.getMonsters());
    }

    @Test
    public void setAndGetWallsTest() {
        Wall mockedWall = mock(Wall.class);
        mockedWalls.add(mockedWall);

        arena.setWalls(mockedWalls);

        Assertions.assertEquals(mockedWalls, arena.getWalls());
    }

    @Test
    public void setAndGetIceWallsTest() {
        IceWall mockedIceWall = mock(IceWall.class);
        mockedIceWalls.add(mockedIceWall);

        arena.setIceWalls(mockedIceWalls);

        Assertions.assertEquals(mockedIceWalls, arena.getIceWalls());
    }

    @Test
    public void setAndGetBananasTest() {
        Banana mockedBanana = mock(Banana.class);
        mockedBananas.add(mockedBanana);

        arena.setBananas(mockedBananas);

        Assertions.assertEquals(mockedBananas, arena.getBananas());
    }

    @Test
    public void setAndGetWaterMelonsTest() {
        WaterMelon mockedWaterMelon = mock(WaterMelon.class);
        mockedWaterMelons.add(mockedWaterMelon);

        arena.setWaterMelons(mockedWaterMelons);

        Assertions.assertEquals(mockedWaterMelons, arena.getWaterMelons());
    }

    @Test
    public void initializeElementsTest() {
        Monster mockedMonster = mock(Monster.class);
        when(mockedMonster.getX()).thenReturn(1);
        when(mockedMonster.getY()).thenReturn(2);
        mockedMonsters.add(mockedMonster);

        Wall mockedWall = mock(Wall.class);
        when(mockedWall.getX()).thenReturn(3);
        when(mockedWall.getY()).thenReturn(4);
        mockedWalls.add(mockedWall);

        IceWall mockedIceWall = mock(IceWall.class);
        when(mockedIceWall.getX()).thenReturn(5);
        when(mockedIceWall.getY()).thenReturn(6);
        mockedIceWalls.add(mockedIceWall);

        Banana mockedBanana = mock(Banana.class);
        when(mockedBanana.getX()).thenReturn(7);
        when(mockedBanana.getY()).thenReturn(8);
        mockedBananas.add(mockedBanana);

        WaterMelon mockedWaterMelon = mock(WaterMelon.class);
        when(mockedWaterMelon.getX()).thenReturn(9);
        when(mockedWaterMelon.getY()).thenReturn(10);
        mockedWaterMelons.add(mockedWaterMelon);

        when(mockedPlayer.getX()).thenReturn(11);
        when(mockedPlayer.getY()).thenReturn(12);

        arena.setMonsters(mockedMonsters);
        arena.setWalls(mockedWalls);
        arena.setIceWalls(mockedIceWalls);
        arena.setBananas(mockedBananas);
        arena.setWaterMelons(mockedWaterMelons);
        arena.setPlayer(mockedPlayer);

        arena.initializeElements();

        verify(mockedGrid.getCell(1, 2)).addOccupant(mockedMonster);
        verify(mockedGrid.getCell(3, 4)).addOccupant(mockedWall);
        verify(mockedGrid.getCell(5, 6)).addOccupant(mockedIceWall);
        verify(mockedGrid.getCell(7, 8)).addOccupant(mockedBanana);
        verify(mockedGrid.getCell(9, 10)).addOccupant(mockedWaterMelon);
        verify(mockedGrid.getCell(11, 12)).addOccupant(mockedPlayer);
    }


    @Test
    public void playerNullTest() {
        Monster mockedMonster = mock(Monster.class);
        when(mockedMonster.getX()).thenReturn(1);
        when(mockedMonster.getY()).thenReturn(2);
        mockedMonsters.add(mockedMonster);

        Wall mockedWall = mock(Wall.class);
        when(mockedWall.getX()).thenReturn(3);
        when(mockedWall.getY()).thenReturn(4);
        mockedWalls.add(mockedWall);

        IceWall mockedIceWall = mock(IceWall.class);
        when(mockedIceWall.getX()).thenReturn(5);
        when(mockedIceWall.getY()).thenReturn(6);
        mockedIceWalls.add(mockedIceWall);

        Banana mockedBanana = mock(Banana.class);
        when(mockedBanana.getX()).thenReturn(7);
        when(mockedBanana.getY()).thenReturn(8);
        mockedBananas.add(mockedBanana);

        WaterMelon mockedWaterMelon = mock(WaterMelon.class);
        when(mockedWaterMelon.getX()).thenReturn(9);
        when(mockedWaterMelon.getY()).thenReturn(10);
        mockedWaterMelons.add(mockedWaterMelon);

        when(mockedPlayer.getX()).thenReturn(11);
        when(mockedPlayer.getY()).thenReturn(12);

        mockedPlayer = null;

        arena.setMonsters(mockedMonsters);
        arena.setWalls(mockedWalls);
        arena.setIceWalls(mockedIceWalls);
        arena.setBananas(mockedBananas);
        arena.setWaterMelons(mockedWaterMelons);
        arena.setPlayer(mockedPlayer);

        arena.initializeElements();

        verify(mockedGrid.getCell(1, 2)).addOccupant(mockedMonster);
        verify(mockedGrid.getCell(3, 4)).addOccupant(mockedWall);
        verify(mockedGrid.getCell(5, 6)).addOccupant(mockedIceWall);
        verify(mockedGrid.getCell(7, 8)).addOccupant(mockedBanana);
        verify(mockedGrid.getCell(9, 10)).addOccupant(mockedWaterMelon);
        verify(mockedGrid.getCell(11, 12), times(0)).addOccupant(mockedPlayer);
    }
}
