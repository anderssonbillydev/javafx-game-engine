package game_engine.renderer.render_objects.sprite;

import game_engine.renderer.color.Pixel;
import game_engine.renderer.render_objects.RenderObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite extends RenderObject {

    // TODO Make sprite a part of shapes/render render_objects

    private String path;

    public Sprite(String path, int width, int height) {
        // TODO FUTURE: make a byte[] buffer of image that can be directly drawn with renderer
        // TODO FUTURE: import byte[] file as image with relevant width, height data
        setWidth(width);
        setHeight(height);
        setPath(path);
    }

    @Override
    protected void createObject() {
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

        setPixels(new Pixel[getWidth() * getHeight()]);
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                int color = bufferedImg.getRGB(x, y);
                setPixel(x, y, new Pixel((color >> 16 & 0xff), (color >> 8 & 0xff), (color & 0xff), (color >> 24 & 0xff)));
            }
        }
    }

    public String getPath(){
        return this.path;
    }

    public void setPath(String path){
        this.path = path;
    }
}
