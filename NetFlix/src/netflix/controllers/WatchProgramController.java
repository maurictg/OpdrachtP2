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
    private ComboBox cbPrograms;

    @FXML
    private ListView tvFilms;

    @FXML
    private Label labelMessage;

    @FXML
    private Button btnWatchFilm;

    @FXML
    private Button btnWatchProgram;

    @FXML
    private TextField textFieldMinutesWatched;

    @FXML
    private Slider sldPercent;

    @FXML
    private Label lblPercent;

    @FXML
    private Label lblFullyWatched;

    @FXML
    private void btnWatchProgram_Click() {
        int minutesWatched = Integer.parseInt(textFieldMinutesWatched.getText());

        if(AccountManager.selectedProgram == null){
            new Alert(Alert.AlertType.WARNING, "Please select a program first!").show();
            return;
        }

        try{
            if (minutesWatched > 0){
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
                btnWatchProgram.setVisible(false);
                cbPrograms.setValue("Select a Program");
            } else{
                new Alert(Alert.AlertType.WARNING, "Please watch at least 1 minute").show();
            }
        }catch (Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Anything went wrong").show();
        }


    }

    @FXML
    private void btnWatchFilm_Click(){

        if(AccountManager.selectedProgram == null){
            new Alert(Alert.AlertType.WARNING, "Please select a film first!").show();
            return;
        }

        try {
            labelMessage.setVisible(false);
            int minutesWatched = Integer.parseInt(textFieldMinutesWatched.getText());
            if (minutesWatched > 0){
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
                btnWatchFilm.setVisible(false);
                cbFilms.setValue("Select a Film");
            } else{
                new Alert(Alert.AlertType.WARNING, "Please watch at least 1 minute").show();
            }

        } catch (Exception e){
            labelMessage.setVisible(true);
            e.printStackTrace();
        }
    }

    @FXML
    public void cbFilms_Change() throws Exception{
        for (Object program : Cache.programs) {
            Program a = (Program)program;
            if(a.title.equals((String)cbFilms.getValue())){
                AccountManager.selectedProgram = a;
                btnWatchFilm.setVisible(true);
                int fw = new WatchedProgram()
                        .selectCount().where("programId",a.programId)
                        .and("timeWatched","=",a.lengthInMinutes).firstInt();

                lblFullyWatched.setText("This film is fully watched by "+fw+" people.");
            }
        }
    }

    @FXML
    public void cbPrograms_Change() throws Exception{
        for (Object program : Cache.programs) {
            Program a = (Program)program;
            if(a.title.equals((String)cbPrograms.getValue())){
                AccountManager.selectedProgram = a;
                btnWatchProgram.setVisible(true);
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
        btnWatchProgram.setVisible(false);
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
                } else{
                    cbPrograms.getItems().add(o.title);
                }
            }

            refreshTable();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void refreshTable(){
        tvFilms.getItems().clear();
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
