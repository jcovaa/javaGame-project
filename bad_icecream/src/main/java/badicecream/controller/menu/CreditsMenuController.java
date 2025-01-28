package badicecream.controller.menu;

import badicecream.Game;
import badicecream.controller.Controller;
import badicecream.controller.game.FruitController;
import badicecream.gui.Gui;
import badicecream.model.arena.ArenaLoader;
import badicecream.model.menu.CreditsMenu;
import badicecream.states.GameState;

import java.io.IOException;

public class CreditsMenuController extends Controller<CreditsMenu> {
    public CreditsMenuController(CreditsMenu model) {
        super(model);
    }

    @Override
    public void step(Game game, Gui.Actions action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                FruitController.resetFruitsCollected();

                if (getModel().isSelectedStart()) game.setState(new GameState(new ArenaLoader(1).createArena()));
                if (getModel().isSelectedExit()) game.setState(null);
        }
    }
}
