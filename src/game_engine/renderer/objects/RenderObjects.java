package game_engine.renderer.objects;

public abstract class RenderObjects {

    private int width, height;
    private Pixel[] pixels;

    protected abstract Pixel[] createObject();

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

    public Pixel[] getPixels() {
        if(pixels == null)
            createObject();
        return pixels;
    }
}
