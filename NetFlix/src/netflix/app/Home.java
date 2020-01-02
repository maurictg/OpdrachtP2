package netflix.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Home extends Application {

    private Stage stage;
    private Accounts accounts;
    private Overzichten overzichten;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        this.accounts = new Accounts();
        this.overzichten = new Overzichten();

        this.homeScreen();
    }

    // Hieronder alle screens, ze hebben in de code allemaal dezelfde opbouw
    // Voor elk onderwerp is er een aparte screen

    private void homeScreen() {
        BorderPane bPane = new BorderPane();

        // Onderdelen toevoegen aan BorderPane
        bPane.setLeft(getLeftBorder());

        // Deze scene tonen - door method 'run()'
        this.run(new Scene(bPane, 600, 400));
    }

    private void createAccountScreen() {

        BorderPane bPane = new BorderPane();

        bPane.setLeft(getLeftBorder());

        bPane.setCenter(this.accounts.newAccount());

        this.run(new Scene(bPane, 600, 400));
    }

    private void getAccountsScreen() {

    }

    // De Left Border uit de Borderpane, deze wordt in elke screen aangeroepen
    private Pane getLeftBorder() {
        VBox vBox = new VBox();

        Button homeButton = newButton("Homepage");
        Button createAccountsButton = newButton("Accounts");
        Button getViewsButton = newButton("Information");

        vBox.getChildren().addAll(homeButton, createAccountsButton);

        vBox.setSpacing(6);

        homeButton.setOnAction((event -> homeScreen()));
        createAccountsButton.setOnAction((event -> createAccountScreen()));
        getViewsButton.setOnAction((event -> getAccountsScreen()));

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
