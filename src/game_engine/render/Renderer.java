package game_engine.render;

import game_engine.model.Point2D;
import game_engine.window.Window;
import javafx.scene.Group;
import javafx.scene.image.PixelWriter;

import java.util.LinkedHashMap;
import java.util.Map;

public class Renderer {

	private Window window;
	private LinkedHashMap<String, Layer> layers;
	private Group screen;
	private String activeLayer;

	public Renderer(Window window) {
		this.window = window;
		layers = new LinkedHashMap<>();
		Layer bottomLayer = new Layer(this.window.getWidth(), this.window.getHeight());
		layers.put("root", bottomLayer);
		screen = new Group(bottomLayer.getScreen());
		activeLayer = "root";
	}

	// DRAW METHODS

	public void drawPixel(Pixel pixel) {
		drawPixel(pixel, activeLayer);
	}

	public void drawPixel(Pixel pixel, String layerName) {
		Layer layer = layers.get(layerName);
		if (layer != null) {
			PixelWriter pw = layer.getImage().getPixelWriter();
			int size = window.getPixelSize();
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if ((pixel.getX() * size + j) >= 0 &&
							(pixel.getX() * size + j) < layer.getImage().getWidth() &&
							(pixel.getY() * size + i) >= 0 &&
							(pixel.getY() * size + i) < layer.getImage().getHeight()) {
						pw.setColor(pixel.getX() * size + j, pixel.getY() * size + i, pixel.getColor());
					}
				}
			}
		}
	}

	public void drawSquare(Pixel pixel, int size) {
		drawSquare(pixel, size, activeLayer);
	}

	public void drawSquare(Pixel pixel, int size, String layerName) {
		drawRectangle(pixel, size, size, layerName);
	}

	public void drawRectangle(Pixel pixel, int width, int height) {
		drawRectangle(pixel, width, height, activeLayer);
	}

	public void drawRectangle(Pixel pixel, int width, int height, String layerName) {
		Layer layer = getLayer(layerName);
		if (layer != null) {
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					Pixel p = new Pixel(
							new Point2D(pixel.getX() + j, pixel.getY() + i),
							pixel.getColor()
					);
					drawPixel(p, layerName);
				}
			}
		}
	}

	public void drawLine(Pixel pixel, int x1, int y1) {
		drawLine(pixel, x1, y1, false, activeLayer);
	}

	public void drawLine(Pixel pixel, int x1, int y1, boolean thick) {
		drawLine(pixel, x1, y1, thick, activeLayer);
	}

	public void drawLine(Pixel pixel, int x1, int y1, boolean thick, String layerName) {
		int dx = Math.abs(x1 - pixel.getX());
		int sx = pixel.getX() < x1 ? 1 : -1;
		int dy = -Math.abs(y1 - pixel.getY());
		int sy = pixel.getY() < y1 ? 1 : -1;
		int err = dx + dy;

		if (pixel.getY() == y1) {
			// Horizontal line
			int X0 = Math.min(pixel.getX(), x1);
			int X1 = Math.max(pixel.getX(), x1);
			for(int x=X0;x<=X1;x++){
				pixel.setX(x);
				drawPixel(pixel,layerName);
			}
		} else if (pixel.getX() == x1) {
			// Vertical line
			int Y0 = Math.min(pixel.getY(), y1);
			int Y1 = Math.max(pixel.getY(), y1);
			for(int y=Y0;y<=Y1;y++){
				pixel.setY(y);
				drawPixel(pixel,layerName);
			}
		} else {
			// Diagonal line
			drawPixel(pixel, layerName);
			while (true) {
				if (pixel.getX() == x1 && pixel.getY() == y1) break;
				int e2 = 2 * err;
				if (thick) {
					// draw points between diagonals
					if (e2 - dy > dx - e2) {
						err += dy;
						pixel.setX((pixel.getX() + sx));
					} else {
						err += dx;
						pixel.setY(pixel.getY() + sy);
					}
				} else {
					// Skip points between diagonals
					if (e2 >= dy) {
						err += dy;
						pixel.setX((pixel.getX() + sx));
					}
					if (e2 <= dx) {
						err += dx;
						pixel.setY(pixel.getY() + sy);
					}
				}
				drawPixel(pixel, layerName);
			}
		}
	}

	public void clear() {
		clear(activeLayer);
	}

	public void clear(String layerName) {
		Layer layer = getLayer(layerName);
		drawRectangle(new Pixel(new Point2D(0, 0), layer.getBackground()), layer.getWidth(), layer.getHeight(), layerName);
	}

	// LAYER LOGIC

	public void addLayer(String name, Layer layer) {
		layers.put(name, layer);
		screen.getChildren().add(layer.getScreen());
	}

	public void removeLayer(String layerName) {
		if (!layerName.equals("root") && layers.containsKey(layerName)) {
			screen.getChildren().remove(layers.get(layerName).getScreen());
			layers.remove(layerName);
		}
	}

	public void setActiveLayer(String layerName) {
		activeLayer = (layers.containsKey(layerName)) ? layerName : "root";
	}

	public String getActivelayerName() {
		return activeLayer;
	}

	public Layer getActivelayer() {
		return getLayer(getActivelayerName());
	}

	public Layer getLayer(String layerName) {
		return layers.get(layerName);
	}

	// GETTERS AND SETTERS
	public Group getScreen() {
		return screen;
	}

	public Layer getBottomLayer() {
		return layers.entrySet().iterator().next().getValue();
	}

	public Layer getTopLayer() {
		Layer lastLayer = getBottomLayer();
		for (Map.Entry<String, Layer> stringLayerEntry : layers.entrySet()) lastLayer = stringLayerEntry.getValue();
		return lastLayer;
	}
}
