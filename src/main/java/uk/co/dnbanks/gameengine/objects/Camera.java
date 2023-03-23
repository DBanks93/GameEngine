package uk.co.dnbanks.gameengine.objects;

import uk.co.dnbanks.gameengine.display.Window;
import uk.co.dnbanks.gameengine.utilities.Vector2D;

/**
 * Class that implemets a camera
 * @author Daniel Banks
 */
public class Camera extends Object {
    /** Default name of the Main Camera */
    public static final String MAIN_CAMERA_NAME = "Main Camera";

    // The window where the camera rendering is done
    private final Window window;

    /**
     * Creates a camera.
     * Note: To create a camera you should call Game.addCamera()
     * @param position Position of the camera in the scene
     * @param displaySize Size of the output window of the camera
     * @param cameraName Name of the camera
     */
    public Camera(Vector2D position, Vector2D displaySize, String cameraName) {
        this.window = new Window(displaySize.x, displaySize.y, cameraName);
        this.position = position;
    }

    /**
     * Creates a Main Camera.
     * Note: To create a main camera you should call Game.addMainCamera()
     * @param displaySize Size of the output window of the camera
     */
    public Camera(Vector2D displaySize) {
        this.window = new Window(displaySize.x, displaySize.y);
        this.position = new Vector2D(0, 0);
    }

    /**
     * Gets the window where the camera renders.
     * Note: This is for backend of the game engine,
     * you shouldn't call this unless you're editing the core game engine!!
     * @return Window
     */
    public Window getWindow() {
        return window;
    }

    /**
     * Gets the name of the camera.
     * @return Camera Name
     */
    public String getCameraName() {
        return window.getName();
    }
}
