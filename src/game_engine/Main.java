package game_engine;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	private final String TITLE = "JavaFX GameEngine";

	@Override
	public void start(Stage stage) throws Exception {
		GameEngine engine = new GameEngine(200, 150, 5) {
			@Override
			public void onCreate() {

			}

			@Override
			public void onUpdate() {

			}
		};

		stage.setResizable(false);
		stage.setTitle(TITLE);
		stage.setScene(engine.createScene());
		stage.sizeToScene();
		stage.show();

		engine.debug("tracker");
		engine.debug("static");
//		engine.debug("checker");
//		engine.debug("line");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
