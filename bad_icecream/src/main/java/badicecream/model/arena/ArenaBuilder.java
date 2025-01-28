package badicecream.model.arena;

import badicecream.model.elements.characters.Monster;
import badicecream.model.elements.characters.Player;
import badicecream.model.elements.fruits.Banana;
import badicecream.model.elements.fruits.WaterMelon;
import badicecream.model.elements.walls.IceWall;
import badicecream.model.elements.walls.Wall;

import java.util.ArrayList;
import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getGrid(), getLevel());

        arena.setPlayer(createPlayer());
        arena.setWalls(createWalls());
        arena.setIceWalls(createIceWalls());
        arena.setBananas(createBananas());
        arena.setWaterMelons(createWaterMelons());

        List<Monster> allMonsters = new ArrayList<>();
        allMonsters.addAll(createHorizontalMonsters());
        allMonsters.addAll(createVerticalMonsters());
        arena.setMonsters(allMonsters);

        arena.initializeElements();

        return arena;
    }

    protected abstract int getLevel();

    protected abstract Grid getGrid();

    protected abstract Player createPlayer();

    protected abstract List<Monster> createHorizontalMonsters();

    protected abstract List<Monster> createVerticalMonsters();

    protected abstract List<Wall> createWalls();

    protected abstract List<IceWall> createIceWalls();

    protected abstract List<Banana> createBananas();

    protected abstract List<WaterMelon> createWaterMelons();
}
