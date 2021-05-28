package game_engine.examples;

import game_engine.GameEngine;
import game_engine.model.Point2D;
import game_engine.renderer.color.Color;
import game_engine.renderer.color.Pixel;
import game_engine.renderer.layers.Layer;
import game_engine.renderer.layers.LayerContext;
import game_engine.renderer.render_objects.shape.Square;
import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

public class LayerExample extends Application {

    private final String TITLE = "Layer Example";
    private int width = 512;
    private int height = 360;
    private GameEngine gameEngine;

    @Override
    public void start(Stage primaryStage) throws Exception {
        gameEngine = new GameEngine(TITLE, primaryStage, width, height, 2) {

            LayerContext layerCtx;
            String layerName1, layerName2, layerName3;
            Layer layer1, layer2, layer3;
            Point2D square1Pos, square2Pos, square3Pos;
            Square square1, square2, square3;
            Pixel lineColor, activeColor, fillColor;

            @Override
            public void onCreate() {
                System.out.println("Creates Layer Example");
                System.out.println("Scroll up or down to change active layer");
                System.out.println("Left or right click to change Z-index");
                System.out.println("NumPad+ or NumPad- to change layer1 width");
                System.out.println("Arrow keys moves layer1");

                layerCtx = getRenderer().getLayerContext();

                layerName1 = "layerName1";
                layerName2 = "layerName2";
                layerName3 = "layerName3";

                lineColor = new Pixel(Color.BLACK);
                activeColor = new Pixel(Color.RED);
                fillColor = new Pixel(Color.WHITE);

                square1Pos = new Point2D(0,0);
                square2Pos = new Point2D(25,25);
                square3Pos = new Point2D(50,50);
                square1 = new Square(50, lineColor, fillColor);
                square2 = new Square(50, lineColor, fillColor);
                square3 = new Square(50, lineColor, fillColor);

                layer1 = layerCtx.createLayer(layerName1,100,100, new Pixel(Color.RED));

                layer2 = layerCtx.createLayer(layerName2);
                layer3 = layerCtx.createLayer(layerName3);

                layerCtx.setActiveLayer(layerName1);
                getRenderer().drawRenderObject(square1Pos, square1);

                layerCtx.setActiveLayer(layerName2);
                getRenderer().drawRenderObject(square2Pos, square2);

                layerCtx.setActiveLayer(layerName3);
                getRenderer().drawRenderObject(square3Pos, square3);

                layerCtx.setActiveLayer(layerName1);
            }

            @Override
            public void onGameTick(long now) {
                String activeLayer = layerCtx.getActiveLayerName();

                if (activeLayer.equals(layerName1)) {
                    square1.setLinePixel(activeColor);
                    square2.setLinePixel(lineColor);
                    square3.setLinePixel(lineColor);
                }
                if (activeLayer.equals(layerName2)) {
                    square1.setLinePixel(lineColor);
                    square2.setLinePixel(activeColor);
                    square3.setLinePixel(lineColor);
                }
                if (activeLayer.equals(layerName3)) {
                    square1.setLinePixel(lineColor);
                    square2.setLinePixel(lineColor);
                    square3.setLinePixel(activeColor);
                }

                if (getInputHandler().isScrollingUp()) {
                    if (activeLayer.equals(layerName1))
                        layerCtx.setActiveLayer(layerName2);
                    if (activeLayer.equals(layerName2))
                        layerCtx.setActiveLayer(layerName3);
                    if (activeLayer.equals(layerName3))
                        layerCtx.setActiveLayer(layerName1);
                }
                if (getInputHandler().isScrollingDown()) {
                    if (activeLayer.equals(layerName1))
                        layerCtx.setActiveLayer(layerName3);
                    if (activeLayer.equals(layerName2))
                        layerCtx.setActiveLayer(layerName1);
                    if (activeLayer.equals(layerName3))
                        layerCtx.setActiveLayer(layerName2);
                }
                if (getInputHandler().isMouseButtonPressed(MouseButton.PRIMARY))
                    layerCtx.setActiveLayerZIndex(layerCtx.getActiveLayerZIndex() + 1);
                if (getInputHandler().isMouseButtonPressed(MouseButton.SECONDARY))
                    layerCtx.setActiveLayerZIndex(layerCtx.getActiveLayerZIndex() - 1);
                if (getInputHandler().isKeyPressed(KeyCode.ADD))
                    layer1.setWidth(layer1.getWidth() + 1);
                if (getInputHandler().isKeyPressed(KeyCode.SUBTRACT))
                    layer1.setWidth(layer1.getWidth() - 1);

                if (getInputHandler().isKeyPressed(KeyCode.LEFT))
                    layer1.setOffsetX(layer1.getOffsetX() - 1);
                if (getInputHandler().isKeyPressed(KeyCode.RIGHT))
                    layer1.setOffsetX(layer1.getOffsetX() + 1);
                if (getInputHandler().isKeyPressed(KeyCode.UP))
                    layer1.setOffsetY(layer1.getOffsetY() - 1);
                if (getInputHandler().isKeyPressed(KeyCode.DOWN))
                    layer1.setOffsetY(layer1.getOffsetY() + 1);

            }

            @Override
            public void onFrameUpdate(long now) {
                String activeLayer = layerCtx.getActiveLayerName();

                getRenderer().clearLayers();

                if (activeLayer.equals(layerName1)) {
                    square1.setLinePixel(activeColor);
                    square2.setLinePixel(lineColor);
                    square3.setLinePixel(lineColor);

                    layerCtx.setActiveLayer(layerName1);
                    getRenderer().drawRenderObject(square1Pos, square1);

                    layerCtx.setActiveLayer(layerName2);
                    getRenderer().drawRenderObject(square2Pos, square2);

                    layerCtx.setActiveLayer(layerName3);
                    getRenderer().drawRenderObject(square3Pos, square3);
                }
                if (activeLayer.equals(layerName2)) {
                    square1.setLinePixel(lineColor);
                    square2.setLinePixel(activeColor);
                    square3.setLinePixel(lineColor);

                    layerCtx.setActiveLayer(layerName1);
                    getRenderer().drawRenderObject(square1Pos, square1);

                    layerCtx.setActiveLayer(layerName2);
                    getRenderer().drawRenderObject(square2Pos, square2);

                    layerCtx.setActiveLayer(layerName3);
                    getRenderer().drawRenderObject(square3Pos, square3);
                }
                if (activeLayer.equals(layerName3)) {
                    square1.setLinePixel(lineColor);
                    square2.setLinePixel(lineColor);
                    square3.setLinePixel(activeColor);

                    layerCtx.setActiveLayer(layerName1);
                    getRenderer().drawRenderObject(square1Pos, square1);

                    layerCtx.setActiveLayer(layerName2);
                    getRenderer().drawRenderObject(square2Pos, square2);

                    layerCtx.setActiveLayer(layerName3);
                    getRenderer().drawRenderObject(square3Pos, square3);
                }

                layerCtx.setActiveLayer(activeLayer);
            }
        };
        gameEngine.start();
        gameEngine.setDebug(true);
    }
}
