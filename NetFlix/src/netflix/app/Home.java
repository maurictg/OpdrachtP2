package netflix.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Home extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane bp = new BorderPane();

        Scene screen = new Scene(bp, 600, 400);
        stage.setScene(screen);
        stage.setTitle("Netflix Statistics");
        stage.show();
    }
}
