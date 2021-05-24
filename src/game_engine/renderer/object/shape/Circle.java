package game_engine.renderer.object.shape;

import game_engine.renderer.Color;
import game_engine.renderer.object.Pixel;

import java.util.Arrays;

public class Circle extends Shape {

    private int radius, diameter;
    private Pixel pixel;

    public Circle(int radius, Pixel pixel){
        this(radius,radius*2+1,pixel);
    }

    private Circle(int radius, int diameter, Pixel pixel) {
        super(diameter, diameter);
        this.radius = radius;
        this.diameter = diameter;
        this.pixel = pixel;
    }

    @Override
    protected Pixel[] createShape() {
        Pixel[] pixels = new Pixel[diameter * diameter];
        Pixel transparent = new Pixel(Color.TRANSPARENT);
        Arrays.fill(pixels, transparent);

        int p0 = (1) - radius;
        int x1 = 0;
        int y1 = radius;
        while (x1 <= y1) {
            // Bottom Right
            pixels[(x1 + radius) + (y1 + radius) * diameter] = pixel;
            pixels[(y1 + radius) + (x1 + radius) * diameter] = pixel;
            // Bottom Left
            pixels[(-x1 + radius) + (y1 + radius) * diameter] = pixel;
            pixels[(-y1 + radius) + (x1 + radius) * diameter] = pixel;
            // Top Left
            pixels[(-x1 + radius) + (-y1 + radius) * diameter] = pixel;
            pixels[(-y1 + radius) + (-x1 + radius) * diameter] = pixel;
            // Top Right
            pixels[(x1 + radius) + (-y1 + radius) * diameter] = pixel;
            pixels[(y1 + radius) + (-x1 + radius) * diameter] = pixel;
            x1++;
            if (p0 <= 0) {
                p0 += 1 + (2 * x1);
            } else {
                // If y1-- is moved outside if else a diamond is drawn
                y1--;
                p0 += 1 + (2 * x1) - (2 * y1);
            }
        }

        return pixels;
    }

    public int getRadius(){
        return this.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        setDiameter(radius);
        setWidth(diameter);
        setHeight(diameter);
        updateShape();
    }

    private void setDiameter(int radius){
        this.diameter = radius * 2 + 1;
    }
}
