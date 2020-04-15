package game_engine;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private final String TITLE = "JavaFX GameEngine";

    @Override
    public void start(Stage primaryStage) throws Exception{
        GameEngine engine = new GameEngine(400,300,2);

        primaryStage.setTitle(TITLE);
        primaryStage.setScene(engine.createScene());
        primaryStage.show();

        engine.test();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
