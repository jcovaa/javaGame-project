package badicecream.states;

import badicecream.controller.Controller;
import badicecream.controller.menu.CreditsMenuController;
import badicecream.model.menu.CreditsMenu;
import badicecream.view.Viewer;
import badicecream.view.menu.CreditsMenuViewer;

import java.io.IOException;

public class CreditsMenuState extends State<CreditsMenu> {
    public CreditsMenuState(CreditsMenu model) throws IOException { super(model); }

    @Override
    protected Viewer<CreditsMenu> getViewer() {
        return new CreditsMenuViewer(getModel());
    }

    @Override
    protected Controller<CreditsMenu> getController() {
        return new CreditsMenuController(getModel());
    }
}
