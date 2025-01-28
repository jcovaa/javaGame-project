package badicecream;

import badicecream.model.menu.MainMenu;
import badicecream.states.CreditsMenuState;
import badicecream.states.MainMenuState;
import badicecream.states.State;
import badicecream.gui.LanternaGui;
import badicecream.gui.ScreenCreator;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private static final int width = 16 * 16;
    private static final int height = 16 * 16;
    private final ScreenCreator gameScreenCreator;
    private final ScreenCreator menuScreenCreator;
    private LanternaGui currentGui;
    private State<?> state;

    public Game() throws URISyntaxException, IOException, FontFormatException {
        this.gameScreenCreator = new ScreenCreator(width, height, 3);
        this.menuScreenCreator = new ScreenCreator(width/16, height/16, 50);
        this.state = new MainMenuState(new MainMenu());
        openMenuScreen();
    }

    public static void main(String[] args) throws URISyntaxException, IOException, FontFormatException {
        new Game().start();
    }

    private void start() throws IOException, URISyntaxException, FontFormatException {
        int FPS = 30;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            if (state instanceof MainMenuState || state instanceof CreditsMenuState) {
                if (currentGui == null) {
                    openMenuScreen();
                }
                state.step(this, currentGui, startTime);
            } else {
                if (currentGui == null) {
                    openGameScreen();
                }
                state.step(this, currentGui, startTime);
            }

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) {
                    Thread.sleep(sleepTime);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        if (currentGui != null) {
            currentGui.close();
        }
    }

    private void openGameScreen() throws IOException, URISyntaxException, FontFormatException {
        if (currentGui != null) {
            currentGui.close();
        }
        currentGui = new LanternaGui(gameScreenCreator.createScreen());
    }

    private void openMenuScreen() throws IOException, URISyntaxException, FontFormatException {
        if (currentGui != null) {
            currentGui.close();
        }
        currentGui = new LanternaGui(menuScreenCreator.createScreen());
    }

    public void setState(State state) throws IOException {
        if (this.state != null && currentGui != null) {
            currentGui.close();
        }
        this.state = state;
        currentGui = null;
    }
}