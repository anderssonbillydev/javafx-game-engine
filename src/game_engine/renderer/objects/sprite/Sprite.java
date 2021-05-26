package game_engine.renderer.objects.sprite;

import game_engine.renderer.objects.Pixel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite {

    // TODO Make sprite a part of shapes/render objects

    private String path;
    private int width, height;
    private Pixel[] pixels;

    public Sprite(String path, int width, int height) {
        // TODO FUTURE: make a byte[] buffer of image that can be directly drawn with renderer
        // TODO FUTURE: import byte[] file as image with relevant width, height data

        BufferedImage bufferedImg = null;

        try {
            bufferedImg = ImageIO.read(new File(getClass().getClassLoader().getResource(path).getPath()));
        } catch (Exception e1) {
            try {
                bufferedImg = ImageIO.read(new File(path));
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }

        setWidth(width);
        setHeight(height);
        pixels = new Pixel[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int color = bufferedImg.getRGB(x, y);
                setPixel(x, y, new Pixel((color >> 16 & 0xff), (color >> 8 & 0xff), (color & 0xff), (color >> 24 & 0xff)));
            }
        }
    }

    public Pixel[] getPixels() {
        return this.pixels;
    }

    public void setPixels(Pixel[] pixels) {
        this.pixels = pixels;
    }

    public Pixel[] getPartialPixels(int x, int y, int width, int height) {
        Pixel[] partialPixels = new Pixel[width * height];

        for (int y1 = 0; y1 < height; y1++) {
            for (int x1 = 0; x1 < width; x1++) {
                partialPixels[x1 + y1 * width] = getPixel(x1 + x, y1 + y);
            }
        }

        return partialPixels;
    }

    public void setPartialPixels(int x, int y, int width, int height, Pixel[] pixels) {
        for (int y1 = 0; y1 < height; y1++) {
            for (int x1 = 0; x1 < width; x1++) {
                setPixel(x1 + x, y1 + y, pixels[x1 + y1 * width]);
            }
        }
    }

    public Pixel getPixel(int x, int y) {
        return this.pixels[x + y * width];
    }

    public void setPixel(int x, int y, Pixel pixel) {
        pixels[x + y * width] = pixel;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
