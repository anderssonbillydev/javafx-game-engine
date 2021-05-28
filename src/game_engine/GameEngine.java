package game_engine;

import com.sun.javafx.perf.PerformanceTracker;
import game_engine.handlers.InputHandler;
import game_engine.renderer.*;
import game_engine.renderer.color.Color;
import game_engine.renderer.color.Pixel;
import game_engine.renderer.render_objects.sprite.Sprite;
import game_engine.renderer.render_objects.shape.Square;
import game_engine.window.Window;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class GameEngine {

    private final long DELTA_TIME = 16_500_000; // 16.5ms in ns 1/60 fps

    private String title;
    private Stage stage;
    private Window window;
    private Pane screen;
    private Scene scene;
    private Renderer renderer;
    private InputHandler inputHandler;
    private AnimationTimer gameLoop, frameLoop;

    private boolean debug;
    private PerformanceTracker tracker;

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
        this.frameLoop = createFrameLoop();
        this.debug = false;
        this.tracker = PerformanceTracker.getSceneTracker(scene);
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
        screen = new Pane();
        screen.getChildren().add(renderer.getScreen());

        scene = new Scene(screen, window.getScreenWidth(), window.getScreenHeight());
        scene.setOnKeyPressed(key -> inputHandler.addKey(key.getCode()));
        scene.setOnKeyReleased(key -> inputHandler.removeKey(key.getCode()));
        scene.setOnMouseMoved(mouse -> {
            inputHandler.setMouseX((int) mouse.getX() / window.getPixelSize());
            inputHandler.setMouseY((int) mouse.getY() / window.getPixelSize());
        });
        scene.setOnMousePressed(mouse -> inputHandler.addMouseButton(mouse.getButton()));
        scene.setOnMouseReleased(mouse -> inputHandler.removeMouseButton(mouse.getButton()));

        scene.setOnScroll(scroll -> {
            if (scroll.getDeltaY() > 0)
                inputHandler.setScrollUp(true);
            else
                inputHandler.setScrollDown(true);
        });

        return scene;
    }

    private AnimationTimer createGameLoop() {
        return new AnimationTimer() {
            private long lastUpdate = 0;
            private boolean fullSpeed = Boolean.parseBoolean(System.getProperty("javafx.animation.fullspeed"));
            private boolean update = false;

            @Override
            public void handle(long now) {
                if (fullSpeed) {
                    if (now - lastUpdate >= DELTA_TIME) {
                        lastUpdate = now;
                        update = true;
                    }
                } else
                    update = true;


                if (update) {
                    onGameTick(now);
                    update = false;
                }
            }
        };
    }

    private AnimationTimer createFrameLoop() {
        return new AnimationTimer() {
            @Override
            public void handle(long now) {
                onFrameUpdate(now);
                if (debug)
                    debug();
            }
        };
    }

    // Runs when game engine starts
    public abstract void onCreate();

    // Runs every gameTick, usually used for game logic
    public abstract void onGameTick(long now);

    // Runs every frame, usually used for rendering
    public abstract void onFrameUpdate(long now);

    public void start() {
        this.gameLoop.start();
        this.frameLoop.start();
    }

    public void stop() {
        this.gameLoop.stop();
        this.frameLoop.stop();
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public Window getWindow() {
        return window;
    }

    public Pane getScreen() {
        return screen;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    private void debug() {
        stage.setTitle(title +
                " - FPS: " + String.format("%.2f", tracker.getAverageFPS()) +
                ", Pulses: " + String.format("%.2f", tracker.getAveragePulses()));
    }

    // TODO move to example classes
    public void debug(String type) {
        PerformanceTracker tracker = PerformanceTracker.getSceneTracker(scene);
        AnimationTimer testLoop;

        switch (type) {
            case "sprite":
                renderer.getLayerContext().createLayer("sprite");

//                Sprite sprite = new Sprite(getClass().getClassLoader().getResource("50x50-transparent.png").getPath(), 50, 50);
                Sprite sprite = new Sprite("48x48-16x16-sprites-spritesheet.png", 48, 48);
//                Sprite sprite1 = new Sprite(getClass().getClassLoader().getResource("50x50-transparent.png").getPath(), 50, 50);
//                sprite.setPartialPixels(16,16,16,16,sprite1.getPartialPixels(0,0,16,16));

                testLoop = new AnimationTimer() {
                    int x = 0;
                    int y = 0;

                    int oldX = -1;
                    int oldY = -1;


                    @Override
                    public void handle(long now) {
                        renderer.getLayerContext().setActiveLayer("sprite");

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
//                            renderer.drawRenderObject(x, y, sprite);
                            renderer.drawPartialRenderObject(x, y, 16, 16, 16, 16, sprite);
                        }
                    }
                };
                testLoop.start();
                break;
            case "shape":
                renderer.getLayerContext().createLayer("shape");

                Square shape = new Square(10, 2, new Pixel(Color.RED), new Pixel(Color.BLUE));
//                Shape shape = new Rectangle(5, 25, new Pixel(Color.RED),new Pixel(Color.BLUE));
                testLoop = new AnimationTimer() {
                    int x = 0;
                    int y = 0;

                    int oldX = -1;
                    int oldY = -1;


                    @Override
                    public void handle(long now) {
                        renderer.getLayerContext().setActiveLayer("shape");

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
                            renderer.drawRenderObject(x, y, shape);
                        }
                    }
                };
                testLoop.start();
                break;
        }
    }
}
