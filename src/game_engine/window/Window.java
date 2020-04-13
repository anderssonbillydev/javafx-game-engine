package game_engine.window;

public class Window {

    private int width, height, pixelSize;

    public Window(int width, int height){
        this(width,height,1);
    }

    public Window(int width, int height, int pixelSize){
        this.width = width * pixelSize;
        this.height = height * pixelSize;
        this.pixelSize = pixelSize;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPixelSize() {
        return pixelSize;
    }
}
