package badicecream.model.menu;

import java.util.Arrays;
import java.util.List;

public class CreditsMenu extends Menu {
    private final int bananasCollected;
    private final int waterMelonsCollected;
    private final String gameStatus;

    public CreditsMenu(int bananasCollected, int waterMelonsCollected, String gameStatus) {
        this.bananasCollected = bananasCollected;
        this.waterMelonsCollected = waterMelonsCollected;
        this.gameStatus = gameStatus;
    }

    @Override
    public List<String> createEntries() {
        return Arrays.asList("Restart", "Quit");
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

    public int getBananasCollected() {
        return bananasCollected;
    }

    public int getWaterMelonsCollected() {
        return waterMelonsCollected;
    }

    public String getGameStatus() {
        return gameStatus;
    }
}
