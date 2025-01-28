package badicecream.model.arena;

import badicecream.model.elements.characters.Monster;
import badicecream.model.elements.characters.Player;
import badicecream.model.elements.fruits.Banana;
import badicecream.model.elements.fruits.WaterMelon;
import badicecream.model.elements.walls.IceWall;
import badicecream.model.elements.walls.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class ArenaLoaderTest {
    private ArenaLoader arenaLoader;

    @BeforeEach
    public void setup() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/levels/level1.lvl"))));
        arenaLoader = new ArenaLoader(1);

    }

    @Test
    public void getLevelTest() {
        Grid grid = arenaLoader.getGrid();

        Assertions.assertEquals(1, arenaLoader.getLevel());
        Assertions.assertEquals(16, grid.getWidth());
        Assertions.assertEquals(16, grid.getHeight());
    }

    @Test
    public void loadPlayerTest() {
        Player player = arenaLoader.createPlayer();
        Assertions.assertNotNull(player);
        assertEquals(7, player.getX());
        assertEquals(14, player.getY());
        assertEquals("UP", player.getDirection());
    }

    @Test
    public void loadHorizontalMonstersTest() {
        List<Monster> monsters = arenaLoader.createHorizontalMonsters();
        assertEquals(2, monsters.size());
    }

    @Test
    public void loadVerticalMonstersTest() {
        List<Monster> monsters = arenaLoader.createVerticalMonsters();
        assertEquals(2, monsters.size());
    }

    @Test
    public void loadWallsTest() {
        List<Wall> walls = arenaLoader.createWalls();
        assertEquals(60, walls.size());
    }

    @Test
    public void loadIceWallsTest() {
        List<IceWall> iceWalls = arenaLoader.createIceWalls();
        assertEquals(24, iceWalls.size());
    }

    @Test
    public void loadBananasTest() {
        List<Banana> bananas = arenaLoader.createBananas();
        assertEquals(20, bananas.size());
    }

    @Test
    public void loadWaterMelonsTest() {
        List<WaterMelon> waterMelons = arenaLoader.createWaterMelons();
        assertEquals(16, waterMelons.size());
    }
}
