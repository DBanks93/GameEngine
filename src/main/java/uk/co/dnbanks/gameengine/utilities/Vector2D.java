package uk.co.dnbanks.gameengine.utilities;

/**
 * Class that implements 2D Vectors.
 * @author Daniel Banks
 */
public class Vector2D {

    /** X value. */
    public int x;

    /** Y value. */
    public int y;

    /**
     * Creates a 2D vector.
     * @param x x Value
     * @param y y Value
     */
    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculates the distance between two Vectors.
     * @param v2 Other Vector to calculate
     * @return distance between vectors
     */
    public double distanceTo(Vector2D v2) {
        return Math.sqrt(Math.pow(x - v2.x, 2) + Math.pow(y - v2.y, 2));
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
