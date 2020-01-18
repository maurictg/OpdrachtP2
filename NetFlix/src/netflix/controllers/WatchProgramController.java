package netflix.controllers;

import com.maurict.orm.Database;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import netflix.app.AccountManager;
import netflix.app.Cache;
import netflix.models.Film;
import netflix.models.Program;
import netflix.models.WatchedProgram;

import java.time.Duration;
import java.util.ArrayList;

public class WatchProgramController extends Controller {

    private ArrayList<Integer> programIdsFromFilms;
    private ArrayList<Object> watchedPrograms;

    @FXML
    private ComboBox cbFilms;

    @FXML
    private ListView tvFilms;

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
                db.add(watchedProgram);
                watchedPrograms.add(watchedProgram);
                new Alert(Alert.AlertType.INFORMATION, "Watch program saved!").show();
                lblPercent.setText((float)(watchedProgram.timeWatched*100 / AccountManager.selectedProgram.lengthInMinutes)+"%");
                sldPercent.setValue(Math.round((float)(watchedProgram.timeWatched*100 / AccountManager.selectedProgram.lengthInMinutes)));
                refreshTable();
            }

        } catch (Exception e){
            labelMessage.setVisible(true);
            e.printStackTrace();
        }
    }

    @FXML
    public void cbFilms_Change(){
        for (Object program : Cache.programs) {
            Program a = (Program)program;
            if(a.title.equals((String)cbFilms.getValue())){
                AccountManager.selectedProgram = a;
                btnWatchFilm.setVisible(true);
            }
        }
    }

    @FXML
    public void btnBack_Click(){
        this.show("Profile");
    }


    @Override
    void onLoad() {
        labelMessage.setVisible(false);
        btnWatchFilm.setVisible(false);
        try{
            Cache.cachePrograms();
            Cache.cacheFilms();
            watchedPrograms = new WatchedProgram().select().where("profileId", AccountManager.selectedProfile.profileId).toList();
            programIdsFromFilms = new ArrayList<>();
            for (Film o: Cache.films){
                programIdsFromFilms.add(o.programId);
            }

            for (Program o: Cache.programs) {
                if (programIdsFromFilms.contains(o.programId)){
                    cbFilms.getItems().add(o.title);
                }
            }

            refreshTable();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void refreshTable(){
        for (Object o : watchedPrograms){
            WatchedProgram wp = (WatchedProgram)o;
            StringBuilder sb = new StringBuilder();
            for (Program p : Cache.programs){
                if(p.programId == wp.programId){
                    sb.append(p.title).append(" - watched: ");
                    Duration d = Duration.ofMinutes(wp.timeWatched);
                    sb.append(d.toHoursPart()).append(":").append(d.toMinutesPart());
                    sb.append(" (").append((float)(wp.timeWatched*100 / p.lengthInMinutes)).append("%)");
                    tvFilms.getItems().add(sb.toString());
                }
            }
        }
    }

}
