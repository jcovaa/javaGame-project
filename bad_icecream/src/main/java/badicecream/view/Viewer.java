package badicecream.view;

import badicecream.gui.Gui;

import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void draw(Gui gui) throws IOException {
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }

    public abstract void drawElements(Gui gui) throws IOException;
}
