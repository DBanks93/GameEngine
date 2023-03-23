package uk.co.dnbanks.gameengine.objects;

import uk.co.dnbanks.gameengine.utilities.Vector2D;

/**
 * Class to represent objects in the Scene.
 * The position is the center of the entity not top left!
 * @author Daniel Banks
 */
public class Object {

    /** Position of the object */
    protected Vector2D position;

    /** Name of the object */
    protected String objectName = "";

    /**
     * Gets the position of the object.
     * The position is taken from the center of the entity
     * @return position
     */
    public Vector2D getPosition() {
        return position;
    }

    /**
     * Moves the object X position.
     * @param newX New X position of the object
     */
    public void transformX(int newX) {
        position.x = newX;
    }

    /**
     * Moves the object Y position.
     * @param newY New Y position of the object
     */
    public void transformY(int newY) {
        position.y = newY;
    }

    /**
     * Moves the object position.
     * @param newPos new position of the object
     */
    public void transform(Vector2D newPos) {
        position = newPos;
    }

    public String getObjectName() {
        return objectName;
    }
}
