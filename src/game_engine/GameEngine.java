package game_engine;

import game_engine.handler.InputHandler;
import game_engine.model.Point2D;
import game_engine.render.Layer;
import game_engine.render.Pixel;
import game_engine.render.Renderer;
import game_engine.window.Window;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class GameEngine {

	private Window window;
	private Pane screen;
	private Renderer renderer;
	private InputHandler inputHandler;

	public GameEngine(int width, int height) {
		this(width, height, 1);
	}

	public GameEngine(int width, int height, int pixelSize) {
		this.window = new Window(width, height, pixelSize);
		this.renderer = new Renderer(this.window);
		this.inputHandler = new InputHandler();
	}

	public Scene createScene() {
		screen = new Pane();
		screen.getChildren().add(renderer.getScreen());
		screen.setOnKeyPressed(key -> inputHandler.addKey(key.getCode()));
		screen.setOnKeyReleased(key -> inputHandler.removeKey(key.getCode()));
		screen.setOnMouseMoved(mouse -> {
			inputHandler.setMouseX((int) mouse.getX());
			inputHandler.setMouseY((int) mouse.getY());
		});
		screen.setOnMousePressed(mouse -> inputHandler.addMouseButton(mouse.getButton()));
		screen.setOnMouseReleased(mouse -> inputHandler.removeMouseButton(mouse.getButton()));
		return new Scene(screen, window.getWidth(), window.getHeight());
	}

	public Renderer getRenderer() {
		return renderer;
	}

	public void test() {

	}
}
