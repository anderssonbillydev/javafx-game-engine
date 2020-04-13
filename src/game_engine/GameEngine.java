package game_engine;

import game_engine.model.Point2D;
import game_engine.render.Layer;
import game_engine.render.shapes.Pixel;
import game_engine.render.Renderer;
import game_engine.window.Window;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class GameEngine {

    private Window window;
    private Pane screen;

    public GameEngine(int width, int height) {
        this.window = new Window(width, height);
    }

    public GameEngine(int width, int height, int pixelSize) {
        this.window = new Window(width, height, pixelSize);
    }

    public Scene createScene() {
        screen = new Pane();
        return new Scene(screen, window.getWidth(), window.getHeight());
    }

    public void test() {
        
    }
}
