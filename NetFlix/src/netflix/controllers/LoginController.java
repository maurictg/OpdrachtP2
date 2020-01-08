package netflix.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class LoginController extends Controller {

    @FXML
    private Label lblTitle;

    @FXML
    private TextField tbUn;

    @FXML
    private PasswordField tbPw;

    @FXML
    private Button btnLogin;


    //Voorbeeld van een button event. Kijk goed in de FXML hoe je dit gebruikt
    @FXML
    public void btnLogin_click(ActionEvent e){
        if(tbUn.getText().isEmpty() || tbPw.getText().isEmpty()){
            new Alert(Alert.AlertType.WARNING, "Please fill all fields!", ButtonType.OK).show();
            return;
        }

        //This is not how we check passwords, but its temporary
        if(tbUn.getText().equals(tbPw.getText())){
            //Open view Home.fxml in current stage thanks to superclass function
            this.show("Home", 1000, 600);
        }
    }

}
