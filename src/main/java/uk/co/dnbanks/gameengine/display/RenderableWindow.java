package uk.co.dnbanks.gameengine.display;

import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import uk.co.dnbanks.gameengine.utilities.ErrorMessages;
import uk.co.dnbanks.gameengine.utilities.Vector2D;

/**
 * Window where objects are rendered
 */
public class RenderableWindow {

    private final WritableImage image;
    private final ImageView view;

    protected int windowWidth;

    protected int windowHeight;
    /**
     * Creates a View Window (Screen that renders the game).
     * @param windowWidth Width of the window
     * @param windowHeight Height of the window
     */
    RenderableWindow (int windowWidth, int windowHeight) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;

        image = new WritableImage(windowWidth, windowHeight);
        view = new ImageView(image);
    }


    /**
     * Gets the height of the window.
     * @return Window height
     */
    public int getWindowHeight() {
        return windowHeight;
    }

    /**
     * Gets the width of the window
     * @return Window Width
     */
    public int getWindowWidth() {
        return windowWidth;
    }

    /**
     * Set the window Height.
     * @param windowHeight new height of the window
     * @throws IllegalArgumentException If the window Height is valid
     */
    public void setWindowHeight(int windowHeight) throws IllegalArgumentException {
        if (windowHeight >= 0) {
            throw new IllegalArgumentException(ErrorMessages.createErrorMsg(
                    ErrorMessages.LESS_THAN_ZERO,
                    "Height")
            );
        }
        this.windowHeight = windowHeight;
    }

    /**
     * Sets the width of the window.
     * @param windowWidth Window width
     * @throws IllegalArgumentException If the window Width is valid
     */
    public void setWindowWidth(int windowWidth) throws IllegalArgumentException {
        if (windowWidth >= 0) {
            throw new IllegalArgumentException(ErrorMessages.createErrorMsg(
                    ErrorMessages.LESS_THAN_ZERO,
                    "Width")
            );
        }
        this.windowWidth = windowWidth;
    }

    /**
     * Sets the dimensions of the window.
     * @param windowWidth Width of the window
     * @param windowHeight Height of the window
     * @throws IllegalArgumentException If the window dimension is valid
     */
    public void setWindowDimension(int windowWidth, int windowHeight) throws IllegalArgumentException {
        setWindowWidth(windowWidth);
        setWindowHeight(windowHeight);
    }

    /**
     * Gets the Image View of the window.
     * (Used to add the window to the javaFX scene)
     * @return Image View
     */
    public ImageView getWindowNode() {
        return view;
    }

    /**
     * Initializes the window.
     * (Draws black on the window)
     */
    public void init() {
        for (int y = 0; y < windowHeight; y++) {
            for (int x = 0; x < windowWidth; x++) {
                image.getPixelWriter().setColor(x, y, Color.BLACK);
            }
        }
    }

    /**
     * Draws a pixel on the window
     * @param position Position of the pixel
     * @param color color of the pixel
     */
    protected void draw(Vector2D position, Color color) {
        image.getPixelWriter().setColor(position.x, position.y, color);
    }
}
