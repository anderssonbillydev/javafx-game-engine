package game_engine.renderer.render_objects.shape;

import game_engine.renderer.color.Color;
import game_engine.renderer.color.Pixel;
import game_engine.renderer.render_objects.RenderObject;

public abstract class Shape extends RenderObject {

    private int lineWidth;
    private Pixel linePixel, fillPixel;

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
        setWidth(width);
        setHeight(height);
        this.lineWidth = lineWidth;
        this.linePixel = linePixel;
        this.fillPixel = fillPixel;
    }

    public int getLineWidth() {
        return this.lineWidth;
    }

    public void setLineWidth(int lineWidth) {
        if(lineWidth > 0) {
            this.lineWidth = lineWidth;
            updateObject();
        }
    }

    public Pixel getLinePixel() {
        return this.linePixel;
    }

    public void setLinePixel(Pixel linePixel) {
        this.linePixel = linePixel;
        updateObject();
    }

    public Pixel getFillPixel() {
        return this.fillPixel;
    }

    public void setFillPixel(Pixel fillPixel) {
        this.fillPixel = fillPixel;
        updateObject();
    }

    public boolean isFilled(){
        return (this.fillPixel.getAlpha() != 0);
    }

}
