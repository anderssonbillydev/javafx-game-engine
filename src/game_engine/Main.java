package game_engine;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	private final String TITLE = "JavaFX GameEngine";

	@Override
	public void start(Stage stage) throws Exception {
		GameEngine engine = new GameEngine(TITLE, stage, 400, 300, 3) {
			@Override
			public void onCreate() {

			}

			@Override
			public void onUpdate() {

			}
		};

		engine.debug("tracker");
		engine.debug("static");
//		engine.debug("checker");
//		engine.debug("line");
		engine.debug("sprite");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
