package game_engine.examples;

import game_engine.GameEngine;
import game_engine.renderer.color.Pixel;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Random;

public class StaticExample extends Application {

    private final String TITLE = "Static Example";
    private int width = 512;
    private int height = 360;
    private GameEngine gameEngine;

    @Override
    public void start(Stage primaryStage) throws Exception {
        gameEngine = new GameEngine(TITLE, primaryStage, width, height, 2) {

            Random r;
            Pixel[] pixels;

            @Override
            public void onCreate() {
                System.out.println("Creates Static Example");

                r = new Random();
                pixels = new Pixel[width * height];
            }

            @Override
            public void onGameTick(long now) {
                for (int y = 0; y < height; y++)
                    for (int x = 0; x < width; x++)
                        pixels[x + y * width] = new Pixel(r.nextInt(256), r.nextInt(256), r.nextInt(256));
            }

            @Override
            public void onFrameUpdate(long now) {
                getRenderer().drawPixels(0, 0, width, height, pixels);
            }
        };
        gameEngine.start();
        gameEngine.setDebug(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
