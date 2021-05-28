package game_engine.examples;

import game_engine.GameEngine;
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
            public void onCreate() {
                System.out.println("Creates Circle Example");

                sprite = new Sprite("50x50.png",50,50);;
                spriteTransparent = new Sprite("50x50-transparent.png",50,50);
                spriteSheet = new Sprite("48x48-16x16-sprites-spritesheet.png",48,48);

                getRenderer().getLayerContext().setActiveLayerBackgroundColor(new Pixel(Color.YELLOW));
                getRenderer().clearActiveLayer();
                // Create new layer so background can show trough transparency
                getRenderer().getLayerContext().createLayer("sprites");
                getRenderer().getLayerContext().setActiveLayer("sprites");
                getRenderer().drawRenderObject(0,0,sprite);
                getRenderer().drawRenderObject(50,0,spriteTransparent);
                getRenderer().drawPartialRenderObject(100,0,16,32,16,16,spriteSheet);
            }

            @Override
            public void onGameTick(long now) {

            }

            @Override
            public void onFrameUpdate(long now) {

            }
        };
        gameEngine.start();
        gameEngine.setDebug(true);
    }
}
