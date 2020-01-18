package netflix.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import netflix.app.AccountManager;
import netflix.app.Cache;
import netflix.models.*;

import java.util.ArrayList;

public class FilmsWatchedByAccountController extends Controller {

    private ArrayList<Object> profiles;
    private ArrayList<Object> watchedPrograms;
    private ArrayList<Profile> foundProfiles = new ArrayList<>();
    private ArrayList<WatchedProgram> foundWatchedProgams = new ArrayList<>();

    @FXML
    private ComboBox cbAccounts;

    @FXML
    private TextArea taData;


    @FXML
    public void cbAccounts_Change(){
        for (Account a : Cache.accounts) {
            if(a.accountName.equals((String)cbAccounts.getValue())){
                AccountManager.selected = a;
            }
        }
        for (Object p: profiles){
            if (((Profile)p).accountId == AccountManager.selected.accountId){
                foundProfiles.add((Profile)p);
            }
        }
        for (int i = 0; i < foundProfiles.size(); i++){
            for (int y = 0; i < watchedPrograms.size(); i++){
                if (((WatchedProgram)watchedPrograms.get(y)).profileId == foundProfiles.get(i).profileId){
                    foundWatchedProgams.add(((WatchedProgram)watchedPrograms.get(y)));
                }
            }
        }
        for (int i = 0; i < foundWatchedProgams.size(); i++){
            for (Film a : Cache.films){
                if (a.programId == foundWatchedProgams.get(i).programId){

                }
            }
        }


    }

    @Override
    void onLoad() {
        try {
            profiles = new Profile().select().toList();
            watchedPrograms = new WatchedProgram().select().toList();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
