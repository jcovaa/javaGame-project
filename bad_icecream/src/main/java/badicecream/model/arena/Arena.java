package badicecream.model.arena;

import badicecream.model.elements.characters.Monster;
import badicecream.model.elements.characters.Player;
import badicecream.model.elements.fruits.Banana;
import badicecream.model.elements.fruits.WaterMelon;
import badicecream.model.elements.walls.IceWall;
import badicecream.model.elements.walls.Wall;

import java.util.List;

public class Arena {
    private final int level;

    private final Grid grid;
    private Player player;
    private List<Monster> monsters;
    private List<Wall> walls;
    private List<IceWall> iceWalls;
    private List<Banana> bananas;
    private List<WaterMelon> waterMelons;

    public Arena(Grid grid, int level) {
        this.grid = grid;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public Grid getGrid() { return grid; }

    public Player getPlayer() { return player; }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Monster> getMonsters() { return monsters; }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public List<Wall> getWalls() { return walls; }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public List<IceWall> getIceWalls() { return iceWalls; }

    public void setIceWalls(List<IceWall> iceWalls) {
        this.iceWalls = iceWalls;
    }

    public List<Banana> getBananas() { return bananas; }

    public void setBananas(List<Banana> bananas) {
        this.bananas = bananas;
    }

    public List<WaterMelon> getWaterMelons() { return waterMelons; }

    public void setWaterMelons(List<WaterMelon> waterMelons) {
        this.waterMelons = waterMelons;
    }

    public void initializeElements() {
        for (Monster monster : monsters)
            grid.getCell(monster.getX(), monster.getY()).addOccupant(monster);

        for (Wall wall : walls)
            grid.getCell(wall.getX(), wall.getY()).addOccupant(wall);

        for (IceWall iceWall : iceWalls)
            grid.getCell(iceWall.getX(), iceWall.getY()).addOccupant(iceWall);

        for (Banana banana : bananas)
            grid.getCell(banana.getX(), banana.getY()).addOccupant(banana);

        for (WaterMelon waterMelon : waterMelons)
            grid.getCell(waterMelon.getX(), waterMelon.getY()).addOccupant(waterMelon);

        if (player != null)
            grid.getCell(player.getX(), player.getY()).addOccupant(player);
    }
}
