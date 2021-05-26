package game_engine.renderer.objects.shape;

import game_engine.renderer.Color;
import game_engine.renderer.objects.Pixel;

public abstract class Shape {

    private int width, height, lineWidth;
    private Pixel linePixel, fillPixel;
    private Pixel[] pixels;

    public Shape(int width, int height, Pixel linePixel) {
        this(width, height, linePixel, new Pixel(Color.TRANSPARENT));
    }

    public Shape(int width, int height, int lineWidth, Pixel linePixel) {
        this(width, height, lineWidth, linePixel, new Pixel(Color.TRANSPARENT));
    }

    public Shape(int width, int height, Pixel linePixel, Pixel fillPixel) {
        this(width, height, 1, linePixel, fillPixel);
    }

    public Shape(int width, int height, int lineWidth, Pixel linePixel, Pixel fillPixel) {
        this.width = width;
        this.height = height;
        this.lineWidth = lineWidth;
        this.linePixel = linePixel;
        this.fillPixel = fillPixel;
    }

    protected abstract Pixel[] createShape();

    protected void updateShape() {
        pixels = createShape();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLineWidth() {
        return this.lineWidth;
    }

    public void setLineWidth(int lineWidth) {
        if(lineWidth > 0) {
            this.lineWidth = lineWidth;
            updateShape();
        }
    }

    public Pixel getLinePixel() {
        return this.linePixel;
    }

    public void setLinePixel(Pixel linePixel) {
        this.linePixel = linePixel;
        updateShape();
    }

    public Pixel getFillPixel() {
        return this.fillPixel;
    }

    public void setFillPixel(Pixel fillPixel) {
        this.fillPixel = fillPixel;
        updateShape();
    }

    public boolean isFilled(){
        return (this.fillPixel.getAlpha() != 0);
    }

    public Pixel[] getPixels() {
        if (pixels == null)
            updateShape();
        return pixels;
    }
}
