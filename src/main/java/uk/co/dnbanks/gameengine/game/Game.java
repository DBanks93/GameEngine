package uk.co.dnbanks.gameengine.game;

import uk.co.dnbanks.gameengine.utilities.ErrorMessages;
import uk.co.dnbanks.gameengine.utilities.Main;
import uk.co.dnbanks.gameengine.utilities.Vector2D;

import java.util.HashMap;

/**
 * Class that controls all the aspects of the game.
 * @author Daniel Banks
 */
public class Game {

    // Map of scenes: scene names -> Scenes.
    private static final HashMap<String, Scene> scenes = new HashMap<>();

    // The starting scene.
    private static String startScene;

    /**
     * Launches and starts the game.
     * Should be called last, after everything is set up /initialised
     */
    public static void launch() {
        Main.launch();
    }

    /**
     * Initialises the game.
     * Must be called at the beginning of the main method
     */
    public static void initGame() {
        Main.initGame();
    }

    /**
     * Creates a scene.
     * @param sceneName Name of the scene
     * @param dimensions Size of the scene window
     * @param hasGameWindow If the scene should have a default game camera
     * @return Scene
     */
    public static Scene createScene(String sceneName,
                                    Vector2D dimensions,
                                    boolean hasGameWindow) {
        Scene scene = new Scene(sceneName, dimensions, hasGameWindow);
        scenes.putIfAbsent(sceneName, scene);
        return scene;
    }

    /**
     * Sets what scene starts in the game.
     * @param newStartScene Name of the starting scene
     */
    public static void setStartScene(String newStartScene) {
        startScene = newStartScene;
    }

    /**
     * Gets the name of the starting scene.
     * @return Name of the starting scene
     */
    public static String getStartScene() {
        return startScene;
    }

    /**
     * Loads a scene.
     * @param name Name of the scene to be loaded
     * @return Scene that's being loaded
     * @throws NullPointerException If Scene exists
     */
    public static Scene loadScene(String name) throws NullPointerException {
        Scene openScene = scenes.get(name);
        if (openScene == null) {
            throw new NullPointerException(ErrorMessages.createErrorMsg(
                    ErrorMessages.NULL_POINTER, ErrorMessages.NO_SCENE_ERROR));
        }
        openScene.open();
        return openScene;
    }
}
