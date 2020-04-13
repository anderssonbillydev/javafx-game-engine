package game_engine.render.shapes;

import game_engine.model.Point2D;
import javafx.scene.paint.Color;

public class Pixel {

    private Point2D position;
    private Color color;

    public Pixel(Point2D position, Color color) {
        this.position = position;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setX(int x) {
        position.setX(x);
    }

    public int getX() {
        return position.getX();
    }

    public void setY(int y) {
        position.setY(y);
    }

    public int getY() {
        return position.getY();
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }
}
