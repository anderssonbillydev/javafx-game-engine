package game_engine.renderer.render_objects.shape;

import game_engine.renderer.color.Pixel;

public class Square extends Rectangle {

    public Square(int size, Pixel linePixel) {
        super(size, size, linePixel);
    }

    public Square(int size, int lineWidth, Pixel linePixel) {
        super(size, size, lineWidth, linePixel);
    }

    public Square(int size, Pixel linePixel, Pixel fillPixel) {
        super(size, size, linePixel, fillPixel);
    }

    public Square(int size, int lineWidth, Pixel linePixel, Pixel fillPixel) {
        super(size, size, lineWidth, linePixel, fillPixel);
    }

}
