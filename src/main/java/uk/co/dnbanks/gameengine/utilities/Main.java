package uk.co.dnbanks.gameengine.utilities;

import javafx.application.Application;
import javafx.stage.Stage;
import uk.co.dnbanks.gameengine.display.Window;
import uk.co.dnbanks.gameengine.game.Game;

import java.util.ArrayList;

public class Main extends Application {

    private static Scene scene;

    private static ArrayList<Window> windows = new ArrayList<>();

    public static void main(String[] args) {
        //Window window = new Window(500, 500);
        //scene = new Scene(new Vector2D(500, 500), window,"test");
        Game.createScene("Test", new Vector2D(800,800), true);
        Game.loadScene("Test");
        launch();
    }



    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle(Main.scene.getSceneName());
        stage.setScene(Main.scene.getScene());
        stage.show();

        Main.scene.init();

        //stage.setTitle();
    }

    public static void setScene(Scene scene) {
        Main.scene = scene;
    }
}
