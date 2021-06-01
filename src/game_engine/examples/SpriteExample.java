package game_engine.examples;

import game_engine.GameEngine;
import game_engine.handlers.InputHandler;
import game_engine.renderer.Renderer;
import game_engine.renderer.color.Color;
import game_engine.renderer.color.Pixel;
import game_engine.renderer.render_objects.sprite.Sprite;
import javafx.application.Application;
import javafx.stage.Stage;

public class SpriteExample extends Application {

    private final String TITLE = "Sprite Example";
    private int width = 512;
    private int height = 360;
    private GameEngine gameEngine;

    @Override
    public void start(Stage primaryStage) throws Exception {
        gameEngine = new GameEngine(TITLE, primaryStage, width, height, 2) {

            Sprite sprite, spriteTransparent, spriteSheet;

            @Override
            public void onCreate(InputHandler inputHandler, Renderer renderer) {
                System.out.println("Creates Circle Example");

                sprite = new Sprite("50x50.png",50,50);;
                spriteTransparent = new Sprite("50x50-transparent.png",50,50);
                spriteSheet = new Sprite("48x48-16x16-sprites-spritesheet.png",48,48);

                renderer.getLayerContext().setActiveLayerBackgroundColor(new Pixel(Color.YELLOW));
                renderer.clearActiveLayer();
                // Create new layer so background can show trough transparency
                renderer.getLayerContext().createLayer("sprites");
                renderer.getLayerContext().setActiveLayer("sprites");
                renderer.drawObject(0,0,sprite);
                renderer.drawObject(50,0,spriteTransparent);
                renderer.drawPartialObject(100,0,16,32,16,16,spriteSheet);
            }

            @Override
            public void onGameTick(InputHandler inputHandler, Renderer renderer, long now) {

            }

            @Override
            public void onFrameUpdate(InputHandler inputHandler, Renderer renderer, long now) {

            }
        };
        gameEngine.start();
        gameEngine.setDebug(true);
    }
}
