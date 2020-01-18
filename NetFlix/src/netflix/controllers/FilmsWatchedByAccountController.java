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
    private ArrayList<Film> foundWatchedFilms = new ArrayList<>();

    @FXML
    private ComboBox cbAccounts;

    @FXML
    private TextArea taData;


    @FXML
    public void cbAccounts_Change(){
        taData.clear();
        taData.setText("results:" + "\n");
        for (Account a : Cache.accounts) {
            if(a.accountName.equals(cbAccounts.getValue())){
                AccountManager.selected = a;
            }
        }

        for (Object p: profiles){
            if (((Profile)p).accountId == AccountManager.selected.accountId){
                foundProfiles.add((Profile)p);
            }
        }
        for (int i = 0; i < foundProfiles.size(); i++){
            for (int y = 0; y < watchedPrograms.size(); y++){
                if (((WatchedProgram)watchedPrograms.get(y)).profileId == foundProfiles.get(i).profileId){
                    foundWatchedProgams.add(((WatchedProgram)watchedPrograms.get(y)));
                }
            }
        }
        for (int i = 0; i < foundWatchedProgams.size(); i++){
            for (Film film : Cache.films){
                if (film.programId == foundWatchedProgams.get(i).programId){
                    foundWatchedFilms.add(film);
                }
            }
        }
        for (int i = 0; i < foundWatchedFilms.size(); i++){
            for (Program program : Cache.programs){
                if (foundWatchedFilms.get(i).programId == program.programId){
                    taData.appendText(program.title + "\n");
                }
            }
        }
        taData.appendText("done");
    }

    @Override
    void onLoad() {
        try{
            for (Account o: Cache.accounts) {
                cbAccounts.getItems().add(o.accountName);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            profiles = new Profile().select().toList();
            watchedPrograms = new WatchedProgram().select().toList();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
