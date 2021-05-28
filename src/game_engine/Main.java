package game_engine;

import game_engine.renderer.color.Color;
import game_engine.renderer.color.Pixel;
import game_engine.renderer.render_objects.shape.Square;
import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Main extends Application {

    private final String TITLE = "JavaFX GameEngine";

    @Override
    public void start(Stage stage) throws Exception {
        GameEngine engine = new GameEngine(TITLE, stage, 200, 200, 4) {

            int oldX, oldY, x, y;
            Square square;

            @Override
            public void onCreate() {
//                System.out.println("This runs when engine is created");
                square = new Square(20, 2, new Pixel(Color.BLACK), new Pixel(Color.YELLOW));
                oldX = 0;
                oldY = 0;
                x = 0;
                y = 0;
                getRenderer().drawRenderObject(x, y, square);
            }

            @Override
            public void onGameTick(long now) {
//                System.out.println("This runs on each engine tick");
                if(getInputHandler().isKeyPressed(KeyCode.RIGHT))
                    x++;
                if(getInputHandler().isKeyPressed(KeyCode.LEFT))
                    x--;
                if(getInputHandler().isKeyPressed(KeyCode.DOWN))
                    y++;
                if(getInputHandler().isKeyPressed(KeyCode.UP))
                    y--;
            }

            @Override
            public void onFrameUpdate(long now) {
//                System.out.println("This runs as fast as possible");
                if (oldX != x || oldY != y) {
                    oldX = x;
                    oldY = y;
                    getRenderer().clear();
                    getRenderer().drawRenderObject(x, y, square);
                }
            }
        };


        engine.debug("tracker");
//        engine.debug("static");
//        engine.debug("checker");
//        engine.debug("line");
//        engine.debug("circle");
//        engine.debug("sprite");
//        engine.debug("shape");

        engine.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
