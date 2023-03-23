package uk.co.dnbanks.gameengine.display;

import uk.co.dnbanks.gameengine.objects.Object;

import java.util.ArrayList;

/**
 * Window the game is displayed
 * @author Daniel Banks
 * @version %I%
 */
public class Window extends RenderableWindow {

    public static final String MAIN_WINDOW_NAME = "Main";

    // Array of objects in the window
    private final ArrayList<Object> objects = new ArrayList<>();

    private final String name;

    /**
     * Creates a main View Window (Screen that renders the game).
     * @param windowWidth Width of the window
     * @param windowHeight Height of the window
     */
    public Window(int windowWidth, int windowHeight) {
        super(windowWidth, windowHeight);
        name = MAIN_WINDOW_NAME;
    }

    /**
     * Creates a View Window (Screen that renders the game).
     * @param windowWidth Width of the window
     * @param windowHeight Height of the window
     * @param name Name of the window
     */
    public Window(int windowWidth, int windowHeight, String name) {
        super(windowWidth, windowHeight);
        this.name = name;
    }

    /**
     * Adds an object to the GUI.
     * @param object object to be added
     */
    public void add(Object object) {
        objects.add(object);
    }

    /**
     * Gets the name of the window.
     * @return Name of window
     */
    public String getName() {
        return name;
    }
}
