package uk.co.dnbanks.gameengine.test;

import uk.co.dnbanks.gameengine.game.Game;
import uk.co.dnbanks.gameengine.utilities.Vector2D;

public class TestGame {

    public static void main(String[] args) {
        Game.init();
        Game.createScene("Main", new Vector2D(800, 800), true).setAsStartScene();
        Game.launch();
    }
}
