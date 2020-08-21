package game_engine.render;

public class Sprite {

    private String path;
    private int width,height;
    private Pixel[] pixels;

    public Sprite(int width, int height, String path){
        // TODO load image from hardrive and convert to pixels array
        // TODO FUTURE: make a byte[] buffer of image that can be directly drawn with renderer
    }

    public Pixel getPixel(int x, int y){
        return pixels[x+y*width];
    }

    public void setPixel(int x, int y, Pixel pixel){
        pixels[x+y*width] = pixel;
    }
}
