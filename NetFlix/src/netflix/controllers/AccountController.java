package netflix.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AccountController extends Controller {

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    public void btnSave_Click() {

    }

    @FXML
    public void btnCancel_Click() {
        this.show("Home", 1000, 600);
    }
}
