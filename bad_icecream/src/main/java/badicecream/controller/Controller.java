package badicecream.controller;

import badicecream.Game;
import badicecream.gui.Gui;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return  model;
    }

    public abstract void step(Game game, Gui.Actions action, long time) throws IOException;
}
