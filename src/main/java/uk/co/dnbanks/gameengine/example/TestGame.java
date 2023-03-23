package uk.co.dnbanks.gameengine.example;

import javafx.scene.paint.Color;
import uk.co.dnbanks.gameengine.game.Game;
import uk.co.dnbanks.gameengine.game.Scene;
import uk.co.dnbanks.gameengine.objects.drawable.Rect;
import uk.co.dnbanks.gameengine.utilities.Vector2D;

/**
 * Test class to show the features and the basics of the game engine.
 * In my example to make it simple I've extended Game, you don't have to do this,
 * but you'd have to call the static class Game before some functions bellow.
 * NOTE: what I've said is subject to change I may change it, so you have to extend game and override a set start method
 *
 * @author Daniel Banks
 */
public class TestGame extends Game {

    /**
     * Main method to start the game.
     * @param args arguments
     */
    public static void main(String[] args) {
        // initialise the game - MUST BE CALLED FIRST
        initGame();

        /* Creates a scene called main with the game window being 800x800
          .setAsStartScene() is used here to set the start scene
          alternatively you can call: Game.setStartScene("Main");
          or to load the scene later on: Game.loadScene("Main");
         */
        Scene scene = createScene("Main", new Vector2D(800, 800), true);
        scene.setAsStartScene();

        // Adding a rectangle to the scene with a size of 150x100 on position 100, 100 with the colour of Aqua
        scene.addObject(new Rect("Test Rectangle", new Vector2D(150, 100), new Vector2D(100, 100), Color.AQUA));


        // Lastly launching the game
        launch();
    }
}
