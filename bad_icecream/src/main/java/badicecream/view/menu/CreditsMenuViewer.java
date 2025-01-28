package badicecream.view.menu;

import badicecream.gui.Gui;
import badicecream.model.menu.CreditsMenu;
import badicecream.view.Viewer;

public class CreditsMenuViewer extends Viewer<CreditsMenu> {
    public CreditsMenuViewer(CreditsMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(Gui gui) {
        String watermelon = "Watermelons: " + (getModel().getWaterMelonsCollected());
        String banana = "Bananas: " + (getModel().getBananasCollected());
        int x = 1;

        gui.drawText(3,3, getModel().getGameStatus(), "#FF0000");

        gui.drawText(0, 6, watermelon, "#00FF00");
        gui.drawText(0, 7, banana, "#FFFF00");

        gui.drawText(
                x,
                10,
                getModel().getEntry(0),
                getModel().isSelected(0) ? "#FFD700" : "#FFFFFF"
        );
        gui.drawText(
                x,
                12,
                getModel().getEntry(1),
                getModel().isSelected(1) ? "#FFD700" : "#FFFFFF"
        );
    }
}
