package game_engine.examples;

import game_engine.GameEngine;
import game_engine.handlers.InputHandler;
import game_engine.renderer.Renderer;
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

            int x, y, lineWidth;
            boolean thick;
            Pixel linePixel;

            @Override
            public void onCreate(InputHandler inputHandler, Renderer renderer) {
                System.out.println("Creates Line Example");

                x = 0;
                y = 0;
                lineWidth = 1;
                thick = false;
                linePixel = new Pixel(Color.BLACK);
            }

            @Override
            public void onGameTick(InputHandler inputHandler, Renderer renderer, long now) {
                if (inputHandler.isMouseButtonPressed(MouseButton.PRIMARY)) {
                    x = inputHandler.getMouseX();
                    y = inputHandler.getMouseY();
                }
                if (inputHandler.isScrollingUp()) {
                    lineWidth++;
//                    thick = true;
                }
                if (inputHandler.isScrollingDown()) {
                    lineWidth = (lineWidth > 1) ? lineWidth - 1 : 1;
//                    thick = false;
                }
            }

            @Override
            public void onFrameUpdate(InputHandler inputHandler, Renderer renderer, long now) {
                renderer.clearActiveLayer();
//                getRenderer().drawLine(x, y,
//                        getInputHandler().getMouseX(), getInputHandler().getMouseY(),
//                        thick,
//                        linePixel);
                renderer.drawLine(x, y, inputHandler.getMouseX(), inputHandler.getMouseY(), lineWidth, linePixel);
            }
        };

        gameEngine.start();
        gameEngine.setDebug(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}