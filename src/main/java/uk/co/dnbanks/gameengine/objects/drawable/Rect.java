package uk.co.dnbanks.gameengine.objects.drawable;

import javafx.scene.paint.Color;
import uk.co.dnbanks.gameengine.utilities.Vector2D;

/**
 * Class that represents a rectangle that can be rendered on a scene/window.
 * @author Daniel Banks
 */
public class Rect extends Drawable {

    /**
     * Creates a rectangle that can be drawn to the scene.
     * @param name Name of the rectangle
     * @param size Size/dimensions of the rectangle
     * @param position Position of the rectangle
     * @param colour Javafx colour of the rectangle
     */
    public Rect(String name, Vector2D size, Vector2D position, Color colour) {
        super(size, colour);
        this.objectName = name;
        this.position = position;
    }


    /**
     * Updates the pixel buffer of the rect.
     */
    @Override
    protected void updatePixelBuffer() {
        if (!hasTexture) {
            for (int x = 0; x < pixelBuffer.length; x++) {
                for (int y = 0; y < pixelBuffer[0].length; y++) {
                    pixelBuffer[x][y] = colour;
                }
            }
        }
    }
}
