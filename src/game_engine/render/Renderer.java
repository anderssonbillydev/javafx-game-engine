package game_engine.render;

import game_engine.model.Point2D;
import game_engine.render.shapes.Pixel;
import game_engine.window.Window;
import javafx.scene.Group;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

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
        Layer bottomLayer = new Layer(new Point2D(this.window.getWidth(), this.window.getHeight()));
        layers.put("root", bottomLayer);
        screen = new Group(bottomLayer.getScreen());
        activeLayer = "root";
    }

    // DRAW METHODS

    public void plotPixel(Pixel pixel) {
        plotPixel(pixel, activeLayer);
    }

    public void plotPixel(Pixel pixel, String layerName) {
        Layer layer = layers.get(layerName);
        if (layer != null) {
            PixelWriter pw = layer.getImage().getPixelWriter();
            int size = window.getPixelSize();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if ((pixel.getX() * size + j) >= 0 &&
                            (pixel.getX() * size + j) <= layer.getImage().getWidth() &&
                            (pixel.getY() * size + i) >= 0 &&
                            (pixel.getY() * size + i) <= layer.getImage().getHeight()) {
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
        Layer layer = layers.get(layerName);
        if (layer != null) {
            PixelWriter pw = layer.getImage().getPixelWriter();
            System.out.println("SIZE: " + size);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.println("test");
                    if ((pixel.getX() * size + j) >= 0 &&
                            (pixel.getX() * size + j) <= layer.getImage().getWidth() &&
                            (pixel.getY() * size + i) >= 0 &&
                            (pixel.getY() * size + i) <= layer.getImage().getHeight()) {
                        System.out.println("X: " + (pixel.getX() * size + j + window.getPixelSize()));
                        System.out.println("Y: " + (pixel.getY() * size + i + window.getPixelSize()));
                        Pixel p = new Pixel(
                                new Point2D(pixel.getX() * size + j + window.getPixelSize(), pixel.getY() * size + i + window.getPixelSize()),
                                pixel.getColor()
                        );
                        plotPixel(p, layerName);
                    }
                }
            }
        }
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

    public String getActiveLayer() {
        return activeLayer;
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
