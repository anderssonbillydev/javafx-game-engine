package game_engine;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private final String TITLE = "JavaFX GameEngine";

    @Override
    public void start(Stage stage) throws Exception {
        GameEngine engine = new GameEngine(TITLE, stage, 200, 200, 4) {
            @Override
            public void onCreate() {
                System.out.println("This runs when engine is created");
            }

            @Override
            public void onUpdate(long now) {
//                System.out.println("This runs on each engine tick");
            }
        };



        engine.debug("tracker");
//		engine.debug("static");
//		engine.debug("checker");
//		engine.debug("line");
        engine.debug("circle");
//		engine.debug("sprite");
//      engine.debug("shape");

        engine.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
