module uk.co.dnbanks.gameengine {
    requires javafx.controls;
    requires javafx.fxml;


    opens uk.co.dnbanks.gameengine to javafx.fxml;
    exports uk.co.dnbanks.gameengine.display;
    opens uk.co.dnbanks.gameengine.display to javafx.fxml;
    exports uk.co.dnbanks.gameengine.utilities;
    opens uk.co.dnbanks.gameengine.utilities to javafx.fxml;
    exports uk.co.dnbanks.gameengine.game;
    opens uk.co.dnbanks.gameengine.game to javafx.fxml;
}