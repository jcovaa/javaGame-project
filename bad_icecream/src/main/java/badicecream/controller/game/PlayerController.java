package badicecream.controller.game;

import badicecream.Game;
import badicecream.gui.Gui;
import badicecream.model.arena.Arena;
import badicecream.model.arena.Cell;
import badicecream.model.arena.Grid;
import badicecream.model.elements.Element;
import badicecream.model.elements.characters.Monster;
import badicecream.model.elements.characters.Player;
import badicecream.model.elements.walls.IceWall;

import java.util.ArrayList;
import java.util.List;

public class PlayerController extends GameController {
    public PlayerController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, Gui.Actions action, long time) {
        playerCollisionWithMonster();

        if (action == Gui.Actions.UP) movePlayerUp();
        if (action == Gui.Actions.DOWN) movePlayerDown();
        if (action == Gui.Actions.LEFT) movePlayerLeft();
        if (action == Gui.Actions.RIGHT) movePlayerRight();

        if (action == Gui.Actions.BUILD) buildIceWalls();
        if (action == Gui.Actions.BREAK) breakIceWalls();
    }

    public void movePlayerUp() {
        getModel().getPlayer().moveUp(getModel().getGrid());
        playerCollisionWithMonster();
    }

    public void movePlayerDown() {
        getModel().getPlayer().moveDown(getModel().getGrid());
        playerCollisionWithMonster();
    }

    public void movePlayerLeft() {
        getModel().getPlayer().moveLeft(getModel().getGrid());
        playerCollisionWithMonster();
    }

    public void movePlayerRight() {
        getModel().getPlayer().moveRight(getModel().getGrid());
        playerCollisionWithMonster();
    }

    public void playerCollisionWithMonster() {
        Grid grid = getModel().getGrid();
        Player player = getModel().getPlayer();
        Cell currentCell = grid.getCell(player.getX(), player.getY());
        List<Element> occupants = currentCell.getOccupants();

        for (Element occupant : occupants) {
            if (occupant instanceof Monster) {
                player.die();
                return;
            }
        }
    }

    public void buildIceWalls() {
        Grid grid = getModel().getGrid();
        int x = getModel().getPlayer().getX();
        int y = getModel().getPlayer().getY();
        String direction = getModel().getPlayer().getDirection();

        while (true) {
            switch (direction) {
                case "UP":
                    y--;
                    break;
                case "DOWN":
                    y++;
                    break;
                case "LEFT":
                    x--;
                    break;
                case "RIGHT":
                    x++;
                    break;
            }

            if (x < 0 || x >= grid.getWidth() || y < 0 || y >= grid.getHeight()) {
                break;
            }

            Cell targetCell = grid.getCell(x, y);

            if (targetCell.impassableElement()) {
                break;
            }

            IceWall iceWall = new IceWall(x, y);
            targetCell.addOccupant(iceWall);
            getModel().getIceWalls().add(iceWall);
        }
    }

    public void breakIceWalls() {
        Grid grid = getModel().getGrid();
        int x = getModel().getPlayer().getX();
        int y = getModel().getPlayer().getY();
        String direction = getModel().getPlayer().getDirection();

        List<IceWall> iceWallsToRemove = new ArrayList<>();

        while (true) {
            switch (direction) {
                case "UP":
                    y--;
                    break;
                case "DOWN":
                    y++;
                    break;
                case "LEFT":
                    x--;
                    break;
                case "RIGHT":
                    x++;
                    break;
            }

            if (x < 0 || x >= grid.getWidth() || y < 0 || y >= grid.getHeight()) {
                break;
            }

            Cell targetCell = grid.getCell(x, y);

            boolean hasIceWall = false;
            for (Element occupant : targetCell.getOccupants()) {
                if (occupant instanceof IceWall) {
                    hasIceWall = true;
                    iceWallsToRemove.add((IceWall) occupant);
                }
            }

            if (!hasIceWall) {
                break;
            }
        }

        for (IceWall iceWall : iceWallsToRemove) {
            grid.getCell(iceWall.getX(), iceWall.getY()).removeOccupant(iceWall);
            getModel().getIceWalls().remove(iceWall);
        }
    }
}
