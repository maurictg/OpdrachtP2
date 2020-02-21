package netflix.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import netflix.app.AccountManager;
import netflix.app.Cache;
import netflix.models.Profile;
import netflix.models.Program;
import netflix.models.Serie;
import netflix.models.WatchedProgram;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;

public class AvgWatchedPerSeriePerAccountController extends Controller {

    @FXML
    private ComboBox cbSeries;

    @FXML
    private TextArea taData;

    @FXML
    private Button btnReturn;

    @FXML
    public void btnReturn_Click(){
        this.show("Home");
    }

    public void cbSeries_Change(){
//        we moeten de serie-episodes van de betreffende serie achterhalen
//        de profileId's van het account achterhalen.
        ArrayList<Profile> profiles = AccountManager.selected.getProfiles();

        Cache.cacheSeries();
        String name = cbSeries.getValue().toString().split("-")[0];
        int episode = Integer.parseInt(cbSeries.getValue().toString().split("-")[1]);

        StringBuilder sb = new StringBuilder("(");
        profiles.forEach((f) -> sb.append(f.profileId).append(","));

        char[] str = sb.toString().toCharArray();
        str[sb.toString().lastIndexOf(',')] = ')';
        String inString = new String(str);


        HashMap<Program, Integer> data = new HashMap<>();

        for (Serie s: Cache.series) {
            if(s.serieName.equals(name)&&s.seasonNumber==episode){
                Serie selected = s;
                ArrayList<Program> programs = selected.getEpisodeList();
                for (Program p: programs) {

                    try {
                        int avg = new WatchedProgram()
                                .selectAvg("timeWatched")
                                .where("programId", p.programId)
                                .raw(" AND profileId IN "+inString)
                                .firstInt();

                        data.put(p, avg);

                    } catch (Exception e) {
                        //e.printStackTrace();
                    }
                }

                break;
            }
        }

        StringBuilder result = new StringBuilder();
        if(data.size()>0){
            data.forEach((k,v) -> {
                result.append(k.title).append(" - ").append((float)(v*100 / k.lengthInMinutes)).append("%\n");
            });
            taData.setText(result.toString());
        } else{
            taData.setText("No results found.");
        }


    }


    @Override
    void onLoad() {
        try {
            ArrayList<Object> series = new Serie().select().toList();
            for (Object o : series) {
                Serie s = (Serie)o;
                cbSeries.getItems().add(s.serieName+"-"+s.seasonNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
