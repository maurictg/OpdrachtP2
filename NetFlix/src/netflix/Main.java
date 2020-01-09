package netflix;

import com.maurict.orm.Database;
import javafx.application.Application;
import javafx.stage.Stage;
import netflix.controllers.Controller;
import netflix.models.*;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //Create connection to the database
        //Database db = new Database("localhost","netflix");

        //Create a controller, just because we need to start the gui
        Controller c = new Controller();
        c.setStage(stage);
        c.show("Login", "Netflix Statistix");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
