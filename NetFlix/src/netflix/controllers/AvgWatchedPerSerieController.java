package netflix.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import netflix.app.Cache;
import netflix.models.Program;
import netflix.models.Serie;
import netflix.models.SeriesEpisode;
import netflix.models.WatchedProgram;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;

public class AvgWatchedPerSerieController extends Controller {

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

    @FXML
    public void cbSeries_Change(){
        Cache.cacheSeries();
        String name = cbSeries.getValue().toString().split("-")[0];
        int episode = Integer.parseInt(cbSeries.getValue().toString().split("-")[1]);

        HashMap<Program, Integer> avgWatched = new HashMap<>();

        for (Serie s: Cache.series) {
            if(s.serieName.equals(name) && s.seasonNumber == episode)
            {
                Serie selected = s;
                ArrayList<Program> episodes = selected.getEpisodeList();

                for (Program p: episodes) {
                    try {
                        int avg = new WatchedProgram().selectAvg("timeWatched").where("programId", p.programId).firstInt();
                        avgWatched.put(p, avg);
                    } catch (Exception ignored){}
                }

                break;
            }
        }

        StringBuilder result = new StringBuilder();
        if(avgWatched.size()>0){
            avgWatched.forEach((k,v) -> {
                Duration d = Duration.ofMinutes(v);
                result.append(k.title).append(" - ").append(d.toHoursPart()).append(":").append(d.toMinutesPart())
                        .append(" - ").append((float)(v*100 / k.lengthInMinutes)).append("%\n");
            });
        }
        else{
            result.append("Geen resultaten.");
        }

        taData.setText(result.toString());

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
