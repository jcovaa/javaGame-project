package badicecream.controller.game;

import badicecream.Game;
import badicecream.gui.Gui;
import badicecream.model.arena.Arena;
import badicecream.model.arena.Grid;
import badicecream.model.elements.characters.Monster;

public class MonsterController extends GameController {
    private long lastMove;

    public MonsterController(Arena arena) {
        super(arena);
        this.lastMove = 0;
    }

    @Override
    public void step(Game game, Gui.Actions action, long time) {
        if (time - lastMove > 500) { // Move monsters every 700 ms
            moveMonsters();
            this.lastMove = time;
        }
    }

    private void moveMonsters() {
        moveVertically();
        moveHorizontally();
    }

    public void moveVertically() {
        Grid grid = getModel().getGrid();
        for (Monster monster : getModel().getMonsters()) {
            if (monster.getDirection().equals("UP")) {

                if (monster.canMove(monster.getX(), monster.getY() - 1, grid)) {
                    monster.moveUp(grid);
                }
                else {
                    monster.setDirection("DOWN");
                    if (monster.canMove(monster.getX(), monster.getY() + 1, grid)) {
                        monster.moveDown(grid);
                    }
                }
            }

            else if (monster.getDirection().equals("DOWN")) {

                if (monster.canMove(monster.getX(), monster.getY() + 1, grid)) {
                    monster.moveDown(grid);
                }
                else {
                    monster.setDirection("UP");
                    if (monster.canMove(monster.getX(), monster.getY() - 1, grid)) {
                        monster.moveUp(grid);
                    }
                }
            }
        }
    }

    public void moveHorizontally() {
        Grid grid = getModel().getGrid();

        for (Monster monster : getModel().getMonsters()) {
            if (monster.getDirection().equals("LEFT")) {

                if (monster.canMove(monster.getX() - 1, monster.getY(), grid)) {
                    monster.moveLeft(grid);
                }
                else {
                    monster.setDirection("RIGHT");
                    if (monster.canMove(monster.getX() + 1, monster.getY(), grid)) {
                        monster.moveRight(grid);
                    }
                }
            }

            else if (monster.getDirection().equals("RIGHT")) {
                if (monster.canMove(monster.getX() + 1, monster.getY(), grid)) {
                    monster.moveRight(grid);
                }
                else {
                    monster.setDirection("LEFT");
                    if (monster.canMove(monster.getX() - 1, monster.getY(), grid)) {
                        monster.moveLeft(grid);
                    }
                }
            }
        }
    }
}
