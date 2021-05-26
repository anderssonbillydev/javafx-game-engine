package game_engine.renderer.layers;

import game_engine.window.Window;
import javafx.scene.Group;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;

import java.util.LinkedHashMap;
import java.util.Map;

public class LayerContext {

    private Window window;
    private Group screen;
    private LinkedHashMap<String, Layer> layers;
    private String activeLayer;

    public LayerContext(Window window){
        this.window = window;
        layers = new LinkedHashMap<>();
        Layer bottomLayer = new Layer(this.window.getWidth(), this.window.getHeight(), this.window.getPixelSize());
        layers.put("root", bottomLayer);
        screen = new Group(bottomLayer.getScreen());
        activeLayer = "root";
    }

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

    public void clear() {
        // TODO fix clear so whole layer is emptied, layer.getBackgroundColor() ?
        Layer layer = getLayer(activeLayer);
        layer.getBlank();
        PixelWriter pw = layer.getImage().getPixelWriter();
        pw.setPixels(0, 0, layer.getWidth(), layer.getHeight(), PixelFormat.getByteBgraPreInstance(), layer.getBlank(), 0, layer.getWidth() * 4);
    }
}
