package badicecream.model.arena;

import badicecream.model.elements.characters.Monster;
import badicecream.model.elements.characters.Player;
import badicecream.model.elements.fruits.Banana;
import badicecream.model.elements.fruits.WaterMelon;
import badicecream.model.elements.walls.IceWall;
import badicecream.model.elements.walls.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ArenaBuilderTest {
    private Arena arena;

    static class TestArenaBuilder extends ArenaBuilder {
        @Override
        protected int getLevel() {
            return 1; // Mock level
        }

        @Override
        protected Grid getGrid() {
            return new Grid(10, 10);
        }

        @Override
        protected Player createPlayer() {
            return mock(Player.class);
        }

        @Override
        protected List<Monster> createHorizontalMonsters() {
            return List.of(mock(Monster.class));
        }

        @Override
        protected List<Monster> createVerticalMonsters() {
            return List.of(mock(Monster.class));
        }

        @Override
        protected List<Wall> createWalls() {
            return List.of(mock(Wall.class));
        }

        @Override
        protected List<IceWall> createIceWalls() {
            return List.of(mock(IceWall.class));
        }

        @Override
        protected List<Banana> createBananas() {
            return List.of(mock(Banana.class));
        }

        @Override
        protected List<WaterMelon> createWaterMelons() {
            return List.of(mock(WaterMelon.class));
        }
    }

    @BeforeEach
    public void setup() {
        TestArenaBuilder testArenaBuilder = new TestArenaBuilder();

        arena = testArenaBuilder.createArena();
    }

    @Test
    public void createArenaTest() {
        assertEquals(10, arena.getGrid().getWidth());
        assertEquals(10, arena.getGrid().getHeight());

        assertEquals(1, arena.getLevel());

        assertNotNull(arena.getPlayer());

        assertFalse(arena.getWalls().isEmpty());

        assertFalse(arena.getIceWalls().isEmpty());

        assertFalse(arena.getBananas().isEmpty());

        assertFalse(arena.getWaterMelons().isEmpty());

        assertFalse(arena.getMonsters().isEmpty());

        List<Monster> monsters = arena.getMonsters();
        assertTrue(monsters.size() >= 2);
    }
}
