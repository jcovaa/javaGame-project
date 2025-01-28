package badicecream.states;

import badicecream.Game;
import badicecream.controller.Controller;
import badicecream.gui.Gui;
import badicecream.view.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    public State(T model) throws IOException {
        this.model = model;
        this.controller = getController();
        this.viewer = getViewer();
    }

    protected abstract Viewer<T> getViewer() throws IOException;

    protected abstract  Controller<T> getController();

    public T getModel() {
        return  model;
    }

    public void step(Game game, Gui gui, long time) throws IOException {
        Gui.Actions action = gui.getNextAction();
        controller.step(game, action, time);
        viewer.draw(gui);
    }
}
