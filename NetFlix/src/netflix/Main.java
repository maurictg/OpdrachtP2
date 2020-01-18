package netflix;

import com.maurict.orm.Database;
import javafx.application.Application;
import javafx.stage.Stage;
import netflix.controllers.Controller;
import netflix.models.Film;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //Create connection to the database
        Database db = new Database("localhost","netflix");
        System.out.println(Film.longestFilmAgeSixteen());

        //Create a controller, just because we need to start the gui
        Controller c = new Controller();
        c.setStage(stage);
        c.show("Home", "Netflix Statistix", 900, 600);
//        c.show("Login", "Netflix Statistix", 600, 400);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
