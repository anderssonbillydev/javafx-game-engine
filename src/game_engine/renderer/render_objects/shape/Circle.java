package game_engine.renderer.render_objects.shape;

import game_engine.renderer.color.Color;
import game_engine.renderer.color.Pixel;

import java.util.Arrays;

public class Circle extends Shape {

    private int radius, diameter;

    public Circle(int radius, Pixel linePixel) {
        super(radius * 2 + 1, radius * 2 + 1, linePixel);
        this.radius = radius;
        this.diameter = radius * 2 + 1;
    }

    public Circle(int radius, int lineWidth, Pixel linePixel) {
        super(radius * 2 + 1, radius * 2 + 1, lineWidth, linePixel);
        this.radius = radius;
        this.diameter = radius * 2 + 1;
    }

    public Circle(int radius, Pixel linePixel, Pixel fillPixel) {
        super(radius * 2 + 1, radius * 2 + 1, linePixel, fillPixel);
        this.radius = radius;
        this.diameter = radius * 2 + 1;
    }

    public Circle(int radius, int lineWidth, Pixel linePixel, Pixel fillPixel) {
        super(radius * 2 + 1, radius * 2 + 1, lineWidth, linePixel, fillPixel);
        this.radius = radius;
        this.diameter = radius * 2 + 1;
    }

    @Override
    protected void createObject() {
        setPixels(new Pixel[diameter * diameter]);
        Pixel transparent = new Pixel(Color.TRANSPARENT);
        Arrays.fill(getPixels(), transparent);

        int innerRadius = (radius - getLineWidth() + 1 < 1) ? 0 : radius - getLineWidth() + 1;

        int xo = radius;
        int xi = innerRadius;
        int y = 0;
        int erro = 1 - xo;
        int erri = 1 - xi;

        while (xo >= y) {
            // Bottom Right
            drawXLine(radius + xi, radius + xo, radius + y, getLinePixel());
            drawYLine(radius + y, radius + xi, radius + xo, getLinePixel());
            // Bottom Left
            drawXLine(radius - xo, radius - xi, radius + y, getLinePixel());
            drawYLine(radius - y, radius + xi, radius + xo, getLinePixel());
            // Top Left
            drawXLine(radius - xo, radius - xi, radius - y, getLinePixel());
            drawYLine(radius - y, radius - xo, radius - xi, getLinePixel());
            // Top Right
            drawXLine(radius + xi, radius + xo, radius - y, getLinePixel());
            drawYLine(radius + y, radius - xo, radius - xi, getLinePixel());

            y++;

            if (erro < 0) {
                erro += 2 * y + 1;
            } else {
                xo--;
                erro += 2 * (y - xo + 1);
            }
            if (y > innerRadius) {
                xi = y;
            } else {
                if (erri < 0) {
                    erri += 2 * y + 1;
                } else {
                    xi--;
                    erri += 2 * (y - xi + 1);
                }
            }
        }

        if (isFilled()) {
            innerRadius--;
            for (int fillY = -innerRadius; fillY <= innerRadius; fillY++)
                for (int fillX = -innerRadius; fillX <= innerRadius; fillX++)
                    if (fillX * fillX + fillY * fillY <= innerRadius * innerRadius + innerRadius + 1)
                        setPixel(radius + fillX, radius + fillY, getFillPixel());
        }
    }

    private void drawXLine(int x1, int x2, int y, Pixel linePixel) {
        while (x1 <= x2) setPixel(x1++, y, linePixel);
    }

    private void drawYLine(int x, int y1, int y2, Pixel linePixel) {
        while (y1 <= y2) setPixel(x, y1++, linePixel);
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius) {
        if (radius > 0) {
            this.radius = radius;
            setDiameter(radius);
            setWidth(diameter);
            setHeight(diameter);
            updateObject();
        }
    }

    private void setDiameter(int radius) {
        if (radius > 0) {
            this.diameter = radius * 2 + 1;
        }
    }
}
