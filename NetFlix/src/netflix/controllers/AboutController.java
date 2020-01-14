package netflix.controllers;

import javafx.fxml.FXML;

public class AboutController extends Controller {

    @FXML
    private void btnAbout_Click() {

    }

    @FXML
    private void btnExit_Click() {
        System.exit(0);
    }

    @FXML
    private void btnBack_Click() {
        this.show("Home");
    }
}
