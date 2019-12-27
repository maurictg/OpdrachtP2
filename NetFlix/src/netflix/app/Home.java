package netflix.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Home extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;

        this.homeScreen();
    }

    // Hieronder alle screens, ze hebben in de code allemaal dezelfde opbouw
    // Voor elk genre is er een aparte screen

    private void homeScreen() {
        BorderPane bPane = new BorderPane();

        //Onderdelen maken
        Label genreLabel = new Label("Home");

        // Onderdelen toevoegen aan BorderPane
        bPane.setLeft(getLeftBorder());
        bPane.setCenter(genreLabel);

        // Deze scene tonen - door method 'run()'
        this.run(new Scene(bPane, 600, 400));
    }

    private void actionScreen() {
        BorderPane bPane = new BorderPane();

        bPane.setLeft(getLeftBorder());
        bPane.setCenter(new Label("action"));

        this.run(new Scene(bPane, 600, 400));
    }

    private void comedyScreen() {
        BorderPane bPane = new BorderPane();

        bPane.setLeft(getLeftBorder());
        bPane.setCenter(new Label("comedy"));

        this.run(new Scene(bPane, 600, 400));
    }

    private void scifiScreen() {
        BorderPane bPane = new BorderPane();

        bPane.setLeft(getLeftBorder());
        bPane.setCenter(new Label("scifi"));

        this.run(new Scene(bPane, 600, 400));
    }

    private void horrorScreen() {
        BorderPane bPane = new BorderPane();

        bPane.setLeft(getLeftBorder());
        bPane.setCenter(new Label("horror"));

        this.run(new Scene(bPane, 600, 400));
    }

    private void thrillerScreen() {
        BorderPane bPane = new BorderPane();

        bPane.setLeft(getLeftBorder());
        bPane.setCenter(new Label("thriller"));

        this.run(new Scene(bPane, 600, 400));
    }

    // De Left Border uit de Borderpane, deze wordt in elke screen aangeroepen
    private Pane getLeftBorder() {
        VBox vBox = new VBox();

        Button homeButton = newButton("Homepage");
        Button actionButton = newButton("Action");
        Button comedyButton = newButton("Comedy");
        Button scifiButton = newButton("Sci-Fi");
        Button horrorButton = newButton("Horror");
        Button thrillerButton = newButton("Thriller");

        vBox.getChildren().addAll(homeButton, actionButton, comedyButton, scifiButton, horrorButton, thrillerButton);

        vBox.setSpacing(6);

        homeButton.setOnAction((event -> homeScreen()));
        actionButton.setOnAction((event -> actionScreen()));
        comedyButton.setOnAction((event -> comedyScreen()));
        scifiButton.setOnAction((event -> scifiScreen()));
        horrorButton.setOnAction((event -> horrorScreen()));
        thrillerButton.setOnAction((event -> thrillerScreen()));

        return vBox;
    }

    private Button newButton(String text) {

        return new Button(text);
    }

    private void run(Scene scene) {

        stage.setScene(scene);
        stage.setTitle("Netflix Statistics");
        stage.show();
    }
}
