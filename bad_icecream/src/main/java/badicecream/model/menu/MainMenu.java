package badicecream.model.menu;

import java.util.Arrays;
import java.util.List;

public class MainMenu extends Menu {

    @Override
    public List<String> createEntries() {
        return Arrays.asList("Start", "Quit");
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }
}
