package netflix.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AccountController extends Controller {

    @FXML
    private TextField tbName;

    @FXML
    private TextField tbPassword;

    @FXML
    private TextField tbRepeatPassword;

    @FXML
    private TextField tbPhonenumber;

    @FXML
    private TextField tbAge;

    @FXML
    private TextField tbCity;

    @FXML
    private TextField tbStreet;

    @FXML
    private TextField tbNumber;

    @FXML
    private TextField tbExtension;

    @FXML
    public void btnSave_Click() {
        if(this.checkEmpty()) {
            this.alert("Please fill all fields");
            return;
        }

        if(!this.checkPasswords()) {
            this.alert("Passwords don't match");
            return;
        }

        this.saveAccount();
        this.show("Home");
    }

    @FXML
    public void btnCancel_Click() {
        this.show("Home");
    }

    // Checks if form is filled
    private boolean checkEmpty() {
        return (tbName.getText().isEmpty() || tbPassword.getText().isEmpty() || tbRepeatPassword.getText().isEmpty() ||
            tbPhonenumber.getText().isEmpty() || tbAge.getText().isEmpty() || tbCity.getText().isEmpty() ||
                tbStreet.getText().isEmpty() || tbNumber.getText().isEmpty());
    }

    // Checks if given passwords are equal;
    private boolean checkPasswords() {
        return tbPassword.getText().equals(tbRepeatPassword.getText());
    }

    // Gives out alert
    private void alert(String text) {
        new Alert(Alert.AlertType.WARNING, text, ButtonType.OK).show();
    }


    private void saveAccount() {

        // Code to save an account

    }
}
