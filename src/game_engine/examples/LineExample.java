package game_engine.examples;

import game_engine.GameEngine;
import game_engine.renderer.color.Color;
import game_engine.renderer.color.Pixel;
import javafx.application.Application;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

public class LineExample extends Application {

    private final String TITLE = "Line Example";
    private int width = 512;
    private int height = 360;
    private GameEngine gameEngine;

    @Override
    public void start(Stage primaryStage) throws Exception {
        gameEngine = new GameEngine(TITLE, primaryStage, width, height, 2) {

            int x, y;
            boolean thick;
            Pixel linePixel;

            @Override
            public void onCreate() {
                System.out.println("Creates Line Example");

                x = 0;
                y = 0;
                thick = false;
                linePixel = new Pixel(Color.BLACK);
            }

            @Override
            public void onGameTick(long now) {
                if (getInputHandler().isMouseButtonPressed(MouseButton.PRIMARY)) {
                    x = getInputHandler().getMouseX();
                    y = getInputHandler().getMouseY();
                }
                if (getInputHandler().isScrollingUp())
                    thick = true;
                if (getInputHandler().isScrollingDown())
                    thick = false;
            }

            @Override
            public void onFrameUpdate(long now) {
                getRenderer().clear();
                getRenderer().drawLine(x, y,
                        getInputHandler().getMouseX(), getInputHandler().getMouseY(),
                        thick,
                        linePixel);
            }
        };

        gameEngine.start();
        gameEngine.setDebug(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
