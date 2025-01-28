package badicecream.model.arena;

import badicecream.model.elements.characters.Monster;
import badicecream.model.elements.characters.Player;
import badicecream.model.elements.fruits.Banana;
import badicecream.model.elements.fruits.WaterMelon;
import badicecream.model.elements.walls.IceWall;
import badicecream.model.elements.walls.Wall;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ArenaLoader extends ArenaBuilder{
    private final int level;
    private final List<String> lines;

    public ArenaLoader(int level) throws IOException {
        this.level = level;

        URL resource = ArenaLoader.class.getResource("/levels/level" + level + ".lvl");
        assert resource != null;
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null;) {
            lines.add(line);
        }
        return lines;
    }

    @Override
    protected int getLevel() {
        return level;
    }

    @Override
    protected Grid getGrid() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        int height = lines.size();

        return new Grid(width, height);
    }

    @Override
    protected Player createPlayer() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'P') return new Player(x, y, "UP");
        }
        return null;
    }

    @Override
    protected  List<Monster> createHorizontalMonsters() {
        List<Monster> monsters = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'H') monsters.add(new Monster(x, y, "LEFT"));
        }
        return monsters;
    }

    @Override
    protected  List<Monster> createVerticalMonsters() {
        List<Monster> monsters = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'V') monsters.add(new Monster(x, y, "DOWN"));
        }
        return monsters;
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') walls.add(new Wall(x, y));
        }
        return walls;
    }

    @Override
    protected List<IceWall> createIceWalls() {
        List<IceWall> iceWalls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'I') iceWalls.add(new IceWall(x, y));
        }
        return iceWalls;
    }

    @Override
    protected List<Banana> createBananas() {
        List<Banana> bananas = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'B') bananas.add(new Banana(x, y));
        }
        return bananas;
    }

    @Override
    protected List<WaterMelon> createWaterMelons() {
        List<WaterMelon> waterMelons = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x <line.length(); x++)
                if (line.charAt(x) == 'W') waterMelons.add(new WaterMelon(x, y));
        }
        return waterMelons;
    }
}
