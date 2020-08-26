package game_engine.render;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite {

    private String path;
    private int width, height;
    private Pixel[] pixels;

    public Sprite(String path, int width, int height) {
        // TODO load image from hardrive and convert to pixels array
        // TODO FUTURE: make a byte[] buffer of image that can be directly drawn with renderer
        setWidth(width);
        setHeight(height);
        pixels = new Pixel[width*height];
        try {
            BufferedImage bufferedImg = ImageIO.read(new File(path));
            for(int y = 0;y<height;y++){
                for(int x = 0;x<width;x++){
                    int color = bufferedImg.getRGB(x,y);
                    setPixel(x,y,new Pixel((color >> 16 & 0xff),(color  >> 8 & 0xff),(color & 0xff),(color >> 24 & 0xff)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Pixel[] getPixels() {
        return this.pixels;
    }

    public void setPixels(Pixel[] pixels) {
        this.pixels = pixels;
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
