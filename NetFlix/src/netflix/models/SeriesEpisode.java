package netflix.models;

public class SeriesEpisode extends Program {

    private int episodeNumber;

    public SeriesEpisode(String title, int lengthInMinutes, int episodeNumber){
        super(title, lengthInMinutes);
        this.episodeNumber = episodeNumber;
    }
}
