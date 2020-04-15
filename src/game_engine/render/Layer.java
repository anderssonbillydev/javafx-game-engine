package game_engine.render;

import game_engine.model.Point2D;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Layer {

	private ImageView screen;
	private WritableImage image;
	private int width, height;
	private Point2D offset;
	private Color background;

	public Layer(int width, int height) {
		this(width, height, new Point2D(0, 0), null);
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
		setBackground(Color.WHITE);
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

	public Color getBackground(){
		return this.background;
	}

	public void setBackground(Color color){
		background = color;
	}
}
