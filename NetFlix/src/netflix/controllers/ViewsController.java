package netflix.controllers;

import javafx.fxml.FXML;

public class ViewsController extends Controller {

    @FXML
    private void btnBack_Click() {
        this.show("Home");
    }
}
