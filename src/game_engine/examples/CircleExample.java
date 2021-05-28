package game_engine.examples;

import game_engine.GameEngine;
import game_engine.renderer.color.Color;
import game_engine.renderer.color.Pixel;
import game_engine.renderer.render_objects.shape.Circle;
import javafx.application.Application;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;


public class CircleExample extends Application {

    private final String TITLE = "Circle Example";
    private int width = 512;
    private int height = 360;
    private GameEngine gameEngine;

    @Override
    public void start(Stage primaryStage) throws Exception {
        gameEngine = new GameEngine(TITLE, primaryStage, width, height, 2) {

            Circle circle;
            int radius, lineWidth;
            Pixel linePixel, fillPixel;

            @Override
            public void onCreate() {
                System.out.println("Creates Circle Example");

                radius = 10;
                lineWidth = 1;
                linePixel = new Pixel(Color.BLACK);
                fillPixel = new Pixel(Color.YELLOW);
                circle = new Circle(radius, lineWidth, linePixel, fillPixel);
            }

            @Override
            public void onGameTick(long now) {
                if (getInputHandler().isMouseButtonPressed(MouseButton.PRIMARY))
                    circle.setRadius(circle.getRadius() + 1);
                if (getInputHandler().isMouseButtonPressed(MouseButton.SECONDARY))
                    circle.setRadius(circle.getRadius() - 1);
                if (getInputHandler().isScrollingUp())
                    circle.setLineWidth(circle.getLineWidth() + 1);
                if (getInputHandler().isScrollingDown())
                    circle.setLineWidth(circle.getLineWidth() - 1);
            }

            @Override
            public void onFrameUpdate(long now) {
                getRenderer().clearActiveLayer();
                getRenderer().drawRenderObject(
                        getInputHandler().getMouseX() - circle.getRadius(),
                        getInputHandler().getMouseY() - circle.getRadius(),
                        circle);
            }
        };
        gameEngine.start();
        gameEngine.setDebug(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
