package netflix.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import netflix.app.Home;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    //Sla de stage op om van pagina te kunnen wisselen
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private Label lblTitle;

    @FXML
    private TextField tbUn;

    @FXML
    private PasswordField tbPw;

    @FXML
    private Button btnLogin;

    @FXML
    private Label lblReturn;

    //Voorbeeld van een button event. Kijk goed in de FXML hoe je dit gebruikt
    @FXML
    public void btnLogin_click(ActionEvent e){
        lblReturn.setText("hey!");
    }

    //Dit is de OnLoad method. Deze code wordt uitgevoerd wanneer deze pagina ingeladen wordt
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Kijk je kunt dus ook zo een event handler maken, op de oude manier
        btnLogin.setOnAction(event -> {

            //natuurlijk moet het zo niet maar ff een maniertje om stage wisselen te testen
            if(tbUn.getText().equals(tbPw.getText())){
                //Nu starten we een oude stage van Aart met oud java FX
                Home home = new Home();
                home.start(stage);
            }
        });
    }
}
