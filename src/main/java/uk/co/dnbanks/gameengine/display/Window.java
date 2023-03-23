package uk.co.dnbanks.gameengine.display;

import javafx.scene.paint.Color;
import uk.co.dnbanks.gameengine.objects.drawable.Drawable;
import uk.co.dnbanks.gameengine.utilities.Vector2D;

import java.util.ArrayList;

/**
 * Window the game is displayed
 *
 * @author Daniel Banks
 * @version %I%
 */
public class Window extends RenderableWindow {

    public static final String MAIN_WINDOW_NAME = "Main";

    // Array of objects in the window
    private final ArrayList<Drawable> objects = new ArrayList<>();

    private final String name;

    private Vector2D cameraPos;

    /**
     * Creates a main View Window (Screen that renders the game).
     *
     * @param windowWidth  Width of the window
     * @param windowHeight Height of the window
     */
    public Window(int windowWidth, int windowHeight) {
        super(windowWidth, windowHeight);
        name = MAIN_WINDOW_NAME;
    }

    /**
     * Creates a View Window (Screen that renders the game).
     *
     * @param windowWidth  Width of the window
     * @param windowHeight Height of the window
     * @param name         Name of the window
     */
    public Window(int windowWidth, int windowHeight, String name) {
        super(windowWidth, windowHeight);
        this.name = name;
    }

    /**
     * Adds an object to the GUI.
     *
     * @param object object to be added
     */
    public void add(Drawable object) {
        objects.add(object);
    }

    /**
     * Gets the name of the window.
     *
     * @return Name of window
     */
    public String getName() {
        return name;
    }

    /**
     * Refreshes and renders the window based on what it's camera is seeing.
     *
     * @param cameraPos current position of the camera.
     */
    public void refresh(Vector2D cameraPos) {
        this.cameraPos = cameraPos;
        for (Drawable object : objects) {
            if (isObjOnScreen(object)) {
                Vector2D pos = offsetPos(object.getPosition());
                Vector2D objectSize = object.getOffset();
                Color[][] pixelBuffer = object.getPixelBuffer();
                for (int x = 0; x < pixelBuffer.length; x++) {
                    for (int y = 0; y < pixelBuffer[0].length; y++) {
                        int posX = ((pos.x + x) - objectSize.x) - cameraPos.x;
                        int posY = ((pos.y + y) - objectSize.y) - cameraPos.y;
                        if (isPixelOnScreen(posX, posY)) {
                            draw(new Vector2D(posX, posY), pixelBuffer[x][y]);
                        }
                    }
                }
            }
        }
    }

    private boolean isObjOnScreen(Drawable drawable) {
        Vector2D pos = offsetPos(drawable.getPosition());
        Vector2D offput = drawable.getOffset();
        return (pos.x - offput.x < cameraPos.x + windowWidth)
                && (pos.x + offput.x > cameraPos.x)
                && (pos.y + offput.y > cameraPos.y)
                && (pos.y - offput.y < cameraPos.y + windowHeight);
    }

    private boolean isPixelOnScreen(int posX, int posY) {
        return (posX > 0
                && posX < windowWidth
                && posY > 0
                && posY < windowHeight);
    }

    private Vector2D offsetPos(Vector2D position) {
        return offsetPos(position.x, position.y);
    }

    private Vector2D offsetPos(int posX, int posY) {
        return new Vector2D(posX + windowWidth / 2, posY + windowHeight / 2);
    }

    private Vector2D cameraOffset() {
        return new Vector2D(
                cameraPos.x + windowWidth / 2,
                cameraPos.y + windowHeight / 2
        );
    }
}
