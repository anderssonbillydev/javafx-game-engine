package game_engine.window;

public class Window {

	private int width, height, pixelSize;

	public Window(int width, int height) {
		this(width, height, 1);
	}

	public Window(int width, int height, int pixelSize) {
		this.width = width;
		this.height = height;
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

	public int getScreenWidth() {
		return width * getPixelSize();
	}

	public int getScreenHeight() {
		return height * getPixelSize();
	}
}
