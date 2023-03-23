package uk.co.dnbanks.gameengine.utilities;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import uk.co.dnbanks.gameengine.display.Window;

import java.util.HashMap;

/**
 * Class that deals with the back end of a scene
 * @author Daniel Banks
 */
public class Scene {
    private static final Vector2D DEFUALT_SIZE = new Vector2D(100, 100);

    private javafx.scene.Scene scene;

    private final Pane root;

    private final Vector2D size;

    private Stage stage;

    private String sceneName;

    private boolean hasWindow;

    private HashMap<String, Window> windows = new HashMap<>();

    Scene () {
        this.size = DEFUALT_SIZE;
        this.root = new Pane();
        this.sceneName = "";
        setScene();
    }

    Scene (Pane root, Vector2D size, String sceneName) {
        this.sceneName = sceneName;
        this.root = root;
        this.size = size;
        setScene();
    }

    public Scene(Vector2D size, String sceneName) {
        this.sceneName = sceneName;
        this.root = new Pane();
        this.size = size;
        setScene();
    }

    Scene (Pane root, Window window, Vector2D size, String sceneName) {
        this.sceneName = sceneName;
        this.root = root;
        this.size = size;
        addWindow(window);
        setScene();
    }

    public Scene(Vector2D size, Window window, String sceneName) {
        this.sceneName = sceneName;
        this.root = new Pane();
        this.size = size;
        addWindow(window);
        setScene();
    }

    /**
     * Changes the name of the scene.
     * This will also be displayed on the window
     * @param sceneName New scene name
     */
    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
        stage.setTitle(sceneName);
    }

    public void add(Node node) {
        root.getChildren().add(node);
    }

    public void addWindow(Window window) {
        window.init();
        windows.putIfAbsent(window.getName(), window);
        root.getChildren().add(window.getWindowNode());
        hasWindow = true;
    }

    public boolean removeWindow(String windowName) {
        return windows.remove(windowName) != null;
    }

    public Pane getRoot() {
        return root;
    }

    public Vector2D getDimenstions() {
        return size;
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setScene(javafx.scene.Scene scene) {
        this.scene = scene;
    }

    public void init() {
        if (hasWindow) {
            windows.get(Window.MAIN_WINDOW_NAME).init();
        }
    }

    public javafx.scene.Scene getScene(){
        return scene;
    }

    public Window getWindow() {
        return windows.get(Window.MAIN_WINDOW_NAME);
    }

    public void open() {
        Main.setScene(this);
    }

    private void setScene() {
        this.scene = new javafx.scene.Scene(
                root,
                size.x,
                size.y
        );
    }
}
