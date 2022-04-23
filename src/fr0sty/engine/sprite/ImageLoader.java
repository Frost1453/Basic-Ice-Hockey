package fr0sty.engine.sprite;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ImageLoader {

    private BufferedImage image;

    public BufferedImage getImage(String path) {
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResource(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
