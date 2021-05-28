package game_engine.renderer.layers;

import game_engine.renderer.color.Pixel;
import game_engine.window.Window;
import javafx.scene.Group;
import javafx.scene.image.PixelWriter;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LayerContext {

    // TODO Test layer sizes, scrolling and resizing. getOffset is used when moving layers

    private Window window;
    private Group screen;
    private LinkedHashMap<String, Layer> layers;
    private String activeLayer;

    public LayerContext(Window window){
        this.window = window;
        layers = new LinkedHashMap<>();
        Layer bottomLayer = new Layer(this.window.getGameWidth(), this.window.getGameHeight(), this.window.getPixelSize());
        layers.put("root", bottomLayer);
        screen = new Group(bottomLayer.getScreen());
        activeLayer = "root";
    }

    public void createLayer(String name) {
        createLayer(name, window.getGameWidth(), window.getGameHeight(), window.getPixelSize());
    }

    public void createLayer(String name, int width, int height) {
        createLayer(name, width, height, window.getPixelSize());
    }

    public void createLayer(String name, int width, int height, int pixelSize) {
        addLayer(name, new Layer(width, height, pixelSize));
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

    public Layer getActivelayer() {
        return getLayer(getActivelayerName());
    }

    public String getActivelayerName() {
        return activeLayer;
    }

    public int getActiveLayerWidth(){
        return getActivelayer().getWidth();
    }

    public int getActiveLayerHeight(){
        return getActivelayer().getHeight();
    }

    public int getActiveLayerZIndex(){
        return getActivelayer().getZIndex();
    }

    public void setActiveLayerZIndex(int zIndex){
        getActivelayer().setZIndex(zIndex);
        sortLayers();
    }

    public int getLayerZIndex(String layerName){
        return getLayer(layerName).getZIndex();
    }

    public void setLayerZIndex(String layerName, int zIndex){
        getLayer(layerName).setZIndex(zIndex);
        sortLayers();
    }

    public Pixel[] getActiveLayerBackgroundPixels(){
        return getActivelayer().getBackgroundPixels();
    }

    public void setActiveLayerBackgroundColor(Pixel backgroundColor){
        getActivelayer().setBackgroundColor(backgroundColor);
    }

    public void setActiveLayerBackgroundPixels(Pixel[] backgroundPixels){
        getActivelayer().setBackgroundPixels(backgroundPixels);
    }

    public PixelWriter getActiveLayerPixelWriter(){
        return getActivelayer().getImage().getPixelWriter();
    }

    public Layer getLayer(String layerName) {
        return layers.get(layerName);
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

    private void sortLayers(){
        layers = layers.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> entry.getValue().getZIndex()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue)->oldValue, LinkedHashMap::new));
    }
}
