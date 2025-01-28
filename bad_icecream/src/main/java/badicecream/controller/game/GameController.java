package badicecream.controller.game;

import badicecream.controller.Controller;
import badicecream.model.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}
