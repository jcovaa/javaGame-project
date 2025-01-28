package badicecream.states;

import badicecream.controller.Controller;
import badicecream.controller.game.ArenaController;
import badicecream.controller.game.FruitController;
import badicecream.controller.game.MonsterController;
import badicecream.controller.game.PlayerController;
import badicecream.model.arena.Arena;
import badicecream.view.Viewer;
import badicecream.view.game.GameViewer;

import java.io.IOException;

public class GameState extends State<Arena> {
    public GameState(Arena arena) throws IOException { super(arena); }

    @Override
    protected Viewer<Arena> getViewer() throws IOException {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel(), new PlayerController(getModel()), new MonsterController(getModel()), new FruitController(getModel()));
    }
}
