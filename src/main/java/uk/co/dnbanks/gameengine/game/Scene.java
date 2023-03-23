package uk.co.dnbanks.gameengine.game;

import uk.co.dnbanks.gameengine.objects.Camera;
import uk.co.dnbanks.gameengine.objects.Object;
import uk.co.dnbanks.gameengine.utilities.Vector2D;

import java.util.HashMap;

/**
 * Class to implement a scene within the game
 * @author Daniel Banks
 */
public class Scene {

    // The scene class where all the back end is delt with
    private final uk.co.dnbanks.gameengine.utilities.Scene scene;

    // size of the stage/window
    private Vector2D dimensions;

    // Objects in the scene
    private HashMap<String, Object> objects = new HashMap<>();

    /**
     * Creates a scene.
     * If hasGameWindow is set to true then output from the camera will take the whole screen up
     * @param sceneName Name of the scene
     * @param dimensions Dimensions of the window
     * @param hasGameWindow If the scene has a camera/is not a menu
     */
    Scene (String sceneName, Vector2D dimensions, Boolean hasGameWindow) {
        if (hasGameWindow) {
            scene = new uk.co.dnbanks.gameengine.utilities
                    .Scene(dimensions, addMainCamera(dimensions).getWindow(), sceneName);
        } else {
            scene = new uk.co.dnbanks.gameengine.utilities
                    .Scene(dimensions, sceneName);
        }
    }

    /**
     * Adds a main camera to the scene.
     * The camera's position is defaulted to (0,0)
     * Note: This doesn't need to be called if hasGameWindow was set to true when the scene was created
     * @param dimensions Dimensions of the display in the window
     * @return Camera
     */
    public Camera addMainCamera(Vector2D dimensions) {
        Camera camera = new Camera(dimensions);
        objects.putIfAbsent(Camera.MAIN_CAMERA_NAME, camera);
        return camera;
    }

    /**
     * Adds a camera to the scene.
     * @param cameraName Name of the camera
     * @param position Position of the camera in the scene
     * @param cameraWindowSize Size of the output display of the camera
     * @return Camera
     */
    public Camera addCamera(String cameraName,
                            Vector2D position,
                            Vector2D cameraWindowSize
    ) {
        Camera camera = new Camera(position, cameraWindowSize, cameraName);
        cameraName =  cameraName.replaceAll("camera", "");
        cameraName =  cameraName.replaceAll("Camera", "");
        objects.putIfAbsent(cameraName, camera);
        return camera;
    }

    /**
     * Opens the scene.
     */
    public void open() {
        scene.open();
    }
}
