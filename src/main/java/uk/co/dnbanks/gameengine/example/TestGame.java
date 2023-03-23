package uk.co.dnbanks.gameengine.example;

import uk.co.dnbanks.gameengine.game.Game;
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
        createScene("Main", new Vector2D(800, 800), true).setAsStartScene();

        // Lastly launching the game
        launch();
    }
}
