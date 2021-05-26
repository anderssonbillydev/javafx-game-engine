package game_engine.renderer;

import game_engine.javafx.scene.image.PixelatedScalingImageView;
import game_engine.model.Point2D;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

public class Layer {

    private ImageView screen;
    private WritableImage image;
    private int width, height, pixelSize;
    private Point2D offset;
    private byte[] blank;

    public Layer(int width, int height, int pixelSize) {
        this(width, height, pixelSize, new Point2D(0, 0), null);
    }

    public Layer(int width, int height, int pixelSize, BlendMode blendMode) {
        this(width, height, pixelSize, new Point2D(0, 0), blendMode);
    }

    public Layer(int width, int height, int pixelSize, Point2D offset) {
        this(width, height, pixelSize, offset, null);
    }

    public Layer(int width, int height, int pixelSize, Point2D offset, BlendMode blendMode) {
        setWidth(width);
        setHeight(height);
        setPixelSize(pixelSize);
        setImage(new WritableImage(this.width, this.height));
        setScreen(new PixelatedScalingImageView(image));
        setOffset(offset);
        setBlendMode(blendMode);
        blank = new byte[width * height * 4];

        this.screen.setSmooth(false);
        this.screen.setFitWidth(this.width * this.pixelSize);
        this.screen.setFitHeight(this.height * this.pixelSize);
    }

    public ImageView getScreen() {
        return screen;
    }

    public void setScreen(ImageView screen) {
        this.screen = screen;
    }

    public WritableImage getImage() {
        return image;
    }

    public void setImage(WritableImage image) {
        this.image = image;
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

    public int getPixelSize() {
        return pixelSize;
    }

    public void setPixelSize(int pixelSize) {
        this.pixelSize = pixelSize;
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

    public byte[] getBlank() {
        return blank;
    }
}
