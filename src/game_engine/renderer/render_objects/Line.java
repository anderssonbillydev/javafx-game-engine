package game_engine.renderer.render_objects;

import game_engine.renderer.color.Color;
import game_engine.renderer.color.Pixel;
import game_engine.renderer.render_objects.shape.Circle;

import java.util.Arrays;

public class Line extends RenderObject{

    private int x1, y1, x2, y2, lineWidth;
    private Pixel linePixel;

    public Line(int x1, int y1, int x2, int y2, int lineWidth, Pixel linePixel){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.lineWidth = lineWidth;
        this.linePixel = linePixel;

        setWidth(((x1 > x2) ? (x1 - x2 > 0) ? x1 - x2 : 1 : (x2 - x1 > 0) ? x2 - x1 : 1) + lineWidth);
        setHeight(((y1 > y2) ? (y1 - y2 > 0) ? y1 - y2 : 1 : (y2 - y1 > 0) ? y2 - y1 : 1) + lineWidth);
    }

    @Override
    protected void createObject() {
        setPixels(new Pixel[(getWidth() + lineWidth + 1) * (getHeight() + lineWidth + 1)]);
        Arrays.fill(getPixels(), new Pixel(Color.RED));
        lineWidth = lineWidth / 2;
        Circle circle = new Circle(lineWidth, linePixel, linePixel);

        if (x1 > x2) {
            x1 = getWidth() - lineWidth - 1;
            x2 = 0;
        } else {
            x1 = 0;
            x2 = getWidth() - lineWidth - 1;
        }

        if (y1 > y2) {
            y1 = getHeight() - lineWidth - 1;
            y2 = 0;
        } else {
            y1 = 0;
            y2 = getHeight() - lineWidth - 1;
        }

        int d = 0;

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int dx2 = 2 * dx;
        int dy2 = 2 * dy;

        int ix = x1 < x2 ? 1 : -1;
        int iy = y1 < y2 ? 1 : -1;

        int x = x1;
        int y = y1;

        if (dx >= dy) {
            while (true) {
                drawThickLineCircle(x, y, circle);
                if (x == x2)
                    break;
                x += ix;
                d += dy2;
                if (d > dx) {
                    y += iy;
                    d -= dx2;
                }
            }
        } else {
            while (true) {
                drawThickLineCircle(x, y, circle);
                if (y == y2)
                    break;
                y += iy;
                d += dx2;
                if (d > dy) {
                    x += ix;
                    d -= dy2;
                }
            }
        }
    }

    private void drawThickLineCircle(int x, int y, Circle circle) {
        for (int cy = 0; cy < circle.getHeight(); cy++) {
            for (int cx = 0; cx < circle.getWidth(); cx++) {
                Pixel p = circle.getPixel(cx, cy);
                if (p.getAlpha() > 0)
                    setPixel((x + cx), (y + cy),circle.getPixel(cx, cy));
            }
        }
    }
}
