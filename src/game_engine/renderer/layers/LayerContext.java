package game_engine.renderer.layers;

import game_engine.renderer.color.Color;
import game_engine.renderer.color.Pixel;
import game_engine.window.Window;
import javafx.scene.Group;
import javafx.scene.image.PixelWriter;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LayerContext {

    private Window window;
    private Group screen;
    private LinkedHashMap<String, Layer> layers;
    private String activeLayer;

    public LayerContext(Window window) {
        this.window = window;
        screen = new Group();
        layers = new LinkedHashMap<>();
        createLayer("root", this.window.getGameWidth(), this.window.getGameHeight());
        setActiveLayer("root");
    }

    public Layer createLayer(String name) {
        return createLayer(name, window.getGameWidth(), window.getGameHeight(), window.getPixelSize(), new Pixel(Color.TRANSPARENT));
    }

    public Layer createLayer(String name, Pixel backgroundColor) {
        return createLayer(name, window.getGameWidth(), window.getGameHeight(), window.getPixelSize(), backgroundColor);
    }

    public Layer createLayer(String name, int width, int height) {
        return createLayer(name, width, height, window.getPixelSize(), new Pixel(Color.TRANSPARENT));
    }

    public Layer createLayer(String name, int width, int height, Pixel backgroundColor) {
        return createLayer(name, width, height, window.getPixelSize(), backgroundColor);
    }

    public Layer createLayer(String name, int width, int height, int pixelSize) {
        return createLayer(name, width, height, pixelSize, new Pixel(Color.TRANSPARENT));
    }

    public Layer createLayer(String name, int width, int height, int pixelSize, Pixel backgroundColor) {
        Layer layer = new Layer(width, height, pixelSize, backgroundColor);
        addLayer(name, layer);
        return layer;
    }

    public void addLayer(String name, Layer layer) {
        layers.put(name, layer);
        layer.setZIndex(layers.size());
        screen.getChildren().add(layer.getScreen());
    }

    public void removeLayer(String layerName) {
        if (!layerName.equals("root") && layers.containsKey(layerName)) {
            screen.getChildren().remove(layers.get(layerName).getScreen());
            layers.remove(layerName);
        }
    }

    public void setActiveLayer(String layerName) {
        this.activeLayer = (layers.containsKey(layerName)) ? layerName : "root";
    }

    public Layer getActiveLayer() {
        return getLayer(getActiveLayerName());
    }

    public String getActiveLayerName() {
        return activeLayer;
    }

    public int getActiveLayerWidth() {
        return getActiveLayer().getWidth();
    }

    public int getActiveLayerHeight() {
        return getActiveLayer().getHeight();
    }

    public int getActiveLayerZIndex() {
        return getActiveLayer().getZIndex();
    }

    public void setActiveLayerZIndex(int zIndex) {
        getActiveLayer().setZIndex(zIndex);
        sortLayers();
    }

    public int getLayerZIndex(String layerName) {
        return getLayer(layerName).getZIndex();
    }

    public void setLayerZIndex(String layerName, int zIndex) {
        getLayer(layerName).setZIndex(zIndex);
        sortLayers();
    }

    public Pixel[] getActiveLayerBackgroundPixels() {
        return getActiveLayer().getBackgroundPixels();
    }

    public void setActiveLayerBackgroundColor(Pixel backgroundColor) {
        getActiveLayer().setBackgroundColor(backgroundColor);
    }

    public void setActiveLayerBackgroundPixels(Pixel[] backgroundPixels) {
        getActiveLayer().setBackgroundPixels(backgroundPixels);
    }

    public PixelWriter getActiveLayerPixelWriter() {
        return getActiveLayer().getImage().getPixelWriter();
    }

    public Layer getLayer(String layerName) {
        return layers.get(layerName);
    }

    public LinkedHashMap<String, Layer> getLayers() {
        return this.layers;
    }

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

    private void sortLayers() {
        layers = layers.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> entry.getValue().getZIndex()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        screen.getChildren().clear();
        layers.values().forEach(layer -> screen.getChildren().add(layer.getScreen()));

    }
}
