package badicecream.view.game;

import badicecream.gui.Gui;
import badicecream.model.elements.Element;

import java.io.IOException;


public interface ElementViewer<T extends Element> {
    void draw(T element, Gui gui) throws IOException;
}
