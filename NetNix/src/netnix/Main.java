package netnix;
import netnix.app.GUI;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        new GUI(stage, "Netflix Statistics").run();
    }
}
