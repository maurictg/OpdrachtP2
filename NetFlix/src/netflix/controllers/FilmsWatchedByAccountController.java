package netflix.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import netflix.app.AccountManager;
import netflix.app.Cache;
import netflix.models.*;

import java.util.ArrayList;

public class FilmsWatchedByAccountController extends Controller {

    private ArrayList<Object> profiles;
    private ArrayList<Object> watchedPrograms;
    private ArrayList<Object> films;
    private ArrayList<Object> programs;
//    private ArrayList<Profile> foundProfiles = new ArrayList<>();
//    private ArrayList<WatchedProgram> foundWatchedProgams = new ArrayList<>();
//    private ArrayList<Film> foundWatchedFilms = new ArrayList<>();

    @FXML
    private ComboBox cbAccounts;

    @FXML
    private TextArea taData;

    @FXML
    private Button btnReturn;

    @FXML
    public void btnReturn_Click(){
        this.show("Home");
    }


    @FXML
    public void cbAccounts_Change(){
        taData.clear();
        ArrayList<Profile> foundProfiles = new ArrayList<>();
        ArrayList<WatchedProgram> foundWatchedProgams = new ArrayList<>();
        ArrayList<Film> foundWatchedFilms = new ArrayList<>();

        taData.setText("results:" + "\n");
        for (Account a : Cache.accounts) {
            if(a.accountName.equals(cbAccounts.getValue())){
                AccountManager.selected = a;
            }
        }
        System.out.println(AccountManager.selected.accountName);

        for (Object p: profiles){
            if (((Profile)p).accountId == AccountManager.selected.accountId){
                foundProfiles.add((Profile)p);
            }
        }
        System.out.println(foundProfiles);
        for (int i = 0; i < foundProfiles.size(); i++){
            for (int y = 0; y < watchedPrograms.size(); y++){
                if (((WatchedProgram)watchedPrograms.get(y)).profileId == foundProfiles.get(i).profileId){
                    foundWatchedProgams.add(((WatchedProgram)watchedPrograms.get(y)));
                }
            }
        }
        System.out.println(foundWatchedProgams);
        for (int i = 0; i < foundWatchedProgams.size(); i++){
            for (int y = 0; y < films.size(); y++){
                if (((Film)films.get(y)).programId == foundWatchedProgams.get(i).programId){
                    foundWatchedFilms.add((Film)films.get(y));
                }
            }
        }
        System.out.println(foundWatchedFilms);
        for (int i = 0; i < foundWatchedFilms.size(); i++){
            for (int y = 0; y < programs.size(); y++){
                if (((Program)programs.get(y)).programId == foundWatchedFilms.get(i).programId){
                    taData.appendText((((Program) programs.get(y)).title) + "\n");
                }
            }

        }
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
            films = new Film().select().toList();
            programs = new Program().select().toList();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
