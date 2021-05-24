package game_engine.renderer.object.shape;

import game_engine.renderer.object.Pixel;

public abstract class Shape{

    private int width,height;
    private Pixel[] pixels;

    public Shape(int width,int height){
        this.width = width;
        this.height = height;
    }

    protected abstract Pixel[] createShape();

    protected void updateShape(){
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

    public Pixel[] getPixels(){
        if(pixels == null)
            updateShape();
        return pixels;
    }
}
