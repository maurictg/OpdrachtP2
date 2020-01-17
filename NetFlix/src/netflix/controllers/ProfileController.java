package netflix.controllers;

import com.maurict.orm.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import netflix.app.AccountManager;
import netflix.models.Profile;

import java.util.ArrayList;

public class ProfileController extends Controller {

    private ArrayList<Object> profiles;

    @FXML
    private ComboBox cbProfiles;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnWatch;


    @FXML
    public void btnAddProfile_Click(){
        this.show("AddProfile");
    }

    @FXML
    public void btnReturn_Click(){
        this.show("Home");
    }

    @FXML
    public void btnDelete_Click(){
        Database db = Database.global;
        try{
            db.remove(AccountManager.selectedProfile);
            this.show("Home");
        } catch (Exception e){

        }
    }

    @FXML
    public void btnWatch_Click(){
        this.show("WatchProgram");
    }

    @FXML
    public void cbProfiles_Change() {
        for (Object profile : profiles) {
            Profile a = (Profile)profile;
            if(a.profileName.equals((String)cbProfiles.getValue())){
                AccountManager.selectedProfile = a;
                AccountManager.isEdit = true;
                btnDelete.setVisible(true);
                btnWatch.setVisible(true);
            }
        }
    }

    @Override
    void onLoad() {
        btnDelete.setVisible(false);
        btnWatch.setVisible(true);
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
