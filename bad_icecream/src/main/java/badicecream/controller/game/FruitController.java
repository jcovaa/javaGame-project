package badicecream.controller.game;

import badicecream.Game;
import badicecream.gui.Gui;
import badicecream.model.arena.Arena;
import badicecream.model.arena.Cell;
import badicecream.model.arena.Grid;
import badicecream.model.elements.Element;
import badicecream.model.elements.characters.Monster;
import badicecream.model.elements.characters.Player;
import badicecream.model.elements.fruits.Banana;
import badicecream.model.elements.fruits.Fruit;
import badicecream.model.elements.fruits.WaterMelon;

import java.util.Iterator;
import java.util.List;

public class FruitController extends GameController {
    private static int bananasCollected = 0;
    private static int waterMelonsCollected = 0;

    public FruitController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, Gui.Actions action, long time) {
        checkFruitsCollect();
    }

    public void checkFruitsCollect() {
        checkFruitCollision(getModel().getBananas());
        checkFruitCollision(getModel().getWaterMelons());
    }

    private <T extends Fruit> void checkFruitCollision(List<T> fruits) {
        Grid grid = getModel().getGrid();
        Player player = getModel().getPlayer();

        Iterator<T> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            Fruit fruit = iterator.next();

            Cell playerCell = grid.getCell(player.getX(), player.getY());
            List<Element> occupants = playerCell.getOccupants();

            boolean isMonsterInCell = false;
            for (Element occupant : occupants) {
                if (occupant instanceof Monster) {
                    isMonsterInCell = true;
                    break;
                }
            }

            if (!isMonsterInCell) {
                if (playerCell.getOccupants().contains(fruit)) {
                    playerCell.removeOccupant(fruit);
                    iterator.remove();

                    if (fruit instanceof Banana) {
                        bananasCollected++;
                    }
                    else if (fruit instanceof WaterMelon) {
                        waterMelonsCollected++;
                    }
                }
            }
        }
    }

    public boolean allFruitsCollected() {
        return getModel().getBananas().isEmpty() && getModel().getWaterMelons().isEmpty();
    }

    public int getBananasCollected() {
        return bananasCollected;
    }

    public int getWatermelonsCollected() {
        return waterMelonsCollected;
    }

    public static void resetFruitsCollected() {
        bananasCollected = 0;
        waterMelonsCollected = 0;
    }
}
