package game_engine;

import com.sun.javafx.perf.PerformanceTracker;
import game_engine.handlers.InputHandler;
import game_engine.renderer.*;
import game_engine.window.Window;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
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
        onCreate(inputHandler,renderer);
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
                    onGameTick(inputHandler, renderer, now);
                    update = false;
                }
            }
        };
    }

    private AnimationTimer createFrameLoop() {
        return new AnimationTimer() {
            @Override
            public void handle(long now) {
                onFrameUpdate(inputHandler, renderer, now);
                if (debug)
                    debug();
            }
        };
    }

    // Runs when game engine starts
    public abstract void onCreate(InputHandler inputHandler, Renderer renderer);

    // Runs every gameTick, usually used for game logic
    public abstract void onGameTick(InputHandler inputHandler, Renderer renderer, long now);

    // Runs every frame, usually used for rendering
    public abstract void onFrameUpdate(InputHandler inputHandler, Renderer renderer, long now);

    public void start() {
        this.gameLoop.start();
        this.frameLoop.start();
    }

    public void stop() {
        this.gameLoop.stop();
        this.frameLoop.stop();
    }

    public Window getWindow() {
        return window;
    }

    public Pane getScreen() {
        return screen;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    private void debug() {
        stage.setTitle(title +
                " - FPS: " + String.format("%.2f", tracker.getAverageFPS()) +
                ", Pulses: " + String.format("%.2f", tracker.getAveragePulses()));
    }
}
