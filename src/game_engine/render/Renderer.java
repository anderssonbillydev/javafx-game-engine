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
        Layer bottomLayer = new Layer(this.window.getScreenWidth(), this.window.getScreenHeight());
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
        int size = window.getPixelSize();
        if ((x * size) >= 0 && (x * size) < width &&
                (y * size) >= 0 && (y * size) < height) {
            int pixels = size * size * 4;
            byte[] buffer = new byte[pixels];
            byte[] pixelColor = pixel.getRGB();

            System.arraycopy(pixelColor, 0, buffer, 0, pixelColor.length);
            int usedSize = pixelColor.length;
            while (usedSize < buffer.length) {
                System.arraycopy(buffer, 0, buffer, usedSize, Math.min(buffer.length - usedSize, usedSize));
                usedSize *= 2;
            }

            PixelWriter pw = layer.getImage().getPixelWriter();
            pw.setPixels(x * size, y * size, size, size, PixelFormat.getByteBgraPreInstance(), buffer, 0, size * 4);
        }
    }

    public void drawPixels(Point2D pos, int width, int height, Pixel[] pixels) {
        drawPixels(pos.getX(), pos.getY(), width, height, pixels);
    }

    public void drawPixels(int x, int y, int width, int height, Pixel[] pixels) {
        int size = window.getPixelSize();

        int bufferWidth = (size * width)*4;
        int bufferHeight = (size * height);
        byte[] buffer = new byte[bufferWidth * bufferHeight];

        for(int iy=0;iy<bufferHeight;iy++){
            for(int ix=0;ix<bufferWidth;ix+=4){
                byte[] pixelColor = pixels[(ix/size)/4 + (iy/size) *width].getRGB();
                buffer[ix + iy * bufferWidth] = pixelColor[0];
                buffer[ix+1 + iy * bufferWidth] = pixelColor[1];
                buffer[ix+2 + iy * bufferWidth] = pixelColor[2];
                buffer[ix+3 + iy * bufferWidth] = pixelColor[3];
            }
        }

        drawPixels(x, y, width, height, buffer);
    }

    public void drawPixels(int x, int y, int width, int height, byte[] buffer) {
        Layer layer = getActivelayer();
        int size = window.getPixelSize();

        // TODO FUTURE: Make this method do the resize of the buffer
        // TODO FUTURE: This is to make it possible to draw byte[] directly

        PixelWriter pw = layer.getImage().getPixelWriter();
        pw.setPixels(x * size, y * size, width*size, height*size, PixelFormat.getByteBgraPreInstance(), buffer, 0, width*size*4);
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

    public void drawSprite() {

    }

    public void clear() {
        // TODO fix clear so whole layer is emptied
        Layer layer = getLayer(activeLayer);
        layer.getBlank();
        PixelWriter pw = layer.getImage().getPixelWriter();
        pw.setPixels(0, 0, layer.getWidth(), layer.getHeight(), PixelFormat.getByteBgraPreInstance(), layer.getBlank(), 0, layer.getWidth() * 4);
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
