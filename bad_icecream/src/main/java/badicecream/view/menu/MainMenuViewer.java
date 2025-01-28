package badicecream.view.menu;

import badicecream.gui.Gui;
import badicecream.model.menu.MainMenu;
import badicecream.view.Viewer;

public class MainMenuViewer extends Viewer<MainMenu> {
    public MainMenuViewer(MainMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(Gui gui) {
        int x = 1;

        gui.drawText(x, 3, "Bad Ice-Cream", "#00FFFF");

        gui.drawText(
            x,
            7,
            getModel().getEntry(0),
            getModel().isSelected(0) ? "#FFD700" : "#FFFFFF"
        );

        gui.drawText(
                x,
                9,
                getModel().getEntry(1),
                getModel().isSelected(1) ? "#FFD700" : "#FFFFFF"
        );
    }
}
