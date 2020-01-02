package netflix.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Login extends Application {

    private Stage stage;
    private Home home;

    public void start(Stage stage) {
        this.stage = stage;
        this.home = new Home();

        this.login();
    }

    private void login() {
        GridPane gPane = new GridPane();

        // Alle verschillende onderdelen maken
        Label headerLabel = new Label("LOGIN");
        Label usernameLabel = new Label("Name: ");
        Label passwordLabel = new Label("Password: ");
        Label returnLabel = new Label(" ");

        TextField usernameField = new TextField();
        TextField passwordField = new TextField();

        Button loginButton = new Button("Login");

        // Alle onderdelen toevoegen aan de GridPane
        gPane.add(headerLabel, 1, 1);
        gPane.add(usernameLabel, 1, 2);
        gPane.add(passwordLabel, 1, 3);
        gPane.add(usernameField, 2, 2);
        gPane.add(passwordField, 2, 3);
        gPane.add(loginButton, 2, 4);

        // geometry
        gPane.setVgap(15);
        gPane.setHgap(15);

        // De werking van de buttons
        loginButton.setOnAction(event -> {
            if (this.checkPassword()) {
                this.home.start(stage);
            }

            returnLabel.setText("Wrong username or password, try again");
        });

        // Deze pagina laten zien d.m.v. de methode 'run()'
        this.run(new Scene(gPane, 600, 400));
    }

    private void run(Scene scene) {
        stage.setScene(scene);
        stage.setTitle("Netflix Statistics");
        stage.show();
    }

    private boolean checkPassword() {
        return true;
    }
}
