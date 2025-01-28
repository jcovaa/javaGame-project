package badicecream.controller.game;

import badicecream.Game;
import badicecream.controller.GameConfig;
import badicecream.gui.Gui;
import badicecream.model.arena.Arena;
import badicecream.model.arena.ArenaLoader;
import badicecream.model.menu.CreditsMenu;
import badicecream.states.CreditsMenuState;
import badicecream.states.GameState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final PlayerController playerController;
    private final MonsterController monsterController;
    private final FruitController fruitController;

    public ArenaController(Arena arena, PlayerController playerController, MonsterController monsterController, FruitController fruitController) {
        super(arena);

        this.playerController = playerController;
        this.monsterController = monsterController;
        this.fruitController = fruitController;
    }

    public void step(Game game, Gui.Actions action, long time) throws IOException {
        boolean allFruitsCollected = fruitController.allFruitsCollected();
        boolean playerIsDead = !getModel().getPlayer().isAlive();
        boolean playerQuit = action == Gui.Actions.QUIT;

        String gameStatus = "";
        if (playerQuit || playerIsDead) gameStatus = "Game over";
        if (allFruitsCollected) gameStatus = "You win!";

        if (playerQuit || playerIsDead || (fruitController.allFruitsCollected() && getModel().getLevel() == GameConfig.TOTAL_LEVELS)) {
            int bananasCollected = fruitController.getBananasCollected();
            int waterMelonsCollected = fruitController.getWatermelonsCollected();

            game.setState(new CreditsMenuState(new CreditsMenu(bananasCollected, waterMelonsCollected, gameStatus)));
        }
        else if (fruitController.allFruitsCollected()) {
            int nextLevel = getModel().getLevel() + 1;
            game.setState(new GameState(new ArenaLoader(nextLevel).createArena()));
        }

        else {
            playerController.step(game, action, time);
            monsterController.step(game, action, time);
            fruitController.step(game, action, time);
        }
    }
}
