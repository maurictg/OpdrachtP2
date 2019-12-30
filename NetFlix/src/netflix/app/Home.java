package netflix.app;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import netflix.models.Account;

public class Home extends Application {

    private Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;

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

    private void newAccountScreen() {
        GridPane grid = new GridPane();

        Label headerLabel = new Label("CREATE ACCOUNT");
        Label nameLabel = new Label("Username: ");
        Label passwordLabel = new Label("Password: ");
        Label cityLabel = new Label("City: ");
        Label streetLabel = new Label("Street: ");
        Label numberLabel = new Label("Number: ");
        Label extensionLabel = new Label("Extension: ");
        Label ageLabel = new Label("Age: ");
        Label phoneLabel = new Label("Phonenumber: ");

        TextField nameText = new TextField();
        TextField passwordText = new TextField();
        TextField cityText = new TextField();
        TextField streetText = new TextField();
        TextField numberText = new TextField();
        TextField extensionText = new TextField();
        TextField phoneText = new TextField();
        TextField ageText = new TextField();

        Button createButton = new Button("Create Account");

        grid.add(headerLabel, 1, 1);
        grid.add(nameLabel, 1, 2);
        grid.add(nameText, 2, 2);
        grid.add(passwordLabel, 1, 3);
        grid.add(passwordText, 2, 3);
        grid.add(cityLabel, 1, 4);
        grid.add(cityText, 2, 4);
        grid.add(streetLabel, 1, 5);
        grid.add(streetText, 2, 5);
        grid.add(numberLabel, 1, 6);
        grid.add(numberText, 2, 6);
        grid.add(extensionLabel, 1, 7);
        grid.add(extensionText, 2, 7);
        grid.add(phoneLabel, 1, 8);
        grid.add(phoneText, 2, 8);
        grid.add(ageLabel, 1, 9);
        grid.add(ageText, 2, 9);
        grid.add(createButton, 2, 14);

        grid.setHgap(2);
        grid.setVgap(5);

        numberText.lengthProperty().addListener(new ChangeListener<>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = numberText.getText().charAt(oldValue.intValue());

                    if (!(ch >= '0' && ch <= '9')) {

                        numberText.setText(numberText.getText().substring(0, numberText.getText().length() - 1));
                    }}}
        });

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

        createButton.setOnAction(event ->
                this.insertData(nameText.getText(), passwordText.getText(), cityText.getText(), streetText.getText(), Integer.parseInt(numberText.getText()), extensionText.getText(), Integer.parseInt(phoneText.getText()), Integer.parseInt(ageText.getText())));

        this.run(new Scene(grid, 600, 400));
    }

    // De Left Border uit de Borderpane, deze wordt in elke screen aangeroepen
    private Pane getLeftBorder() {
        VBox vBox = new VBox();

        Button homeButton = newButton("Homepage");
        Button newAccountButton = newButton("Create account");

        vBox.getChildren().addAll(homeButton, newAccountButton);

        vBox.setSpacing(6);

        homeButton.setOnAction((event -> homeScreen()));
        newAccountButton.setOnAction((event -> newAccountScreen()));

        return vBox;
    }

    private void insertData(String username, String password, String city, String street, int number, String extension, int phone, int age) {
        new Account();
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
