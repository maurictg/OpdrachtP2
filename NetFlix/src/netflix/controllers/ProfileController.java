package netflix.controllers;

import com.maurict.orm.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import netflix.app.AccountManager;
import netflix.models.Account;
import netflix.models.Profile;

import java.util.ArrayList;

public class ProfileController extends Controller {
    @FXML
    private ComboBox cbProfiles;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnWatch;

    @FXML
    private Button btn_AverageWatched;


    @FXML
    public void btnAddProfile_Click(){
        this.show("AddProfile");
    }

    @FXML
    public void btnReturn_Click(){
        this.show("Home");
    }

    @FXML
    public void btnAvgWatch_Click(){
        this.show("AvgWatchedPerSeriePerAccount");
    }

    @FXML
    public void btnDelete_Click(){
        Database db = Database.global;
        try{
            db.remove(AccountManager.selectedProfile);
            //Clears the profiles. So the next time the profiles are needed they will be queried from the database
            AccountManager.selected.clearProfiles();
            this.show("Home");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void btnWatch_Click(){
        this.show("WatchProgram");
    }

    @FXML
    public void cbProfiles_Change() {
        for (Profile a : AccountManager.selected.getProfiles()) {
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
        btnWatch.setVisible(false);
        try{
            AccountManager.selected.getProfiles().forEach((f) -> cbProfiles.getItems().add(f.profileName));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
