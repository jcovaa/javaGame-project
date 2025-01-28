package badicecream.states;

import badicecream.controller.Controller;
import badicecream.controller.menu.MainMenuController;
import badicecream.model.menu.MainMenu;
import badicecream.view.Viewer;
import badicecream.view.menu.MainMenuViewer;

import java.io.IOException;

public class MainMenuState extends State<MainMenu> {
    public MainMenuState(MainMenu model) throws IOException { super(model); }

    @Override
    protected Viewer<MainMenu> getViewer() {
        return new MainMenuViewer(getModel());
    }

    @Override
    protected Controller<MainMenu> getController() {
        return new MainMenuController(getModel());
    }
}
