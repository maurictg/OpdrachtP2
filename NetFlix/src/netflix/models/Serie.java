package netflix.models;

import java.util.ArrayList;

public class Serie {

    private String serieName;
    private String recommendedSerie;
    private ArrayList<SeriesEpisode> episodeList;

    public Serie(String serieName, String recommendedSerie){
        this.serieName = serieName;
        this.recommendedSerie = recommendedSerie;
        this.episodeList = new ArrayList<>();
    }
}
