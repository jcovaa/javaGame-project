package badicecream.view;

import badicecream.gui.Gui;
import com.googlecode.lanterna.TextColor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class SpriteRenderer {
    private final BufferedImage image;

    public SpriteRenderer(String filePath) throws IOException {
        URL resource = getClass().getClassLoader().getResource(filePath);
        assert resource != null;

        this.image = ImageIO.read(resource);
    }

    public void draw(Gui gui, double stX, double stY) {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int color = image.getRGB(x, y);
                int alpha = (color >> 24) & 0xff;
                if (alpha != 0) {
                    gui.drawPixel(stX * 16 + x, stY * 16 + y, getRGB(color));
                }
            }
        }
    }

    private TextColor getRGB(int color) {
        int red = (color >> 16) & 0xff;
        int green = (color >> 8) & 0xff;
        int blue = color & 0xff;
        return new TextColor.RGB(red, green, blue);
    }
}
