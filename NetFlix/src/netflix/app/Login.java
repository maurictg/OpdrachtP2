package netflix.app;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Login extends Application {

    private Stage stage;
    private Home home = new Home();

    public void start(Stage stage) {
        this.stage = stage;

        this.login();
    }

    private void login() {
        GridPane gPane = new GridPane();

        // Alle verschillende onderdelen maken
        Label headerLabel = new Label("LOGIN");
        Label usernameLabel = new Label("Emailaddress: ");
        Label passwordLabel = new Label("Password: ");
        Label returnLabel = new Label(" ");

        TextField usernameField = new TextField();
        TextField passwordField = new TextField();

        Button loginButton = new Button("Login");
        Button accountButton = new Button("Create account");

        // Alle onderdelen toevoegen aan de GridPane
        gPane.add(headerLabel, 1, 1);
        gPane.add(usernameLabel, 1, 2);
        gPane.add(passwordLabel, 1, 3);
        gPane.add(usernameField, 2, 2);
        gPane.add(passwordField, 2, 3);
        gPane.add(loginButton, 2, 4);
        gPane.add(accountButton, 2, 5);

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

        accountButton.setOnAction(event -> this.createAccount());

        // Deze pagina laten zien d.m.v. de methode 'run()'
        this.run(new Scene(gPane, 600, 400));
    }

    private void createAccount() {
        GridPane grid = new GridPane();

        Label headerLabel = new Label("CREATE ACCOUNT");
        Label firstnameLabel = new Label("First name: ");
        Label lastnameLabel = new Label("Last name: ");
        Label emailLabel = new Label("Emailaddress: ");
        Label passwordLabel = new Label("Password: ");
        Label phoneLabel = new Label("Phonenumber: ");
        Label ageLabel = new Label("Age: ");

        TextField firstnameText = new TextField();
        TextField lastnameText = new TextField();
        TextField emailText = new TextField();
        TextField passwordText = new TextField();
        TextField phoneText = new TextField();
        TextField ageText = new TextField();

        Button createButton = new Button("Create Account");

        grid.add(headerLabel, 1, 1);
        grid.add(firstnameLabel, 1, 2);
        grid.add(firstnameText, 2, 2);
        grid.add(lastnameLabel, 1, 3);
        grid.add(lastnameText, 2, 3);
        grid.add(emailLabel, 1, 4);
        grid.add(emailText, 2, 4);
        grid.add(passwordLabel, 1, 5);
        grid.add(passwordText, 2, 5);
        grid.add(phoneLabel, 1, 6);
        grid.add(phoneText, 2, 6);
        grid.add(ageLabel, 1, 7);
        grid.add(ageText, 2, 7);
        grid.add(createButton, 2, 8);

        grid.setHgap(2);
        grid.setVgap(5);

        ageText.lengthProperty().addListener(new ChangeListener<>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = ageText.getText().charAt(oldValue.intValue());

                    if (!(ch >= '0' && ch <= '9')) {

                        ageText.setText(ageText.getText().substring(0, ageText.getText().length() - 1));
                    }}}
        });

        phoneText.lengthProperty().addListener(new ChangeListener<>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = phoneText.getText().charAt(oldValue.intValue());

                    if (!(ch >= '0' && ch <= '9')) {

                        phoneText.setText(phoneText.getText().substring(0, phoneText.getText().length() - 1));
                    }}}
        });

        createButton.setOnAction(event -> this.login());

        this.run(new Scene(grid, 600, 400));
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
