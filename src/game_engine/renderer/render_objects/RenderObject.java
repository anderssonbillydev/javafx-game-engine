package game_engine.renderer.render_objects;

import game_engine.renderer.color.Pixel;

public abstract class RenderObject {

    private int width, height;
    private Pixel[] pixels;

    protected abstract void createObject();

    public void updateObject(){ createObject(); }
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
    public Pixel getPixel(int x, int y) {
        checkIfCreated();
        return this.pixels[x + y * width];
    }
    public void setPixel(int x, int y, Pixel pixel) {
        checkIfCreated();
        pixels[x + y * width] = pixel;
    }

    public Pixel[] getPixels() {
        checkIfCreated();
        return pixels;
    }

    public void setPixels(Pixel[] pixels){
        this.pixels = pixels;
    }

    public Pixel[] getPartialPixels(int x, int y, int width, int height) {
        checkIfCreated();
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

    private void checkIfCreated(){
        if(pixels == null)
            createObject();
    }
}
