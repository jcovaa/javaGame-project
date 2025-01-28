package badicecream.view.game;

import badicecream.gui.Gui;
import badicecream.model.arena.Arena;
import badicecream.model.elements.Element;
import badicecream.view.Viewer;
import badicecream.view.game.characters.MonsterViewer;
import badicecream.view.game.characters.PlayerViewer;
import badicecream.view.game.fruits.BananaViewer;
import badicecream.view.game.fruits.WaterMelonViewer;
import badicecream.view.game.walls.IceWallViewer;
import badicecream.view.game.walls.WallViewer;

import java.io.IOException;
import java.util.List;

public class GameViewer extends Viewer<Arena> {
    private final PlayerViewer playerViewer;
    private final MonsterViewer monsterViewer;
    private final BananaViewer bananaViewer;
    private final WaterMelonViewer waterMelonViewer;
    private final WallViewer wallViewer;
    private final IceWallViewer iceWallViewer;
    private final BackgroundRenderer backgroundRenderer;

    public GameViewer(Arena arena) throws IOException {
        super(arena);
        this.playerViewer = new PlayerViewer();
        this.monsterViewer = new MonsterViewer();
        this.bananaViewer = new BananaViewer();
        this.waterMelonViewer = new WaterMelonViewer();
        this.wallViewer = new WallViewer();
        this.iceWallViewer = new IceWallViewer();
        this.backgroundRenderer = new BackgroundRenderer();
    }

    public GameViewer(Arena arena,
                      PlayerViewer playerViewer,
                      MonsterViewer monsterViewer,
                      BananaViewer bananaViewer,
                      WaterMelonViewer waterMelonViewer,
                      WallViewer wallViewer,
                      IceWallViewer iceWallViewer,
                      BackgroundRenderer backgroundRenderer) {
        super(arena);
        this.playerViewer = playerViewer;
        this.monsterViewer = monsterViewer;
        this.bananaViewer = bananaViewer;
        this.waterMelonViewer = waterMelonViewer;
        this.wallViewer = wallViewer;
        this.iceWallViewer = iceWallViewer;
        this.backgroundRenderer = backgroundRenderer;
    }

    @Override
    public void drawElements(Gui gui) throws IOException {
        backgroundRenderer.drawBackground(gui, getModel().getGrid().getHeight(), getModel().getGrid().getWidth());
        drawElements(gui, getModel().getWalls(), wallViewer);
        drawElements(gui, getModel().getIceWalls(), iceWallViewer);
        drawElements(gui, getModel().getBananas(), bananaViewer);
        drawElements(gui, getModel().getWaterMelons(), waterMelonViewer);
        drawElements(gui, getModel().getMonsters(), monsterViewer);
        drawElement(gui, getModel().getPlayer(), playerViewer);
    }

    private <T extends Element> void drawElements(Gui gui, List<T> elements, ElementViewer<T> viewer) throws IOException {
        for (T element : elements) {
            drawElement(gui, element, viewer);
        }
    }

    private <T extends Element> void drawElement(Gui gui, T element, ElementViewer<T> viewer) throws IOException {
        viewer.draw(element, gui);
    }
}
