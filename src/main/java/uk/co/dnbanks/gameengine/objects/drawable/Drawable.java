package uk.co.dnbanks.gameengine.objects.drawable;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import uk.co.dnbanks.gameengine.objects.Object;
import uk.co.dnbanks.gameengine.utilities.Vector2D;

/**
 * Class to represent an object that can be rendered through the camera,
 * The object can have a colour or a texture,
 * If the object is set a texture then the camera will render the texture not the colour
 * @author Daniel Banks
 */
public abstract class Drawable extends Object {

    /** Size of the Object */
    protected Vector2D size;

    /** Colour of the Object. */
    protected Color colour;

    /** Image/texture of the object. */
    protected Image texture;

    /** If the image has a texture. */
    protected boolean hasTexture;

    protected final Color[][] pixelBuffer;

    Drawable(Vector2D size, Color color) {
        this.size = size;
        this.colour = color;
        pixelBuffer = new Color[size.x][size.y];
        updatePixelBuffer();
    }

    /**
     * Gets the size of the object.
     * @return size of the object
     */
    public Vector2D getSize() {
        return size;
    }

    /**
     * Sets the size of the object
     * @param size new size of the object
     */
    public void setSize(Vector2D size) {
        this.size = size;
    }

    /**
     * Gets the colour of the object.
     * @return Javafx Color
     */
    public Color getColour() {
        return colour;
    }

    /**
     * Sets the colour of the object.
     * @param colour new javaFx color
     */
    public void setColour(Color colour) {
        this.colour = colour;
    }

    /**
     * Sets the texture of the object.
     * @param texture Javafx Image
     */
    public void setTexture(Image texture) {
        this.texture = texture;
        hasTexture = true;
    }

    /**
     * Gets the current texture of the object.
     * @return texture of the object (Javafx Image)
     */
    public Image getTexture() {
        return texture;
    }

    /**
     * Checks if the object has a texture.
     * @return If it has a texture
     */
    public boolean hasTexture() {
        return hasTexture;
    }

    public Color[][] getPixelBuffer() {
        return pixelBuffer;
    }

    public Vector2D getOffset() {
        return new Vector2D(size.x/2, size.y/2);
    }

    /**
     * Updates the pixel buffer of the object.
     */
    protected abstract void updatePixelBuffer();
}
