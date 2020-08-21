package game_engine;

import com.sun.javafx.perf.PerformanceTracker;
import game_engine.handler.InputHandler;
import game_engine.render.Color;
import game_engine.render.Layer;
import game_engine.render.Pixel;
import game_engine.render.Renderer;
import game_engine.window.Window;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;

import java.util.Random;

public abstract class GameEngine {

    private Window window;
    private Pane screne;
    private Scene scene;
    private Renderer renderer;
    private InputHandler inputHandler;

    public GameEngine(int width, int height) {
        this(width, height, 1);
    }

    public GameEngine(int width, int height, int pixelSize) {
        this.window = new Window(width, height, pixelSize);
        this.renderer = new Renderer(this.window);
        this.inputHandler = new InputHandler();
    }

    public Scene createScene() {
        screne = new Pane();
        screne.getChildren().add(renderer.getScreen());
        screne.setOnKeyPressed(key -> inputHandler.addKey(key.getCode()));
        screne.setOnKeyReleased(key -> inputHandler.removeKey(key.getCode()));
        screne.setOnMouseMoved(mouse -> {
            inputHandler.setMouseX((int) mouse.getX());
            inputHandler.setMouseY((int) mouse.getY());
        });
        screne.setOnMousePressed(mouse -> inputHandler.addMouseButton(mouse.getButton()));
        screne.setOnMouseReleased(mouse -> inputHandler.removeMouseButton(mouse.getButton()));
        scene = new Scene(screne, window.getScreenWidth(), window.getScreenHeight());
        return scene;
    }

    public abstract void onCreate();

    public abstract void onUpdate();

    public Renderer getRenderer() {
        return renderer;
    }

    public Window getWindow() {
        return window;
    }

    public Pane getScrene() {
        return screne;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public void debug(String type) {
        PerformanceTracker tracker = PerformanceTracker.getSceneTracker(scene);
        AnimationTimer testLoop;

        switch (type) {
            case "tracker":
                Label debugLabel = new Label();
                debugLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 25px; -fx-text-fill:white;");
                screne.getChildren().add(debugLabel);
                testLoop = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        debugLabel.setText("FPS: " + tracker.getAverageFPS() + "\n");
                    }
                };
                testLoop.start();
                break;
            case "checker":
                Layer checkerLayer = new Layer(window.getScreenWidth(), window.getScreenHeight());
                renderer.addLayer("checker", checkerLayer);
                testLoop = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        renderer.setActiveLayer("checker");
                        int width = window.getWidth();
                        int height = window.getHeight();
                        Pixel p1 = new Pixel(Color.WHITE);
                        Pixel p2 = new Pixel(Color.BLACK);
                        Pixel[] pixels = new Pixel[width * height];
                        for(int y=0;y<height;y++){
                            for(int x=0;x<width;x++){
                                if((y+x)%2 == 0)
                                    pixels[x+y*width] = p1;
                                else
                                    pixels[x+y*width] = p2;
                            }
                        }
                        pixels[pixels.length-1] = new Pixel(Color.RED);
                        pixels[width-1] = new Pixel(Color.RED);
                        renderer.drawPixels(0, 0, width, height, pixels);
                    }
                };
                testLoop.start();
                break;
            case "static":
                Random r = new Random();
                Layer staticLayer = new Layer(window.getScreenWidth(), window.getScreenHeight());
                renderer.addLayer("static", staticLayer);
                testLoop = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        renderer.setActiveLayer("static");
                        int width = window.getWidth();
                        int height = window.getHeight();
                        Pixel[] pixels = new Pixel[width * height];
                        for (int i = 0; i < pixels.length; i++) {
                            pixels[i] = new Pixel(r.nextInt(256), r.nextInt(256), r.nextInt(256), 255);
                        }
                        renderer.drawPixels(0, 0, width, height, pixels);
                    }
                };
                testLoop.start();
                break;
            case "line":
                Layer lineLayer = new Layer(window.getScreenWidth(), window.getScreenHeight());
                renderer.addLayer("line", lineLayer);
                testLoop = new AnimationTimer() {
                    int x = window.getWidth() / 2;
                    int y = window.getHeight() / 2;
                    int mouseX, mouseY;
                    int oldMouseX = 0;
                    int oldMouseY = 0;
                    boolean thick = true;

                    @Override
                    public void handle(long now) {
                        renderer.setActiveLayer("line");

                        mouseX = inputHandler.getMouseX();
                        mouseY = inputHandler.getMouseY();
                        if (inputHandler.isMouseButtonPressed(MouseButton.PRIMARY)) {
                            x = mouseX / window.getPixelSize();
                            y = mouseY / window.getPixelSize();
                        }
                        if (inputHandler.isMouseButtonPressed(MouseButton.SECONDARY)) {
                            thick = !thick;
                        }

                        if (mouseX != oldMouseX || mouseY != oldMouseY) {
                            renderer.clear();
                            renderer.drawLine(
                                    x,
                                    y,
                                    mouseX / window.getPixelSize(),
                                    mouseY / window.getPixelSize(),
                                    thick,
                                    new Pixel(0, 0, 255));
                            oldMouseX = mouseX;
                            oldMouseY = mouseY;
                        }
                    }
                };
                testLoop.start();
                break;
        }
    }

    public void test() {
    }
}
