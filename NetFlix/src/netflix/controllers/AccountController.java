package netflix.controllers;

import com.maurict.orm.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import netflix.app.AccountManager;
import netflix.models.Account;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountController extends Controller {

    private Date bday;

    @FXML
    private TextField tbName;

    @FXML
    private TextField tbPassword;

    @FXML
    private TextField tbRepeatPassword;

    @FXML
    private TextField tbPhonenumber;

    @FXML
    private TextField tbAgeDay;

    @FXML
    private TextField tbAgeMonth;

    @FXML
    private TextField tbAgeYear;

    @FXML
    private TextField tbCity;

    @FXML
    private TextField tbStreet;

    @FXML
    private TextField tbNumber;

    @FXML
    private TextField tbExtension;

    @FXML
    private Label lblFeedback;

    @FXML
    private Label lblTitle;

    @FXML
    public void btnSave_Click() {
        if (this.checkEmpty()) {
            lblFeedback.setText("Please fill all fields");
            return;
        }

        if (!this.checkPasswords()) {
            lblFeedback.setText("Passwords don't match");
            return;
        }

        if (checkInteger(tbPhonenumber) && checkInteger(tbNumber)) {
            lblFeedback.setText("Number: enter a number");
            return;
        }

        try {
            bday = new SimpleDateFormat("dd/MM/yyyy").parse(tbAgeDay.getText() + "/" + tbAgeMonth.getText() + "/" + tbAgeYear.getText());

        } catch (Exception e) {
            System.out.println("Date?");
            bday = new Date(1999, 1, 1);
            e.printStackTrace();
        }

        this.saveAccount();

    }

    @FXML
    public void btnCancel_Click() {
        this.show("Home");
    }

    // Checks if form is filled
    private boolean checkEmpty() {
        return (tbName.getText().isEmpty() || tbPassword.getText().isEmpty() || tbRepeatPassword.getText().isEmpty() ||
                tbPhonenumber.getText().isEmpty() || tbAgeDay.getText().isEmpty() || tbAgeMonth.getText().isEmpty() ||
                tbAgeYear.getText().isEmpty() || tbCity.getText().isEmpty() || tbStreet.getText().isEmpty() ||
                tbNumber.getText().isEmpty());
    }

    // Checks if given passwords are equal;
    private boolean checkPasswords() {
        return tbPassword.getText().equals(tbRepeatPassword.getText());
    }

    private boolean checkInteger(TextField field) {
        try {
            int i = Integer.parseInt(field.getText());

        } catch (NumberFormatException ex) {
            return true;
        }

        return false;
    }

    private void saveAccount() {

        // Code to save an account

        Account account = (AccountManager.isEdit) ? AccountManager.selected : new Account();

        account.accountName = tbName.getText();
        account.password = tbPassword.getText();
        account.phone = tbPhonenumber.getText();
        account.birthdate = bday;
        account.city = tbCity.getText();
        account.street = tbStreet.getText();
        account.number = Integer.parseInt(tbNumber.getText());
        account.extension = tbExtension.getText();

        //db.add(account);
        Database db = Database.global;

        if(!AccountManager.isEdit){
            try {
                int a = new Account().selectCount().where("accountName", account.accountName).firstInt();
                System.out.println(a);
                if (a > 0){
                    lblFeedback.setText("This name is already in use.");
                    return;
                }
            } catch (Exception e){
                e.printStackTrace();
                return;
            }
        }

        try {
            if(AccountManager.isEdit){
                db.add(account);
            } else{
                db.update(account);
            }
            this.show("Home");
        } catch (Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to commit", ButtonType.OK).show();
        }

    }

    @Override
    void onLoad() {
        if(AccountManager.isEdit){
            lblTitle.setText("Edit account");
            Account a = AccountManager.selected;
            tbName.setText(a.accountName);
            tbName.setDisable(true);

        }
    }
}
