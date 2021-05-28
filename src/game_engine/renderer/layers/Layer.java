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
    private Pixel backgroundColor;
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
        this.width = width;
        this.height = height;
        this.pixelSize = pixelSize;
        this.image = new WritableImage(this.width, this.height);
        this.screen = new PixelatedScalingImageView(image);
        setOffset(offset);
        setBlendMode(blendMode);
        setupBackground(backgroundColor);
        this.screen.setSmooth(false);
        this.screen.setFitWidth(this.width * this.pixelSize);
        this.screen.setFitHeight(this.height * this.pixelSize);
    }

    private void setupBackground(Pixel backgroundColor) {
        setBackgroundPixels(new Pixel[this.width * this.height]);
        setBackgroundColor(backgroundColor);
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

    public void setWidth(int width) {
        if (width > 0) {
            this.width = width;
            setupBackground(this.backgroundColor);
            this.image = new WritableImage(this.width, this.height);
            this.screen.setImage(image);
            this.screen.setFitWidth(this.width * this.pixelSize);
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height > 0) {
            this.height = height;
            setupBackground(this.backgroundColor);
            this.image = new WritableImage(this.width, this.height);
            this.screen.setImage(image);
            this.screen.setFitHeight(this.height * this.pixelSize);
        }
    }

    int getZIndex() {
        return this.zIndex;
    }

    void setZIndex(int zIndex) {
        this.zIndex = zIndex;
    }

    public Point2D getOffset() {
        return offset;
    }

    public void setOffset(Point2D offset) {
        this.offset = offset;
        this.screen.setX(this.offset.getX() * pixelSize);
        this.screen.setY(this.offset.getY() * pixelSize);
    }

    public void setOffset(int x, int y) {
        this.offset.setX(x);
        this.offset.setY(y);
        this.screen.setX(this.offset.getX() * pixelSize);
        this.screen.setY(this.offset.getY() * pixelSize);
    }

    public int getOffsetX() {
        return this.offset.getX();
    }

    public void setOffsetX(int offsetX) {
        this.offset.setX(offsetX);
        this.screen.setX(this.offset.getX() * pixelSize);
    }

    public int getOffsetY() {
        return this.offset.getY();
    }

    public void setOffsetY(int offsetY) {
        this.offset.setY(offsetY);
        this.screen.setY(this.offset.getY() * pixelSize);
    }

    public BlendMode getBlendMode() {
        return screen.getBlendMode();
    }

    public void setBlendMode(BlendMode blendMode) {
        screen.setBlendMode(blendMode);
    }

    public void setBackgroundColor(Pixel backgroundColor) {
        this.backgroundColor = backgroundColor;
        Arrays.fill(this.backgroundPixels, backgroundColor);
    }

    public void setBackgroundPixels(Pixel[] backgroundPixels) {
        this.backgroundPixels = backgroundPixels;
    }

    public Pixel[] getBackgroundPixels() {
        return this.backgroundPixels;
    }
}
