package netflix.controllers;

import com.maurict.orm.Database;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import netflix.app.AccountManager;
import netflix.models.Account;
import netflix.models.Film;
import netflix.models.Program;
import netflix.models.WatchedProgram;

import java.util.ArrayList;

public class WatchProgramController extends Controller {

    private ArrayList<Object> programs;
    private ArrayList<Object> films;
    private ArrayList<Integer> programIdsFromFilms;
    private ArrayList<Object> watchedPrograms;

    @FXML
    private ComboBox cbFilms;

    @FXML
    private Label labelMessage;

    @FXML
    private Button btnWatchFilm;

    @FXML
    private TextField textFieldMinutesWatched;

    @FXML
    private Slider sldPercent;

    @FXML
    private Label lblPercent;

    @FXML
    private void btnWatchFilm_Click(){
        try {
            labelMessage.setVisible(false);
            int minutesWatched = Integer.parseInt(textFieldMinutesWatched.getText());
            if (minutesWatched >= 0){
                Database db = Database.global;
                WatchedProgram watchedProgram = new WatchedProgram();
                watchedProgram.profileId = AccountManager.selectedProfile.profileId;
                watchedProgram.programId = AccountManager.selectedProgram.programId;
                watchedProgram.timeWatched = minutesWatched;
                sldPercent.setValue(watchedProgram.getPercentageWatched());
                lblPercent.setText(watchedProgram.getPercentageWatched()+"%");
                db.add(watchedProgram);
            }

        } catch (Exception e){
            labelMessage.setVisible(true);
            e.printStackTrace();
        }
    }

    @FXML
    public void cbFilms_Change(){
        for (Object program : programs) {
            Program a = (Program)program;
            if(a.title.equals((String)cbFilms.getValue())){
                AccountManager.selectedProgram = a;
                btnWatchFilm.setVisible(true);
            }
        }
    }


    @Override
    void onLoad() {
        labelMessage.setVisible(false);
        btnWatchFilm.setVisible(false);
        try{
            programs = new Program().select().toList();
            films = new Film().select().toList();
            watchedPrograms = new Film().select().toList();
            programIdsFromFilms = new ArrayList<>();
            for (Object o: films){
                programIdsFromFilms.add(((Film)o).programId);
            }

            for (Object o: programs) {
                if (programIdsFromFilms.contains(((Program)o).programId)){
                    cbFilms.getItems().add(((Program)o).title);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
