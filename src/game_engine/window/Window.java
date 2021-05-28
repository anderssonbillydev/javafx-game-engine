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

	// Game screen width
	public int getGameWidth() {
		return width;
	}

	// Game screen height
	public int getGameHeight() {
		return height;
	}

	public int getPixelSize() {
		return pixelSize;
	}

	// Screen width
	public int getScreenWidth() {
		return width * getPixelSize();
	}

	// Screen height
	public int getScreenHeight() {
		return height * getPixelSize();
	}
}
