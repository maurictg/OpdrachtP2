package netflix.controllers;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;

public class HomeController extends Controller {

    @Override
    void onLoad() {

    }

    @FXML
    public void exitApp(ActionEvent e){
        System.exit(0);
    }

    @FXML
    public void btnNewAccount_Click() {
        this.show("Account", 1000, 600);
    }
}
