package netflix;

import com.maurict.orm.Database;
import javafx.application.Application;
import javafx.stage.Stage;
import netflix.controllers.Controller;
import netflix.models.Serie;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Controller c = new Controller();
        c.setStage(stage);
        c.show("Login", "Netflix Statistix");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
