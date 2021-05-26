package game_engine.renderer.render_objects.shape;

import game_engine.renderer.color.Pixel;

public class Rectangle extends Shape {

    public Rectangle(int width, int height, Pixel linePixel) {
        super(width, height, linePixel);
    }

    public Rectangle(int width, int height, int lineWidth, Pixel linePixel) {
        super(width, height, lineWidth, linePixel);
    }

    public Rectangle(int width, int height, Pixel linePixel, Pixel fillPixel) {
        super(width, height, linePixel, fillPixel);
    }

    public Rectangle(int width, int height, int lineWidth, Pixel linePixel, Pixel fillPixel) {
        super(width, height, lineWidth, linePixel, fillPixel);
    }

    @Override
    protected void createObject() {
        setPixels(new Pixel[getWidth() * getHeight()]);

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                if (
                        x < getLineWidth() ||
                        x >= getWidth() - getLineWidth() ||
                        y < getLineWidth() ||
                        y >= getHeight() - getLineWidth()) {
                    // Line
                    setPixel(x,y,getLinePixel());
                } else {
                    // Fill
                    setPixel(x,y,getFillPixel());
                }
            }
        }
    }
}
