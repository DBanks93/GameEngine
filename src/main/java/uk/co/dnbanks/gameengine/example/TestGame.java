package uk.co.dnbanks.gameengine.example;

import javafx.scene.paint.Color;
import uk.co.dnbanks.gameengine.game.Game;
import uk.co.dnbanks.gameengine.game.Scene;
import uk.co.dnbanks.gameengine.objects.drawable.Rect;
import uk.co.dnbanks.gameengine.utilities.Vector2D;

public class TestGame extends Game {

    public static void main(String[] args) {
        // initialise the game - must be called first
        initGame();
        /* Creates a scene called main with the game window being 800x800
          .setAsStartScene() is used here to set the start scene
          alternatively you can call: Game.setStartScene("Main");
          or to load the scene later on: Game.loadScene("Main");
         */
        Scene scene = createScene("Main", new Vector2D(800, 800), true);
        scene.setAsStartScene();

        // Adding a rectangle to the scene with a size of 150x100 on position 100, 100 with the colour of aquq
        scene.addObject(new Rect("Test Rectangle", new Vector2D(150, 100), new Vector2D(100, 100), Color.AQUA));


        // Lastly launching the game
        launch();
    }
}
