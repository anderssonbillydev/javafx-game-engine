package game_engine.renderer.object.shape;

import game_engine.renderer.object.Pixel;

public class Rectangle extends Shape {

    private Pixel pixel;

    public Rectangle(int width, int height, Pixel pixel) {
        super(width, height);
        this.pixel = pixel;
    }

    @Override
    protected Pixel[] createShape() {
        Pixel[] pixels = new Pixel[getWidth() * getHeight()];

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                pixels[x+y*getWidth()] = pixel;
            }
        }

        return pixels;
    }
}
