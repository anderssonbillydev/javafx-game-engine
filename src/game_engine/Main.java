package game_engine;

import game_engine.handlers.InputHandler;
import game_engine.renderer.Renderer;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private final String TITLE = "JavaFX GameEngine";
    private int width = 512;
    private int height = 360;
    private GameEngine gameEngine;

    @Override
    public void start(Stage primaryStage) throws Exception {
        gameEngine = new GameEngine(TITLE, primaryStage, width, height, 2) {
            @Override
            public void onCreate(InputHandler inputHandler, Renderer renderer) {
//                System.out.println("This runs when engine is created");
            }

            @Override
            public void onGameTick(InputHandler inputHandler, Renderer renderer, long now) {
//                System.out.println("This runs on each game tick, 1/60 fps");
            }

            @Override
            public void onFrameUpdate(InputHandler inputHandler, Renderer renderer, long now) {
//                System.out.println("This runs as fast as possible, usually capped at 60fps");
            }
        };

        gameEngine.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
