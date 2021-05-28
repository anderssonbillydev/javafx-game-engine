package game_engine.renderer.layers;

import game_engine.javafx.scene.image.PixelatedScalingImageView;
import game_engine.model.Point2D;
import game_engine.renderer.color.Color;
import game_engine.renderer.color.Pixel;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

import java.util.Arrays;

public class Layer {

    private ImageView screen;
    private WritableImage image;
    private int width, height, pixelSize, zIndex;
    private Point2D offset;
    private Pixel[] backgroundPixels;

    public Layer(int width, int height, int pixelSize) {
        this(width, height, pixelSize, new Point2D(0, 0), new Pixel(Color.TRANSPARENT), null);
    }

    public Layer(int width, int height, int pixelSize, Pixel backgroundColor) {
        this(width, height, pixelSize, new Point2D(0, 0), backgroundColor, null);
    }

    public Layer(int width, int height, int pixelSize, BlendMode blendMode) {
        this(width, height, pixelSize, new Point2D(0, 0), new Pixel(Color.TRANSPARENT), blendMode);
    }

    public Layer(int width, int height, int pixelSize, Pixel backgroundColor, BlendMode blendMode) {
        this(width, height, pixelSize, new Point2D(0, 0), backgroundColor, blendMode);
    }

    public Layer(int width, int height, int pixelSize, Point2D offset) {
        this(width, height, pixelSize, offset, null);
    }

    public Layer(int width, int height, int pixelSize, Point2D offset, Pixel backgroundColor) {
        this(width, height, pixelSize, offset, backgroundColor, null);
    }


    public Layer(int width, int height, int pixelSize, Point2D offset, Pixel backgroundColor, BlendMode blendMode) {
        setWidth(width);
        setHeight(height);
        this.pixelSize = pixelSize;
        this.image = new WritableImage(this.width, this.height);
        this.screen = new PixelatedScalingImageView(image);
        setOffset(offset);
        setBlendMode(blendMode);
        setBackgroundPixels(new Pixel[this.width * this.height]);
        setBackgroundColor(backgroundColor);

        this.screen.setSmooth(false);
        this.screen.setFitWidth(this.width * this.pixelSize);
        this.screen.setFitHeight(this.height * this.pixelSize);
    }

    ImageView getScreen() {
        return screen;
    }

    WritableImage getImage() {
        return image;
    }

    public int getWidth() {
        return width;
    }

    // TODO setWidth doesn't change width of image or screen
    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    // TODO setHeight doesn't change height of image or screen
    public void setHeight(int height) {
        this.height = height;
    }

    int getZIndex(){
        return this.zIndex;
    }

    void setZIndex(int zIndex){
        this.zIndex = zIndex;
    }

    public Point2D getOffset() {
        return offset;
    }

    public void setOffset(Point2D offset) {
        this.offset = offset;
        this.screen.setX(this.offset.getX());
        this.screen.setY(this.offset.getY());
    }

    public BlendMode getBlendMode() {
        return screen.getBlendMode();
    }

    public void setBlendMode(BlendMode blendMode) {
        screen.setBlendMode(blendMode);
    }

    public void setBackgroundColor(Pixel backgroundColor) {
        Arrays.fill(this.backgroundPixels, backgroundColor);
    }

    public void setBackgroundPixels(Pixel[] backgroundPixels) {
        this.backgroundPixels = backgroundPixels;
    }

    public Pixel[] getBackgroundPixels() {
        return this.backgroundPixels;
    }
}
