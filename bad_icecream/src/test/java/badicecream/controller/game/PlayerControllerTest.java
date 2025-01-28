package badicecream.controller.game;

import badicecream.Game;
import badicecream.gui.Gui;
import badicecream.model.arena.Arena;
import badicecream.model.arena.Cell;
import badicecream.model.arena.Grid;
import badicecream.model.elements.characters.Monster;
import badicecream.model.elements.characters.Player;
import badicecream.model.elements.walls.IceWall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class PlayerControllerTest {

    private PlayerController playerController;
    private PlayerController playerController2;
    private Arena arena2;
    private Player player;
    private Grid mockedGrid;
    private Cell mockedCell;
    private Cell mockedCell2;
    private Game game;

    @BeforeEach
    public void setup(){
        Arena arena = Mockito.mock(Arena.class);
        arena2 = Mockito.mock(Arena.class);

        game = Mockito.mock(Game.class);

        player = Mockito.mock(Player.class);

        mockedGrid = Mockito.mock(Grid.class);
        Grid mockedGrid2 = Mockito.mock(Grid.class);

        mockedCell = Mockito.mock(Cell.class);
        mockedCell2 = Mockito.mock(Cell.class);

        Monster monster1 = Mockito.mock(Monster.class);
        Monster monster2 = Mockito.mock(Monster.class);

        IceWall iceWall1 = Mockito.mock(IceWall.class);
        IceWall iceWall2 = Mockito.mock(IceWall.class);

        List<Monster> mockedMonsters = new ArrayList<>();
        mockedMonsters.add(monster1);
        mockedMonsters.add(monster2);

        List<IceWall> iceWalls = new ArrayList<>();
        iceWalls.add(iceWall1);
        iceWalls.add(iceWall2);

        Mockito.when(arena.getPlayer()).thenReturn(player);
        Mockito.when(arena.getGrid()).thenReturn(mockedGrid);
        Mockito.when(arena.getMonsters()).thenReturn(mockedMonsters);
        Mockito.when(arena.getIceWalls()).thenReturn(iceWalls);

        Mockito.when(arena2.getPlayer()).thenReturn(player);
        Mockito.when(arena2.getGrid()).thenReturn(mockedGrid2);
        Mockito.when(arena2.getMonsters()).thenReturn(mockedMonsters);
        Mockito.when(arena2.getIceWalls()).thenReturn(iceWalls);

        Mockito.when(player.getX()).thenReturn(5);
        Mockito.when(player.getY()).thenReturn(5);

        Mockito.when(mockedGrid.getCell(anyInt(), anyInt())).thenReturn(mockedCell);
        Mockito.when(mockedGrid.getHeight()).thenReturn(10);
        Mockito.when(mockedGrid.getWidth()).thenReturn(10);

        Mockito.when(mockedCell.getOccupants()).thenReturn(List.copyOf(mockedMonsters));
        Mockito.when(mockedCell.impassableElement()).thenReturn(false);

        Mockito.when(mockedCell2.getOccupants()).thenReturn(List.copyOf(iceWalls));

        Mockito.when(mockedGrid2.getCell(anyInt(), anyInt())).thenReturn(mockedCell2);
        Mockito.when(mockedGrid2.getHeight()).thenReturn(10);
        Mockito.when(mockedGrid2.getWidth()).thenReturn(10);



        playerController = new PlayerController(arena);
        playerController2 = new PlayerController(arena2);
    }

    @Test
    public void movePlayerUpTest(){
        playerController.movePlayerUp();
        Mockito.verify(player,Mockito.times(1)).moveUp(mockedGrid);

    }

    @Test
    public void movePlayerDown(){
        playerController.movePlayerDown();
        Mockito.verify(player,Mockito.times(1)).moveDown(mockedGrid);

    }

    @Test
    public void movePlayerLeft(){
        playerController.movePlayerLeft();
        Mockito.verify(player,Mockito.times(1)).moveLeft(mockedGrid);

    }

    @Test
    public void movePlayerRight(){
        playerController.movePlayerRight();
        Mockito.verify(player,Mockito.times(1)).moveRight(mockedGrid);

    }

    @Test
    public void playerCollisionWithMonsterTest(){
        playerController.playerCollisionWithMonster();
        Mockito.verify(player, Mockito.times(1)).die();
    }

    @Test
    public void buildIceWallsTest(){

        Mockito.when(player.getDirection()).thenReturn("DOWN");
        playerController.buildIceWalls();
        Mockito.verify(mockedCell, atLeastOnce()).addOccupant(any(IceWall.class));
        Mockito.verify(mockedCell, atLeastOnce()).impassableElement();

        Mockito.when(player.getDirection()).thenReturn("UP");
        playerController.buildIceWalls();
        Mockito.verify(mockedCell, atLeastOnce()).addOccupant(any(IceWall.class));
        Mockito.verify(mockedCell, atLeastOnce()).impassableElement();

        Mockito.when(player.getDirection()).thenReturn("RIGHT");
        playerController.buildIceWalls();
        Mockito.verify(mockedCell, atLeastOnce()).addOccupant(any(IceWall.class));
        Mockito.verify(mockedCell, atLeastOnce()).impassableElement();

        Mockito.when(player.getDirection()).thenReturn("LEFT");
        playerController.buildIceWalls();
        Mockito.verify(mockedCell, atLeastOnce()).addOccupant(any(IceWall.class));
        Mockito.verify(mockedCell, atLeastOnce()).impassableElement();
    }

    @Test
    public void breakIceWallsTest(){

        Mockito.when(player.getDirection()).thenReturn("DOWN");
        playerController2.breakIceWalls();
        Mockito.verify(mockedCell2, atLeastOnce()).removeOccupant(any(IceWall.class));
        Mockito.verify(arena2, atLeastOnce()).getIceWalls();

        Mockito.when(player.getDirection()).thenReturn("UP");
        playerController2.breakIceWalls();
        Mockito.verify(mockedCell2, atLeastOnce()).removeOccupant(any(IceWall.class));
        Mockito.verify(arena2, atLeastOnce()).getIceWalls();

        Mockito.when(player.getDirection()).thenReturn("RIGHT");
        playerController2.breakIceWalls();
        Mockito.verify(mockedCell2, atLeastOnce()).removeOccupant(any(IceWall.class));
        Mockito.verify(arena2, atLeastOnce()).getIceWalls();

        Mockito.when(player.getDirection()).thenReturn("LEFT");
        playerController2.breakIceWalls();
        Mockito.verify(mockedCell2, atLeastOnce()).removeOccupant(any(IceWall.class));
        Mockito.verify(arena2, atLeastOnce()).getIceWalls();
    }

    @Test
    public void stepUp(){
        playerController.step(game, Gui.Actions.UP, 0);
        Mockito.verify(player, times(1)).moveUp(mockedGrid);
    }

    @Test
    public void stepDown(){
        playerController.step(game, Gui.Actions.DOWN, 0);
        Mockito.verify(player, times(1)).moveDown(mockedGrid);
    }

    @Test
    public void stepLeft(){
        playerController.step(game, Gui.Actions.LEFT, 0);
        Mockito.verify(player, times(1)).moveLeft(mockedGrid);
    }

    @Test
    public void stepRight(){
        playerController.step(game, Gui.Actions.RIGHT, 0);
        Mockito.verify(player, times(1)).moveRight(mockedGrid);
    }

}
