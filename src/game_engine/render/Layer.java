package game_engine.render;

import game_engine.model.Point2D;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

public class Layer {

    private ImageView screen;
    private WritableImage image;
    private Point2D size, offset;
    private BlendMode blendMode;

    public Layer(Point2D size){
        this(size, new Point2D(0,0), BlendMode.ADD);
    }

    public Layer(Point2D size, Point2D offset){
        this(size, offset, BlendMode.ADD);
    }

    public Layer(Point2D size, Point2D offset, BlendMode blendMode){
        this.size = size;
        this.blendMode = blendMode;
        this.image = new WritableImage(this.size.getX(),this.size.getY());
        this.screen = new ImageView(image);
        setOffset(offset);
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

    public Point2D getSize() {
        return size;
    }

    public void setSize(Point2D size) {
        this.size = size;
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
        return blendMode;
    }

    public void setBlendMode(BlendMode blendMode) {
        screen.setBlendMode(blendMode);
    }
}
