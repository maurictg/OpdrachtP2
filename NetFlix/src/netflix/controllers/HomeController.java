package netflix.controllers;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;

public class HomeController extends Controller {

    @FXML
    public void btnAbout_Click() {
        this.show("About");
    }

    @FXML
    public void btnExit_Click(ActionEvent e){
        System.exit(0);
    }

    @FXML
    public void btnNewAccount_Click() {
        this.show("Account");
    }

    @FXML
    public void btnViews_Click() {
        this.show("Views");
    }
}
