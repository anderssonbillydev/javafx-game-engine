package game_engine.render;

import game_engine.model.Point2D;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

public class Layer {

	private ImageView screen;
	private WritableImage image;
	private int width, height;
	private Point2D offset;
	private byte[] blank;

	public Layer(int width, int height) {
		this(width, height, new Point2D(0, 0), null);
	}

	public Layer(int width, int height, BlendMode blendMode) {
		this(width, height, new Point2D(0, 0), blendMode);
	}

	public Layer(int width, int height, Point2D offset) {
		this(width, height, offset, null);
	}

	public Layer(int width, int height, Point2D offset, BlendMode blendMode) {
		setWidth(width);
		setHeight(height);
		setImage(new WritableImage(this.width, this.height));
		setScreen(new ImageView(image));
		setOffset(offset);
		setBlendMode(blendMode);
		blank = new byte[width*height*4];
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
