package badicecream.controller.menu;

import badicecream.Game;
import badicecream.controller.Controller;
import badicecream.gui.Gui;
import badicecream.model.arena.ArenaLoader;
import badicecream.model.menu.MainMenu;
import badicecream.states.GameState;

import java.io.IOException;

public class MainMenuController extends Controller<MainMenu> {
    public MainMenuController(MainMenu menu) {
        super(menu);
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
                if (getModel().isSelectedStart()) game.setState(new GameState(new ArenaLoader(1).createArena()));
                if (getModel().isSelectedExit()) game.setState(null);
        }
    }
}
