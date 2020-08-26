package game_engine.render;

import game_engine.model.Point2D;
import game_engine.window.Window;
import javafx.scene.Group;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;

import java.util.*;

public class Renderer {

    private Window window;
    private LinkedHashMap<String, Layer> layers;
    private Group screen;
    private String activeLayer;

    public Renderer(Window window) {
        this.window = window;
        layers = new LinkedHashMap<>();
        Layer bottomLayer = new Layer(this.window.getWidth(), this.window.getHeight(), this.window.getPixelSize());
        layers.put("root", bottomLayer);
        screen = new Group(bottomLayer.getScreen());
        activeLayer = "root";
    }

    // DRAW METHODS
    public void drawPixel(Point2D pos, Pixel pixel) {
        drawPixel(pos.getX(), pos.getY(), pixel);
    }

    public void drawPixel(int x, int y, Pixel pixel) {
        Layer layer = getActivelayer();
        double width = layer.getWidth();
        double height = layer.getHeight();
        if (x >= 0 && x < width &&
                y >= 0 && y < height) {
            byte[] pixelColor = pixel.getRGB();
            PixelWriter pw = layer.getImage().getPixelWriter();
            pw.setPixels(x, y, 1, 1, PixelFormat.getByteBgraPreInstance(), pixelColor, 0, 1);
        }
    }

    public void drawPixels(Point2D pos, int width, int height, Pixel[] pixels) {
        drawPixels(pos.getX(), pos.getY(), width, height, pixels);
    }

    public void drawPixels(int x, int y, int width, int height, Pixel[] pixels) {
        Layer layer = getActivelayer();
        int layerWidth = layer.getWidth();
        int layerHeight = layer.getHeight();

        if ((x) < layerWidth && (y) < layerHeight) {
            int xOffset = 0;
            int yOffset = 0;
            int widthOffset = 0;
            int heightOffset = 0;

            if (x < 0) {
                xOffset = x * -1;
                widthOffset = xOffset;
                x = 0;
            } else if ((x + width)  > layerWidth) {
                widthOffset = ((x + width) - layerWidth);
            }
            if (y < 0) {
                yOffset = y * -1;
                heightOffset = yOffset;
                y = 0;
            } else if ((y + height) > layerHeight) {
                heightOffset = ((y + height) - layerHeight);
            }

            int bufferWidth = ((width - widthOffset)) * 4;
            int bufferHeight = ((height - heightOffset));
            if (bufferWidth > 0 && bufferHeight > 0) {
                byte[] buffer = new byte[bufferWidth * bufferHeight];

                for (int iy = 0; iy < bufferHeight; iy++) {
                    for (int ix = 0; ix < bufferWidth; ix += 4) {
                        int pixelX = ((ix) / 4) + xOffset;
                        int pixelY = (iy) + yOffset;
                        byte[] pixelColor = pixels[pixelX + pixelY * width].getRGB();
                        int i = ix + iy * bufferWidth;
                        buffer[i] = pixelColor[0];
                        buffer[i + 1] = pixelColor[1];
                        buffer[i + 2] = pixelColor[2];
                        buffer[i + 3] = pixelColor[3];
                    }
                }

                width -= widthOffset;
                height -= heightOffset;
                drawPixels(x, y, width, height, buffer);
            }
        }
    }

    public void drawBuffer(int x, int y, int width, int height, byte[] buffer) {
        drawPixels(x, y, width, height, buffer);
    }

    private void drawPixels(int x, int y, int width, int height, byte[] buffer) {
        Layer layer = getActivelayer();

        PixelWriter pw = layer.getImage().getPixelWriter();
        pw.setPixels(x, y, width, height, PixelFormat.getByteBgraPreInstance(), buffer, 0, width * 4);
    }

    public void drawSquare(Point2D pos, int size, Pixel pixel) {
        drawSquare(pos.getX(), pos.getY(), size, pixel);
    }

    public void drawSquare(int x, int y, int size, Pixel pixel) {
        drawRectangle(x, y, size, size, pixel);
    }

    public void drawRectangle(Point2D pos, int width, int height, Pixel pixel) {
        drawRectangle(pos.getX(), pos.getY(), width, height, pixel);
    }

    public void drawRectangle(int x, int y, int width, int height, Pixel pixel) {
        for (int iy = 0; iy < height; iy++) {
            for (int ix = 0; ix < width; ix++) {
                drawPixel(x + ix, y + iy, pixel);
            }
        }
    }

    public void drawLine(Point2D pos1, Point2D pos2, Pixel pixel) {
        drawLine(pos1.getX(), pos1.getY(), pos2.getX(), pos2.getY(), false, pixel);
    }

    public void drawLine(Point2D pos1, Point2D pos2, boolean thick, Pixel pixel) {
        drawLine(pos1.getX(), pos1.getY(), pos2.getX(), pos2.getY(), thick, pixel);
    }

    public void drawLine(int x1, int y1, int x2, int y2, Pixel pixel) {
        drawLine(x1, y1, x2, y2, false, pixel);
    }

    public void drawLine(int x1, int y1, int x2, int y2, boolean thick, Pixel pixel) {
        int dx = Math.abs(x2 - x1);
        int sx = x1 < x2 ? 1 : -1;
        int dy = -Math.abs(y2 - y1);
        int sy = y1 < y2 ? 1 : -1;
        int err = dx + dy;

        if (y1 == y2) {
            // Horizontal line
            int X0 = Math.min(x1, x2);
            int X1 = Math.max(x1, x2);
            for (int x = X0; x <= X1; x++) {
                drawPixel(x, y1, pixel);
            }
        } else if (x1 == x2) {
            // Vertical line
            int Y0 = Math.min(y1, y2);
            int Y1 = Math.max(y1, y2);
            for (int y = Y0; y <= Y1; y++) {
                drawPixel(x1, y, pixel);
            }
        } else {
            // Diagonal line
            drawPixel(x1, y1, pixel);
            while (true) {
                if (x1 == x2 && y1 == y2) break;
                int e2 = 2 * err;
                if (thick) {
                    // draw points between diagonals
                    if (e2 - dy > dx - e2) {
                        err += dy;
                        x1 += sx;
                    } else {
                        err += dx;
                        y1 += sy;
                    }
                } else {
                    // Skip points between diagonals
                    if (e2 >= dy) {
                        err += dy;
                        x1 += sx;
                    }
                    if (e2 <= dx) {
                        err += dx;
                        y1 += sy;
                    }
                }
                drawPixel(x1, y1, pixel);
            }
        }
    }

    public void drawSprite(Point2D pos, Sprite sprite) {
        drawSprite(pos.getX(), pos.getY(), sprite);
    }

    public void drawSprite(int x, int y, Sprite sprite) {
        drawPixels(x, y, sprite.getWidth(), sprite.getHeight(), sprite.getPixels());
    }

    public void clear() {
        // TODO fix clear so whole layer is emptied
        Layer layer = getLayer(activeLayer);
        layer.getBlank();
        PixelWriter pw = layer.getImage().getPixelWriter();
        pw.setPixels(0, 0, layer.getWidth(), layer.getHeight(), PixelFormat.getByteBgraPreInstance(), layer.getBlank(), 0, layer.getWidth() * 4);
    }

    // LAYER LOGIC

    public void createLayer(String name) {
        createLayer(name, window.getWidth(), window.getHeight(), window.getPixelSize());
    }

    public void createLayer(String name, int width, int height) {
        createLayer(name, width, height, window.getPixelSize());
    }

    public void createLayer(String name, int width, int height, int pixelSize) {
        addLayer(name, new Layer(width, height, pixelSize));
    }

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
