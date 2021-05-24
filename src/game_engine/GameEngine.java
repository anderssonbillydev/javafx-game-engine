package game_engine;

import com.sun.javafx.perf.PerformanceTracker;
import game_engine.handler.InputHandler;
import game_engine.renderer.*;
import game_engine.renderer.object.Pixel;
import game_engine.renderer.object.sprite.Sprite;
import game_engine.renderer.object.shape.Circle;
import game_engine.renderer.object.shape.Rectangle;
import game_engine.renderer.object.shape.Shape;
import game_engine.renderer.object.shape.Square;
import game_engine.window.Window;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;

public abstract class GameEngine {

    private String title;
    private Stage stage;
    private Window window;
    private Pane screne;
    private Scene scene;
    private Renderer renderer;
    private InputHandler inputHandler;
    private AnimationTimer gameLoop;

    public GameEngine(String title, Stage stage, int width, int height) {
        this(title, stage, width, height, 1);
    }

    public GameEngine(String title, Stage stage, int width, int height, int pixelSize) {
        this.title = title;
        this.stage = stage;
        this.window = new Window(width, height, pixelSize);
        this.renderer = new Renderer(this.window);
        this.inputHandler = new InputHandler();
        setupStage();
        this.gameLoop = createGameLoop();
    }

    private void setupStage() {
        stage.setResizable(false);
        stage.setTitle(this.title);
        stage.setScene(createScene());
        stage.sizeToScene();
        stage.show();
        onCreate();
    }

    private Scene createScene() {
        screne = new Pane();
        screne.getChildren().add(renderer.getScreen());

        scene = new Scene(screne, window.getScreenWidth(), window.getScreenHeight());
        scene.setOnKeyPressed(key -> inputHandler.addKey(key.getCode()));
        scene.setOnKeyReleased(key -> inputHandler.removeKey(key.getCode()));
        scene.setOnMouseMoved(mouse -> {
            inputHandler.setMouseX((int) mouse.getX());
            inputHandler.setMouseY((int) mouse.getY());
        });
        scene.setOnMousePressed(mouse -> inputHandler.addMouseButton(mouse.getButton()));
        scene.setOnMouseReleased(mouse -> inputHandler.removeMouseButton(mouse.getButton()));
        return scene;
    }

    private AnimationTimer createGameLoop() {
        return new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate(now);
            }
        };
    }

    public abstract void onCreate();

    public abstract void onUpdate(long now);

    private void gameLoop() {

    }

    public void start() {
        this.gameLoop.start();
    }

    public void stop() {
        this.gameLoop.stop();
    }

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
                renderer.createLayer("checker");
                testLoop = new AnimationTimer() {

                    @Override
                    public void handle(long now) {
                        renderer.setActiveLayer("checker");
                        int width = window.getWidth();
                        int height = window.getHeight();
                        Pixel p1 = new Pixel(Color.WHITE);
                        Pixel p2 = new Pixel(Color.BLACK);
                        Pixel[] pixels = new Pixel[width * height];
                        for (int y = 0; y < height; y++) {
                            for (int x = 0; x < width; x++) {
                                if ((y + x) % 2 == 0)
                                    pixels[x + y * width] = p1;
                                else
                                    pixels[x + y * width] = p2;
                            }
                        }
                        pixels[pixels.length - 1] = new Pixel(Color.RED);
                        pixels[width - 1] = new Pixel(Color.RED);
                        renderer.drawPixels(0, 0, width, height, pixels);
                    }
                };
                testLoop.start();
                break;
            case "static":
                Random r = new Random();
                renderer.createLayer("static");
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
                renderer.createLayer("line");
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
                                    new Pixel(Color.AQUA));
                            oldMouseX = mouseX;
                            oldMouseY = mouseY;
                        }
                    }
                };
                testLoop.start();
                break;
            case "circle":
                renderer.createLayer("circle");
                testLoop = new AnimationTimer() {
                    int x = 0;
                    int y = 0;
                    int r = 5;

                    Circle circle = new Circle(r,new Pixel(Color.AMETHYST));

                    long old = System.nanoTime();

                    @Override
                    public void handle(long now) {
                        renderer.clear();
//                        renderer.drawCircle(x, y, r, new Pixel(Color.DARK_BLUE));
                        renderer.drawShape(x,y,circle);
                        if (now - old >= 50000000) {
                            old = now;

                            if (getInputHandler().isKeyPressed(KeyCode.LEFT)) {
                                x--;
                            }
                            if (getInputHandler().isKeyPressed(KeyCode.RIGHT)) {
                                x++;
                            }
                            if (getInputHandler().isKeyPressed(KeyCode.UP)) {
                                y--;
                            }
                            if (getInputHandler().isKeyPressed(KeyCode.DOWN)) {
                                y++;
                            }
                            if (getInputHandler().isKeyPressed(KeyCode.ADD)) {
//                                r++;
                                circle.setRadius(circle.getRadius()+1);
                            }
                            if (getInputHandler().isKeyPressed(KeyCode.SUBTRACT)) {
                                if (circle.getRadius() > 0)
                                    circle.setRadius(circle.getRadius() - 1);
                            }
                        }
                    }
                };
                testLoop.start();
                break;
            case "sprite":
                renderer.createLayer("sprite");

                Sprite sprite = new Sprite("C:\\Users\\billy.andersson\\Pictures\\stop.png", 256, 256);
                testLoop = new AnimationTimer() {
                    int x = 0;
                    int y = 0;

                    int oldX = -1;
                    int oldY = -1;


                    @Override
                    public void handle(long now) {
                        renderer.setActiveLayer("sprite");

                        if (inputHandler.isKeyPressed(KeyCode.LEFT)) {
                            x--;
                        }
                        if (inputHandler.isKeyPressed(KeyCode.RIGHT)) {
                            x++;
                        }
                        if (inputHandler.isKeyPressed(KeyCode.UP)) {
                            y--;
                        }
                        if (inputHandler.isKeyPressed(KeyCode.DOWN)) {
                            y++;
                        }

                        if (oldX != x || oldY != y) {
                            oldX = x;
                            oldY = y;
                            renderer.clear();
                            renderer.drawSprite(x, y, sprite);
                        }
                    }
                };
                testLoop.start();
                break;
            case "shape":
                renderer.createLayer("shape");

                Shape square = new Square(10, new Pixel(Color.RED));
                Shape rectangle = new Rectangle(5, 25, new Pixel(Color.RED));
                testLoop = new AnimationTimer() {
                    int x = 0;
                    int y = 0;

                    int oldX = -1;
                    int oldY = -1;


                    @Override
                    public void handle(long now) {
                        renderer.setActiveLayer("shape");

                        if (inputHandler.isKeyPressed(KeyCode.LEFT)) {
                            x--;
                        }
                        if (inputHandler.isKeyPressed(KeyCode.RIGHT)) {
                            x++;
                        }
                        if (inputHandler.isKeyPressed(KeyCode.UP)) {
                            y--;
                        }
                        if (inputHandler.isKeyPressed(KeyCode.DOWN)) {
                            y++;
                        }

                        if (oldX != x || oldY != y) {
                            oldX = x;
                            oldY = y;
                            renderer.clear();
                            renderer.drawShape(x, y, square);
                        }
                    }
                };
                testLoop.start();
                break;
        }
    }
}
