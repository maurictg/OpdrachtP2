package netflix.app;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import netflix.models.Account;

public class Accounts {

    public Pane newAccount() {
        GridPane grid = new GridPane();

        // create all parts
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

        // add all parts
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

        // button functionality
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

        return grid;
    }

    private Pane getAccounts() {

        GridPane grid = new GridPane();

        // create parts
        Button averagePercentageWatchedPerMovieButton = new Button("Average time watched per movie");
        Button averagePercentageWatchedPerAccountPerMovieButton = new Button("Average time watched per account per movie");
        Button watchedMoviesPerAccountButton = new Button("Watched movies per account");
        Button longestMovieForSixteensButton = new Button("Longest Movie for sixteen-year-old's");
        Button allAccountsWithOneProfileButton = new Button("All series with one profile");
        Button timesWatchedPerMovieButton = new Button("Times watched");
        TextField field = new TextField("Press a button to see specific information about Netflix");

        // geometry
        field.setPrefSize(300, 200);

        // add all parts

        // button functionality
        averagePercentageWatchedPerMovieButton.setOnAction(event -> averagePercentageWatchedPerMovie());
        averagePercentageWatchedPerAccountPerMovieButton.setOnAction(event -> averagePercentageWatchedPerAccountPerMovie());
        watchedMoviesPerAccountButton.setOnAction(event -> watchedMoviesPerAccount());
        longestMovieForSixteensButton.setOnAction(event -> longestMovieForSixteens());
        allAccountsWithOneProfileButton.setOnAction(event -> allAccountsWithOneProfile());
        timesWatchedPerMovieButton.setOnAction(event -> timesWatchedPerMovie());

        return grid;

    }

    private void insertData(String username, String password, String city, String street, int number, String extension, int phone, int age) {
        new Account();
    }

    private void averagePercentageWatchedPerMovie() {

    }

    private void averagePercentageWatchedPerAccountPerMovie() {

    }

    private void watchedMoviesPerAccount() {

    }

    private void longestMovieForSixteens() {

    }

    private void allAccountsWithOneProfile() {

    }

    private void timesWatchedPerMovie() {}

}
