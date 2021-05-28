package game_engine.renderer;

import game_engine.model.Point2D;
import game_engine.renderer.color.Pixel;
import game_engine.renderer.layers.LayerContext;
import game_engine.renderer.render_objects.RenderObject;
import game_engine.window.Window;
import javafx.scene.Group;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;

public class Renderer {

    private LayerContext layerContext;

    public Renderer(Window window) {
        this.layerContext = new LayerContext(window);
    }

    //////
    // DRAW METHODS
    public void drawPixel(Point2D pos, Pixel pixel) {
        drawPixel(pos.getX(), pos.getY(), pixel);
    }

    public void drawPixel(int x, int y, Pixel pixel) {
        int width = layerContext.getActiveLayerWidth();
        int height = layerContext.getActiveLayerHeight();
        if (x >= 0 && x < width &&
                y >= 0 && y < height) {
            byte[] pixelColor = pixel.getRGB();
            drawPixels(x,y,1,1,pixelColor);
        }
    }

    public void drawPixels(Point2D pos, int width, int height, Pixel[] pixels) {
        drawPixels(pos.getX(), pos.getY(), width, height, pixels);
    }

    public void drawPixels(int x, int y, int width, int height, Pixel[] pixels) {
        int layerWidth = layerContext.getActiveLayerWidth();
        int layerHeight = layerContext.getActiveLayerHeight();

        if ((x) < layerWidth && (y) < layerHeight) {
            int xOffset = 0;
            int yOffset = 0;
            int widthOffset = 0;
            int heightOffset = 0;

            if (x < 0) {
                xOffset = x * -1;
                widthOffset = xOffset;
                x = 0;
            } else if ((x + width) > layerWidth) {
                widthOffset = (x + width) - layerWidth;
            }
            if (y < 0) {
                yOffset = y * -1;
                heightOffset = yOffset;
                y = 0;
            } else if ((y + height) > layerHeight) {
                heightOffset = (y + height) - layerHeight;
            }

            int widthWithOffset = width - widthOffset;
            int heightWithOffset = height - heightOffset;

            // Correct ArrayOutOfBoundsException when circle is outside (left and right) and (up and down)
            if (widthWithOffset > layerWidth)
                widthWithOffset -= widthWithOffset - layerWidth;
            if (heightWithOffset > layerHeight)
                heightWithOffset -= heightWithOffset - layerHeight;

            int bufferWidth = widthWithOffset * 4;
            int bufferHeight = heightWithOffset;
            if (bufferWidth > 0 && bufferHeight > 0) {
                byte[] buffer = new byte[bufferWidth * bufferHeight];

                for (int iy = 0; iy < bufferHeight; iy++) {
                    for (int ix = 0; ix < bufferWidth; ix += 4) {
                        byte[] pixelColor = pixels[((ix / 4) + xOffset) + (iy + yOffset) * width].getRGB();
                        int i = ix + iy * bufferWidth;
                        buffer[i] = pixelColor[0];
                        buffer[i + 1] = pixelColor[1];
                        buffer[i + 2] = pixelColor[2];
                        buffer[i + 3] = pixelColor[3];
                    }
                }
                drawPixels(x, y, widthWithOffset, heightWithOffset, buffer);
            }
        }
    }

    public void drawBuffer(Point2D pos, int width, int height, byte[] buffer) {
        drawPixels(pos.getX(), pos.getY(), width, height, buffer);
    }

    public void drawBuffer(int x, int y, int width, int height, byte[] buffer) {
        drawPixels(x, y, width, height, buffer);
    }

    private void drawPixels(int x, int y, int width, int height, byte[] buffer) {
        PixelWriter pw = layerContext.getActiveLayerPixelWriter();
        try {
            pw.setPixels(x, y, width, height, PixelFormat.getByteBgraPreInstance(), buffer, 0, width * 4);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public void drawRenderObject(Point2D pos, RenderObject renderObject){
        drawRenderObject(pos.getX(), pos.getY(), renderObject);
    }

    public void drawRenderObject(int x, int y, RenderObject renderObject){
        drawPixels(x,y,renderObject.getWidth(),renderObject.getHeight(), renderObject.getPixels());
    }

    public void drawPartialRenderObject(Point2D pos, Point2D sPos, int width, int height, RenderObject renderObject){
        drawPartialRenderObject(pos.getX(), pos.getY(), sPos.getX(), sPos.getY(), width,height,renderObject);
    }

    public void drawPartialRenderObject(int x, int y, int sX, int sY, int width, int height, RenderObject renderObject){
        drawPixels(x, y, width, height, renderObject.getPartialPixels(sX, sY, width, height));
    }

    // TODO Line width

    public void drawLine(Point2D pos1, Point2D pos2, Pixel pixel) {
        drawLine(pos1.getX(), pos1.getY(), pos2.getX(), pos2.getY(), false, pixel);
    }

    public void drawLine(Point2D pos1, Point2D pos2, boolean thick, Pixel pixel) {
        drawLine(pos1.getX(), pos1.getY(), pos2.getX(), pos2.getY(), thick, pixel);
    }

    public void drawLine(int x1, int y1, int x2, int y2, Pixel pixel) {
        drawLine(x1, y1, x2, y2, false, pixel);
    }

    public void drawLine(int x1, int y1, int x2, int y2, boolean thick, Pixel pixel) {
        int dx = Math.abs(x2 - x1);
        int sx = x1 < x2 ? 1 : -1;
        int dy = -Math.abs(y2 - y1);
        int sy = y1 < y2 ? 1 : -1;
        int err = dx + dy;

        if (y1 == y2) {
            // Horizontal line
            int X0 = Math.min(x1, x2);
            int X1 = Math.max(x1, x2);
            for (int x = X0; x <= X1; x++) {
                drawPixel(x, y1, pixel);
            }
        } else if (x1 == x2) {
            // Vertical line
            int Y0 = Math.min(y1, y2);
            int Y1 = Math.max(y1, y2);
            for (int y = Y0; y <= Y1; y++) {
                drawPixel(x1, y, pixel);
            }
        } else {
            // Diagonal line
            drawPixel(x1, y1, pixel);
            while (true) {
                if (x1 == x2 && y1 == y2) break;
                int e2 = 2 * err;
                if (thick) {
                    // draw points between diagonals
                    if (e2 - dy > dx - e2) {
                        err += dy;
                        x1 += sx;
                    } else {
                        err += dx;
                        y1 += sy;
                    }
                } else {
                    // Skip points between diagonals
                    if (e2 >= dy) {
                        err += dy;
                        x1 += sx;
                    }
                    if (e2 <= dx) {
                        err += dx;
                        y1 += sy;
                    }
                }
                drawPixel(x1, y1, pixel);
            }
        }
    }

    public Group getScreen(){
        return layerContext.getScreen();
    }

    public LayerContext getLayerContext(){
        return layerContext;
    }

    public void clearActiveLayer(){
        drawPixels(0,0,
                getLayerContext().getActiveLayerWidth(),
                getLayerContext().getActiveLayerHeight(),
                layerContext.getActiveLayer().getBackgroundPixels());
    }

    public void clearLayer(String layerName){
        String activeLayer = layerContext.getActiveLayerName();
        layerContext.setActiveLayer(layerName);
        clearActiveLayer();
        layerContext.setActiveLayer(activeLayer);
    }

    public void clearLayers(){
        layerContext.getLayers().keySet().forEach(this::clearLayer);
    }
}
