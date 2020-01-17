package netflix.controllers;

import com.maurict.orm.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import netflix.app.AccountManager;
import netflix.models.Profile;


public class AddProfileController extends Controller {

    @FXML
    private TextField tbNameProfile;

    @FXML
    private Label labelWarning;
    

    public void btnReturn_Click(){
        this.show("Home");
    }

    public void btnSaveProfile_Click(){
        if (tbNameProfile.getText().isEmpty()){
            labelWarning.setText("Please fill in the field");
        } else {
            Database db = Database.global;
            Profile profile = new Profile();
            profile.profileName = tbNameProfile.getText();
            profile.accountId = AccountManager.selected.accountId;
            try {
                db.add(profile);
                this.show("Profile");
            } catch (Exception e){

            }

        }
    }

}
