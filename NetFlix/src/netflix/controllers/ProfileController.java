package netflix.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import netflix.app.AccountManager;
import netflix.models.Profile;

import java.util.ArrayList;

public class ProfileController extends Controller {

    private ArrayList<Object> profiles;

    @FXML
    private ComboBox cbProfiles;


    @FXML
    public void btnAddProfile_Click(){
        this.show("AddProfile");
    }

    public void btnReturn_Click(){
        this.show("Home");
    }

    @FXML
    public void cbProfiles_Change() {
        for (Object profile : profiles) {
            Profile a = (Profile)profile;
            if(a.profileName.equals((String)cbProfiles.getValue())){
                AccountManager.selectedProfile = a;
                AccountManager.isEdit = true;

            }
        }
    }

    @Override
    void onLoad() {
        try{
            profiles = new Profile().select().toList();
            for (Object o: profiles) {
                if (((Profile)o).accountId == AccountManager.selected.accountId){
                    cbProfiles.getItems().add(((Profile)o).profileName);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
