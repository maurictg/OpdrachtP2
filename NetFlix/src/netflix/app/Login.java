package netflix.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Login extends Application {

    private Home home = new Home();

    public void start(Stage stage) {
        GridPane gPane = new GridPane();

        // Alle verschillende onderdelen maken
        Label usernameLabel = new Label("Username: ");
        Label passwordLabel = new Label("Password: ");
        Label returnLabel = new Label(" ");

        TextField usernameField = new TextField();
        TextField passwordField = new TextField();

        Button loginButton = new Button("Login");

        // Alle onderdelen toevoegen aan de GridPane
        gPane.add(usernameLabel, 1, 1);
        gPane.add(passwordLabel, 1, 2);
        gPane.add(usernameField, 2, 1);
        gPane.add(passwordField, 2, 2);
        gPane.add(loginButton, 2, 3);

        // geometry
        gPane.setVgap(15);
        gPane.setHgap(15);

        // De werking van de buttons
        loginButton.setOnAction(event -> {
            if (checkPassword()) {

                try {
                    this.home.start(stage);
                }
                catch(Exception e) {
                    returnLabel.setText("Dit ging fout");
                }

            }

            returnLabel.setText("Wrong username or password, try again");
        });

        Scene loginScreen = new Scene(gPane, 600, 400);
        stage.setScene(loginScreen);
        stage.setTitle("Netflix Statistics");
        stage.show();
    }

    private boolean checkPassword() {
        return true;
    }
}
