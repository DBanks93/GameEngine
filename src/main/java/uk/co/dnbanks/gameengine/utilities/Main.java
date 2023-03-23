package uk.co.dnbanks.gameengine.utilities;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import uk.co.dnbanks.gameengine.display.Window;
import uk.co.dnbanks.gameengine.game.Game;

import java.util.ArrayList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main extends Application {

    private static Scene scene;

    private static Stage javaFxStage;

    private static final ArrayList<Window> windows = new ArrayList<>();

    private static final ReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * Launches the game.
     */
    public static void launch() {
        lock.writeLock().lock();
        String startScene = Game.getStartScene();
        if (startScene == null || startScene.equals("")) {
            System.out.println("Start Scene has not been set");
            System.exit(1);
        } else {
            Game.loadScene(startScene);
        }
        lock.writeLock().unlock();
    }

    /**
     * Initialise the game.
     */
    public static void initGame() {
        lock.writeLock().lock();
        Thread fxThread = new Thread(() -> Application.launch(Main.class));
        fxThread.start();
        lock.writeLock().unlock();
    }

    public static void main(String[] args) {
        //Window window = new Window(500, 500);
        //scene = new Scene(new Vector2D(500, 500), window,"test");
        /* // Used for my Testing
        Game.createScene("Test", new Vector2D(800,800), true);
        Game.loadScene("Test");
        */
        String startScene = Game.getStartScene();
        if (startScene == null || startScene.equals("")) {
            System.out.println("Start Scene has not been set");
            System.exit(1);
        } else {
            Game.loadScene(startScene);
            launch();
        }
    }



    @Override
    public void start(Stage stage) {
        Main.javaFxStage = stage;
        Main.scene = new Scene();
        stage.setTitle(Main.scene.getSceneName());
        stage.setScene(Main.scene.getScene());
        stage.show();

        Main.scene.init();
        //stage.setTitle();
    }

    public static void setScene(Scene scene) {
        Platform.runLater(() -> {
            Main.scene = scene;
            Main.javaFxStage.setTitle(Main.scene.getSceneName());
            Main.javaFxStage.setScene(Main.scene.getScene());
            Main.javaFxStage.show();
        });
    }
}
